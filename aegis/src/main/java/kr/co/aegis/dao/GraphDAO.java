package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class GraphDAO extends BaseDAO {
	
	/**
	 * 
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectGraph(Map<String, String> param) {
		String type = param.get("TYPE");
		return getSqlSession().selectList("sql.graph.selectGraph"+type, param);
	}
}
