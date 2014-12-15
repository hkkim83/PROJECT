package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class CommonDAO extends BaseDAO {

	public List<Map<String, String>> selectList(String groupCode) {
		return getSqlSession().selectList("sql.common.selectList", groupCode);
	}
	
	/**
	 * 시퀀스 가져오기
	 * @param seqName
	 * @return
	 */
	public Map<String, String> selectNextVal(String seqName) {
		return getSqlSession().selectOne("sql.common.selectNextVal", seqName);
	}
}
