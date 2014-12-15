package kr.co.aegis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseService;
import kr.co.aegis.dao.ApplicantDAO;
import kr.co.aegis.dao.CategoryDAO;
import kr.co.aegis.dao.PatentDAO;
import kr.co.aegis.dao.UserDAO;
import kr.co.aegis.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatentService extends BaseService {
	private PatentDAO patentDAO;
	private ApplicantDAO applicantDAO;
	private UserDAO userDAO;
	private CategoryDAO categoryDAO;
	
	@Autowired
	public void setPatentDAO(PatentDAO patentDAO) {
		this.patentDAO = patentDAO;
	}

	@Autowired
	public void setApplicantDAO(ApplicantDAO applicantDAO) {
		this.applicantDAO = applicantDAO;
	}
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	/**
	 * 특허 전체건수 상세조회
	 * 
	 * @return
	 */
	public Map<String, Object> selectPatentCnt(Map<String, Object> param) {
		return patentDAO.selectPatentCnt(param);
	}
	
	/**
	 * 특허리스트 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectPatentList(Map<String, Object> param) {
		return patentDAO.selectPatentList(param);
	}
	
	/**
	 * 특허리스트 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectKeyPatentList(Map<String, String> param) {
		return patentDAO.selectKeyPatentList(param);
	}

	/**
	 * 특허 상세조회
	 * 
	 * @return
	 */
	public Map<String, String> selectPatentDtl(Map<String, Object> param) {
		return patentDAO.selectPatentDtl(param);
	}


	/**
	 * 기존 데이터 등록여부
	 * 
	 * @return
	 */
	public String selectExistsPatent(Map<String, String> param) {
		return patentDAO.selectExistsPatent(param);
	}
	
	/**
	 * 업로드 임시 리스트
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectUploadTempList(Map<String, String> param) {
		return patentDAO.selectUploadTempList(param);
	}

	
	/**
	 * 특허 임시 리스트
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectPatentTempList(Map<String, String> param) {
		return patentDAO.selectPatentTempList(param);
	}
	
	/**
	 * 특허 임시 리스트
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectSeqNumList(Map<String, String> param) {
		return patentDAO.selectSeqNumList(param);
	}
	
	/**
	 * 누락 DB 조회
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectOmissionTempList(Map<String, String> param) {
		
		return patentDAO.selectOmissionTempList(param);
	}
	
	
	/**
	 * OS 매트릭스 조회
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectMcateList(Map<String, String> param) {
		return patentDAO.selectMcateList(param);
	}
	
	
	/**
	 * OS 매트릭스 특허 조회
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectOSMatrixList(Map<String, String> param) {
		return patentDAO.selectOSMatrixList(param);
	}


	/**
	 * 업로드 임시 저장
	 * @param param
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public void saveUploadTemp(Map<String, Object> param) {
		Map<String, String> deleteMap = new HashMap<String, String>();
		deleteMap.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
		patentDAO.deleteUploadTemp(deleteMap);

		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("USER_ID", (String)param.get("LOGIN_ID"));
			patentDAO.insertUploadTemp(map);
		}
	}
	
	/**
	 * 특허 임시 저장
	 * @param param
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public void savePatentTemp(Map<String, Object> param) {
		Map<String, String> deleteMap = new HashMap<String, String>();
		deleteMap.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
		patentDAO.deletePatentTemp(deleteMap);
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("USER_ID", (String)param.get("LOGIN_ID"));
			patentDAO.insertPatentTemp(map);
		}
	}
	
	/**
	 * 특허 마스터 저장
	 * @param param
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public int savePatent(Map<String, Object> param) {
		int ret = 0;
		Map<String, String> updateMap = new HashMap<String, String>();
		updateMap.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
		updateMap.put("ADMIN_ID"  , (String)param.get("ADMIN_ID"));	
		updateMap.put("PROJECT_ID", (String)param.get("PROJECT_ID"));	
		
		// 특허테이블 저장
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			map.put("PROJECT_ID", (String)param.get("PROJECT_ID"));
			// 국가코드, 출원번호가 중복되지 않으면 insert
			if("F".equals(patentDAO.selectExistsApplNum(map)))
				ret += patentDAO.insertToSelectPatent(map);
		}

		// 포인트 차감
		updateMap.put("COUNT"     , String.valueOf(ret));
		userDAO.updatePoint(updateMap);
		return ret;
	}
	
	/**
	 * 특허 저장
	 * @param param
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void save(Map<String, Object> param) {
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID", param.get("LOGIN_ID").toString());
			if("DELETE".equals(map.get("STATUS"))) {
				patentDAO.updateDelYn(map);
			} else if("UPDATE".equals(map.get("STATUS"))) {
				patentDAO.updatePatent(map);
				String[] keywordList = map.get("KEYWORD_LIST").split(",");
				if(!StringUtil.isNull(map.get("KEYWORD_LIST"))) {
					// 기존값 삭제
					categoryDAO.deletePatentCategory(map);
					for(String keyword : keywordList) {
						if(StringUtil.isNull(keyword)) continue;
						map.put("KEYWORD", keyword.trim());
						// 1. 특허별 키워드 저장
						categoryDAO.mergePatentCategory(map);
						// 2. 프로젝트별 키워드 저장
						categoryDAO.mergeProjectCategory(map);
					}
				}
			}
		}
	}

	/**
	 * 핵심특허 정보 수정
	 * @param param
	 */
	@Transactional
	public void updatePatent(Map<String, String> param) {
		patentDAO.updatePatent(param);
	}
	
	/**
	 * 연번 저장
	 * @param param
	 */
	@Transactional
	public void setSeqNum(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		int index = 0;
		for(Map<String, String> map : list) {
			++index;
			map.put("SEQ_NUM"   , StringUtil.lpad(String.valueOf(index), 5, "0"));
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			map.put("PROJECT_ID", (String)param.get("PROJECT_ID"));
			patentDAO.updateSeqNum(map);
		}
	}

	/**
	 * 대표명화 저장
	 * @param param
	 */
	@Transactional
	public void setApplicantRename(Map<String, Object> param ) {
		@SuppressWarnings("unchecked")
		// 대표명화 프로젝트 테이블에 등록
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			map.put("PROJECT_ID", (String)param.get("PROJECT_ID"));
			map.put("ADMIN_ID"  , (String)param.get("ADMIN_ID"));
			
			if(!StringUtil.isNull(map.get("APPLICANT")) && applicantDAO.isNotExistProjectApplicant(map))
				applicantDAO.insertProjectApplicant(map);
		}
		
		// 특허 테이블의 대표명화컬럼 갱신
		Map<String, String> updateMap = new HashMap<String, String>();
		updateMap.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
		updateMap.put("PROJECT_ID", (String)param.get("PROJECT_ID"));
		updateMap.put("ADMIN_ID"  , (String)param.get("ADMIN_ID"));
		
		patentDAO.updateAllApplicantRename(updateMap);
		
		// 대표명화 프로젝트 테이블을 대표명화 관리자 테이블 정보로 업데이트
		applicantDAO.updateAllProjectApplicant(updateMap);
	}
	

	/**
	 * 패밀리연번 저장
	 * @param param
	 */
	@Transactional
	public void setFmSeqNum(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			patentDAO.updateFmSeqNum(map);
		}
	}

	/**
	 * 법적상태 저장
	 * @param param
	 */
	@Transactional
	public void setLegalStatus(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			patentDAO.updateLegalStatus(map);
		}
	}	
	

	/**
	 * 중요특허여부 저장
	 * @param param
	 */
	@Transactional
	public void setImportantYn(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			patentDAO.updateImportantYn(map);
		}
	}
	
	

	/**
	 * 삭제여부 저장
	 * @param param
	 */
	@Transactional
	public void setDelYn(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			patentDAO.updateDelYn(map);
		}
	}
	
	/**
	 * 누락DB 저장
	 * @param param
	 */
	@Transactional
	public void saveOmissionTemp(Map<String, Object> param) {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)param.get("list");
		patentDAO.deleteOmissionTemp(list.get(0));
		for(Map<String, String> map : list) {
			map.put("LOGIN_ID"  , (String)param.get("LOGIN_ID"));
			patentDAO.insertOmissionTemp(map);
		}
	}
	
	/**
	 * 기술분류(키워드) 저장
	 * 
	 * @param param
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void saveKeyword(Map<String, Object> param) {
		String[] list = (String[])param.get("list");
		Map<String, String> map = (Map<String, String>)param.get("map");
		for(String keyword : list) {
			if(StringUtil.isNull(keyword)) continue;
			map.put("LOGIN_ID", (String)param.get("LOGIN_ID"));
			map.put("ADMIN_ID", (String)param.get("ADMIN_ID"));
			map.put("KEYWORD" , keyword);

			// 1. 기술분류(프로젝트) 수정
			categoryDAO.mergeProjectCategory(map);
			// 2. 기술분류(관리자) 테이블에 삽입
			categoryDAO.insertPatentCategory(map);
		}

	}

	/**
	 * 대표도면 저장
	 * @param param
	 */
	@Transactional
	public void setImageMain(Map<String, String> param) {
		patentDAO.updateImageMain(param);
	}
}
