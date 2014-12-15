package kr.co.aegis.service;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.dao.ProjectDAO;
import kr.co.aegis.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends BaseService {
	private UserDAO userDAO;
	private ProjectDAO projectDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Autowired
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	/**
	 * 사용자 조회
	 * @param param
	 * @return
	 */
	public Map<String, String> selectUser(Map<String, String> param) {
		return userDAO.selectUser(param);
	}
	
	/**
	 * 로그인 확인
	 * @param param
	 * @return
	 */
	public Map<String, String> selectLoginUser(Map<String, Object> param) {
		return userDAO.selectLoginUser(param);
	}

	
	/**
	 * 사용자 리스트
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectUserList(Map<String, String> param) {
		return userDAO.selectUserList(param);
	}
	
	
	/**
	 * 사용자 리스트 ( 프로그램 권한 조회용 )
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectUserListForAuth(Map<String, String> param) {
		return userDAO.selectUserListForAuth(param);
	}
	
	/**
	 * 로그인 확인
	 * @param param
	 * @return
	 */
	public Map<String, String> selectCheckId(Map<String, String> param) {
		return userDAO.selectCheckId(param);
	}
	
	/**
	 * 로그인 확인
	 * @param param
	 * @return
	 */
	public String selectFindId(Map<String, String> param) {
		return userDAO.selectFindId(param);
	}
	
	
	/**
	 * 사용자정보 저장
	 * @param param
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void save(Map<String, Object> param) {
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("PRIORITY", (String)param.get("PRIORITY"));
			map.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
			map.put("ADMIN_ID", (String)param.get("ADMIN_ID"));
			if(map.get("STATUS").startsWith("DELETE")) {
				userDAO.deleteUser(map);
				projectDAO.deleteProjectAuth(map);
			} else if(map.get("STATUS").startsWith("INSERT")) {
				userDAO.insertUser(map);
				// 일반사용자 등록시 프로젝트권한을 추가로 등록시킨다.
				// 2014.04.08 사용자 등록시 프로젝트 권한 추가하지 않음
//				if("U".equals(map.get("PRIORITY"))) {
//					projectDAO.insertToSelectProjectAuth2(map);
//				}
			} else if(map.get("STATUS").startsWith("UPDATE")) {
				userDAO.updateUser(map);
			}
		}
	}

	/**
	 * 선택한 프로젝트로 프로젝트 변경
	 * @param param
	 * @return
	 */
	@Transactional
	public void setProjectId(Map<String, String> param) {
		userDAO.updateProjectId(param);
	}
	

	/**
	 * 관리자 포인트 차감
	 * @param param
	 * @return
	 */
	@Transactional
	public void setPoint(Map<String, String> param) {
		userDAO.updatePoint(param);
	}
	
	/**
	 * 관리자 비밀번호 변경
	 * @param param
	 * @return
	 */
	@Transactional
	public void setPassword(Map<String, String> param) {
		userDAO.updatePassword(param);
	}
	
	
	/**
	 * 승인요청 수락
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void setAppvYn(Map<String, Object> param) {
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
			userDAO.updateAppvYn(map);
		}
	}
}
