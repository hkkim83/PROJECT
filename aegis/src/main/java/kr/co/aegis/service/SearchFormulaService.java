package kr.co.aegis.service;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.core.exception.DataIntegrityException;
import kr.co.aegis.dao.SearchFormulaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SearchFormulaService extends BaseService {
	
	private SearchFormulaDAO searchFormulaDAO;
	
	@Autowired
	public void setSearchFormDAO(SearchFormulaDAO searchFormDAO) {
		this.searchFormulaDAO = searchFormDAO;
	}	
	
	
	/**
	 * 검색식 등록
	 * @param map
	 * @param userId
	 */
	@Transactional
	public void registry(Map<String, String> map, String userId) {
		map.put("USER_ID", userId);
		int result = searchFormulaDAO.insert(map);
		if(result != 1){
			throw new DataIntegrityException();
		}
	}
	
	/**
	 * 검색식 수정
	 * @param map
	 * @param userId
	 */
	@Transactional
	public void modify(Map<String, String> map, String userId) {
		map.put("USER_ID", userId);
		int result = searchFormulaDAO.update(map);
		if(result != 1){
			throw new DataIntegrityException();
		}
	}

	/**
	 * 검색식 삭제
	 * @param map
	 */
	@Transactional
	public void remove(Map<String, String> map) {
		int result = searchFormulaDAO.delete(map);
		if(result != 1){
			throw new DataIntegrityException();
		}
	}
	
	/**
	 * 검색식 목록조회
	 * @param userId
	 * @return
	 */
	public List<Map<String, String>> getList(String userId) {
		return searchFormulaDAO.selectList(userId);
	}
}
