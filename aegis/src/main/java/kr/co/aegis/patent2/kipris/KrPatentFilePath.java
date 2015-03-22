package kr.co.aegis.patent2.kipris;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.FamilyInfoServicePortTypeProxy;
import kr.or.kipris.plus.FamilyInfoServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentAdvancedSearchServicePortTypeProxy;
import kr.or.kipris.plus.PatentAdvancedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentBibliographicInfoServicePortTypeProxy;
import kr.or.kipris.plus.PatentBibliographicInfoServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.PatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorArtDocumentsInfo;
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
		String openTextYn     = null;
		String regiTextYn     = null;
		String reviTextYn     = null;
		String imageMainYn    = null;
		FilePathInfo filePathInfo = null;
		
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			String applNum = map.get("APPL_NUM_ORG");
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			// 대표전문, 대표도면 유무 조회 
			FullTextCheckResult checkResult = (FullTextCheckResult)stub.fullTextCheck(applNum);
			// 공개전문 
			openTextYn = checkResult.getUnexPubfullDocPDFCheckResult();
			// 등록전문 
			regiTextYn = checkResult.getExamPubfullDocPDFCheckResult();
			// 정정전문 
			reviTextYn = checkResult.getRevisionfullDocPDFCheckResult();
			// 대표도면
			imageMainYn = checkResult.getAbstractFigureCheckResult();			
			logger.info("applNum::::::"+applNum+" , "+_defaultTxtPath+" , "+_defaultPath);
			// 전문 
			if("Y".equals(reviTextYn)) {
				FilePathRevisionInfo[] array = (FilePathRevisionInfo[])stub.revisionfullDocPDFInfo(applNum);
				if(array != null) {
					patentFullText = array[0] == null ? "" : array[0].getPath();
				}
			} else if("Y".equals(regiTextYn)) {
				filePathInfo = (FilePathInfo)stub.examPubfullDocPDFInfo(applNum);
				patentFullText = filePathInfo.getPath();
			} else if("Y".equals(openTextYn)) {
				filePathInfo = (FilePathInfo)stub.unexPubfullDocPDFInfo(applNum);
				patentFullText = filePathInfo.getPath();
			} 
			
			// 대표도면 
			if("Y".equals(imageMainYn)) {
				ImagePathInfo[] imagePathInfos = (ImagePathInfo[])stub.abstractFigure(applNum);
				if(imagePathInfos != null) {
					imageMain  = imagePathInfos[0] == null ? "" : imagePathInfos[0].getLargePath(); 
					imageSmall = imagePathInfos[0] == null ? "" : imagePathInfos[0].getPath(); 
				}
			}			

		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			map.put("PATENT_FULLTXT", StringUtil.isNull(patentFullText) ? _defaultTxtPath : patentFullText);
			map.put("IMAGE_MAIN"    , StringUtil.isNull(imageMain)      ? _defaultPath : imageMain);
			map.put("IMAGE_SMALL"   , StringUtil.isNull(imageSmall)     ? _defaultPath : imageSmall);
			
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
		logger.info("getBibliographygetBibliography:::::"+applNum);
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			BibliographyParser parser = new KrBibliographyParser(map);
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
			
			// 인용문헌정보 
			PriorArtDocumentsInfo[] priorArtDocumentsInfos = (PriorArtDocumentsInfo[])stub.priorArtDocumentsInfo(applNum);
			parser.setPriorArtDocumentsInfo(priorArtDocumentsInfos);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 패밀리정보 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getFamilyInfo(Map<String, String>map) {
		
		FamilyInfoServicePortTypeProxy proxy = new FamilyInfoServicePortTypeProxy();
		FamilyInfoServiceSoap11BindingStub stub =(FamilyInfoServiceSoap11BindingStub)proxy.getFamilyInfoServicePortType();
		String publicationCountryCode = null; 
		String publicationNumber      = null;
		String publicationKindCode    = null;
		String fmNum = "";
		int fmCount = 0;
		
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			String applNum = map.get("APPL_NUM_ORG");
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			FamilyInfo[] arrays = (FamilyInfo[])stub.familyInfo(applNum);
			logger.info("getFamilyInfo_fmCount::::"+arrays.length);
			fmCount = arrays.length;
			if(fmCount > 0 && arrays != null) {
				for(FamilyInfo familyInfo : arrays) {
					publicationCountryCode = familyInfo.getPublicationCountryCode();
					publicationNumber = familyInfo.getPublicationNumber();
					publicationKindCode = familyInfo.getPublicationKindCode();
					fmNum += publicationCountryCode+publicationNumber+publicationKindCode+" | ";
				}				
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if(StringUtil.isNull(map.get("FM_NUM"))) map.put("FM_NUM", StringUtil.subStr2(fmNum, -3));
			if(StringUtil.isNull(map.get("FM_COUNT"))) map.put("FM_COUNT", String.valueOf(fmCount));	
			
			logger.info("getFamilyInfo_fmNum::::"+fmNum);
			logger.info("getFamilyInfo_fmCount::::"+fmCount);
		}
	}
	
	/**
	 * KIPRIS DB검색식으로 전체 갯수 구하기 
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public int getTotalCount(Map<String, String>map) {
		
		PatentAdvancedSearchServicePortTypeProxy proxy = new PatentAdvancedSearchServicePortTypeProxy();
		PatentAdvancedSearchServiceSoap11BindingStub stub =(PatentAdvancedSearchServiceSoap11BindingStub)proxy.getPatentAdvancedSearchServicePortType();
		int totalSearchCount = 0;
		
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			String content = map.get("CONTENT");
			logger.info("content::::::::::"+content);
			AdvancedSearchArray bean = stub.freeSearch(content, 1, 1, true, true, "", "", true);		
			totalSearchCount = bean.getTotalSearchCount();
			logger.info("totalSearchCount::::::::"+totalSearchCount);
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
		return totalSearchCount;
	}	
	
	/**
	 * KIPRIS DB검색식으로 전체검색하기 
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public void getAdvancedSearch(Map<String, String>map, List<Map<String, String>> list ) {
		
		PatentAdvancedSearchServicePortTypeProxy proxy = new PatentAdvancedSearchServicePortTypeProxy();
		PatentAdvancedSearchServiceSoap11BindingStub stub =(PatentAdvancedSearchServiceSoap11BindingStub)proxy.getPatentAdvancedSearchServicePortType();
		
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			String content = map.get("CONTENT");
//			int totCount   = Integer.parseInt(String.valueOf(map.get("COUNT")));
//			int docsCount  = totCount > 50 ? 50 : totCount;
			int totCount  = 100;
			int docsCount = 50;
			for(int i=0; i<totCount/docsCount; i++) {
				AdvancedSearchArray bean = stub.freeSearch(content, 1+(i*docsCount), docsCount, true, true, "", "", true);				
				AdvancedSearch[] arrays = bean.getAdvancedSearch();
				for(AdvancedSearch arr : arrays) {
					Map<String, String> tempMap = new HashMap<String, String>();
					tempMap.put("APPL_NUM_ORG"		, arr.getApplicationNumber());			// 문헌번호 
					tempMap.put("NATL_CODE"			, map.get("NATL_CODE"));					// 국가코드
					tempMap.put("KINDS_IP_CODE"		, getKindsIpCode(arr.getRegisterNumber()));			// 문헌번호 
					tempMap.put("KINDS_IP_TYPE"		, getKindsIpType(arr.getApplicationNumber()));			// 문헌번호 
					tempMap.put("TITLE"				, arr.getInventionTitle());				// 발명의명칭 
					tempMap.put("IPC_ALL"			, arr.getIpcNumber());					// IPC
					tempMap.put("REGI_NUM"			, arr.getRegisterNumber());				// 등록번호 	
					tempMap.put("REGI_DATE"			, StringUtil.replaceString(arr.getRegisterDate(),"/",""));				// 등록일 
					tempMap.put("APPL_NUM"			, arr.getApplicationNumber());			// 출원번호 	
					tempMap.put("APPL_DATE"			, StringUtil.replaceString(arr.getApplicationDate(),"/",""));				// 출원일 	
					tempMap.put("OPEN_NUM"			, arr.getOpenNumber());					// 공개번호 
					tempMap.put("OPEN_DATE"			, StringUtil.replaceString(arr.getOpenDate(),"/",""));					// 공개일 
					tempMap.put("LAID_PUBLIC_NUM"	, arr.getPublicationNumber());			// 공고번호 	
					tempMap.put("LAID_PUBLIC_DATE"	, StringUtil.replaceString(arr.getPublicationDate(),"/",""));				// 공고일 
//					tempMap.put("ABSTRACT"			, arr.getAstrtCont());					// 요약 
//					tempMap.put("APPLICANT"			, arr.getApplicantName());				// 출원인 			
					list.add(tempMap);
				}
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 특허/실용 구분
	 * @param applNum
	 * @return
	 */
	private String getKindsIpType(String applNum) {
		String result = "";
		if(!StringUtil.isNull(applNum)) {
			result = applNum.startsWith("10") ? "P" : "U";
		}
		return result;
	}
	
	/**
	 * 문헌종류코드
	 * @param regiNum
	 * @return
	 */
	private String getKindsIpCode(String regiNum) {
		return !StringUtil.isNull(regiNum) ? "B" : "A";
	}
}