package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class ApplicantDAO extends BaseDAO {
	
	/**
	 * 출원인대표명(프로젝트) 완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectApplicantCmpl(Map<String, String> param) {
		return getSqlSession().selectList("sql.applicant.selectProjectApplicantCmpl", param);
	}
	
	/**
	 * 출원인대표명(프로젝트) 미완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectApplicantIncmpl(Map<String, String> param) {
		return getSqlSession().selectList("sql.applicant.selectProjectApplicantIncmpl", param);
	}
	
	/**
	 * 출원인대표명(프로젝트) 등록여부 조회
	 * 
	 * @param param
	 */
	public boolean isNotExistProjectApplicant(Map<String, String> param) {
		Map<String, Integer> map = getSqlSession().selectOne("sql.applicant.selectExistProjectApplicant", param);
		return "F".equals(map.get("DUP_CHECK"));
	}

	/**
	 * 출원인대표명(프로젝트) 등록
	 * 
	 * @param param
	 */
	public void insertProjectApplicant(Map<String, String> param) {
		getSqlSession().insert("sql.applicant.insertProjectApplicant", param);
	}


	/**
	 * 출원인대표명(프로젝트) 수정
	 * 
	 * @param param
	 */
	public void updateProjectApplicant(Map<String, String> param) {
		getSqlSession().insert("sql.applicant.updateProjectApplicant", param);
	}


	/**
	 * 출원인대표명(관리자)를 이용한 출원인대표명(프로젝트) 수정
	 * 
	 * @param param
	 */
	public void updateAllProjectApplicant(Map<String, String> param) {
		getSqlSession().insert("sql.applicant.updateAllProjectApplicant", param);
	}
	

	/**
	 * 출원인대표명(프로젝트) 삭제
	 * 
	 * @param param
	 */
	public void deleteProjectApplicant(Map<String, String> param) {
		getSqlSession().insert("sql.applicant.deleteProjectApplicant", param);
	}
	
	/**
	 * 출원인대표명(관리자) 등록여부 조회
	 * 
	 * @param param
	 */
	public boolean isNotExistAdminApplicant(Map<String, String> param) {
		Map<String, Integer> map = getSqlSession().selectOne("sql.applicant.selectExistAdminApplicant", param);
		return "F".equals(map.get("DUP_CHECK"));
	}
	
	
	/**
	 * 출원인대표명(관리자) 등록
	 * 
	 * @param param
	 */
	public void insertAdminApplicant(Map<String, String> param) {
		getSqlSession().insert("sql.applicant.insertAdminApplicant", param);
	}
}
