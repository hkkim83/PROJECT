package kr.co.aegis.patent.kipris;

import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo;

public class OthBibliographyParser extends BibliographyParser{ 
	
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
		String laidPulbicNum = getLaidPulbicNum(biblioSummaryInfo.getOpenNumber());
		String laidPulbicDate = getLaidPulbicDate(biblioSummaryInfo.getOpenDate());
		
		if(StringUtil.isNull(map.get("TITLE"))) map.put("TITLE", "*"+title);
		if(StringUtil.isNull(map.get("APPL_DATE"))) map.put("APPL_DATE", "*"+applDate);
		if(StringUtil.isNull(map.get("LAID_PULBIC_NUM"))) map.put("LAID_PULBIC_NUM", "*"+laidPulbicNum);
		if(StringUtil.isNull(map.get("LAID_PULBIC_DATE"))) map.put("LAID_PULBIC_DATE", "*"+laidPulbicDate);

		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getApplicationNumber());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getApplicationDate());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getInventionTitle());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getPublicationNumber());
		logger.info("biblioSummaryInfo:::::\n"+biblioSummaryInfo.getPublishDate());		
	}
	
	/**
	 * IPC 정보 
	 * @param ipcInfos
	 */
	public void setIpcInfo(IpcInfo[] ipcInfos) {
		if(ipcInfos == null || ipcInfos.length < 1) return;
		for(int i=0; i<ipcInfos.length; i++) {
			logger.info("ipcInfos:::"+i+"::\n"+ipcInfos[i].getIpcCd());
		}
		
		IpcInfo ipcInfo = ipcInfos[0];
		if(ipcInfo == null) return;
		String ipcAll = getIpcAll(ipcInfo.getIpcCd());
		if(StringUtil.isNull(map.get("IPC_ALL"))) map.put("IPC_ALL", "*"+ipcAll);
	}
	
	/**
	 * 요약정보 
	 * @param summations
	 */
	public void setSummation(Summation[] summations) {
		if(summations == null || summations.length < 1) return;
		for(int i=0; i<summations.length; i++) {
			logger.info("summations2:::"+summations[i]);
//			logger.info("summations3:::"+i+"::\n"+summations[i].getAstrtCont());
		}
		Summation summation = summations[0];
		if(summation == null) return;
		String astrtCont = getAbstract(summation.getAstrtCont());
		if(StringUtil.isNull(map.get("ABSTRACT"))) map.put("ABSTRACT", "*"+astrtCont);	
	}
	
	/**
	 * 출원인정보 
	 * @param applicantInfos
	 */
	public void setApplicantInfo(ApplicantInfo[] applicantInfos) {
		if(applicantInfos == null || applicantInfos.length < 1) return;
		for(int i=0; i<applicantInfos.length; i++) {
			logger.info("applicantInfos:::"+i+"::\n"+applicantInfos[i].getApplicantName());
			logger.info("applicantInfos:::"+i+"::\n"+applicantInfos[i].getApplicantName());
		}
		ApplicantInfo applicantInfo = applicantInfos[0];
		if(applicantInfo == null) return;
		String applicant = getApplicant(applicantInfo.getApplicantName());
		String applicantNatl = getApplicantNatl(applicantInfo.getApplicantCountry());
		if(StringUtil.isNull(map.get("APPLICANT"))) map.put("APPLICANT", "*"+applicant);	
		if(StringUtil.isNull(map.get("APPLICANT_NATL"))) map.put("APPLICANT_NATL", "*"+applicantNatl);	
	}
	
	/**
	 * 발명자 정보 
	 * @param inventorInfos
	 */
	public void setInventorsInfo(InventorsInfo[] inventorInfos) {
		if(inventorInfos == null || inventorInfos.length < 1) return;
		for(int i=0; i<inventorInfos.length; i++) {
			logger.info("inventorInfos:::"+i+"::\n"+inventorInfos[i].getInventorName());
		}
		InventorsInfo inventorInfo = inventorInfos[0];
		if(inventorInfo == null) return;
		String inventor = getInventor(inventorInfo.getInventorName());
		if(StringUtil.isNull(map.get("INVENTOR"))) map.put("INVENTOR", "*"+inventor);	
	}
	
	/**
	 * 우선권 정보 
	 * @param priorityInfos
	 */
	public void setPriorityNumberDateInfo(PriorityNumberDateInfo[] priorityInfos) {
		if(priorityInfos == null || priorityInfos.length < 1) return;
		for(int i=0; i<priorityInfos.length; i++) {
			logger.info("priorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationNumber());
			logger.info("priorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationDate());
			logger.info("priorityInfos:::"+i+"::\n"+priorityInfos[i].getPriorityApplicationCountry());
		}
		PriorityNumberDateInfo priorityInfo = priorityInfos[0];
		if(priorityInfo == null) return;
		String priorityNum = getPriorityNum(priorityInfo.getPriorityApplicationNumber());
		String priorityDate = getPriorityDate(priorityInfo.getPriorityApplicationDate());
		String priorityNatl = getPriorityNatl(priorityInfo.getPriorityApplicationCountry());

		if(StringUtil.isNull(map.get("PRIORITY_NUM"))) {map.put("PRIORITY_NUM", "*"+priorityNum); logger.info("map:::priority_num=>"+map.get("PRIORITY_NUM"));}	
		if(StringUtil.isNull(map.get("PRIORITY_DATE"))) {map.put("PRIORITY_DATE", "*"+priorityDate);logger.info("map:::priority_date=>"+map.get("PRIORITY_DATE"));}	
		if(StringUtil.isNull(map.get("PRIORITY_NATL"))) {map.put("PRIORITY_NATL", "*"+priorityNatl);logger.info("map:::priority_natl=>"+map.get("PRIORITY_NATL"));}	
		logger.info("priorityInfos:::"+map);
	}
	
	/**
	 * f-term 정보 
	 * @param ftermInfos
	 */
	public void setFtermInfo(FtermInfo[] ftermInfos) {
		if(ftermInfos == null || ftermInfos.length < 1) return;
		for(int i=0; i<ftermInfos.length; i++) {
			logger.info("ftermInfos:::"+i+"::\n"+ftermInfos[i].getFTermCode());
		}
		FtermInfo ftermInfo = ftermInfos[0];
		if(ftermInfo == null) return;
		String fTermJp = getFtermInfo(ftermInfo.getFTermCode());
		if(StringUtil.isNull(map.get("F_TERM_JP"))) map.put("F_TERM_JP", "*"+fTermJp);	
	}
	
	/**
	 * fi정보 
	 * @param fiInfos
	 */
	public void setFiInfo(FiInfo[] fiInfos) {
		if(fiInfos == null || fiInfos.length < 1) return;
		for(int i=0; i<fiInfos.length; i++) {
			logger.info("fiInfos:::"+i+"::\n"+fiInfos[i].getPublKey());
		}
		
		FiInfo fiInfo = fiInfos[0];
		if(fiInfo == null) return;
		String fiCodeJp = getFiCodeJp(fiInfo.getPublKey());
		if(StringUtil.isNull(map.get("FI_CODE_JP"))) map.put("FI_CODE_JP", "*"+fiCodeJp);	
	}
	
	/**
	 * upc정보 
	 * @param upcInfos
	 */
	public void setUpcInfo(UpcInfo[] upcInfos) {
		if(upcInfos == null || upcInfos.length < 1) return;
		for(int i=0; i<upcInfos.length; i++) {
			logger.info("upcInfos:::"+i+"::\n"+upcInfos[i].getUpcUspdCd());
		}
		UpcInfo upcInfo = upcInfos[0];
		if(upcInfo == null) return;
		String upcCurrentAll = getUpcCurrentAll(upcInfo.getUpcUspdCd());
		if(StringUtil.isNull(map.get("UPC_CURRENT_ALL"))) map.put("UPC_CURRENT_ALL", "*"+upcCurrentAll);		
	}

}
