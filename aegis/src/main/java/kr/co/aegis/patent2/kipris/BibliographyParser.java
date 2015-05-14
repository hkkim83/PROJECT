package kr.co.aegis.patent2.kipris;

import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorArtDocumentsInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorityInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BibliographyParser {
	protected final Log logger = LogFactory.getLog(this.getClass());
	protected Map<String, String> map;
	
	public void setBibliographicSummaryInfo(BibliographicSummaryInfo biblioSummaryInfo) {}
	public void setBiblioSummaryInfo(BiblioSummaryInfo[] biblioSummaryInfos) {}
	public void setIpcInfo(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[] ipcInfos) {}
	public void setIpcInfo(kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo[] ipcInfos) {}
	public void setAbstractInfo(AbstractInfo[] abstractInfos) {}
	public void setSummation(Summation[] summations) {}
	public void setClaimInfo(ClaimInfo[] claimInfos) {}
	public void setDemandParagraphInfo(DemandParagraphInfo[] demandParagraphInfos) {}
	public void setApplicantInfo(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[] applicantInfos) {}
	public void setApplicantInfo(kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo[] applicantInfos) {}
	public void setInventorsInfo(InventorsInfo[] inventorInfos) {}
	public void setInventorsInfo(InventorInfo[] inventorInfos) {}
	public void setPriorityNumberDateInfo(PriorityNumberDateInfo[] priorityInfos) {}
	public void setPriorityNumberDateInfo(PriorityInfo[] priorityInfos) {}
	public void setPriorArtDocumentsInfo(PriorArtDocumentsInfo[] priorArtDocumentsInfos) {}
	public void setFtermInfo(FtermInfo[] ftermInfos) {}
	public void setFiInfo(FiInfo[] fiInfos) {}
	public void setUpcInfo(UpcInfo[] upcInfos) {}
	public void setCpcInfo(CpcInfo[] cpcInfos) {}
	public void setEclaInfo(EclaInfo[] eclaInfos) {}
	
	public BibliographyParser(Map<String, String> map) {
		this.map = map;
	}
	
	/**
	 * 출원일 
	 * @param applDate
	 * @return
	 */
	protected String getApplDate(String applDate) {
		applDate =  StringUtil.replaceString(applDate, "[.]", "");
		applDate = applDate.replaceAll("[(]", "");
		applDate = applDate.replaceAll("[)]", "");
		return applDate;
	}
	
	/**
	 * 공개번호 
	 * @param openNum
	 * @return
	 */
	protected String getOpenNum(String openNum) {
		return openNum;
	}
	
	/**
	 * 공개일 
	 * @param openDate
	 * @return
	 */
	protected String getOpenDate(String openDate) {
		openDate = StringUtil.replaceString(openDate, "[.]", "");
		openDate = openDate.replaceAll("[(]", "");
		openDate = openDate.replaceAll("[)]", "");
		return openDate;
	}
	
	/**
	 * 공고번호 
	 * @param laidPulbicNum
	 * @return
	 */
	protected String getLaidPulbicNum(String laidPulbicNum) {
		return laidPulbicNum;
	}
	
	/**
	 * 공고일 
	 * @param laidPulbicDate
	 * @return
	 */
	protected String getLaidPulbicDate(String laidPulbicDate) {
		laidPulbicDate =  StringUtil.replaceString(laidPulbicDate, "[.]", "");
		laidPulbicDate = laidPulbicDate.replaceAll("[(]", "");
		laidPulbicDate = laidPulbicDate.replaceAll("[)]", "");
		return laidPulbicDate;
	}
	
	/**
	 * 등록번호 
	 * @param regiNum
	 * @return
	 */
	protected String getRegiNum(String regiNum) {
		return regiNum;
	}
	
	/**
	 * 등록일 
	 * @param regiDate
	 * @return
	 */
	protected String getRegiDate(String regiDate) {
		regiDate =  StringUtil.replaceString(regiDate, "[.]", "");
		regiDate = regiDate.replaceAll("[(]", "");
		regiDate = regiDate.replaceAll("[)]", "");
		return regiDate;
	}
	
	/**
	 * ipc정보
	 * @param ipcAll
	 * @return
	 */
	protected String getIpcAll(String ipcAll) {
		return StringUtil.subStr2(ipcAll, -3);
	}
	
	/**
	 * 요약정보 
	 * @param astrtCont
	 * @return
	 */
	protected String getAbstract(String astrtCont) {
		return astrtCont.trim();
	}
	
	/**
	 * 대표청구항 
	 * 2015.05.14 청구항 중 1번만 데이터에 반영
	 * @param claimMain
	 * @return
	 */
	protected String getClaimMain(String claimMain) {
		int index = claimMain.indexOf("2.") > -1 ? claimMain.indexOf("2.") : claimMain.length();
		claimMain = claimMain.substring(0, index);
		return claimMain.trim();
	}
	
	/**
	 * 출원인 
	 * @param applicant
	 * @return
	 */
	protected String getApplicant(String applicant) {
		return StringUtil.isNull(applicant) ? "" : applicant.split(",")[0];
	}
	
	/**
	 * 출원인 국가 
	 * @param applicantNatl
	 * @return
	 */
	protected String getApplicantNatl(String applicantNatl) {
		return applicantNatl;
	}
	
	/**
	 * 발명자정보
	 * @param inventor
	 * @return
	 */
	protected String getInventor(String inventor) {
		return StringUtil.isNull(inventor) ? "" : inventor.split(",")[0];
	}
	
	/**
	 * 우선권번호 
	 * @param priorityNum
	 * @return
	 */
	protected String getPriorityNum(String priorityNum) {
		return priorityNum;
	}
	
	/**
	 * 우선권주장일  
	 * @param priorityDate
	 * @return
	 */
	protected String getPriorityDate(String priorityDate) {
		return StringUtil.replaceString(priorityDate, "[.]", "");
	}
	
	/**
	 * 우선권국가 
	 * @param priorityNatl
	 * @return
	 */
	protected String getPriorityNatl(String priorityNatl) {
		return priorityNatl;
	}
	
	/**
	 * bcBeNum정보
	 * @param ftermInfo
	 * @return
	 */
	protected String getBcBeNum(String bcBeNum) {
		return StringUtil.subStr2(bcBeNum, -3);
	}
	
	/**
	 * f-term정보
	 * @param ftermInfo
	 * @return
	 */
	protected String getFtermJp(String ftermJp) {
		return StringUtil.subStr2(ftermJp, -3);
	}

	/**
	 * fi정보
	 * @param fiCodeJp
	 * @return
	 */
	protected String getFiCodeJp(String fiCodeJp) {
		return StringUtil.subStr2(fiCodeJp, -3);
	}

	/**
	 * upc정보 
	 * @param upcCurrentAll
	 * @return
	 */
	protected String getUpcCurrentAll(String upcCurrentAll) {
		return StringUtil.subStr2(upcCurrentAll, -3);
	}
	
	/**
	 * cpc정보 
	 * @param cpc
	 * @return
	 */
	protected String getCpc(String cpc) {
		return StringUtil.subStr2(cpc, -3);
	}

	/**
	 * epc정보 
	 * @param epc
	 * @return
	 */
	protected String getEpc(String epc) {
		return StringUtil.subStr2(epc, -3);
	}
}
