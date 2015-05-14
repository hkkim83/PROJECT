package kr.co.aegis.patent2.parser;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import kr.co.aegis.patent2.kipris.KrPatentFilePath;
import kr.co.aegis.patent2.kipris.OthPatentFilePath;
import kr.co.aegis.patent2.kipris.PatentFilePath;
import kr.co.aegis.util.StringUtil;

public class ExcelParser {
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * 
	 * @param list
	 */
	public void parse(List<Map<String, String>> list) {}

	
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
//				logger.info("deleteDuplication::::::"+oldApplNum+","+applNum);
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
	public void getPatentFilePath(List<Map<String, String>> list, String userId, String userKey, String kiprisUrl, String defaultPath) throws InterruptedException {
		
		PatentFilePath pfp = null;
		int index = 0;
		for(Map<String, String> map : list) {
			if(index++%30 == 29) {
				Thread.sleep(1000); // ms단위 - 1초 멈춤
			}
			pfp = "KR".equals(map.get("NATL_CODE")) ? new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath) : new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
			pfp.getFilePath(map);
//			logger.info("getPatentFilePath::::\n"+map);
		}
	}
	
	/**
	 * kipris에서 서지 정보 가져오기
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public void getBibliography(List<Map<String, String>> list, String userId, String userKey, String kiprisUrl, String defaultPath) throws InterruptedException {
		
		PatentFilePath pfp = null;
		int index = 0;
		for(Map<String, String> map : list) {
			if(index++%30 == 29) {
				Thread.sleep(1000); // ms단위 - 1초 멈춤
			}
			pfp = "KR".equals(map.get("NATL_CODE")) ? new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath) : new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
			pfp.getBibliography(map);
//			logger.info(map.get("NATL_CODE")+"getBibliography:::::::::::::::::::::::::::::::::::");
//			logger.info(map);
		}
	}
	
	/**
	 * kipris에서 패밀리 정보 가져오기
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public void getFamilyInfo(List<Map<String, String>> list, String userId, String userKey, String kiprisUrl, String defaultPath) throws InterruptedException {
		
		PatentFilePath pfp = null;
		int index = 0;
		for(Map<String, String> map : list) {
			if(index++%30 == 29) {
				Thread.sleep(1000); // ms단위 - 1초 멈춤
			}
			pfp = "KR".equals(map.get("NATL_CODE")) ? new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath) : new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
			pfp.getFamilyInfo(map);
//			logger.info(map.get("NATL_CODE")+"getFamilyInfo:::::::::::::::::::::::::::::::::::");
//			logger.info(map);
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
	public void setApplNumOrg(List<Map<String, String>> list, String userId, String userKey, String kiprisUrl, String defaultPath) throws InterruptedException {
//		logger.info("setApplNumOrg:::::::::::::::::::::::::::::::::::");
		PatentFilePath pfp = null;
		int index = 0;
		for(Map<String, String> map : list) {
			if(index++%30 == 29) {
				Thread.sleep(1000); // ms단위 - 1초 멈춤
			}
//			logger.info("1111111:::::"+index+","+map.get("NATL_CODE"));
			pfp = "KR".equals(map.get("NATL_CODE")) ? new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath) : new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
			pfp.setApplNumOrg(map);
//			logger.info(map);
		}
	}
	
	/**
	 * KIPRIS DB검색식으로 전체건수 구하기   
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public int getTotalCount(Map<String, String> map, String userId, String userKey, String kiprisUrl, String defaultPath) throws InterruptedException {
//		logger.info("getTotCount:::::::::::::::::::::::::::::::::::");
		PatentFilePath pfp = null;
//		int index = 0;
		int cnt = 0;
//		logger.info("1111111:::::"+index+","+map.get("NATL_CODE"));
		pfp = "KR".equals(map.get("NATL_CODE")) ? new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath) : new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
		cnt = pfp.getTotalCount(map);
//		logger.info("count::::::"+cnt);
		return cnt;
	}
	
	/**
	 * KIPRIS DB검색식으로 전체검색하기 
	 * @param list
	 * @param userId
	 * @param userKey
	 * @param kiprisUrl
	 * @param defaultPath
	 * @return
	 * @throws RemoteException
	 * @throws InterruptedException
	 */
	public void getAdvancedSearch(List<Map<String, String>> list, Map<String, String> map, String userId, String userKey, String kiprisUrl, String defaultPath) throws InterruptedException {
//		logger.info("getAdvancedSearch:::::::::::::::::::::::::::::::::::");
		PatentFilePath pfp = null;
		pfp = "KR".equals(map.get("NATL_CODE")) ? new KrPatentFilePath(userId, userKey, kiprisUrl, defaultPath) : new OthPatentFilePath(userId, userKey, kiprisUrl, defaultPath);
		pfp.getAdvancedSearch(map, list);
	}
}
