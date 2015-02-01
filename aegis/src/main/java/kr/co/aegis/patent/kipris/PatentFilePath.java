package kr.co.aegis.patent.kipris;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

abstract public class PatentFilePath {
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	protected String _userId;
	protected String _userKey;
	protected String _kiprisUrl;
	protected String _defaultPath;
	protected String _defaultTxtPath;
	/**
	 * 생성자 호출
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 */
	protected PatentFilePath(String userId, String userKey, String kiprisUrl, String defaultPath) {
		this._userId      = userId;
		this._userKey     = userKey;
		this._kiprisUrl   = kiprisUrl;
		this._defaultPath = defaultPath;
		this._defaultTxtPath = "/process/error.do";
	}
	
	/**
	 * 대표도면, 전문 가져오기
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	abstract public void getFilePath(Map<String, String>map) throws RemoteException;
	
	/**
	 * 추가적인 정보 가져오기
	 * @param map
	 * @return
	 * @throws RemoteException
	 */
	abstract public void getBibliography(Map<String, String>map) throws RemoteException;
	
	/***
	 * KIPRIS PLUS용 출원번호 가져오기
	 * @param map
	 * @throws RemoteException
	 */
	public void setApplNumOrg(Map<String, String>map) throws RemoteException{
	};
	
	abstract public int getAdvancedSearch(Map<String, String>map, List<Map<String, String>> list) throws RemoteException;
}
