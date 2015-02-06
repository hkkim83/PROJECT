import java.rmi.RemoteException;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.ForeignPatentBibliographicServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub;
import kr.or.kipris.plus.ForeignPatentUtilServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentUtilServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo;

import org.apache.axis.message.SOAPHeaderElement;


public class FF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForeignPatentUtilServicePortTypeProxy proxy = new ForeignPatentUtilServicePortTypeProxy();
		ForeignPatentUtilServiceSoap11BindingStub stub =(ForeignPatentUtilServiceSoap11BindingStub)proxy.getForeignPatentUtilServicePortType();
		String _userId = "airsgroup";
		String _userKey = "d73f2580c4a0b15f915c27009834c75f29992aac1f25a0a1";
		String _kiprisUrl = "http://plus.kipris.or.kr";
		SOAPHeaderElement _soapId = new SOAPHeaderElement(_kiprisUrl,"userId");
		_soapId.setValue(_userId);
		
		SOAPHeaderElement _soapKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		_soapKey.setValue(_userKey);
		stub.setHeader(_soapId);
		stub.setHeader(_soapKey);
		
		String applNum  = null;
		String natlCode = "JP";
		String regiNum  = null;
		String openNum  = "2012108156";
		
		try {
			LtrtnoInfo[] arrays = stub.getLtrtno(natlCode, applNum, openNum, regiNum, null);
			System.out.println(arrays[0].getLtrtno());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
