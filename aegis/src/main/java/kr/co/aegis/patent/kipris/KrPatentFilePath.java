package kr.co.aegis.patent.kipris;

import java.rmi.RemoteException;
import java.util.Map;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.PatentBibliographicInfoServicePortTypeProxy;
import kr.or.kipris.plus.PatentBibliographicInfoServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.PatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorityInfo;

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
		
		logger.info("patentFullText::::"+patentFullText);
		logger.info("imageMain::::"+imageMain);
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
		// 서지정보
		BiblioSummaryInfo[] biblioSummaryInfos = (BiblioSummaryInfo[])stub.biblioSummaryInfo(applNum);
		for(int i=0; i<biblioSummaryInfos.length; i++) {
			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getInventionTitle());
			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getApplicationNumber());
			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getApplicationDate());
			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getPublicationNumber());
			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getPublicationDate());
			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getRegisterNumber());
			logger.info("biblioSummaryInfo:::"+i+"::\n"+biblioSummaryInfos[i].getRegisterDate());
		}
		
		if(biblioSummaryInfos.length > 0) {
			BiblioSummaryInfo biblioSummaryInfo = biblioSummaryInfos[0];
			map.put("title", !StringUtil.isNull(map.get("title")) ? map.get("title") : biblioSummaryInfo.getInventionTitle());	
			map.put("appl_date", !StringUtil.isNull(map.get("appl_date")) ? map.get("appl_date") : biblioSummaryInfo.getApplicationDate());
			map.put("laid_pulbic_num", !StringUtil.isNull(map.get("laid_pulbic_num")) ? map.get("laid_pulbic_num") : biblioSummaryInfo.getPublicationNumber());
			map.put("laid_pulbic_date", !StringUtil.isNull(map.get("laid_pulbic_date")) ? map.get("laid_pulbic_date") : biblioSummaryInfo.getPublicationDate());
			map.put("regi_num", !StringUtil.isNull(map.get("regi_num")) ? map.get("regi_num") : biblioSummaryInfo.getRegisterNumber());
			map.put("regi_date", !StringUtil.isNull(map.get("regi_date")) ? map.get("regi_date") : biblioSummaryInfo.getRegisterDate());
		}
		
		// ipc정보
		IpcInfo[] ipcInfos = (IpcInfo[])stub.ipcInfo(applNum);
		for(int i=0; i<ipcInfos.length; i++) {
			logger.info("ipcInfos::"+i+":::\n"+ipcInfos[i].getIpcNumber());
		}
		if(ipcInfos.length > 0) {
			IpcInfo ipcInfo = ipcInfos[0];
			map.put("ipc_all", !StringUtil.isNull(map.get("ipc_all")) ? map.get("ipc_all") : ipcInfo.getIpcNumber());
		}
		
		// 초록
		AbstractInfo[] abstractInfos = (AbstractInfo[])stub.abstractInfo(applNum);
		for(int i=0; i<abstractInfos.length; i++) {
			logger.info("claimInfos::"+i+":::\n"+abstractInfos[i].getAstrtCont());
		}
		if(abstractInfos.length > 0) {
			AbstractInfo abstractInfo = abstractInfos[0];
			map.put("abstract", !StringUtil.isNull(map.get("abstract")) ? map.get("abstract") : abstractInfo.getAstrtCont());
		}
		
		
		// 청구항
		ClaimInfo[] claimInfos = (ClaimInfo[])stub.claimInfo(applNum);
		logger.info("claimInfos:::::\n"+claimInfos);
		for(int i=0; i<claimInfos.length; i++) {
			logger.info("claimInfos::"+i+":::\n"+claimInfos[i].getClaim());
		}
		if(claimInfos.length > 0) {
			ClaimInfo claimInfo = claimInfos[0];
			map.put("claim_main", !StringUtil.isNull(map.get("claim_main")) ? map.get("claim_main") : claimInfo.getClaim());
		}
		
		
		// 출원인정보
		ApplicantInfo[] applicantInfos = (ApplicantInfo[])stub.applicantInfo(applNum);
		for(int i=0; i<applicantInfos.length; i++) {
			logger.info("applicantInfos::"+i+":::\n"+applicantInfos[i].getName());
			logger.info("applicantInfos::"+i+":::\n"+applicantInfos[i].getCountry());
		}
		if(applicantInfos.length > 0) {
			ApplicantInfo applicantInfo = applicantInfos[0];
			map.put("applicant", !StringUtil.isNull(map.get("applicant")) ? map.get("applicant") : applicantInfo.getName());
			map.put("applicant_natl", !StringUtil.isNull(map.get("applicant_natl")) ? map.get("applicant_natl") : applicantInfo.getCountry());
		}
		
		
		// 발명자정보
		InventorInfo[] inventorInfos = (InventorInfo[])stub.inventorInfo(applNum);
		for(int i=0; i<inventorInfos.length; i++) {
			logger.info("inventorInfos::"+i+":::\n"+inventorInfos[i].getName());
		}
		if(inventorInfos.length > 0) {
			InventorInfo inventorInfo = inventorInfos[0];
			map.put("inventor", !StringUtil.isNull(map.get("inventor")) ? map.get("inventor") : inventorInfo.getName());
		}
		
		
		// 우선권정보
		PriorityInfo[] priorityInfos = (PriorityInfo[])stub.priorityInfo(applNum);
		for(int i=0; i<priorityInfos.length; i++) {
			logger.info("priorityInfos::"+i+":::\n"+priorityInfos[i].getPriorityApplicationNumber());
			logger.info("priorityInfos::"+i+":::\n"+priorityInfos[i].getPriorityApplicationDate());
			logger.info("priorityInfos::"+i+":::\n"+priorityInfos[i].getPriorityApplicationCountry());
		}
		if(priorityInfos.length > 0) {
			PriorityInfo priorityInfo = priorityInfos[0];
			map.put("priority_num", !StringUtil.isNull(map.get("priority_num")) ? map.get("priority_num") : priorityInfo.getPriorityApplicationNumber());
			map.put("priority_date", !StringUtil.isNull(map.get("priority_date")) ? map.get("priority_date") : priorityInfo.getPriorityApplicationDate());
			map.put("priority_natl", !StringUtil.isNull(map.get("priority_natl")) ? map.get("priority_natl") : priorityInfo.getPriorityApplicationCountry());
		}
	}
}
