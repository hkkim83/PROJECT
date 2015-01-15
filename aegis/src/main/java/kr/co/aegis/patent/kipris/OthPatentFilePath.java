package kr.co.aegis.patent.kipris;

import java.rmi.RemoteException;
import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FpatBeanItem;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray;

import org.apache.axis.message.SOAPHeaderElement;

public class OthPatentFilePath extends PatentFilePath{
	
	public OthPatentFilePath(String userId, String userKey, String kiprisUrl,
			String defaultPath) {
		super(userId, userKey, kiprisUrl, defaultPath);
	}
	
	/***
	 * 출원번호 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getFilePath(Map<String, String>map) throws RemoteException {
		
		ForeignPatentImageAndFullTextServicePortTypeProxy proxy = new ForeignPatentImageAndFullTextServicePortTypeProxy();
		ForeignPatentImageAndFullTextServiceSoap11BindingStub stub =(ForeignPatentImageAndFullTextServiceSoap11BindingStub)proxy.getForeignPatentImageAndFullTextServicePortType();

		SOAPHeaderElement id = new SOAPHeaderElement(_kiprisUrl,"userId");
		id.setValue(_userId);
		
		SOAPHeaderElement userKey = new SOAPHeaderElement(_kiprisUrl,"userK ey");
		userKey.setValue(_userKey);
	
		stub.setHeader(id);
		stub.setHeader(userKey);
		
		String applNum  = map.get("APPL_NUM_ORG");
		String natlCode = map.get("NATL_CODE");
		
		if(StringUtil.isNull(applNum)) 
			return;
		
		String applNumArr[] = applNum.split(",");
		
		FullTextInfo fullTextInfo = (FullTextInfo)stub.fullTextInfo(applNumArr[1], natlCode);;

		RepresentationImageInfo[] imagePathInfos = (RepresentationImageInfo[])stub.representationImageInfo(applNumArr[1], natlCode);
		String patentFullText = fullTextInfo.getPath(); 
		String imageMain      = imagePathInfos[0] == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getJpgPath();
		String imageSmall     = imagePathInfos[0] == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getJpgPath();
		
		map.put("PATENT_FULLTXT", StringUtil.isNull(patentFullText)  ? _defaultTxtPath : patentFullText);
		map.put("IMAGE_MAIN"    , StringUtil.isNull(imageMain)  ? _defaultPath : imageMain);
		map.put("IMAGE_SMALL"   , StringUtil.isNull(imageSmall) ? _defaultPath : imageSmall);

	}
	
	/***
	 * KIPRIS 서지 정보 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getBibliography(Map<String, String>map) throws RemoteException {
	   	ForeignPatentAdvencedSearchServicePortTypeProxy proxy = new ForeignPatentAdvencedSearchServicePortTypeProxy();
		ForeignPatentAdvencedSearchServiceSoap11BindingStub stub =(ForeignPatentAdvencedSearchServiceSoap11BindingStub)proxy.getForeignPatentAdvencedSearchServicePortType();

		SOAPHeaderElement id = new SOAPHeaderElement(_kiprisUrl,"userId");
		id.setValue(_userId);
		
		SOAPHeaderElement userKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		userKey.setValue(_userKey);
	
		stub.setHeader(id);
		stub.setHeader(userKey);
		
		String applNum  = map.get("APPL_NUM_ORG");
		String natlCode = map.get("NATL_CODE");
		
		if(StringUtil.isNull(applNum)) 
			return;
		
		String applNumArr[] = applNum.split(",");
		
		SearchResultArray array = stub.applicationNumberSearch(applNumArr[1], natlCode, "", "", "", "");
		logger.info("array:::\n"+array);
		SearchResult[] searchResult = array.getSearchTestResult();
		logger.info("searchResult:::\n"+searchResult);
	}
	
	/**
	 * KIPRIS PLUS용 출원번호 가져오기
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public void setApplNumOrg(Map<String, String>map) throws RemoteException {
		
	   	ForeignPatentAdvencedSearchServicePortTypeProxy proxy = new ForeignPatentAdvencedSearchServicePortTypeProxy();
		ForeignPatentAdvencedSearchServiceSoap11BindingStub stub =(ForeignPatentAdvencedSearchServiceSoap11BindingStub)proxy.getForeignPatentAdvencedSearchServicePortType();

		SOAPHeaderElement id = new SOAPHeaderElement(_kiprisUrl,"userId");
		id.setValue(_userId);
		
		SOAPHeaderElement userKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		userKey.setValue(_userKey);
	
		stub.setHeader(id);
		stub.setHeader(userKey);
		
		String natlCode = map.get("NATL_CODE");
		String applDate = map.get("APPL_DATE");
		String title    = map.get("TITLE");
		title =	title.replaceAll("[,.]", "");
		title = title.replaceAll(" ", "*");
		
		FpatBeanItem fpatBean = new FpatBeanItem();
		fpatBean.setCollectionValues(natlCode);
		fpatBean.setApplicationdate(applDate);
		fpatBean.setInventionName(title);
		
		SearchResultArray array = stub.advancedSearch(fpatBean);
		String applNumOrg = "";
		if(Integer.parseInt(array.getTotalSearchCount()) > 0) {
			SearchResult[] searchResult = array.getSearchTestResult();
			applNumOrg = searchResult[0] == null || searchResult.length == 0 ? "" : searchResult[0].getVdkVgwKey();
//			logger.info("SearchResult:::"+searchResult[0]);
		}
		map.put("APPL_NUM_ORG", applNumOrg);
	}
}
