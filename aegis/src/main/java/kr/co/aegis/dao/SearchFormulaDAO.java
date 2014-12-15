package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class SearchFormulaDAO extends BaseDAO {

	// 검색식 저장
	public int insert(Map<String, String> map) {
		return getSqlSession().insert("sql.searchFormula.insert", map);
	}
	
	// 검색식 삭제
	public int update(Map<String, String> map) {
		return getSqlSession().update("sql.searchFormula.update", map);
	}

	// 검색식 삭제
	public int delete(Map<String, String> map) {
		return getSqlSession().delete("sql.searchFormula.delete", map);
	}

	// 사용자별 검색식 목록 조회
	public List<Map<String, String>> selectList(String userId) {
		return getSqlSession().selectList("sql.searchFormula.selectList", userId);
	}
}
