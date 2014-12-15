package kr.co.aegis.service;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.dao.ApplicantDAO;
import kr.co.aegis.dao.PatentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicantService extends BaseService {
	private ApplicantDAO applicantDAO;
	private PatentDAO patentDAO;
	
	@Autowired
	public void setApplicantDAO(ApplicantDAO applicantDAO) {
		this.applicantDAO = applicantDAO;
	}
	
	@Autowired
	public void setPatentDAO(PatentDAO patentDAO) {
		this.patentDAO = patentDAO;
	}
	
	/**
	 * 출원인대표명(프로젝트) 완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectApplicantCmpl(Map<String, String> param) {
		return applicantDAO.selectProjectApplicantCmpl(param);
	}
	

	/**
	 * 출원인대표명(프로젝트) 미완료목록 조회
	 * 
	 * @param param
	 */
	public List<Map<String, String>> selectProjectApplicantIncmpl(Map<String, String> param) {
		return applicantDAO.selectProjectApplicantIncmpl(param);
	}
	

	/**
	 * 출원인대표명(프로젝트) 미완료목록 조회
	 * 
	 * @param param
	 */
	@Transactional
	public void save(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
			map.put("ADMIN_ID", (String)param.get("ADMIN_ID"));
			// 1. 출원인대표명(프로젝트) 수정
			applicantDAO.updateProjectApplicant(map);
			
			// 2. 특허마스터에 해당 출원인 대표명 수정
			patentDAO.updateApplicantRename(map);
			
			// 3. 등록일 경우 출원인대표명(관리자) 테이블에 삽입
			if("INSERT".equals(map.get("STATUS")))
				applicantDAO.insertAdminApplicant(map);
			
		}
	}

}
