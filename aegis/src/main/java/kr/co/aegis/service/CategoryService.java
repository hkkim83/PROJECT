package kr.co.aegis.service;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.dao.CategoryDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService extends BaseService {
	private CategoryDAO categoryDAO;
	
	@Autowired
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	/**
	 * 기술분류(프로젝트) 완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectCategoryCmpl(Map<String, String> param) {
		return categoryDAO.selectProjectCategoryCmpl(param);
	}
	

	/**
	 * 기술분류(프로젝트) 미완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectCategoryIncmpl(Map<String, String> param) {
		return categoryDAO.selectProjectCategoryIncmpl(param);
	}
	

	/**
	 *  기술분류(특허) 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectPatentCategoryList(Map<String, String> param) {
		return categoryDAO.selectPatentCategoryList(param);
	}

	/**
	 *  기술분류(프로젝트) 중분류 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectCategoryList(Map<String, String> param) {
		return categoryDAO.selectCategoryList(param);
	}
	
	/**
	 * 기술분류(프로젝트) 저장
	 * 
	 * @param param
	 */
	@Transactional
	public void save(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			
			if("DELETE".equals(map.get("STATUS"))) {
				// 1. 기술분류(프로젝트) 삭제
				categoryDAO.deleteProjectCategory(map);
				// 2. 기술분류(특허) 삭제
				categoryDAO.deletePatentCategory(map);
			} else {
				map.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
				map.put("ADMIN_ID", (String)param.get("ADMIN_ID"));
				if("INSERT".equals(map.get("STATUS"))) {
					// 키워드 대표명에 맞는 중분류, 대분류 조회
					Map<String, String> cateMap = categoryDAO.selectAdminCategory(map);
					if(cateMap != null && !cateMap.isEmpty()) {
						map.put("MCATE", cateMap.get("MCATE"));
						map.put("LCATE", cateMap.get("LCATE"));
					}
					// 1. 기술분류(관리자) 테이블에 삽입
					categoryDAO.mergeAdminCategory(map);
				} else {
					// 기존 기술분류(관리자)테이블에 중분류, 대분류값이 없으면
					if(categoryDAO.isUpdateableAdminCategory(map)) {
						// 1. 기술분류(관리자) 테이블 수정
						categoryDAO.updateAdminCategory(map);						
					}
				}
				// 2. 기술분류(프로젝트) 수정
				categoryDAO.updateProjectCategory(map);
			}
		}
	}
}
