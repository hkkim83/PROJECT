package kr.co.aegis.patent.parser;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import kr.co.aegis.patent.kipris.KrPatentFilePath;
import kr.co.aegis.patent.kipris.OthPatentFilePath;
import kr.co.aegis.patent.kipris.PatentFilePath;
import kr.co.aegis.util.StringUtil;

public class ExcelParser {
	protected final Log logger = LogFactory.getLog(this.getClass());
		
	public void parse(List<Map<String, String>> list) {}

	protected String replaceString(String str, String regex, String replacement) {
		return StringUtil.isNull(str) ? "" : str.replaceAll(regex, replacement);
	}
	
	/**
	 * 특허 중복제거
	 * @param list
	 * @return
	 */
	public void deleteDuplication(List<Map<String, String>> list) {
		String applNum = "";
		String oldApplNum = "";
		for(Map<String, String> map : list) {
			applNum = map.get("APPL_NUM");
			if(applNum.equals(oldApplNum)) {
				map.put("status", "delete");
			}
			applNum = oldApplNum;
		}
//		for(int i=list.size()-1; i>=0; i--) 
//		{
//			map = list.get(i);
//			count = Integer.parseInt(map.get("CNT"));
//			for(int j=1; j<count; j++)
//			{
//				list.remove(i-j);
//				i--;
//			}
//		}
	}
		
	/**
	 * kipris에서 도면, 전문 정보 가져오기
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public void getPatentFilePath(List<Map<String, String>> list, String userId, String userKey, String kiprisUrl, String defaultPath) throws RemoteException, InterruptedException {
		
		PatentFilePath pfp = null;
		int index = 0;
		for(Map<String, String> map : list) {
			if(index++%20 == 19) {
				Thread.sleep(1000); // ms단위 - 1초 멈춤
			}
			
			if("KR".equals(map.get("NATL_CODE"))) {
				pfp = new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
				pfp.getFilePath(map);
			} else if("EP".equals(map.get("NATL_CODE")) || "US".equals(map.get("NATL_CODE")) || "WO".equals(map.get("NATL_CODE")) || "JP".equals(map.get("NATL_CODE"))) {
				pfp = new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
				pfp.getFilePath(map);
			} else {
				// 그외 국가는 기본값으로 전문, 대표도면 값 설정
				map.put("PATENT_FULLTXT", "/process/error.do");
				map.put("IMAGE_MAIN"    , defaultPath);
				map.put("IMAGE_SMALL"   , defaultPath);
			}
		}
	}
	
	/**
	 * kipris에서 도면, 전문 정보 가져오기
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public void getBibliography(List<Map<String, String>> list, String userId, String userKey, String kiprisUrl, String defaultPath) throws RemoteException, InterruptedException {
		
		PatentFilePath pfp = null;
		int index = 0;
		for(Map<String, String> map : list) {
			if(index++%20 == 19) {
				Thread.sleep(1000); // ms단위 - 1초 멈춤
			}
			
			if("KR".equals(map.get("NATL_CODE"))) {
				pfp = new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
				pfp.getBibliography(map);
			} else if("EP".equals(map.get("NATL_CODE")) || "US".equals(map.get("NATL_CODE")) || "WO".equals(map.get("NATL_CODE")) || "JP".equals(map.get("NATL_CODE"))) {
				pfp = new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
				pfp.getBibliography(map);
			}
		}
	}
	
	
	/**
	 * kipris에서 출원번호원본 가져오기
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public void setApplNumOrg(List<Map<String, String>> list, String userId, String userKey, String kiprisUrl, String defaultPath) throws RemoteException, InterruptedException {
		logger.info("setApplNumOrg:::::::::::::::::::::::::::::::::::");
		PatentFilePath pfp = null;
		int index = 0;
		for(Map<String, String> map : list) {
			if(index++%20 == 19) {
				Thread.sleep(1000); // ms단위 - 1초 멈춤
			}
			logger.info(map);
			if(!"KR".equals(map.get("NATL_CODE")) && !"CN".equals(map.get("NATL_CODE"))) {
				pfp = new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
				pfp.setApplNumOrg(map);
			}
		}
	}
	
	/**
	 * kipris에서 출원번호원본 가져오기
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public int getAdvancedSearch(List<Map<String, String>> list, Map<String, String> map, String userId, String userKey, String kiprisUrl, String defaultPath) throws RemoteException, InterruptedException {
		logger.info("getAdvancedSearch:::::::::::::::::::::::::::::::::::");
		PatentFilePath pfp = null;
		int cnt = 0;
		parseFormular(map);
		if("KR".equals(map.get("NATL_CODE")))
			pfp = new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
		else
			pfp = new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
		
		cnt = pfp.getAdvancedSearch(map, list);
		logger.info("count::::::"+cnt);
		return cnt;
	}
	
	/**
	 * 검색식 
	 * @param map
	 */
	private void parseFormular(Map<String, String> map) {
		map.put("ABSTRACT", map.get("CONTENT"));
	}
}
