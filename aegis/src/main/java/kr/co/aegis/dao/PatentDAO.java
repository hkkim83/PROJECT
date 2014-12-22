package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.aegis.base.BaseDAO;

@Repository
public class PatentDAO extends BaseDAO {

	/**
	 * 특허 전체건수 상세조회
	 * 
	 * @return
	 */
	public Map<String, Object> selectPatentCnt(Map<String, Object> param) {
		return getSqlSession().selectOne("sql.patent.selectPatentCnt", param);
	}
	
	/**
	 * 특허리스트 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectPatentList(Map<String, Object> param) {
		
		return getSqlSession().selectList("sql.patent.selectPatentList", param);
	}
	
	/**
	 * 특허리스트 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectKeyPatentList(Map<String, String> param) {
		return getSqlSession().selectList("sql.patent.selectKeyPatentList", param);
	}

	/**
	 * 특허 상세조회
	 * 
	 * @return
	 */
	public Map<String, String> selectPatentDtl(Map<String, Object> param) {
		return getSqlSession().selectOne("sql.patent.selectPatentDtl", param);
	}

	/**
	 * 기존 데이터 등록여부
	 * 
	 * @return
	 */
	public String selectExistsPatent(Map<String, String> param) {
		return getSqlSession().selectOne("sql.patent.selectExistsPatent", param);
	}
	
	/**
	 * 중복 출원번호 등록 여부
	 * 
	 * @return
	 */
	public String selectExistsApplNum(Map<String, String> param) {
		return getSqlSession().selectOne("sql.patent.selectExistsApplNum", param);
	}
	
	
	/**
	 * 업로드 임시 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectUploadTempList(Map<String, String> param) {
		return getSqlSession().selectList("sql.patent.selectUploadTempList", param);
	}

	/**
	 * 업로드 임시 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectPatentTempList(Map<String, String> param) {
		return getSqlSession().selectList("sql.patent.selectPatentTempList", param);
	}


	/**
	 * 특허 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectSeqNumList(Map<String, String> param) {
		return getSqlSession().selectList("sql.patent.selectSeqNumList", param);
	}

	/**
	 * 누락디비리스트 조회
	 * @param param
	 * @return
	 */
	public List<Map<String, String>> selectOmissionTempList(Map<String, String> param) {
		return getSqlSession().selectList("sql.patent.selectOmissionTempList", param);
	}

	/**
	 * OS 매트릭스 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectMcateList(Map<String, String> param) {
		return getSqlSession().selectList("sql.patent.selectMcateList", param);
	}
	

	/**
	 * OS 매트릭스 특허 조회
	 * 
	 * @return
	 */
	public List<Map<String, String>> selectOSMatrixList(Map<String, String> param) {
		return getSqlSession().selectList("sql.patent.selectOSMatrixList", param);
	}
	
	/**
	 * 업로드 임시 등록
	 * 
	 * @param param
	 */
	public void insertUploadTemp(Map<String, String> param) {
		getSqlSession().insert("sql.patent.insertUploadTemp", param);
	}

	/**
	 * 특허 임시 등록
	 * 
	 * @param param
	 */
	public void insertPatentTemp(Map<String, String> param) {
		getSqlSession().insert("sql.patent.insertPatentTemp", param);
	}

	/**
	 * 특허 마스터 등록
	 * 
	 * @param param
	 */
	public void insertPatent(Map<String, String> param) {
		getSqlSession().insert("sql.patent.insertPatent", param);
	}

	/**
	 * 특허 마스터 등록 ( 특허임시에서 )
	 * 
	 * @param param
	 */
	public int insertToSelectPatent(Map<String, String> param) {
		return getSqlSession().insert("sql.patent.insertToSelectPatent", param);
	}
	

	/**
	 * 연번 부여
	 * 
	 * @param param
	 */
	public void updateSeqNum(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateSeqNum", param);
	}
	
	

	/**
	 * 출원인 대표명 일괄수정
	 * 
	 * @param param
	 */
	public void updateAllApplicantRename(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateAllApplicantRename", param);
	}
	

	/**
	 * 출원인 대표명 수정
	 * 
	 * @param param
	 */
	public void updateApplicantRename(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateApplicantRename", param);
	}
	

	/**
	 * 패밀리연번 부여
	 * 
	 * @param param
	 */
	public void updateFmSeqNum(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateFmSeqNum", param);
	}
	

	/**
	 * 법적상태 갱신
	 * 
	 * @param param
	 */
	public void updateLegalStatus(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateLegalStatus", param);
	}
	

	/**
	 * 중요특허여부 갱신
	 * 
	 * @param param
	 */
	public void updateImportantYn(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateImportantYn", param);
	}
	

	/**
	 * 특허 삭제
	 * 
	 * @param param
	 */
	public void updateDelYn(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateDelYn", param);
	}
	

	/**
	 * 대표도면 저장
	 * 
	 * @param param
	 */
	public void updateImageMain(Map<String, String> param) {
		getSqlSession().update("sql.patent.updateImageMain", param);
	}
	
	

	/**
	 * 전문저장
	 * 
	 * @param param
	 */
	public void updatePatentFulltxt(Map<String, String> param) {
		getSqlSession().update("sql.patent.updatePatentFulltxt", param);
	}
	

	/**
	 * 특허 수정
	 * 
	 * @param param
	 */
	public void updatePatent(Map<String, String> param) {
		getSqlSession().update("sql.patent.updatePatent", param);
	}

	/**
	 * 
	 * 누락DB 등록
	 * 
	 * @param param
	 */
	public void insertOmissionTemp(Map<String, String> param) {
		getSqlSession().insert("sql.patent.insertOmissionTemp", param);
	}
	
	/**
	 * 
	 * 누락DB 삭제
	 * 
	 * @param param
	 */
	public void deleteOmissionTemp(Map<String, String> param) {
		getSqlSession().delete("sql.patent.deleteOmissionTemp", param);
	}
	
	
	/**
	 * 
	 * 업로드 임시 삭제
	 * 
	 * @param param
	 */
	public void deleteUploadTemp(Map<String, String> param) {
		getSqlSession().delete("sql.patent.deleteUploadTemp", param);
	}
	
	
	/**
	 * 
	 * 특허 임시 삭제
	 * 
	 * @param param
	 */
	public void deletePatentTemp(Map<String, String> param) {
		getSqlSession().delete("sql.patent.deletePatentTemp", param);
	}
	
	
	/**
	 * 
	 * 특허 삭제
	 * 
	 * @param param
	 */
	public void deletePatent(Map<String, String> param) {
		getSqlSession().delete("sql.patent.deletePatent", param);
	}
}
