package kr.co.aegis.service;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.dao.CommonDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService extends BaseService {
	private CommonDAO commonDAO;
	
	@Autowired
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	/**
	 * 콤보리스트 조회
	 * @param groupCode
	 * @return
	 */
	public List<Map<String, String>> selectCommonList(String groupCode) {
		return commonDAO.selectList(groupCode);
	}
}
