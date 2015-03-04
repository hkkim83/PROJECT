package kr.co.aegis.patent2.kipris;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

abstract public class PatentFilePath {
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	protected String _userId;
	protected String _userKey;
	protected String _kiprisUrl;
	protected String _defaultPath;
	protected String _defaultTxtPath;
	protected SOAPHeaderElement _soapId;
	protected SOAPHeaderElement _soapKey;
	/**
	 * 생성자 호출
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 */
	protected PatentFilePath(String userId, String userKey, String kiprisUrl, String defaultPath) {
		_userId      = userId;
		_userKey     = userKey;
		_kiprisUrl   = kiprisUrl;
		_defaultPath = defaultPath;
		_defaultTxtPath = "/process/error.do";
		
		_soapId = new SOAPHeaderElement(_kiprisUrl,"userId");
		_soapId.setValue(_userId);
		
		_soapKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
		_soapKey.setValue(_userKey);
	}
	
	/**
	 * 대표도면, 전문 가져오기
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	abstract public void getFilePath(Map<String, String>map);
	
	/**
	 * 추가적인 정보 가져오기
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	abstract public void getBibliography(Map<String, String>map);
	
	/***
	 * KIPRIS PLUS용 출원번호 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	abstract public void setApplNumOrg(Map<String, String>map);
	
	/**
	 * 패밀리 정보 가져오기
	 */
	abstract public void getFamilyInfo(Map<String, String>map);
	

	/**
	 * KIPRIS DB검색식으로 전체건수 구하기   
	 * @param map
	 * @param list
	 * @return
	 */
	abstract public int getTotalCount(Map<String, String>map);
	
	/**
	 * KIPRIS DB검색식으로 전체검색하기  
	 * @param map
	 * @param list
	 * @return
	 */
	abstract public void getAdvancedSearch(Map<String, String>map, List<Map<String, String>> list);
}
