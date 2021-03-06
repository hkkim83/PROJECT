import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import kr.co.aegis.patent2.kipris.BibliographyParser;
import kr.co.aegis.patent2.kipris.OthBibliographyParser;
import kr.or.kipris.plus.ForeignPatentBibliographicServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo;

import org.apache.axis.message.SOAPHeaderElement;


public class ForeignPatentBibliographic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForeignPatentBibliographicServicePortTypeProxy proxy = new ForeignPatentBibliographicServicePortTypeProxy();
		ForeignPatentBibliographicServiceSoap11BindingStub stub =(ForeignPatentBibliographicServiceSoap11BindingStub)proxy.getForeignPatentBibliographicServicePortType();
		String _userId = "airsgroup";
		String _userKey = "d73f2580c4a0b15f915c27009834c75f29992aac1f25a0a1";
		String _kiprisUrl = "http://plus.kipris.or.kr";
		SOAPHeaderElement _soapId = new SOAPHeaderElement(_kiprisUrl,"userId");
		_soapId.setValue(_userId);
		
		SOAPHeaderElement _soapKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		_soapKey.setValue(_userKey);
		stub.setHeader(_soapId);
		stub.setHeader(_soapKey);
		
		String applNum  = "201400267585A1";
		String natlCode = "US";
//		String applNum  = "200200007321A1";
//		String natlCode = "WO";		
//		String applNum  = "200400160235A0";
//		String natlCode = "PJ";		
		try {
			Map<String, String> map = new HashMap<String, String>();
			BibliographyParser parser = new OthBibliographyParser(map);
			// 서지정보
//			System.out.println("getKiprisBibliography::::"+applNum+","+natlCode);
//			BibliographicSummaryInfo biblioSummaryInfo = (BibliographicSummaryInfo)stub.bibliographicSummaryInfo(applNum, natlCode);
//			parser.setBibliographicSummaryInfo(biblioSummaryInfo);
//			System.out.println("getKiprisBibliography::::"+biblioSummaryInfo);
			
//			
//			// ipc정보
//			IpcInfo[] ipcInfos = (IpcInfo[])stub.ipcInfo(applNum, natlCode);
//			parser.setIpcInfo(ipcInfos);
			
////			// 초록
//			Summation[] summations = (Summation[])stub.summation(applNum, natlCode);
//			parser.setSummation(summations);
//			System.out.println("summations1::::"+summations.length+","+summations);
//			for(int i=0; i<summations.length; i++)
//				System.out.println(summations[i]);
//
//			// 청구항
//			DemandParagraphInfo[] demandParagraphInfos = (DemandParagraphInfo[])stub.demandParagraphInfo(applNum, natlCode);
//			String claimMain = demandParagraphInfos[0].getClaimText();
//			System.out.println("demandParagraphInfos1::::"+claimMain);
//			int index = claimMain.indexOf("2.");
//			claimMain = claimMain.substring(0, index);
//			parser.setDemandParagraphInfo(demandParagraphInfos);
//			System.out.println("demandParagraphInfos2::::"+claimMain);
//			
//			// 출원인정보
			ApplicantInfo[] applicantInfos = (ApplicantInfo[])stub.applicantInfo(applNum, natlCode);
			for(int i=0; i<applicantInfos.length; i++) {
				if(applicantInfos[i] == null) return;
				System.out.println(applicantInfos[i].getApplicantName());
			}			
//			
//			// 발명자정보
//			InventorsInfo[] inventorInfos = (InventorsInfo[])stub.inventorsInfo(applNum, natlCode);
//			parser.setInventorsInfo(inventorInfos);
//			
//			// 우선권정보
//			PriorityNumberDateInfo[] priorityInfos = (PriorityNumberDateInfo[])stub.priorityNumberDateInfo(applNum, natlCode);
//			parser.setPriorityNumberDateInfo(priorityInfos);
//			
//			// f-term정보
//			FtermInfo[] ftermInfos = (FtermInfo[])stub.ftermInfo(applNum, natlCode);
//			parser.setFtermInfo(ftermInfos);
//			
//			// fi정보 
//			FiInfo[] fiInfos = (FiInfo[])stub.fiInfo(applNum, natlCode);
//			parser.setFiInfo(fiInfos);
//			
//			// upc정보
//			UpcInfo[] upcInfos = (UpcInfo[])stub.upcInfo(applNum, natlCode);
//			parser.setUpcInfo(upcInfos);
//			
//			// cpc정보 
//			CpcInfo[] cpcInfos = (CpcInfo[])stub.cpcInfo(applNum, natlCode);
//			parser.setCpcInfo(cpcInfos);

			// epc정보 
//			EclaInfo[] eclaInfos = (EclaInfo[])stub.eclaInfo(applNum, natlCode);
//			parser.setEclaInfo(eclaInfos);
			
			// 패밀리정보 
//			FamilyInfo[] familyInfos = stub.familyInfo(applNum, natlCode);
//			for(int i=0; i<familyInfos.length; i++)
//				System.out.println(familyInfos[i].getFamilyNumber()+familyInfos[i].getFamilyKind());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
