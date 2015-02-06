import java.rmi.RemoteException;

import kr.or.kipris.plus.ForeignPatentBibliographicServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;

import org.apache.axis.message.SOAPHeaderElement;


public class DD {

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
		
		String applNum  = "201210040148A0";
		String natlCode = "CN";
		
		try {
			BibliographicSummaryInfo biblioSummaryInfo = (BibliographicSummaryInfo)stub.bibliographicSummaryInfo(applNum, natlCode);
			System.out.println(biblioSummaryInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
