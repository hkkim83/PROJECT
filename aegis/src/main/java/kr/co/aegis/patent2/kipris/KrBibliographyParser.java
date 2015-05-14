package kr.co.aegis.patent2.kipris;

import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorArtDocumentsInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorityInfo;

public class KrBibliographyParser extends BibliographyParser{
	private static final String DELIMITER = " | ";
		
	public KrBibliographyParser(Map<String, String> map) {
		super(map);
	}

	/**
	 * 국내 서지정보 설정 
	 * @param biblioSummaryInfo
	 */
	public void setBiblioSummaryInfo(BiblioSummaryInfo[] biblioSummaryInfos) {
//		logger.info("KrBibliographyParser::::::::::");
		if(biblioSummaryInfos == null || biblioSummaryInfos.length < 1) return;
//		for(int i=0; i<biblioSummaryInfos.length; i++) {
//			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getInventionTitle());
//			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getApplicationNumber());
//			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getApplicationDate());
//			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getPublicationNumber());
//			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getPublicationDate());
//			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getRegisterNumber());
//			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getRegisterDate());
//		}
		
		BiblioSummaryInfo biblioSummaryInfo = biblioSummaryInfos[0];
		if(biblioSummaryInfo == null) return;
		
		String title = biblioSummaryInfo.getInventionTitle();
		String applDate = getApplDate(biblioSummaryInfo.getApplicationDate());
		String openNum = getLaidPulbicNum(biblioSummaryInfo.getOpenNumber());
		String openDate = getLaidPulbicDate(biblioSummaryInfo.getOpenDate());
		String laidPulbicNum = getLaidPulbicNum(biblioSummaryInfo.getPublicationNumber());
		String laidPulbicDate = getLaidPulbicDate(biblioSummaryInfo.getPublicationDate());
		String regiNum = getRegiNum(biblioSummaryInfo.getRegisterNumber());
		String regiDate = getRegiDate(biblioSummaryInfo.getRegisterDate());
		String registerStatus = biblioSummaryInfo.getRegisterStatus();
		if(StringUtil.isNull(map.get("TITLE"))) map.put("TITLE", title);
		if(StringUtil.isNull(map.get("APPL_DATE"))) map.put("APPL_DATE", applDate);
		if(StringUtil.isNull(map.get("OPEN_NUM"))) map.put("OPEN_NUM", openNum);
		if(StringUtil.isNull(map.get("OPEN_DATE"))) map.put("OPEN_DATE", openDate);
		if(StringUtil.isNull(map.get("LAID_PUBLIC_NUM"))) map.put("LAID_PUBLIC_NUM", laidPulbicNum);
		if(StringUtil.isNull(map.get("LAID_PUBLIC_DATE"))) map.put("LAID_PUBLIC_DATE", laidPulbicDate);
		if(StringUtil.isNull(map.get("REGI_NUM"))) map.put("REGI_NUM", regiNum);
		if(StringUtil.isNull(map.get("REGI_DATE"))) map.put("REGI_DATE", regiDate);	
		if(StringUtil.isNull(map.get("LEGAL_STATUS"))) map.put("LEGAL_STATUS", registerStatus);	
	}
	
