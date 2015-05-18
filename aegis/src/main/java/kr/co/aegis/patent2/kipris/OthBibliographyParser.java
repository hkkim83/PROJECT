package kr.co.aegis.patent2.kipris;

import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo;
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
		}
		if(StringUtil.isNull(map.get("IPC_ALL"))) map.put("IPC_ALL", getIpcAll(sb.toString()));
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
		}
		if(StringUtil.isNull(map.get("ABSTRACT"))) map.put("ABSTRACT", getAbstract(sb.toString()));		
	}
	
	/**
	 * 대표청구항 
	 * @param demandParagraphInfos
	 */
	public void setDemandParagraphInfo(DemandParagraphInfo[] demandParagraphInfos) {
		if(demandParagraphInfos == null || demandParagraphInfos.length < 1) return;
		DemandParagraphInfo demandParagraphInfo = demandParagraphInfos[0];
		if(demandParagraphInfo == null) return;
		String claimMain = getClaimMain(demandParagraphInfo.getClaimText());
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
			sb.append(applicantInfos[i].getApplicantName());
		}
		ApplicantInfo applicantInfo = applicantInfos[0];
		if(applicantInfo == null) return;
		String applicant = getApplicant(sb.toString());
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
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<inventorInfos.length; i++) {
			if(inventorInfos[i] == null) return;
			sb.append(inventorInfos[i].getInventorName());
		}
		String inventor = getInventor(sb.toString());
		if(StringUtil.isNull(map.get("INVENTOR"))) map.put("INVENTOR", inventor);	
	}
	
	/**
	 * 우선권 정보 
	 * @param priorityInfos
	 */
	public void setPriorityNumberDateInfo(PriorityNumberDateInfo[] priorityInfos) {
		if(priorityInfos == null || priorityInfos.length < 1) return;
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
		}
		if(StringUtil.isNull(map.get("F_TERM_JP"))) map.put("F_TERM_JP", getFtermJp(sb.toString()));		
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
		}
		if(StringUtil.isNull(map.get("FI_CODE_JP"))) map.put("FI_CODE_JP", getFiCodeJp(sb.toString()));	
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
		}
		if(StringUtil.isNull(map.get("UPC_CURRENT_ALL"))) map.put("UPC_CURRENT_ALL", getUpcCurrentAll(sb.toString()));	
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
		}
		if(StringUtil.isNull(map.get("CPC"))) map.put("CPC", getCpc(sb.toString()));	
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
		}
		if(StringUtil.isNull(map.get("EPC"))) map.put("EPC", getEpc(sb.toString()));
	}
	
	
	/**
	 * 패밀리정보 가져오기
	 * 2015.05.14 해외 패밀리 정보 가져오는 API변경 
	 * @param eclaInfos
	 */
	public void setFamilyInfo(FamilyInfo[] familyInfos) {
		if(familyInfos == null || familyInfos.length < 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<familyInfos.length; i++) {
			if(familyInfos[i] == null) return;
			sb.append(familyInfos[i].getFamilyNumber()).append(DELIMITER);
		}
		if(StringUtil.isNull(map.get("FM_NUM"))) map.put("FM_NUM", StringUtil.subStr2(sb.toString(), -3));
		if(StringUtil.isNull(map.get("FM_COUNT"))) map.put("FM_COUNT", String.valueOf(familyInfos.length));	
	}
}
