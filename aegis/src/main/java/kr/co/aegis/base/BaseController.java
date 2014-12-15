package kr.co.aegis.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.aegis.dto.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

abstract public class BaseController {
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	public static final String USER_SESSION = "USER_SESSION";
	
	/**
	 * 관리자 세션 설정
	 * @param request
	 * @param user
	 */
	protected void setLoginUser(HttpSession session, User user){
		session.setAttribute(USER_SESSION, user);
	}
	
	
	/**
	 * 관리자 세션 반환
	 * @param request
	 * @return
	 */
	public static User getLoginUser(HttpSession session){
		User sessionBean = (User)session.getAttribute(USER_SESSION);
		return sessionBean;
	}
	

	/**
	 * 관리자 세션 반환
	 * @param request
	 * @return
	 */
	public static String getLoginId(HttpSession session){
		User sessionBean = (User)session.getAttribute(USER_SESSION);
		String loginId = sessionBean.getId();
		return loginId;
	}
	
	/**
	 * 사용자 세션 종료
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected boolean expireSession(HttpSession session){
		//session.removeAttribute(USER_SESSION);
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			session.removeAttribute(name);
		}
		return true;
	}
	
	/**
	 * 맴에 상태값 추가하기
	 * @param map
	 * @return
	 */
	protected Map<String, String> setStatus(Map<String, String> map) {
		map.put("STATUS", "NORMAL");
		return map;
	}
	
	/**
	 * 파라미터를 통해 들어온 데이터를 파싱한다.
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected<T> Map<String, T> parseRequest(HttpServletRequest request) {
		Map<String, T> map = new HashMap<String, T>();
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			map.put(name, (T)request.getParameter(name));
		}		
		return map;
	}

	@SuppressWarnings("unchecked")
	protected<T> Map<String, T> parsePostData(HttpServletRequest request) {
		
		Map<String, T> resultMap = new HashMap<String, T>();
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			if(Pattern.matches("^[0-9]*\\[..+", name)){
				int braketStartIndex = name.indexOf("[");
				int braketEndIndex = name.indexOf("]");
				String numIdx = name.substring(0, braketStartIndex);
				
				List<Map<String, String>> list = (List<Map<String, String>>) resultMap.get("list");
				if(list == null) {
					list = new ArrayList<Map<String, String>>();
					resultMap.put("list", (T)list);
				}
				
				int idx = Integer.parseInt(numIdx);
				Map<String, String> map = null;
				if(list.size() >= idx+1) {
					map = list.get(idx);
					if(map == null) {
						map = new HashMap<String, String>();
						list.set(idx, map);
					}
				} else {
					map = new HashMap<String, String>();
					for(int i = list.size(); i <= idx; i++) {
						list.add(null);
					}
					list.set(idx, map);
				}
				
				String mapKey   = name.substring(braketStartIndex+1, braketEndIndex);
				map.put(mapKey,  request.getParameter(name));
				
			} else {
				resultMap.put(name, (T)request.getParameter(name));
			}
		}			
		return resultMap;
	}
	
	
	
	protected<T> Map<String, T> getMapFromJson(String json) throws JsonParseException, JsonMappingException, IOException{
		
		if(json == null || "".equals(json)){
			return null;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
		Map<String, T> resultMap = objectMapper.readValue(json, HashMap.class);
		
		return resultMap;
	}
	
	
	protected<T> List<Map<String, T>> getListFromJson(String json) throws JsonParseException, JsonMappingException, IOException{
		
		if(json == null || "".equals(json)){
			return null;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
		List<Map<String, T>> resultList = objectMapper.readValue(json, ArrayList.class);
		
		return resultList;
	}
	
    protected String setGridXML(List<Map<String, String>> list) {

		StringBuffer sb = new StringBuffer();
    	sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><rows>");
    	if(!list.isEmpty() && list.size() > 0) {
	    	for(int i=0; i<list.size(); i++) {
	    		sb.append("<row id=\"").append(i).append("\">");
	    		Map<String, String> map = list.get(i);
	    		Set<String> keySet = map.keySet();
				Iterator<String> iterator = keySet.iterator();
				sb.append("<cell><![CDATA[").append("0").append("]]></cell>");
				while(iterator.hasNext()) {
					String key = iterator.next();
					String val = map.get(key);
	    			sb.append("<cell><![CDATA[").append(val).append("]]></cell>");
	    		}
	    		sb.append("</row>");
	    	}
			sb.append("</rows>");
    	}
        return sb.toString();
    }
	
}
