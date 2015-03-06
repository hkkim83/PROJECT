package kr.co.aegis.patent2.kipris;

import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo;

public class OthBibliographyParser extends BibliographyParser{ 
	
	private static final String DELIMITER = " | ";
	public OthBibliographyParser(Map<String, String> map) {
		super(map);
	}

	/**
	 * 해외 서지정보 설정 
	 * @param biblioSummaryInfo
	 */
	public void setBibliographicSummaryInfo(BibliographicSummaryInfo biblioSummaryInfo) {
		String title = biblioSummaryInfo.getInventionTitle();
		String applDate = getApplDate(biblioSummaryInfo.getApplicationDate());
		String openNum = getOpenNum(biblioSummaryInfo.getOpenNumber());
		String openDate = getOpenDate(biblioSummaryInfo.getOpenDate());
		String laidPulbicNum = getLaidPulbicNum(biblioSummaryInfo.getPublicationNumber());
		String laidPulbicDate = getLaidPulbicDate(biblioSummaryInfo.getPublishDate());
		
		if(StringUtil.isNull(map.get("TITLE"))) map.put("TITLE", title);
		if(StringUtil.isNull(map.get("APPL_DATE"))) map.put("APPL_DATE", applDate);
		if(StringUtil.isNull(map.get("OPEN_NUM"))) map.put("OPEN_NUM", openNum);
		if(StringUtil.isNull(map.get("OPEN_DATE"))) map.put("OPEN_DATE", openDate);
		if(StringUtil.isNull(map.get("REGI_NUM"))) map.put("REGI_NUM", laidPulbicNum);
		if(StringUtil.isNull(map.get("REGI_DATE"))) map.put("REGI_DATE", laidPulbicDate);
		if(StringUtil.isNull(map.get("LAID_PUBLIC_NUM"))) map.put("LAID_PUBLIC_NUM", laidPulbicNum);
		if(StringUtil.isNull(map.get("LAID_PUBLIC_DATE"))) map.put("LAID_PUBLIC_DATE", laidPulbicDate);

		logger.info("OtherbiblioSummaryInfo:::::\n"+biblioSummaryInfo.getApplicationNumber());
		logger.info("OtherbiblioSummaryInfo:::::\n"+biblioSummaryInfo.getApplicationDate());
		logger.info("OtherbiblioSummaryInfo:::::\n"+biblioSummaryInfo.getInventionTitle());
		logger.info("OtherbiblioSummaryInfo:::::\n"+biblioSummaryInfo.getPublicationNumber());
		logger.info("OtherbiblioSummaryInfo:::::\n"+biblioSummaryInfo.getPublishDate());		
	}
	
	/**
	 * IPC 정보 
	 * @param ipcInfos
	 */
	public void setIpcInfo(IpcInfo[] ipcInfos) {
		if(ipcInfos == null || ipcInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ipcInfos.length; i++) {
			if(ipcInfos[i] == null) return;
			sb.append(ipcInfos[i].getIpcCd()).append(DELIMITER);
			logger.info("OtheripcInfos:::::\n"+ipcInfos[i].getIpcCd());
		}
		logger.info("OthersetIpcInfo::::::"+sb.toString());
		if(StringUtil.isNull(map.get("IPC_ALL"))) map.put("IPC_ALL", getIpcAll(sb.toString()));
//		IpcInfo ipcInfo = ipcInfos[0];
//		String ipcAll = getIpcAll(ipcInfo.getIpcCd());
//		if(StringUtil.isNull(map.get("IPC_ALL"))) map.put("IPC_ALL", ipcAll);
	}
	
