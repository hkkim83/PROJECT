package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO extends BaseDAO {
	
	/**
	 * 기술분류(프로젝트) 완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectCategoryCmpl(Map<String, String> param) {
		return getSqlSession().selectList("sql.category.selectProjectCategoryCmpl", param);
	}
	
	/**
	 * 기술분류(프로젝트) 미완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectCategoryIncmpl(Map<String, String> param) {
		return getSqlSession().selectList("sql.category.selectProjectCategoryIncmpl", param);
	}
	
	
	/**
	 * 기술분류(특허) 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectPatentCategoryList(Map<String, String> param) {
		return getSqlSession().selectList("sql.category.selectPatentCategoryList", param);
	}
	
	/**
	 * 기술분류(관리자) 조회
	 * 
	 * @param param
	 */
	public Map<String, String> selectAdminCategory(Map<String, String> param) {
		return getSqlSession().selectOne("sql.category.selectAdminCategory", param);
	}
	
	/**
	 * 기술분류(프로젝트) 중분류 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectCategoryList(Map<String, String> param) {
		return getSqlSession().selectList("sql.category.selectCategoryList", param);
	}
	
	/**
	 * 기술분류(관리자) 수정여부 조회
	 * 
	 * @param param
	 */
	public boolean isUpdateableAdminCategory(Map<String, String> param) {
		Map<String, Integer> map = getSqlSession().selectOne("sql.category.selectUpdateableAdminCategory", param);
		return "T".equals(map.get("DUP_CHECK"));
	}
	
	/**
	 * 기술분류(프로젝트) 등록
	 * 
	 * @param param
	 */
	public void mergeProjectCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.mergeProjectCategory", param);
	}
	
	/**
	 * 기술분류(프로젝트) 등록 또는 수정
	 * 
	 * @param param
	 */
	public void updateProjectCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.updateProjectCategory", param);
	}

	
	/**
	 * 기술분류(프로젝트) 삭제
	 * 
	 * @param param
	 */
	public void deleteProjectCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.deleteProjectCategory", param);
	}
	
	/**
	 * 기술분류(특허) 등록또는수정
	 * 
	 * @param param
	 */
	public void mergePatentCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.mergePatentCategory", param);
	}
	
	/**
	 * 기술분류(특허) 등록
	 * 
	 * @param param
	 */
	public void insertPatentCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.insertPatentCategory", param);
	}
	
	/**
	 * 기술분류(특허) 삭제
	 * 
	 * @param param
	 */
	public void deletePatentCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.deletePatentCategory", param);
	}

	/**
	 * 기술분류(관리자) 등록 또는 수정
	 * 
	 * @param param
	 */
	public void mergeAdminCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.mergeAdminCategory", param);
	}
	
	/**
	 * 기술분류(관리자) 등록
	 * 
	 * @param param
	 */
	public void insertAdminCategory(Map<String, String> param) {
		getSqlSession().insert("sql.category.insertAdminCategory", param);
	}
	
	
	/**
	 * 기술분류(관리자) 수정
	 * 
	 * @param param
	 */
	public void updateAdminCategory(Map<String, String> param) {
		getSqlSession().update("sql.category.updateAdminCategory", param);
	}
}
