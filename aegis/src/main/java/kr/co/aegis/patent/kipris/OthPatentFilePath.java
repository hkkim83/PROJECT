package kr.co.aegis.patent.kipris;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.ForeignPatentBibliographicServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FpatBeanItem;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo;

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
		
		SOAPHeaderElement userKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		userKey.setValue(_userKey);
	
		stub.setHeader(id);
		stub.setHeader(userKey);
		
		String applNum  = map.get("APPL_NUM_ORG");
		String natlCode = map.get("NATL_CODE");
		
		if(StringUtil.isNull(applNum)) 
			return;
		
		logger.info("applNum::::::"+applNum+" , "+natlCode);
		FullTextInfo fullTextInfo = (FullTextInfo)stub.fullTextInfo(applNum, natlCode);

		RepresentationImageInfo[] imagePathInfos = (RepresentationImageInfo[])stub.representationImageInfo(applNum, natlCode);
		String patentFullText = fullTextInfo.getPath(); 
		String imageMain      = imagePathInfos[0] == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getJpgPath();
		String imageSmall     = imagePathInfos[0] == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getJpgPath();
		
		map.put("PATENT_FULLTXT", StringUtil.isNull(patentFullText)  ? _defaultTxtPath : patentFullText);
		map.put("IMAGE_MAIN"    , StringUtil.isNull(imageMain)  ? _defaultPath : imageMain);
		map.put("IMAGE_SMALL"   , StringUtil.isNull(imageSmall) ? _defaultPath : imageSmall);
		
