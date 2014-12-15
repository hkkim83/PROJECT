package kr.co.aegis.service;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.dao.BoardDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService extends BaseService {
	private BoardDAO boardDAO;
	
	@Autowired
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	/**
	 * 게시판 목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectBoardList(Map<String, String> param) {
		return boardDAO.selectBoardList(param);
	}
	
	/**
	 * 게시판 저장
	 * 
	 * @param param
	 */
	@Transactional
	public void save(Map<String, String> param) {
		if("DELETE".equals(param.get("STATUS")))
			boardDAO.deleteBoard(param);
		else if("INSERT".equals(param.get("STATUS")))
			boardDAO.insertBoard(param);
		else if("UPDATE".equals(param.get("STATUS")))
			boardDAO.updateBoard(param);
	}
}
