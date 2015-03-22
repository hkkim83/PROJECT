import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import kr.co.aegis.patent2.kipris.BibliographyParser;
import kr.co.aegis.patent2.kipris.OthBibliographyParser;
import kr.or.kipris.plus.DOCDBServicePortTypeProxy;
import kr.or.kipris.plus.DOCDBServiceSoap11BindingStub;
import kr.or.kipris.plus.ForeignPatentBibliographicServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo;

import org.apache.axis.message.SOAPHeaderElement;


public class ForeignPatentFamilyInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOCDBServicePortTypeProxy proxy = new DOCDBServicePortTypeProxy();
		DOCDBServiceSoap11BindingStub stub =(DOCDBServiceSoap11BindingStub)proxy.getDOCDBServicePortType();
		String _userId = "airsgroup";
		String _userKey = "d73f2580c4a0b15f915c27009834c75f29992aac1f25a0a1";
		String _kiprisUrl = "http://plus.kipris.or.kr";
		SOAPHeaderElement _soapId = new SOAPHeaderElement(_kiprisUrl,"userId");
		_soapId.setValue(_userId);
		
		SOAPHeaderElement _soapKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		_soapKey.setValue(_userKey);
		stub.setHeader(_soapId);
		stub.setHeader(_soapKey);

		String docdbCountryCode = null; 
		String docdbLiteratureNumber      = null;
		String docdbLiteratureIdCode    = null;
		
		String fmNum = "";
		int fmCount = 0;
		String applNum  = "000005593214A1";
		String natlCode = "US";
//		String applNum  = "200200007321A1";
//		String natlCode = "WO";		
//		String applNum  = "201300223310A0";
//		String natlCode = "PJ";		
		try {
			
			DocdbFamilyInfo[] arrays = (DocdbFamilyInfo[])stub.familyInfo(applNum, natlCode);
			fmCount = arrays.length;
			System.out.println("fmCount : "+fmCount);
			if(fmCount > 0 && arrays != null) {
				for(DocdbFamilyInfo familyInfo : arrays) {
					docdbCountryCode = familyInfo.getDocdbCountryCode();
					docdbLiteratureNumber = familyInfo.getDocdbLiteratureNumber();
					docdbLiteratureIdCode = familyInfo.getDocdbLiteratureIdCode();
					fmNum += docdbCountryCode+docdbLiteratureNumber+docdbLiteratureIdCode+" | ";
					System.out.println(docdbCountryCode+","+docdbLiteratureNumber+","+docdbLiteratureIdCode);
				}				
			}		

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
