package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO extends BaseDAO {
	
	/**
	 * 게시판 목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectBoardList(Map<String, String> param) {
		return getSqlSession().selectList("sql.board.selectBoardList", param);
	}
	
	/**
	 * 게시판 등록
	 * 
	 * @param param
	 */
	public void insertBoard(Map<String, String> param) {
		getSqlSession().update("sql.board.insertBoard", param);
	}

	/**
	 * 게시판 수정
	 * 
	 * @param param
	 */
	public void updateBoard(Map<String, String> param) {
		getSqlSession().update("sql.board.updateBoard", param);
	}


	/**
	 * 게시판 삭제
	 * 
	 * @param param
	 */
	public void deleteBoard(Map<String, String> param) {
		getSqlSession().delete("sql.board.deleteBoard", param);
	}
}
