package kr.co.aegis.patent.kipris;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.PatentAdvancedSearchServicePortTypeProxy;
import kr.or.kipris.plus.PatentAdvancedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentBibliographicInfoServicePortTypeProxy;
import kr.or.kipris.plus.PatentBibliographicInfoServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.PatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.CategorySearchQuery;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorityInfo;

public class KrPatentFilePath extends PatentFilePath{

	public KrPatentFilePath(String userId, String userKey, String kiprisUrl, String defaultPath) {
		super(userId, userKey, kiprisUrl, defaultPath);
	}
	
	/**
	 * KIPRIS PLUS용 출원번호 가져오기
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public void setApplNumOrg(Map<String, String>map) {
		String kiprisApplNum = map.get("KIPRIS_APPL_NUM");
		map.put("APPL_NUM_ORG", kiprisApplNum);
	}
	
	
	
	/***
	 * 출원번호 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getFilePath(Map<String, String>map) {
		
		PatentImageAndFullTextServicePortTypeProxy proxy = new PatentImageAndFullTextServicePortTypeProxy();
		PatentImageAndFullTextServiceSoap11BindingStub stub =(PatentImageAndFullTextServiceSoap11BindingStub)proxy.getPatentImageAndFullTextServicePortType();
		String patentFullText = null; 
		String imageMain      = null;
		String imageSmall     = null;
		
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			String applNum = map.get("APPL_NUM_ORG");
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			logger.info("applNum::::::"+applNum+" , "+_defaultTxtPath+" , "+_defaultPath);
			FilePathInfo filePathInfo = (FilePathInfo)stub.unexPubfullDocPDFInfo(applNum);
			ImagePathInfo[] imagePathInfos = (ImagePathInfo[])stub.abstractFigure(applNum);
			
			patentFullText = filePathInfo.getPath(); 
			imageMain      = imagePathInfos == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getLargePath();
			imageSmall     = imagePathInfos == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getPath();
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			map.put("PATENT_FULLTXT", StringUtil.isNull(patentFullText)  ? _defaultTxtPath : patentFullText);
			map.put("IMAGE_MAIN"    , StringUtil.isNull(imageMain)  ? _defaultPath : imageMain);
			map.put("IMAGE_SMALL"   , StringUtil.isNull(imageSmall) ? _defaultPath : imageSmall);
			
			logger.info("patentFullText::::"+patentFullText);
			logger.info("imageMain::::"+imageMain);
		}
	}
	
	
	/***
	 * 업로드시 없는 정보 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getBibliography(Map<String, String>map) {
		PatentBibliographicInfoServicePortTypeProxy proxy = new PatentBibliographicInfoServicePortTypeProxy();
		PatentBibliographicInfoServiceSoap11BindingStub stub =(PatentBibliographicInfoServiceSoap11BindingStub)proxy.getPatentBibliographicInfoServicePortType();
		String applNum = map.get("APPL_NUM_ORG");

		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			BibliographyParser parser = new OthBibliographyParser(map);
			// 서지정보
			BiblioSummaryInfo[] biblioSummaryInfos = (BiblioSummaryInfo[])stub.biblioSummaryInfo(applNum);
			parser.setBiblioSummaryInfo(biblioSummaryInfos);
			
			// ipc정보
			IpcInfo[] ipcInfos = (IpcInfo[])stub.ipcInfo(applNum);
			parser.setIpcInfo(ipcInfos);
			
			// 초록
			AbstractInfo[] abstractInfos = (AbstractInfo[])stub.abstractInfo(applNum);
			parser.setAbstractInfo(abstractInfos);
			
			// 청구항
			ClaimInfo[] claimInfos = (ClaimInfo[])stub.claimInfo(applNum);
			parser.setClaimInfo(claimInfos);
			
			// 출원인정보
			ApplicantInfo[] applicantInfos = (ApplicantInfo[])stub.applicantInfo(applNum);
			parser.setApplicantInfo(applicantInfos);
			
			// 발명자정보
			InventorInfo[] inventorInfos = (InventorInfo[])stub.inventorInfo(applNum);
			parser.setInventorsInfo(inventorInfos);
			
			// 우선권정보
			PriorityInfo[] priorityInfos = (PriorityInfo[])stub.priorityInfo(applNum);
			parser.setPriorityNumberDateInfo(priorityInfos);
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * KIPRIS DB검색식으로 전체검색하기 
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public int getAdvancedSearch(Map<String, String>map, List<Map<String, String>> list ) {
		
		PatentAdvancedSearchServicePortTypeProxy proxy = new PatentAdvancedSearchServicePortTypeProxy();
		PatentAdvancedSearchServiceSoap11BindingStub stub =(PatentAdvancedSearchServiceSoap11BindingStub)proxy.getPatentAdvancedSearchServicePortType();
		int totalSearchCount = 0;
		
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			CategorySearchQuery categorySearchQuery = new CategorySearchQuery();
			categorySearchQuery.setInventionTitle(map.get("TITLE"));						// 발명의 명칭
//			categorySearchQuery.setAstrtCont(map.get("ABSTRACT"));						// 요약 
//			categorySearchQuery.setClaimScope(map.get("CLAIM_MAIN"));						// 대표청구항 
//			categorySearchQuery.setIpcNumber(map.get("IPC_ALL"));						// IPC
//			categorySearchQuery.setApplicant(map.get("APPLICANT"));						// 출원인 
//			categorySearchQuery.setInventors(map.get("INVENTOR"));						// 발명자
//			categorySearchQuery.setAgent(map.get("AGENT"));								// 대리인
//			categorySearchQuery.setApplicationNumber(map.get("APPL_NUM"));				// 출원번호 
//			categorySearchQuery.setApplicationDate(map.get("APPL_DATE"));					// 출원일 
//			categorySearchQuery.setOpenNumber(map.get("OPEN_NUM"));						// 공개번호 
//			categorySearchQuery.setOpenDate(map.get("OPEN_DATE"));						// 공개일 
//			categorySearchQuery.setPublicationNumber(map.get("LAID_PUBLIC_NUM"));			// 공고번호
//			categorySearchQuery.setPublicationDate(map.get("LAID_PUBLIC_DATE"));			// 공고일  
//			categorySearchQuery.setRegisterNumber(map.get("REGI_NUM"));					// 등록번호
//			categorySearchQuery.setRegisterDate(map.get("REGI_DATE"));					// 등록일 
//			categorySearchQuery.setPriorityApplicationNumber(map.get("PRIORITY_NUM"));	// 우선권번호 
//			categorySearchQuery.setPriorityApplicationDate(map.get("PRIORITY_DATE"));		// 우선권주장일 
//			categorySearchQuery.setPatent(true);
//			categorySearchQuery.setUtility(true);
			
			AdvancedSearchArray bean = stub.advancedSearch(categorySearchQuery, null, null, null, null);
			AdvancedSearch[] arrays = bean.getAdvancedSearch();
			totalSearchCount = bean.getTotalSearchCount();
			logger.info("totalSearchCount::::::::"+totalSearchCount);
//			for(AdvancedSearch arr : arrays) {
//				Map<String, String> tempMap = new HashMap<String, String>();
//				tempMap.put("APPL_NUM_ORG", arr.getApplicationNumber());			// 문헌번호  	
//				tempMap.put("TITLE", arr.getInventionTitle());					// 발명의명칭 
//				tempMap.put("IPC_ALL", arr.getIpcNumber());						// IPC
//				tempMap.put("REGI_NUM", arr.getRegisterNumber());				// 등록번호 	
//				tempMap.put("REGI_DATE", arr.getRegisterDate());					// 등록일 
//				tempMap.put("APPL_NUM", arr.getApplicationNumber());				// 출원번호 	
//				tempMap.put("APPL_DATE", arr.getApplicationDate());				// 출원일 	
//				tempMap.put("OPEN_NUM", arr.getOpenNumber());					// 공개번호 
//				tempMap.put("OPEN_DATE", arr.getOpenDate());						// 공개일 
//				tempMap.put("LAID_PUBLIC_NUM", arr.getPublicationNumber());		// 공고번호 	
//				tempMap.put("LAID_PUBLIC_DATE", arr.getPublicationDate());		// 공고일 
//				tempMap.put("ABSTRACT", arr.getAstrtCont());						// 요약 
//				tempMap.put("APPLICANT", arr.getApplicantName());				// 출원인 
//				list.add(tempMap);
//			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
		return totalSearchCount;
	}
}