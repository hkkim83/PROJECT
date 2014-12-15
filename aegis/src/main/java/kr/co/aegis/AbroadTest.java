package kr.co.aegis;

import kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FpatBeanItem;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray;

import org.apache.axis.message.SOAPHeaderElement;

public class AbroadTest {
    public static void main(String[] args) throws Exception {

    	ForeignPatentAdvencedSearchServicePortTypeProxy proxy = new ForeignPatentAdvencedSearchServicePortTypeProxy();
		ForeignPatentAdvencedSearchServiceSoap11BindingStub stub =(ForeignPatentAdvencedSearchServiceSoap11BindingStub)proxy.getForeignPatentAdvencedSearchServicePortType();
		
		String _userId = "airsgroup";
	 	String _userKey ="d73f2580c4a0b15f915c27009834c75f29992aac1f25a0a1";
		
		SOAPHeaderElement id = new SOAPHeaderElement("http://plus.kipris.or.kr","userId");
		id.setValue(_userId);
		
		SOAPHeaderElement userKey = new SOAPHeaderElement("http://plus.kipris.or.kr","userKey");
		userKey.setValue(_userKey);
		
		stub.setHeader(id);
		stub.setHeader(userKey);
		
		FpatBeanItem fpatBean = new FpatBeanItem();
		//fpatBean.setApplicant("Buckman Lisa A.,Peters Frank H.");
		fpatBean.setCollectionValues("US");
		fpatBean.setApplicationdate("2010-04-29");
//		fpatBean.setApplicationNo("10080944");
//		fpatBean.setInventionName("Game*device*control*method*of*computer*and*information*storage*medium");
		String str = "Launch and, recovery. system";
		str = str.replaceAll("[,.]", "");
		str = str.replaceAll(" ", "*");
		System.out.println(str);
		fpatBean.setInventionName(str);
		SearchResultArray array = stub.advancedSearch(fpatBean);
		System.out.println(array.getTotalSearchCount()+":::"+array.getColString());
		SearchResult[] searchResult = array.getSearchTestResult();
		System.out.println(searchResult[0]);
		for(int i=0; i<searchResult.length; i++)
		{
			System.out.println("getApplicationNo::::"+searchResult[i].getApplicationNo());
			System.out.println("getVdkVgwKey::::"+searchResult[i].getVdkVgwKey());
			System.out.println("getAgents::::"+searchResult[i].getApplicationDate());
			System.out.println("getInventionName::::"+searchResult[i].getInventionName());
			System.out.println("=====================================================");
		}
		
		ForeignPatentImageAndFullTextServicePortTypeProxy proxy2 = new ForeignPatentImageAndFullTextServicePortTypeProxy();
		ForeignPatentImageAndFullTextServiceSoap11BindingStub stub2 =(ForeignPatentImageAndFullTextServiceSoap11BindingStub)proxy2.getForeignPatentImageAndFullTextServicePortType();
		
		stub2.setHeader(id);
		stub2.setHeader(userKey);
		
		FullTextInfo fullTextInfo = stub2.fullTextInfo("200900042737A1", "WO");
		RepresentationImageInfo[] imageInfo = stub2.representationImageInfo("200900042737A1", "WO");
		System.out.println(fullTextInfo.getPath());
		System.out.println(imageInfo[0].getJpgPath());
    }
}
