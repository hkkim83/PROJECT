package kr.co.aegis.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
	
	private static final long serialVersionUID = 3900067986168100486L;
	
	private String id;            //사용자아이디        
	private String password;      //사용자비밀번호 
	private String name;          //사용자이름     
	private String priority;      //사용자권한     
	private String company;       //소속           
	private String bizNo;         //사업자번호     
	private String adminId;       //관리자ID       
	private String email;         //이메일         
	private String tel;           //전화번호       
	private String tel1;          //전화번호1      
	private String tel2;          //전화번호2      
	private String tel3;          //전화번호3      
	private String comment;       //의견           
	private String appvYn;        //승인여부       
	private String delYn;         //삭제여부
	private String point;         //포인트
	private String projectId;     //프로젝트ID
	private String projectAuth;   //프로젝트권한
	private List<Map<String, String>> projectList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBizNo() {
		return bizNo;
	}
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAppvYn() {
		return appvYn;
	}
	public void setAppvYn(String appvYn) {
		this.appvYn = appvYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectAuth() {
		return projectAuth;
	}
	public void setProjectAuth(String projectAuth) {
		this.projectAuth = projectAuth;
	}
	public List<Map<String, String>> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Map<String, String>> projectList) {
		this.projectList = projectList;
	}
}
