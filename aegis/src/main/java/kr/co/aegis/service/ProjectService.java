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
public class ProjectService extends BaseService {
	private ProjectDAO projectDAO;
	private UserDAO userDAO;
	
	@Autowired
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	/**
	 * 프로젝트 권한 조회
	 * @param param
	 * @return
	 */
	public String selectWriteYn(Map<String, Object> param) {
		return projectDAO.selectWriteYn(param);
	}
	
	
	/**
	 * 프로젝트 리스트
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectProjectList(Map<String, String> param) {
		return projectDAO.selectProjectList(param);
	}
	
	
	/**
	 * 프로젝트권한 리스트
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectProjectAuthList(Map<String, String> param) {
		return projectDAO.selectProjectAuthList(param);
	}
	
	
	/**
	 * 프로젝트권한 리스트
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectProjectAuthList2(Map<String, String> param) {
		return projectDAO.selectProjectAuthList2(param);
	}
	
	
	/**
	 * 로그인 사용자 프로젝트 조회
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectLoginProject(Map<String, Object> param) {
		return projectDAO.selectLoginProject(param);
	}
	
	/**
	 * 프로젝트권한 리스트 조회조건 아이디
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectProjectAuthListWithId(Map<String, String> param) {
		return projectDAO.selectProjectAuthListWithId(param);
	}
	
	/**
	 * 프로젝트정보 저장
	 * @param param
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void save(Map<String, Object> param) {
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
			if(map.get("STATUS").startsWith("DELETE")) {
				projectDAO.deleteProject(map);
				projectDAO.deleteProjectAuth(map);
				userDAO.deleteProjectId(map);
			} else if(map.get("STATUS").startsWith("INSERT")) {
				// 등록일 경우 프로젝트 아이디 가져오기
				String projectId = projectDAO.selectProjectId();
				map.put("PROJECT_ID", projectId);
				projectDAO.insertProject(map);
				// 프로젝트 등록일 경우 관리자가 관리하는 사용자를 제한편집 사용자에 추가한다.
				// 2014.04.08 프로젝트 추가시 권한은 추가하지 않는다.
				// projectDAO.insertToSelectProjectAuth(map);
			} else if(map.get("STATUS").startsWith("UPDATE")) {
				projectDAO.updateProject(map);
			}
		}
	}
	
	/**
	 * 프로젝트권한정보 저장
	 * @param param
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void saveAuth(Map<String, Object> param) {
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
			if(map.get("STATUS").startsWith("DELETE")) {
				projectDAO.deleteProjectAuth(map);
				userDAO.deleteProjectId(map);
			} else if(map.get("STATUS").startsWith("INSERT")) {
				projectDAO.insertProjectAuth(map);
			} else if(map.get("STATUS").startsWith("UPDATE")) {
				if("X".equals(map.get("WRITE_YN"))) {
					projectDAO.deleteProjectAuth(map);
					userDAO.deleteProjectId(map);
				} else
					projectDAO.mergeProjectAuth(map);
			}
		}
	}
}
