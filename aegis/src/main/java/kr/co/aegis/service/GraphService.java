package kr.co.aegis.service;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.dao.GraphDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphService extends BaseService {
	private GraphDAO graphDAO;
	
	@Autowired
	public void setGraphDAO(GraphDAO graphDAO) {
		this.graphDAO = graphDAO;
	}
	
	/**
	 * 그래프 조회
	 * @param param
	 */
	public List<Map<String, String>> selectGraph(Map<String, String> param) {
		return graphDAO.selectGraph(param);
	}
}
