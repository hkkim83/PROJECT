package kr.co.aegis.dao;

import java.util.List;
import java.util.Map;

import kr.co.aegis.base.BaseDAO;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends BaseDAO {

	/**
	 * 사용자 조회
	 * @param param
	 * @return
	 */
	public Map<String, String> selectUser(Map<String, String> param) {
		return getSqlSession().selectOne("sql.user.selectUser", param);
	}
	

	/**
	 * 사용자 로그인 확인
	 * @param param
	 * @return
	 */
	public Map<String, String> selectLoginUser(Map<String, Object> param) {
		return getSqlSession().selectOne("sql.user.selectLoginUser", param);
	}
	
	/**
	 * 사용자 목록 조회
	 * @return
	 */
	public List<Map<String, String>> selectUserList(Map<String, String> param) {
		return getSqlSession().selectList("sql.user.selectUserList", param);
	}
	
	/**
	 * 사용자 목록 조회
	 * @return
	 */
	public List<Map<String, String>> selectUserListForAuth(Map<String, String> param) {
		return getSqlSession().selectList("sql.user.selectUserListForAuth", param);
	}
	
	/**
	 * 사용자 ID 중복체크
	 * @param param
	 * @return
	 */
	public Map<String, String> selectCheckId(Map<String, String> param) {
		return getSqlSession().selectOne("sql.user.selectCheckId", param);
	}
	
	/**
	 * 관리자 ID 찾기
	 * @param param
	 * @return
	 */
	public String selectFindId(Map<String, String> param) {
		return getSqlSession().selectOne("sql.user.selectFindId", param);
	}
		
	/**
	 * 사용자정보 등록
	 * @param param
	 */
	public void insertUser(Map<String, String> param) {
		getSqlSession().insert("sql.user.insertUser", param);
	}
	
	/**
	 * 사용자정보 수정
	 * @param param
	 */
	public void updateUser(Map<String, String> param) {
		getSqlSession().update("sql.user.updateUser", param);
	}
	
	/**
	 * 사용자정보 삭제
	 * @param param
	 */
	public void deleteUser(Map<String, String> param) {
		getSqlSession().delete("sql.user.deleteUser", param);
	}
	
	
	/**
	 * 사용자리스트에 projectId 셋팅
	 * @param param
	 * @return
	 */
	public void updateProjectId(Map<String, String> param) {
		getSqlSession().delete("sql.user.updateProjectId", param);
	}
	
	/**
	 * 사용자리스트에 projectId 삭제
	 * @param param
	 * @return
	 */
	public void deleteProjectId(Map<String, String> param) {
		getSqlSession().delete("sql.user.deleteProjectId", param);
	}
	
	/**
	 * 관리자 포인트 차감
	 * @param param
	 */
	public void updatePoint(Map<String, String> param) {
		getSqlSession().update("sql.user.updatePoint", param);
	}
	
	
	/**
	 * 관리자 비밀번호 변경
	 * @param param
	 */
	public void updatePassword(Map<String, String> param) {
		getSqlSession().update("sql.user.updatePassword", param);
	}
	

	/**
	 * 관리자 비밀번호 변경
	 * @param param
	 */
	public void updateAppvYn(Map<String, String> param) {
		getSqlSession().update("sql.user.updateAppvYn", param);
	}
}