//		logger.info("patentFullText::::"+patentFullText);
		logger.info("imageMain::::"+imageMain+"::::::");
	}
	
	/***
	 * KIPRIS 서지 정보 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getBibliography(Map<String, String>map) throws RemoteException {
		ForeignPatentBibliographicServicePortTypeProxy proxy = new ForeignPatentBibliographicServicePortTypeProxy();
		ForeignPatentBibliographicServiceSoap11BindingStub stub =(ForeignPatentBibliographicServiceSoap11BindingStub)proxy.getForeignPatentBibliographicServicePortType();

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
		
//		String applNumArr[] = applNum.split(",");
		
		// 서지정보
		BibliographicSummaryInfo biblioSummaryInfo = (BibliographicSummaryInfo)stub.bibliographicSummaryInfo(applNum, natlCode);
		map.put("title", !StringUtil.isNull(map.get("title")) ? map.get("title") : biblioSummaryInfo.getInventionTitle());	
		map.put("appl_date", !StringUtil.isNull(map.get("appl_date")) ? map.get("appl_date") : biblioSummaryInfo.getApplicationDate());
		map.put("laid_pulbic_num", !StringUtil.isNull(map.get("laid_pulbic_num")) ? map.get("laid_pulbic_num") : biblioSummaryInfo.getPublicationNumber());
		map.put("laid_pulbic_date", !StringUtil.isNull(map.get("laid_pulbic_date")) ? map.get("laid_pulbic_date") : biblioSummaryInfo.getPublishDate());
		//map.put("regi_num", StringUtil.isNull(map.get("regi_num")) ? map.get("regi_num") : biblioSummaryInfo.getRegisterNumber());
		//map.put("regi_date", StringUtil.isNull(map.get("regi_date")) ? map.get("regi_date") : biblioSummaryInfo.getRegisterDate());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getApplicationNumber());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getApplicationDate());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getInventionTitle());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getPublicationNumber());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getPublishDate());
		// ipc정보
		IpcInfo[] ipcInfos = (IpcInfo[])stub.ipcInfo(applNum, natlCode);
		for(int i=0; i<ipcInfos.length; i++) {
			logger.info("ipcInfos:::"+i+"::\n"+ipcInfos[i].getIpcCd());
		}
		if(ipcInfos.length > 0) {
			IpcInfo ipcInfo = ipcInfos[0];
			if(ipcInfo != null)
				map.put("ipc_all", !StringUtil.isNull(map.get("ipc_all")) ? map.get("ipc_all") : ipcInfo.getIpcCd());
		}
		// 초록
		Summation[] summations = (Summation[])stub.summation(applNum, natlCode);
		logger.info("summations1::::"+summations.length);
		for(int i=0; i<summations.length; i++) {
			logger.info("summations2:::"+summations[i]);
//			logger.info("summations3:::"+i+"::\n"+summations[i].getAstrtCont());
		}
		if(summations.length > 0) {
			Summation summation = summations[0];
			if(summation != null)
				map.put("abstract", !StringUtil.isNull(map.get("abstract")) ? map.get("abstract") : summation.getAstrtCont());
		}
		// 청구항
//		ClaimInfo[] claimInfos = (ClaimInfo[])stub.claimInfo(applNum);
//		ClaimInfo claimInfo = claimInfos[0];
//		map.put("claim_main", StringUtil.isNull(map.get("claim_main")) ? map.get("claim_main") : claimInfo.getClaim());
		
		// 출원인정보
		ApplicantInfo[] applicantInfos = (ApplicantInfo[])stub.applicantInfo(applNum, natlCode);
		for(int i=0; i<applicantInfos.length; i++) {
			logger.info("applicantInfos:::"+i+"::\n"+applicantInfos[i].getApplicantName());
			logger.info("applicantInfos:::"+i+"::\n"+applicantInfos[i].getApplicantName());
		}
		if(applicantInfos.length > 0) {
			ApplicantInfo applicantInfo = applicantInfos[0];
			if(applicantInfo != null) {
				map.put("applicant", !StringUtil.isNull(map.get("applicant")) ? map.get("applicant") : applicantInfo.getApplicantName());
				map.put("applicant_natl", !StringUtil.isNull(map.get("applicant_natl")) ? map.get("applicant_natl") : applicantInfo.getApplicantCountry());
			}
		}
		
		// 발명자정보
		InventorsInfo[] inventorInfos = (InventorsInfo[])stub.inventorsInfo(applNum, natlCode);
		for(int i=0; i<inventorInfos.length; i++) {
			logger.info("inventorInfos:::"+i+"::\n"+inventorInfos[i].getInventorName());
		}
		if(inventorInfos.length > 0) {
			InventorsInfo inventorInfo = inventorInfos[0];
			if(inventorInfo != null)
				map.put("inventor", !StringUtil.isNull(map.get("inventor")) ? map.get("inventor") : inventorInfo.getInventorName());
		}
		
		// 우선권정보
		PriorityNumberDateInfo[] priorityInfos = (PriorityNumberDateInfo[])stub.priorityNumberDateInfo(applNum, natlCode);
		for(int i=0; i<priorityInfos.length; i++) {
			logger.info("priorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationNumber());
			logger.info("priorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationDate());
			logger.info("priorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationCountry());
		}
		if(priorityInfos.length > 0) {
			PriorityNumberDateInfo priorityInfo = priorityInfos[0];
			if(priorityInfo != null) {
				map.put("priority_num", !StringUtil.isNull(map.get("priority_num")) ? map.get("priority_num") : priorityInfo.getPriorityApplicationNumber());
				map.put("priority_date", !StringUtil.isNull(map.get("priority_date")) ? map.get("priority_date") : priorityInfo.getPriorityApplicationDate());
				map.put("priority_natl", !StringUtil.isNull(map.get("priority_natl")) ? map.get("priority_natl") : priorityInfo.getPriorityApplicationCountry());
			}
		}
		
		// f-term정보
		FtermInfo[] ftermInfos = (FtermInfo[])stub.ftermInfo(applNum, natlCode);
		for(int i=0; i<ftermInfos.length; i++) {
			logger.info("ftermInfos:::"+i+"::\n"+ftermInfos[i].getFTermCode());
		}
		if(ftermInfos.length > 0) {
			FtermInfo ftermInfo = ftermInfos[0];
			if(ftermInfo != null)
				map.put("f_term_jp", !StringUtil.isNull(map.get("f_term_jp")) ? map.get("f_term_jp") : ftermInfo.getFTermCode());
		}
		
		// fi정보 
		FiInfo[] fiInfos = (FiInfo[])stub.fiInfo(applNum, natlCode);
		for(int i=0; i<fiInfos.length; i++) {
			logger.info("fiInfos:::"+i+"::\n"+fiInfos[i].getPublKey());
		}
		if(fiInfos.length > 0) {
			FiInfo fiInfo = fiInfos[0];
			if(fiInfo != null)
				map.put("fi_code_jp", !StringUtil.isNull(map.get("fi_code_jp")) ? map.get("fi_code_jp") : fiInfo.getPublKey());
		}
		
		// upc정보
		UpcInfo[] upcInfos = (UpcInfo[])stub.upcInfo(applNum, natlCode);
		for(int i=0; i<upcInfos.length; i++) {
			logger.info("upcInfos:::"+i+"::\n"+upcInfos[i].getUpcUspdCd());
		}
		if(upcInfos.length > 0) {
			UpcInfo upcInfo = upcInfos[0];
			if(upcInfo != null)
				map.put("upc_current_all", !StringUtil.isNull(map.get("upc_current_all")) ? map.get("upc_current_all") : upcInfo.getUpcUspdCd());
		}
		
	};
	
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
		logger.info(":::::::setApplNumOrg:::::::::");
		logger.info(natlCode);
		logger.info(applDate);
		logger.info(title);
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
			applNumOrg = searchResult[0] == null || searchResult.length == 0 ? "" : searchResult[0].getLtrtno();
//			logger.info("SearchResult:::"+searchResult[0]);
		}
		map.put("APPL_NUM_ORG", applNumOrg);
	}
	
	
	/**
	 * KIPRIS DB검색식으로 전체검색하기 
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public int getAdvancedSearch(Map<String, String>map, List<Map<String, String>> list ) throws RemoteException {
		
	   	ForeignPatentAdvencedSearchServicePortTypeProxy proxy = new ForeignPatentAdvencedSearchServicePortTypeProxy();
		ForeignPatentAdvencedSearchServiceSoap11BindingStub stub =(ForeignPatentAdvencedSearchServiceSoap11BindingStub)proxy.getForeignPatentAdvencedSearchServicePortType();

		SOAPHeaderElement id = new SOAPHeaderElement(_kiprisUrl,"userId");
		id.setValue(_userId);
		
		SOAPHeaderElement userKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		userKey.setValue(_userKey);
	
		stub.setHeader(id);
		stub.setHeader(userKey);
		String regiNum  = !StringUtil.isNull(map.get("LAID_PUBLIC_NUM"))  ? map.get("LAID_PUBLIC_NUM")  : map.get("REGI_NUM");
		String regiDate = !StringUtil.isNull(map.get("LAID_PUBLIC_DATE")) ? map.get("LAID_PUBLIC_DATE") : map.get("REGI_DATE");
		FpatBeanItem fpatBean = new FpatBeanItem();		
		fpatBean.setInventionName(map.get("FREE"));						// 전체
		fpatBean.setInventionName(map.get("TITLE"));						// 발명의 명칭
		fpatBean.setAbstracts(map.get("ABSTRACT"));						// 요약 
		fpatBean.setClaimExtend(map.get("CLAIM_MAIN"));					// 대표청구항 
		fpatBean.setIpc(map.get("IPC_ALL"));								// IPC
		fpatBean.setApplicant(map.get("APPLICANT"));						// 출원인 
		fpatBean.setInventors(map.get("INVENTOR"));						// 발명자
		fpatBean.setAgents(map.get("AGENT"));							// 대리인
		fpatBean.setApplicationNo(map.get("APPL_NUM"));					// 출원번호 
		fpatBean.setApplicationdate(map.get("APPL_DATE"));				// 출원일 
		fpatBean.setOpenNumber(map.get("OPEN_NUM"));						// 공개번호 
		fpatBean.setOpenDate(map.get("OPEN_DATE"));						// 공개일 
		fpatBean.setRegisterNo(regiNum);									// 등록/공고번호
		fpatBean.setRegisterDate(regiDate);								// 등록/공고일 
		fpatBean.setPriorityNo(map.get("PRIORITY_NUM"));					// 우선권번호 
		fpatBean.setPriorityDate(map.get("PRIORITY_DATE"));				// 우선권주장일
		fpatBean.setFi(map.get("FI_CODE_JP"));							// FI 
		fpatBean.setCollectionValues(map.get("NATL_CODE")); 				// 국가 
		
//		categorySearchQuery.setInternationalApplicationNumber(map.get("TITLE"));	
//		categorySearchQuery.setInternationOpenNumber(map.get("TITLE"));	
//		categorySearchQuery.setInternationalApplicationDate(map.get("TITLE"));
//		categorySearchQuery.setInternationOpenDate(map.get("TITLE"));
		
		SearchResultArray bean = stub.advancedSearch(fpatBean);
		SearchResult[] arrays = bean.getSearchTestResult();
		int totalSearchCount = Integer.parseInt(bean.getTotalSearchCount());
		for(SearchResult arr : arrays) {
			Map<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("APPL_NUM_ORG", arr.getLtrtno());			// 문서번호 
			tempMap.put("TITLE", arr.getInventionName());			// 발명의명칭 
			tempMap.put("IPC_ALL", arr.getIpc());					// IPC
			tempMap.put("REGI_NUM", arr.getRegisterNo());			// 등록번호 
			tempMap.put("REGI_DATE", arr.getRegisterDate());			// 등록일 	
			tempMap.put("APPL_NUM", arr.getApplicationNo());			// 출원번호 
			tempMap.put("APPL_DATE", arr.getApplicationDate());		// 출원일 
			tempMap.put("OPEN_NUM", arr.getOpenNumber());			// 공개번호 
			tempMap.put("OPEN_DATE", arr.getOpenDate());				// 공개일 
			tempMap.put("LAID_PUBLIC_NUM", arr.getPublishrNo());		// 공고번호 
			tempMap.put("LAID_PUBLIC_DATE", arr.getPublishrDate());	// 공고일 
			tempMap.put("APPLICANT", arr.getApplicant());			// 우선권번호 
			tempMap.put("UPC_CURRENT_ALL", arr.getUpc());			// 우선권주장일 
			tempMap.put("FI_CODE_JP", arr.getFi());					// FI
			tempMap.put("F_TERM_JP", arr.getFterm());				// F-TERM
			list.add(tempMap);
		}
		return totalSearchCount;
	}
}
