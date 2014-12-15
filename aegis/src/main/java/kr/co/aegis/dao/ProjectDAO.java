package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO extends BaseDAO {

	/**
	 * 프로젝트 목록 조회
	 * @return
	 */
	public String selectWriteYn(Map<String, Object> param) {
		Map<String, String> map = getSqlSession().selectOne("sql.project.selectWriteYn", param);
		return map.get("WRITE_YN");
	}
	
	/**
	 * 프로젝트 아이디 조회
	 * @return
	 */
	public String selectProjectId() {
		String projectId = getSqlSession().selectOne("sql.project.selectProjectId");
		return projectId;
	}
	
	/**
	 * 프로젝트 목록 조회
	 * @return
	 */
	public List<Map<String, String>> selectProjectList(Map<String, String> param) {
		return getSqlSession().selectList("sql.project.selectProjectList", param);
	}
	
	/**
	 * 프로젝트정보 등록
	 * @param param
	 */
	public void insertProject(Map<String, String> param) {
		getSqlSession().insert("sql.project.insertProject", param);
	}
	
	/**
	 * 프로젝트정보 수정
	 * @param param
	 */
	public void updateProject(Map<String, String> param) {
		getSqlSession().update("sql.project.updateProject", param);
	}
	
	/**
	 * 프로젝트정보 삭제
	 * @param param
	 */
	public void deleteProject(Map<String, String> param) {
		getSqlSession().delete("sql.project.deleteProject", param);
	}
	
	/**
	 * 프로젝트권한 목록 조회
	 * @return
	 */
	public List<Map<String, String>> selectProjectAuthList(Map<String, String> param) {
		return getSqlSession().selectList("sql.project.selectProjectAuthList", param);
	}
	
	/**
	 * 프로젝트권한 목록 조회
	 * @return
	 */
	public List<Map<String, String>> selectProjectAuthList2(Map<String, String> param) {
		return getSqlSession().selectList("sql.project.selectProjectAuthList2", param);
	}
	

	/**
	 * 로그인 사용자 프로젝트 목록 조회
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectLoginProject(Map<String, Object> param) {
		return getSqlSession().selectList("sql.project.selectLoginProject", param);
	}
	
	/**
	 * 프로젝트권한 목록 조회 조회조건 아이디
	 * @return
	 */
	public List<Map<String, String>> selectProjectAuthListWithId(Map<String, String> param) {
		return getSqlSession().selectList("sql.project.selectProjectAuthListWithId", param);
	}
		
	/**
	 * 프로젝트권한정보 등록
	 * @param param
	 */
	public void insertProjectAuth(Map<String, String> param) {
		getSqlSession().insert("sql.project.insertProjectAuth", param);
	}
	
		
	/**
	 * 프로젝트권한정보 등록(사용자기준)
	 * @param param
	 */
	public void insertToSelectProjectAuth(Map<String, String> param) {
		getSqlSession().insert("sql.project.insertToSelectProjectAuth", param);
	}
	
	/**
	 * 프로젝트권한정보 등록(프로젝트기준)
	 * @param param
	 */
	public void insertToSelectProjectAuth2(Map<String, String> param) {
		getSqlSession().insert("sql.project.insertToSelectProjectAuth2", param);
	}
	
	/**
	 * 프로젝트권한정보 수정
	 * @param param
	 */
	public void updateProjectAuth(Map<String, String> param) {
		getSqlSession().update("sql.project.updateProjectAuth", param);
	}
	
	/**
	 * 프로젝트권한정보 병합
	 * @param param
	 */
	public void mergeProjectAuth(Map<String, String> param) {
		getSqlSession().update("sql.project.mergeProjectAuth", param);
	}
	
	/**
	 * 프로젝트권한정보 삭제
	 * @param param
	 */
	public void deleteProjectAuth(Map<String, String> param) {
		getSqlSession().delete("sql.project.deleteProjectAuth", param);
	}
}
