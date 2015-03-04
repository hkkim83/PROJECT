import java.util.HashMap;
import java.util.Map;

import org.apache.axis.message.SOAPHeaderElement;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentAdvencedSearchServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FpatBeanItem;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray;


public class HH {

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
//			FpatBeanItem fpatBean = new FpatBeanItem();		
//			fpatBean.setInventionName("camera*video");						// 전체
//			fpatBean.setInventionName("Automated image duplicating apparatus");						// 발명의 명칭
//			fpatBean.setAbstracts(map.get("ABSTRACT"));						// 요약 
//			fpatBean.setClaimExtend(map.get("CLAIM_MAIN"));					// 대표청구항 
//			fpatBean.setIpc(map.get("IPC_ALL"));								// IPC
//			fpatBean.setApplicant(map.get("APPLICANT"));						// 출원인 
//			fpatBean.setInventors(map.get("INVENTOR"));						// 발명자
//			fpatBean.setAgents(map.get("AGENT"));							// 대리인
//			fpatBean.setApplicationNo("99116441");					// 출원번호 
//			fpatBean.setApplicationdate(map.get("APPL_DATE"));				// 출원일 
//			fpatBean.setOpenNumber(map.get("OPEN_NUM"));						// 공개번호 
//			fpatBean.setOpenDate(map.get("OPEN_DATE"));						// 공개일 
//			fpatBean.setRegisterNo(regiNum);									// 등록/공고번호
//			fpatBean.setRegisterDate(regiDate);								// 등록/공고일 
//			fpatBean.setPriorityNo(map.get("PRIORITY_NUM"));					// 우선권번호 
//			fpatBean.setPriorityDate(map.get("PRIORITY_DATE"));				// 우선권주장일
//			fpatBean.setFi(map.get("FI_CODE_JP"));							// FI 
//			fpatBean.setCollectionValues("US,JP,CN,EP,WO"); 				// 국가 
//			fpatBean.setCurrentPage("3");
			//fpatBean.setDocsCount("100");
//			SearchResultArray bean = stub.advancedSearch(fpatBean);
			String str = "(TL=[(imag+video+camera)]+AB=[(object+target+body)]+CL=[(track+tracking+system)])*(security+watch)";
			SearchResultArray bean = stub.freeSearch(str, "US,JP,EP,WO,CN", "3", "15", "", "");
			SearchResult[] arrays = bean.getSearchTestResult();
			for(int i=0; i<arrays.length; i++)
				System.out.println(i+"::::"+arrays[i].getInventionName()+","+arrays[i].getApplicationNo());
			totalSearchCount = Integer.parseInt(bean.getTotalSearchCount());
			System.out.println("totalSearchCount:::::"+totalSearchCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
