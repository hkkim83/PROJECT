package kr.co.aegis.patent.kipris;

import java.rmi.RemoteException;
import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.PatentBibliographicInfoServicePortTypeProxy;
import kr.or.kipris.plus.PatentBibliographicInfoServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.PatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo;

import org.apache.axis.message.SOAPHeaderElement;

public class KrPatentFilePath extends PatentFilePath{

	public KrPatentFilePath(String userId, String userKey, String kiprisUrl, String defaultPath) {
		super(userId, userKey, kiprisUrl, defaultPath);
	}
	
	/***
	 * 출원번호 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getFilePath(Map<String, String>map) throws RemoteException {
		
		PatentImageAndFullTextServicePortTypeProxy proxy = new PatentImageAndFullTextServicePortTypeProxy();
		PatentImageAndFullTextServiceSoap11BindingStub stub =(PatentImageAndFullTextServiceSoap11BindingStub)proxy.getPatentImageAndFullTextServicePortType();

		SOAPHeaderElement id = new SOAPHeaderElement(_kiprisUrl,"userId");
		id.setValue(_userId);
		
		SOAPHeaderElement userKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		userKey.setValue(_userKey);
		
		stub.setHeader(id);
		stub.setHeader(userKey);
		
		String applNum = map.get("APPL_NUM_ORG");
		logger.info("applNum::::::"+applNum);
		FilePathInfo filePathInfo = (FilePathInfo)stub.unexPubfullDocPDFInfo(applNum);
		ImagePathInfo[] imagePathInfos = (ImagePathInfo[])stub.abstractFigure(applNum);
		
		String patentFullText = filePathInfo.getPath(); 
		String imageMain      = imagePathInfos == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getLargePath();
		String imageSmall     = imagePathInfos == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getPath();
		
		map.put("PATENT_FULLTXT", StringUtil.isNull(patentFullText)  ? _defaultTxtPath : patentFullText);
		map.put("IMAGE_MAIN"    , StringUtil.isNull(imageMain)  ? _defaultPath : imageMain);
		map.put("IMAGE_SMALL"   , StringUtil.isNull(imageSmall) ? _defaultPath : imageSmall);
	}
	
	
	/***
	 * 업로드시 없는 정보 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getBibliography(Map<String, String>map) throws RemoteException {
		PatentBibliographicInfoServicePortTypeProxy proxy = new PatentBibliographicInfoServicePortTypeProxy();
		PatentBibliographicInfoServiceSoap11BindingStub stub =(PatentBibliographicInfoServiceSoap11BindingStub)proxy.getPatentBibliographicInfoServicePortType();

		SOAPHeaderElement id = new SOAPHeaderElement(_kiprisUrl,"userId");
		id.setValue(_userId);
		
		SOAPHeaderElement userKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		userKey.setValue(_userKey);
		
		stub.setHeader(id);
		stub.setHeader(userKey);
		
		String applNum = map.get("APPL_NUM_ORG");
		BiblioSummaryInfo biblioSummaryInfo[] = (BiblioSummaryInfo[])stub.biblioSummaryInfo(applNum); 
		
		logger.info(":::::::::::::::::::::biblioSummaryInfo");
		logger.info(biblioSummaryInfo);
	}
}
