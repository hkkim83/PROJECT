import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import kr.or.kipris.plus.ForeignPatentUtilServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentUtilServiceSoap11BindingStub;
import kr.or.kipris.plus.PatentAdvancedSearchServicePortTypeProxy;
import kr.or.kipris.plus.PatentAdvancedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.CategorySearchQuery;

import org.apache.axis.message.SOAPHeaderElement;


public class GG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatentAdvancedSearchServicePortTypeProxy proxy = new PatentAdvancedSearchServicePortTypeProxy();
		PatentAdvancedSearchServiceSoap11BindingStub stub =(PatentAdvancedSearchServiceSoap11BindingStub)proxy.getPatentAdvancedSearchServicePortType();
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
			
//			CategorySearchQuery categorySearchQuery = new CategorySearchQuery();
//			categorySearchQuery.setInventionTitle("비디오*video");						// 발명의 명칭
//			categorySearchQuery.setApplicationDate("20130101~20131231");
			String str = "(video+camera)*AB=[object+target+body+대상+목표+타켓+물체]";
//			AdvancedSearchArray bean = stub.advancedSearch(categorySearchQuery, 0, 6000, "", null);
			AdvancedSearchArray bean = stub.freeSearch(str, 2, 30, true, true, "", "", true);
			System.out.println(bean);
			AdvancedSearch[] arrays = bean.getAdvancedSearch();
			int i = 0;
			for(AdvancedSearch a : arrays) {
				System.out.println((++i)+":::::"+a.getInventionTitle());
			}
			totalSearchCount = bean.getTotalSearchCount();
			System.out.println("totalSearchCount:::::"+totalSearchCount);
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
	}
}
