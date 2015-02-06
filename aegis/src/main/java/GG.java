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
			
			CategorySearchQuery categorySearchQuery = new CategorySearchQuery();
//			categorySearchQuery.setInventionTitle("VOLTAGE SURGE AND OVERVOLTAGE PROTECTION");						// 발명의 명칭
//			categorySearchQuery.setAstrtCont(map.get("ABSTRACT"));						// 요약 
//			categorySearchQuery.setClaimScope(map.get("CLAIM_MAIN"));						// 대표청구항 
//			categorySearchQuery.setIpcNumber("H04N");						// IPC
//			categorySearchQuery.setApplicant(map.get("APPLICANT"));						// 출원인 
//			categorySearchQuery.setInventors(map.get("INVENTOR"));						// 발명자
//			categorySearchQuery.setAgent(map.get("AGENT"));								// 대리인
//			categorySearchQuery.setApplicationNumber(map.get("APPL_NUM"));				// 출원번호 
//			categorySearchQuery.setApplicationDate(map.get("APPL_DATE"));					// 출원일 
//			categorySearchQuery.setOpenNumber(map.get("OPEN_NUM"));						// 공개번호 
//			categorySearchQuery.setOpenDate(map.get("OPEN_DATE"));						// 공개일 
//			categorySearchQuery.setPublicationNumber(map.get("LAID_PUBLIC_NUM"));			// 공고번호
//			categorySearchQuery.setPublicationDate(map.get("LAID_PUBLIC_DATE"));			// 공고일  
//			categorySearchQuery.setRegisterNumber(map.get("REGI_NUM"));					// 등록번호
//			categorySearchQuery.setRegisterDate(map.get("REGI_DATE"));					// 등록일 
//			categorySearchQuery.setPriorityApplicationNumber(map.get("PRIORITY_NUM"));	// 우선권번호 
//			categorySearchQuery.setPriorityApplicationDate(map.get("PRIORITY_DATE"));		// 우선권주장일 
//			categorySearchQuery.setPatent(true);
//			categorySearchQuery.setUtility(true);
			
			AdvancedSearchArray bean = stub.advancedSearch(categorySearchQuery, null, null, null, null);
			System.out.println(bean);
			AdvancedSearch[] arrays = bean.getAdvancedSearch();
			totalSearchCount = bean.getTotalSearchCount();
			System.out.println(totalSearchCount);
//			for(AdvancedSearch arr : arrays) {
//				Map<String, String> tempMap = new HashMap<String, String>();
//				tempMap.put("APPL_NUM_ORG", arr.getApplicationNumber());			// 문헌번호  	
//				tempMap.put("TITLE", arr.getInventionTitle());					// 발명의명칭 
//				tempMap.put("IPC_ALL", arr.getIpcNumber());						// IPC
//				tempMap.put("REGI_NUM", arr.getRegisterNumber());				// 등록번호 	
//				tempMap.put("REGI_DATE", arr.getRegisterDate());					// 등록일 
//				tempMap.put("APPL_NUM", arr.getApplicationNumber());				// 출원번호 	
//				tempMap.put("APPL_DATE", arr.getApplicationDate());				// 출원일 	
//				tempMap.put("OPEN_NUM", arr.getOpenNumber());					// 공개번호 
//				tempMap.put("OPEN_DATE", arr.getOpenDate());						// 공개일 
//				tempMap.put("LAID_PUBLIC_NUM", arr.getPublicationNumber());		// 공고번호 	
//				tempMap.put("LAID_PUBLIC_DATE", arr.getPublicationDate());		// 공고일 
//				tempMap.put("ABSTRACT", arr.getAstrtCont());						// 요약 
//				tempMap.put("APPLICANT", arr.getApplicantName());				// 출원인 
//				list.add(tempMap);
//			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
	}
}
