import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import kr.co.aegis.patent2.kipris.BibliographyParser;
import kr.co.aegis.patent2.kipris.KrBibliographyParser;
import kr.co.aegis.patent2.kipris.OthBibliographyParser;
import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.PatentBibliographicInfoServicePortTypeProxy;
import kr.or.kipris.plus.PatentBibliographicInfoServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorArtDocumentsInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorityInfo;

import org.apache.axis.message.SOAPHeaderElement;


public class PatentBibliographic {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PatentBibliographicInfoServicePortTypeProxy proxy = new PatentBibliographicInfoServicePortTypeProxy();
		PatentBibliographicInfoServiceSoap11BindingStub stub =(PatentBibliographicInfoServiceSoap11BindingStub)proxy.getPatentBibliographicInfoServicePortType();
		String applNum = "1019960025842";

		try {
			String _userId = "airsgroup";
			String _userKey = "d73f2580c4a0b15f915c27009834c75f29992aac1f25a0a1";
			String _kiprisUrl = "http://plus.kipris.or.kr";
			SOAPHeaderElement _soapId = new SOAPHeaderElement(_kiprisUrl,"userId");
			_soapId.setValue(_userId);
			
			SOAPHeaderElement _soapKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
			_soapKey.setValue(_userKey);
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			if(StringUtil.isNull(applNum)) 
				return;
			Map<String, String> map = new HashMap<String, String>();			
			BibliographyParser parser = new KrBibliographyParser(map);
			// 서지정보
			BiblioSummaryInfo[] biblioSummaryInfos = (BiblioSummaryInfo[])stub.biblioSummaryInfo(applNum);
			parser.setBiblioSummaryInfo(biblioSummaryInfos);
			
			// ipc정보
//			IpcInfo[] ipcInfos = (IpcInfo[])stub.ipcInfo(applNum);
//			parser.setIpcInfo(ipcInfos);
			
			// 초록
			AbstractInfo[] abstractInfos = (AbstractInfo[])stub.abstractInfo(applNum);
			parser.setAbstractInfo(abstractInfos);
			
			// 청구항
			ClaimInfo[] claimInfos = (ClaimInfo[])stub.claimInfo(applNum);
			parser.setClaimInfo(claimInfos);
			
			// 출원인정보
//			ApplicantInfo[] applicantInfos = (ApplicantInfo[])stub.applicantInfo(applNum);
//			parser.setApplicantInfo(applicantInfos);
			
			// 발명자정보
//			InventorInfo[] inventorInfos = (InventorInfo[])stub.inventorInfo(applNum);
//			parser.setInventorsInfo(inventorInfos);
			
			// 우선권정보
//			PriorityInfo[] priorityInfos = (PriorityInfo[])stub.priorityInfo(applNum);
//			parser.setPriorityNumberDateInfo(priorityInfos);
			
			// 인용문헌정보 
//			PriorArtDocumentsInfo[] priorArtDocumentsInfos = (PriorArtDocumentsInfo[])stub.priorArtDocumentsInfo(applNum);
//			parser.setPriorArtDocumentsInfo(priorArtDocumentsInfos);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

}