	/**
	 * IPC 정보 
	 * @param ipcInfos
	 */
	public void setIpcInfo(IpcInfo[] ipcInfos) {
		if(ipcInfos == null || ipcInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(IpcInfo ipcInfo : ipcInfos) {
			if(ipcInfo == null) return;
			sb.append(ipcInfo.getIpcNumber()).append(DELIMITER);
//			logger.info("ipcInfos:::::\n"+ipcInfo.getIpcNumber());
		}
//		logger.info("setIpcInfo::::::"+sb.toString());
		if(StringUtil.isNull(map.get("IPC_ALL"))) map.put("IPC_ALL", getIpcAll(sb.toString()));
//		IpcInfo ipcInfo = ipcInfos[0];
//		String ipcAll = getIpcAll(ipcInfo.getIpcCd());
//		if(StringUtil.isNull(map.get("IPC_ALL"))) map.put("IPC_ALL", ipcAll);
	}
	
	/**
	 * 요약정보 
	 * @param summations
	 */
	public void setAbstractInfo(AbstractInfo[] abstractInfos) {
		if(abstractInfos == null || abstractInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<abstractInfos.length; i++) {
			if(abstractInfos[i] == null) return;
			sb.append(abstractInfos[i].getAstrtCont());
//			logger.info("abstractInfos:::"+abstractInfos[i]);
		}
//		logger.info(map.get("APPL_NUM_ORG")+":::"+map.get("CLAIM_MAIN"));
//		logger.info(map.get("APPL_NUM_ORG")+":::setAbstractInfo::::::"+sb.toString().trim());
		if(StringUtil.isNull(map.get("ABSTRACT"))) map.put("ABSTRACT", getAbstract(sb.toString()));
//		AbstractInfo abstractInfo = abstractInfos[0];
//		if(abstractInfo == null) return;
//		String astrtCont = getAbstract(abstractInfo.getAstrtCont());
//		if(StringUtil.isNull(map.get("ABSTRACT"))) map.put("ABSTRACT", astrtCont);	
	}
	
	/**
	 * 대표청구항 정보 
	 * @param claimInfos
	 */
	public void setClaimInfo(ClaimInfo[] claimInfos) {
		if(claimInfos == null || claimInfos.length < 1) return;
//		StringBuilder sb = new StringBuilder();
//		logger.info("claimInfos:::::\n"+claimInfos);
//		for(int i=0; i<claimInfos.length; i++) {
//			if(claimInfos[i] == null) return;
//			sb.append(claimInfos[i].getClaim());
//			logger.info(":::claimInfos::"+i+":::\n"+claimInfos[i].getClaim());
//		}
//		logger.info(map.get("APPL_NUM_ORG")+":::"+map.get("CLAIM_MAIN"));
//		logger.info(map.get("APPL_NUM_ORG")+":::setClaimInfo::::::"+sb.toString());
//		if(StringUtil.isNull(map.get("CLAIM_MAIN"))) map.put("CLAIM_MAIN", getClaimMain(sb.toString()));
		ClaimInfo claimInfo = claimInfos[0];
		if(claimInfo == null) return;
		String claimMain = getClaimMain(claimInfo.getClaim());
		if(StringUtil.isNull(map.get("CLAIM_MAIN"))) map.put("CLAIM_MAIN", claimMain);
	}
	
	/**
	 * 출원인정보 
	 * @param applicantInfos
	 */
	public void setApplicantInfo(ApplicantInfo[] applicantInfos) {
		if(applicantInfos == null || applicantInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<applicantInfos.length; i++) {
			if(applicantInfos[i] == null) return;
			sb.append(applicantInfos[i].getName());
//			logger.info("applicantInfos::"+i+":::\n"+applicantInfos[i].getName());
//			logger.info("applicantInfos::"+i+":::\n"+applicantInfos[i].getCountry());
		}
		ApplicantInfo applicantInfo = applicantInfos[0];
		if(applicantInfo == null) return;
		String applicant = getApplicant(sb.toString());
		String applicantNatl = getApplicantNatl(applicantInfo.getCountry());
		if(StringUtil.isNull(map.get("APPLICANT"))) map.put("APPLICANT", applicant);	
		if(StringUtil.isNull(map.get("APPLICANT_NATL"))) map.put("APPLICANT_NATL", applicantNatl);	
	}
	
	/**
	 * 발명자 정보 
	 * @param inventorInfos
	 */
	public void setInventorsInfo(InventorInfo[] inventorInfos) {
		if(inventorInfos == null || inventorInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<inventorInfos.length; i++) {
			if(inventorInfos[i] == null) return;
			sb.append(inventorInfos[i].getName());
//			logger.info("inventorInfos::"+i+":::\n"+inventorInfos[i].getName());
		}
		String inventor = getInventor(sb.toString());
		if(StringUtil.isNull(map.get("INVENTOR"))) map.put("INVENTOR", inventor);	
	}
	
	/**
	 * 우선권 정보 
	 * @param priorityInfos
	 */
	public void setPriorityNumberDateInfo(PriorityInfo[] priorityInfos) {
		if(priorityInfos == null || priorityInfos.length < 1) return;
//		for(int i=0; i<priorityInfos.length; i++) {
//			logger.info("priorityInfos::"+i+":::\n"+priorityInfos[i].getPriorityApplicationNumber());
//			logger.info("priorityInfos::"+i+":::\n"+priorityInfos[i].getPriorityApplicationDate());
//			logger.info("priorityInfos::"+i+":::\n"+priorityInfos[i].getPriorityApplicationCountry());
//		}
		PriorityInfo priorityInfo = priorityInfos[0];
		if(priorityInfo == null) return;
		String priorityNum = getPriorityNum(priorityInfo.getPriorityApplicationNumber());
		String priorityDate = getPriorityDate(priorityInfo.getPriorityApplicationDate());
		String priorityNatl = getPriorityNatl(priorityInfo.getPriorityApplicationCountry());

		if(StringUtil.isNull(map.get("PRIORITY_NUM"))) map.put("PRIORITY_NUM", priorityNum);	
		if(StringUtil.isNull(map.get("PRIORITY_DATE"))) map.put("PRIORITY_DATE", priorityDate);	
		if(StringUtil.isNull(map.get("PRIORITY_NATL"))) map.put("PRIORITY_NATL", priorityNatl);	
	}

	/**
	 * 인용문헌 정보 
	 * @param priorArtDocumentsInfos
	 */
	public void setPriorArtDocumentsInfo(PriorArtDocumentsInfo[] priorArtDocumentsInfos) {
		String bcBeNum = "";
		int bcCount = 0;
		bcCount = priorArtDocumentsInfos.length;
		if(bcCount > 0 && priorArtDocumentsInfos != null) {
			for(PriorArtDocumentsInfo priorArtDocumentsInfo : priorArtDocumentsInfos) {
				bcBeNum += priorArtDocumentsInfo.getDocumentsNumber()+DELIMITER;
			}				
		}

		if(StringUtil.isNull(map.get("BC_BE_NUM"))) map.put("BC_BE_NUM", getBcBeNum(bcBeNum));
		if(StringUtil.isNull(map.get("BC_COUNT"))) map.put("BC_COUNT", String.valueOf(bcCount));
	}
}
