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
import kr.or.kipris.plus.ForeignPatentUtilServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentUtilServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FpatBeanItem;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo;

public class OthPatentFilePath extends PatentFilePath{
	
	public OthPatentFilePath(String userId, String userKey, String kiprisUrl,
			String defaultPath) {
		super(userId, userKey, kiprisUrl, defaultPath);
	}

	/**
	 * KIPRIS PLUS용 출원번호 가져오기
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public void setApplNumOrg(Map<String, String>map) {
		ForeignPatentUtilServicePortTypeProxy proxy = new ForeignPatentUtilServicePortTypeProxy();
		ForeignPatentUtilServiceSoap11BindingStub stub =(ForeignPatentUtilServiceSoap11BindingStub)proxy.getForeignPatentUtilServicePortType();
		// 등록번호가 있으면 등록번호 사용, 없으면 공개번호, 출원번호 사용 
		String natlCode = map.get("NATL_CODE");
		String regiNum  = map.get("KIPRIS_REGI_NUM");
		String applNum  = StringUtil.isNull(regiNum) ? map.get("KIPRIS_APPL_NUM") : null;
		String openNum  = StringUtil.isNull(regiNum) ? map.get("KIPRIS_OPEN_NUM") : null;
		String applNumOrg = null;
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);

			logger.info(":::::::setKiprisApplNumOrg:::::::::");
			logger.info("natlCode::"+natlCode);
			logger.info("applNum::"+applNum);
			logger.info("openNum::"+openNum);
			logger.info("regiNum::"+regiNum);
			
			LtrtnoInfo[] arrays = stub.getLtrtno(natlCode, applNum, openNum, regiNum, null);
			if(arrays == null || arrays.length < 1) return;
			logger.info("arrays::::::"+arrays.length);
			for(LtrtnoInfo ltrtnoInfo : arrays) {
				logger.info("ltrtnoInfo::::::"+ltrtnoInfo.getLtrtno());	
				applNumOrg = ltrtnoInfo.getLtrtno();
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			map.put("APPL_NUM_ORG", applNumOrg);
		}
	}
	
	/***
	 * 출원번호 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getFilePath(Map<String, String>map) {
		
		ForeignPatentImageAndFullTextServicePortTypeProxy proxy = new ForeignPatentImageAndFullTextServicePortTypeProxy();
		ForeignPatentImageAndFullTextServiceSoap11BindingStub stub =(ForeignPatentImageAndFullTextServiceSoap11BindingStub)proxy.getForeignPatentImageAndFullTextServicePortType();
		String patentFullText = null; 
		String imageMain      = null;
		String imageSmall     = null;
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			String applNum  = map.get("APPL_NUM_ORG");
			String natlCode = map.get("NATL_CODE");
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			logger.info("applNum::::::"+applNum+" , "+natlCode+" , "+_defaultTxtPath+" , "+_defaultPath);
			FullTextInfo fullTextInfo = (FullTextInfo)stub.fullTextInfo(applNum, natlCode);
	
			RepresentationImageInfo[] imagePathInfos = (RepresentationImageInfo[])stub.representationImageInfo(applNum, natlCode);
			patentFullText = fullTextInfo.getPath(); 
			imageMain      = imagePathInfos[0] == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getJpgPath();
			imageSmall     = imagePathInfos[0] == null || imagePathInfos.length == 0 ? "" : imagePathInfos[0].getJpgPath();
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			map.put("PATENT_FULLTXT", StringUtil.isNull(patentFullText)  ? _defaultTxtPath : patentFullText);
			map.put("IMAGE_MAIN"    , StringUtil.isNull(imageMain)  ? _defaultPath : imageMain);
			map.put("IMAGE_SMALL"   , StringUtil.isNull(imageSmall) ? _defaultPath : imageSmall);
			logger.info("imageMain::::"+imageMain+"::::::");
			logger.info("patentFullText::::"+patentFullText);
		}		
		
	}
	
	/***
	 * KIPRIS 서지 정보 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void getBibliography(Map<String, String>map) {
		ForeignPatentBibliographicServicePortTypeProxy proxy = new ForeignPatentBibliographicServicePortTypeProxy();
		ForeignPatentBibliographicServiceSoap11BindingStub stub =(ForeignPatentBibliographicServiceSoap11BindingStub)proxy.getForeignPatentBibliographicServicePortType();
		String applNum  = map.get("APPL_NUM_ORG");
		String natlCode = map.get("NATL_CODE");

		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			BibliographyParser parser = new OthBibliographyParser(map);
			// 서지정보
			logger.info("getKiprisBibliography::::"+applNum+","+natlCode);
			BibliographicSummaryInfo biblioSummaryInfo = (BibliographicSummaryInfo)stub.bibliographicSummaryInfo(applNum, natlCode);
			parser.setBibliographicSummaryInfo(biblioSummaryInfo);
			logger.info("getKiprisBibliography::::"+biblioSummaryInfo);
			
			
			// ipc정보
			IpcInfo[] ipcInfos = (IpcInfo[])stub.ipcInfo(applNum, natlCode);
			parser.setIpcInfo(ipcInfos);
			// 초록
			Summation[] summations = (Summation[])stub.summation(applNum, natlCode);
			parser.setSummation(summations);
			logger.info("summations1::::"+summations.length);

			// 청구항
	//		ClaimInfo[] claimInfos = (ClaimInfo[])stub.claimInfo(applNum);
	//		ClaimInfo claimInfo = claimInfos[0];
	//		map.put("claim_main", StringUtil.isNull(map.get("claim_main")) ? map.get("claim_main") : claimInfo.getClaim());
			
			// 출원인정보
			ApplicantInfo[] applicantInfos = (ApplicantInfo[])stub.applicantInfo(applNum, natlCode);
			parser.setApplicantInfo(applicantInfos);
			
			// 발명자정보
			InventorsInfo[] inventorInfos = (InventorsInfo[])stub.inventorsInfo(applNum, natlCode);
			parser.setInventorsInfo(inventorInfos);
			
			// 우선권정보
			PriorityNumberDateInfo[] priorityInfos = (PriorityNumberDateInfo[])stub.priorityNumberDateInfo(applNum, natlCode);
			parser.setPriorityNumberDateInfo(priorityInfos);
			
			// f-term정보
			FtermInfo[] ftermInfos = (FtermInfo[])stub.ftermInfo(applNum, natlCode);
			parser.setFtermInfo(ftermInfos);
			
			// fi정보 
			FiInfo[] fiInfos = (FiInfo[])stub.fiInfo(applNum, natlCode);
			parser.setFiInfo(fiInfos);
			
			// upc정보
			UpcInfo[] upcInfos = (UpcInfo[])stub.upcInfo(applNum, natlCode);
			parser.setUpcInfo(upcInfos);
			
			logger.info("getKiprisBibliography++++++"+map);
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	};
	
	/**
	 * KIPRIS DB검색식으로 전체검색하기 
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	public int getAdvancedSearch(Map<String, String>map, List<Map<String, String>> list ) {
		
	   	ForeignPatentAdvencedSearchServicePortTypeProxy proxy = new ForeignPatentAdvencedSearchServicePortTypeProxy();
		ForeignPatentAdvencedSearchServiceSoap11BindingStub stub =(ForeignPatentAdvencedSearchServiceSoap11BindingStub)proxy.getForeignPatentAdvencedSearchServicePortType();
		String regiNum  = !StringUtil.isNull(map.get("LAID_PUBLIC_NUM"))  ? map.get("LAID_PUBLIC_NUM")  : map.get("REGI_NUM");
		String regiDate = !StringUtil.isNull(map.get("LAID_PUBLIC_DATE")) ? map.get("LAID_PUBLIC_DATE") : map.get("REGI_DATE");
		int totalSearchCount = 0;
		try {
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			FpatBeanItem fpatBean = new FpatBeanItem();		
//			fpatBean.setInventionName(map.get("FREE"));						// 전체
			fpatBean.setInventionName(map.get("TITLE"));						// 발명의 명칭
//			fpatBean.setAbstracts(map.get("ABSTRACT"));						// 요약 
//			fpatBean.setClaimExtend(map.get("CLAIM_MAIN"));					// 대표청구항 
//			fpatBean.setIpc(map.get("IPC_ALL"));								// IPC
//			fpatBean.setApplicant(map.get("APPLICANT"));						// 출원인 
//			fpatBean.setInventors(map.get("INVENTOR"));						// 발명자
//			fpatBean.setAgents(map.get("AGENT"));							// 대리인
//			fpatBean.setApplicationNo(map.get("APPL_NUM"));					// 출원번호 
//			fpatBean.setApplicationdate(map.get("APPL_DATE"));				// 출원일 
//			fpatBean.setOpenNumber(map.get("OPEN_NUM"));						// 공개번호 
//			fpatBean.setOpenDate(map.get("OPEN_DATE"));						// 공개일 
//			fpatBean.setRegisterNo(regiNum);									// 등록/공고번호
//			fpatBean.setRegisterDate(regiDate);								// 등록/공고일 
//			fpatBean.setPriorityNo(map.get("PRIORITY_NUM"));					// 우선권번호 
//			fpatBean.setPriorityDate(map.get("PRIORITY_DATE"));				// 우선권주장일
//			fpatBean.setFi(map.get("FI_CODE_JP"));							// FI 
			fpatBean.setCollectionValues(map.get("NATL_CODE")); 				// 국가 
			
			SearchResultArray bean = stub.advancedSearch(fpatBean);
			SearchResult[] arrays = bean.getSearchTestResult();
			totalSearchCount = Integer.parseInt(bean.getTotalSearchCount());
			logger.info("totalSearchCount::::::::"+totalSearchCount);			
//			for(SearchResult arr : arrays) {
//				Map<String, String> tempMap = new HashMap<String, String>();
//				tempMap.put("APPL_NUM_ORG", arr.getLtrtno());			// 문서번호 
//				tempMap.put("TITLE", arr.getInventionName());			// 발명의명칭 
//				tempMap.put("IPC_ALL", arr.getIpc());					// IPC
//				tempMap.put("REGI_NUM", arr.getRegisterNo());			// 등록번호 
//				tempMap.put("REGI_DATE", arr.getRegisterDate());			// 등록일 	
//				tempMap.put("APPL_NUM", arr.getApplicationNo());			// 출원번호 
//				tempMap.put("APPL_DATE", arr.getApplicationDate());		// 출원일 
//				tempMap.put("OPEN_NUM", arr.getOpenNumber());			// 공개번호 
//				tempMap.put("OPEN_DATE", arr.getOpenDate());				// 공개일 
//				tempMap.put("LAID_PUBLIC_NUM", arr.getPublishrNo());		// 공고번호 
//				tempMap.put("LAID_PUBLIC_DATE", arr.getPublishrDate());	// 공고일 
//				tempMap.put("APPLICANT", arr.getApplicant());			// 우선권번호 
//				tempMap.put("UPC_CURRENT_ALL", arr.getUpc());			// 우선권주장일 
//				tempMap.put("FI_CODE_JP", arr.getFi());					// FI
//				tempMap.put("F_TERM_JP", arr.getFterm());				// F-TERM
//				list.add(tempMap);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalSearchCount;
	}
}