	/**
	 * 요약정보 
	 * @param summations
	 */
	public void setSummation(Summation[] summations) {
		if(summations == null || summations.length < 1) return;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<summations.length; i++) {
			if(summations[i] == null) return;
			sb.append(summations[i].getAstrtCont());
			logger.info("Othersummations2:::"+summations[i]);
//			logger.info("summations3:::"+i+"::\n"+summations[i].getAstrtCont());
		}
		logger.info("OthersetSummation::::::"+sb.toString());
		if(StringUtil.isNull(map.get("ABSTRACT"))) map.put("ABSTRACT", getAbstract(sb.toString()));		
//		Summation summation = summations[0];
//		String astrtCont = getAbstract(summation.getAstrtCont());
//		if(StringUtil.isNull(map.get("ABSTRACT"))) map.put("ABSTRACT", astrtCont);	
	}
	
	/**
	 * 대표청구항 
	 * @param demandParagraphInfos
	 */
	public void setDemandParagraphInfo(DemandParagraphInfo[] demandParagraphInfos) {
		if(demandParagraphInfos == null || demandParagraphInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<demandParagraphInfos.length; i++) {
			logger.info("OtherdemandParagraphInfos:::"+demandParagraphInfos[i]);
			if(demandParagraphInfos[i] == null) return;
			sb.append(demandParagraphInfos[i].getClaimText());
			logger.info("OtherdemandParagraphInfos:::"+demandParagraphInfos[i]);
//			logger.info("summations3:::"+i+"::\n"+summations[i].getAstrtCont());
		}
		logger.info("setDemandParagraphInfo::::::"+sb.toString());
		if(StringUtil.isNull(map.get("CLAIM_MAIN"))) map.put("CLAIM_MAIN", getClaimMain(sb.toString()));	
//		DemandParagraphInfo demandParagraphInfo = demandParagraphInfos[0];
//		if(demandParagraphInfo == null) return;
//		String claimMain = getAbstract(demandParagraphInfo.getClaimText());
//		if(StringUtil.isNull(map.get("CLAIM_MAIN"))) map.put("CLAIM_MAIN", claimMain);			
	}
	
	/**
	 * 출원인정보 
	 * @param applicantInfos
	 */
	public void setApplicantInfo(ApplicantInfo[] applicantInfos) {
		if(applicantInfos == null || applicantInfos.length < 1) return;
		for(int i=0; i<applicantInfos.length; i++) {
			logger.info("OtherapplicantInfos:::"+i+"::\n"+applicantInfos[i].getApplicantName());
			logger.info("OtherapplicantInfos:::"+i+"::\n"+applicantInfos[i].getApplicantName());
		}
		ApplicantInfo applicantInfo = applicantInfos[0];
		if(applicantInfo == null) return;
		String applicant = getApplicant(applicantInfo.getApplicantName());
		String applicantNatl = getApplicantNatl(applicantInfo.getApplicantCountry());
		if(StringUtil.isNull(map.get("APPLICANT"))) map.put("APPLICANT", applicant);	
		if(StringUtil.isNull(map.get("APPLICANT_NATL"))) map.put("APPLICANT_NATL", applicantNatl);	
	}
	
	/**
	 * 발명자 정보 
	 * @param inventorInfos
	 */
	public void setInventorsInfo(InventorsInfo[] inventorInfos) {
		if(inventorInfos == null || inventorInfos.length < 1) return;
		for(int i=0; i<inventorInfos.length; i++) {
			logger.info("OtherinventorInfos:::"+i+"::\n"+inventorInfos[i].getInventorName());
		}
		InventorsInfo inventorInfo = inventorInfos[0];
		if(inventorInfo == null) return;
		String inventor = getInventor(inventorInfo.getInventorName());
		if(StringUtil.isNull(map.get("INVENTOR"))) map.put("INVENTOR", inventor);	
	}
	
	/**
	 * 우선권 정보 
	 * @param priorityInfos
	 */
	public void setPriorityNumberDateInfo(PriorityNumberDateInfo[] priorityInfos) {
		if(priorityInfos == null || priorityInfos.length < 1) return;
		for(int i=0; i<priorityInfos.length; i++) {
			logger.info("OtherpriorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationNumber());
			logger.info("OtherpriorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationDate());
			logger.info("OtherpriorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationCountry());
		}
		PriorityNumberDateInfo priorityInfo = priorityInfos[0];
		if(priorityInfo == null) return;
		String priorityNum = getPriorityNum(priorityInfo.getPriorityApplicationNumber());
		String priorityDate = getPriorityDate(priorityInfo.getPriorityApplicationDate());
		String priorityNatl = getPriorityNatl(priorityInfo.getPriorityApplicationCountry());

		if(StringUtil.isNull(map.get("PRIORITY_NUM"))) map.put("PRIORITY_NUM", priorityNum); 
		if(StringUtil.isNull(map.get("PRIORITY_DATE"))) map.put("PRIORITY_DATE", priorityDate);
		if(StringUtil.isNull(map.get("PRIORITY_NATL"))) map.put("PRIORITY_NATL", priorityNatl);
	}
	
	/**
	 * f-term 정보 
	 * @param ftermInfos
	 */
	public void setFtermInfo(FtermInfo[] ftermInfos) {
		if(ftermInfos == null || ftermInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ftermInfos.length; i++) {
			if(ftermInfos[i] == null) return;
			sb.append(ftermInfos[i].getFTermCode()).append(DELIMITER);
			logger.info("OtherftermInfos:::"+i+"::\n"+ftermInfos[i].getFTermCode());
		}
		if(StringUtil.isNull(map.get("F_TERM_JP"))) map.put("F_TERM_JP", getFtermJp(sb.toString()));		

//		FtermInfo ftermInfo = ftermInfos[0];
//		if(ftermInfo == null) return;
//		String fTermJp = getFtermInfo(ftermInfo.getFTermCode());
//		if(StringUtil.isNull(map.get("F_TERM_JP"))) map.put("F_TERM_JP", fTermJp);	
	}
	
	/**
	 * fi정보 
	 * @param fiInfos
	 */
	public void setFiInfo(FiInfo[] fiInfos) {
		if(fiInfos == null || fiInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<fiInfos.length; i++) {
			if(fiInfos[i] == null) return;
			sb.append(fiInfos[i].getPublKey()).append(DELIMITER);
			logger.info("OtherfiInfos:::"+i+"::\n"+fiInfos[i].getPublKey());
		}
		if(StringUtil.isNull(map.get("FI_CODE_JP"))) map.put("FI_CODE_JP", getFiCodeJp(sb.toString()));	

//		FiInfo fiInfo = fiInfos[0];
//		if(fiInfo == null) return;
//		String fiCodeJp = getFiCodeJp(fiInfo.getPublKey());
//		if(StringUtil.isNull(map.get("FI_CODE_JP"))) map.put("FI_CODE_JP", fiCodeJp);	
	}
	
	/**
	 * upc정보 
	 * @param upcInfos
	 */
	public void setUpcInfo(UpcInfo[] upcInfos) {
		if(upcInfos == null || upcInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<upcInfos.length; i++) {
			if(upcInfos[i] == null) return;
			sb.append(upcInfos[i].getUpcUspdCd()).append(DELIMITER);
			logger.info("OtherupcInfos:::"+i+"::\n"+upcInfos[i].getUpcUspdCd());
		}
		if(StringUtil.isNull(map.get("UPC_CURRENT_ALL"))) map.put("UPC_CURRENT_ALL", getUpcCurrentAll(sb.toString()));	
//		UpcInfo upcInfo = upcInfos[0];
//		if(upcInfo == null) return;
//		String upcCurrentAll = getUpcCurrentAll(upcInfo.getUpcUspdCd());
//		if(StringUtil.isNull(map.get("UPC_CURRENT_ALL"))) map.put("UPC_CURRENT_ALL", upcCurrentAll);		
	}
	
	/**
	 * cpc정보 
	 * @param cpcInfos
	 */
	public void setCpcInfo(CpcInfo[] cpcInfos) {
		if(cpcInfos == null || cpcInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cpcInfos.length; i++) {
			if(cpcInfos[i] == null) return;
			sb.append(cpcInfos[i].getCpcCd()).append(DELIMITER);
			logger.info("OtherCpcInfos:::"+i+"::\n"+cpcInfos[i].getCpcCd());
		}
		if(StringUtil.isNull(map.get("CPC"))) map.put("CPC", getCpc(sb.toString()));	
//		CpcInfo cpcInfo = cpcInfos[0];
//		if(cpcInfo == null) return;
//		String cpc = getCpc(cpcInfo.getCpcCd());
//		if(StringUtil.isNull(map.get("CPC"))) map.put("CPC", cpc);		
	}
	
	/**
	 * epc정보 
	 * @param eclaInfos
	 */
	public void setEclaInfo(EclaInfo[] eclaInfos) {
		if(eclaInfos == null || eclaInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<eclaInfos.length; i++) {
			if(eclaInfos[i] == null) return;
			sb.append(eclaInfos[i].getClssCd()).append(DELIMITER);
			logger.info("OtherEpcInfos:::"+i+"::\n"+eclaInfos[i].getClssCd());
		}
		if(StringUtil.isNull(map.get("EPC"))) map.put("EPC", getEpc(sb.toString()));
//		EclaInfo eclaInfo = eclaInfos[0];
//		if(eclaInfo == null) return;
//		String cpc = getEpc(eclaInfo.getClssCd());
//		if(StringUtil.isNull(map.get("EPC"))) map.put("EPC", cpc);		
	}
}
