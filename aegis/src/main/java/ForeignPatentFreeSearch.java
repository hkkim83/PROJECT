import java.util.HashMap;
import java.util.Map;

import org.apache.axis.message.SOAPHeaderElement;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FpatBeanItem;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray;


public class ForeignPatentFreeSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   	ForeignPatentAdvencedSearchServicePortTypeProxy proxy = new ForeignPatentAdvencedSearchServicePortTypeProxy();
		ForeignPatentAdvencedSearchServiceSoap11BindingStub stub =(ForeignPatentAdvencedSearchServiceSoap11BindingStub)proxy.getForeignPatentAdvencedSearchServicePortType();
		int totalSearchCount = 0;
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

			String str = "(TL=[electric*car*charger]+AB=[electric*car*charger]+CL=[electric*car*charger])";
			SearchResultArray bean = stub.freeSearch(str, "US", "0", "15", "", "");
			SearchResult[] arrays = bean.getSearchTestResult();
			System.out.println("totalSearchCount:::::"+totalSearchCount);
			for(int i=0; i<arrays.length; i++)
				System.out.println(i+"::::"+arrays[i].getInventionName()+","+arrays[i].getApplicationNo());
			totalSearchCount = Integer.parseInt(bean.getTotalSearchCount());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
