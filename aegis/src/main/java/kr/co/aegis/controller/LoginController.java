package kr.co.aegis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.properties.Message;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.dto.User;
import kr.co.aegis.service.MailService;
import kr.co.aegis.service.ProjectService;
import kr.co.aegis.service.UserService;
import kr.co.aegis.util.StringUtil;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController {
	@Value("${mail.fromUser}") private String fromUser;
	@Value("${mail.toUser}") private String toUser;
	
	private UserService userService;
	private ProjectService projectService;
	private MailService mailService;
	
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@Autowired
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
	/**
	 * 메인화면
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/index.do")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("index");
	}	
	
	/**
	 * 메인화면
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/loginView.do")
	public ModelAndView loginView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("login");
	}	
	
	/**
	 * 로그인창 팝업
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/loginDlg.do")
	public ModelAndView loginPop(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/common/loginDlg");
	}	
	
	/**
	 * 회원가입
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/join.do")
	public ModelAndView join(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/common/joinView");
	}	
	
	/**
	 * ID/PW찾기
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/find.do")
	public ModelAndView find(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/common/findView");
	}	
	
	/**
	 * PW변경 팝업
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/findDlg.do")
	public ModelAndView findDlg(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/common/findDlg");
	}	
	
	/**
	 * 로그인
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login.do")
	public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {

		String json = request.getParameter("JSON");
		Map<String, Object> paramMap = super.getMapFromJson(json);
		
		Map<String, String> login = userService.selectLoginUser(paramMap);
		
		@SuppressWarnings("unchecked")
		// 로그인 하기전 검색식이 존재한다면 검색식 세션에 저장
		Map<String, String> sessionData = (Map<String, String>)paramMap.get("DATA");
		if(sessionData != null){
			Iterator<String> it = sessionData.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				session.setAttribute(key, sessionData.get(key));
			}
		}
		
		
		JsonModelAndView modelAndView = new JsonModelAndView();
		if(login == null || "".equals(login.get("ID"))) {
			modelAndView.error(Message.ERR_0011);
		}else {
			// 세션 작업
			List<Map<String, String>> projectList = projectService.selectLoginProject(paramMap);
			// 프로젝트 리스트가 존재한다면
			if(projectList != null && projectList.size() > 0) {
				if(StringUtil.isNull(login.get("PROJECT_ID"))) {
					// 작업중엔 프로젝트가 없으면 최근에 만든 프로젝트로 세션 설정
					Map<String, String> map = projectList.get(0);
					login.put("PROJECT_ID", map.get("PROJECT_ID"));
					login.put("PROJECT_AUTH", map.get("WRITE_YN"));
					login.put("LOGIN_ID"  , login.get("ID"));
					userService.setProjectId(login);
				} else {
					// 작업중인 프로젝트가 있다면 편집권한을 세션 설정
					String projectId = StringUtil.isNull(login.get("PROJECT_ID")) ? "" : login.get("PROJECT_ID");
					for(Map<String, String> map : projectList) {
						if(projectId.equals(map.get("PROJECT_ID"))) {
							login.put("PROJECT_AUTH", map.get("WRITE_YN"));
							break;
						}
					}
				}
			} else {
				login.put("PROJECT_AUTH", "0");
			}
			// 사용자 세션 저장
			User user = setSessionInfo(login, projectList, session);
			modelAndView.addObject("NAME", user.getName());
			modelAndView.success();
		}
		
		return modelAndView;
	}
	
	/**
	 * 아이디 중복 체크
	 * @param ID
	 * @param PASSWORD
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dupCheckID.do")
	public ModelAndView dupCheckID(@RequestParam String ID, @RequestParam String PASSWORD, Model model) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("ID", ID);
		param.put("PASSWORD", PASSWORD);
		
		return new ModelAndView("index");
	}
	
	/**
	 * 로그아웃
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		super.expireSession(session);
		JsonModelAndView modelAndView = new JsonModelAndView();
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 프로젝트 변경시 세션값 변경
	 * @param PROJECT_ID
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/setProjectId.do")
	public ModelAndView setProjectId(@RequestParam String PROJECT_ID, HttpSession session) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		User user = getLoginUser(session);
		user.setProjectId(PROJECT_ID);
		List<Map<String, String>> projectList = user.getProjectList();
		for(Map<String, String> map : projectList) {
			if(PROJECT_ID.equals(map.get("PROJECT_ID"))) {
				user.setProjectAuth(map.get("WRITE_YN"));
				break;
			}
		}		
		Map<String, String> param = new HashMap<String, String>();
		param.put("LOGIN_ID"  , user.getId());
		param.put("PROJECT_ID", PROJECT_ID);
		userService.setProjectId(param);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 회원가입 요청
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/request.do")
	public ModelAndView request(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		List<Map<String, String>> list  = super.getListFromJson(data);     
		Map<String, Object> saveMap = new HashMap<String, Object>();
		saveMap.put("list"    , list);
		saveMap.put("LOGIN_ID", "system");
		saveMap.put("PRIORITY", "A");
		userService.save(saveMap);
		

		// 관리자에게 메일 보내기
		Map<String, String> tempMap = list.get(0);
		Map<String, String> emailInfo = new HashMap<String, String>();
		String company = StringUtil.isNull(tempMap.get("COMPANY")) ? "" : tempMap.get("COMPANY");
		String name = StringUtil.isNull(tempMap.get("NAME")) ? "" : tempMap.get("NAME");
		String tel1 = StringUtil.isNull(tempMap.get("TEL_1")) ? "" : tempMap.get("TEL_1")+"-";
		String tel2 = StringUtil.isNull(tempMap.get("TEL_2")) ? "" : tempMap.get("TEL_2")+"-";
		String tel3 = StringUtil.isNull(tempMap.get("TEL_3")) ? "" : tempMap.get("TEL_3");
		String email = StringUtil.isNull(tempMap.get("E_MAIL")) ? "" : tempMap.get("E_MAIL");
		String comment = StringUtil.isNull(tempMap.get("COMMENT")) ? "" : tempMap.get("COMMENT");
		
		String text = "요청자 정보<br/>\n";
		text += "소속 : "+company+"<br/>\n";
		text += "이름 : "+name+"<br/>\n";
		text += "연락처 :" + tel1+tel2+tel3+"<br/>\n";
		text += "E-MAIL : "+ email +"<br/>\n";
		text += "남기는 말 : "+ comment +"<br/><br/><br/>\n";
		text += "고객관리 화면에서 승인요청을 수락해주시기 바랍니다.";
		
		emailInfo.put("subject", "[AEGIS]승인요청");
		emailInfo.put("toUser", toUser);
		emailInfo.put("fromUser", fromUser);
		emailInfo.put("text", text);
		mailService.sendMail(emailInfo);
		
		modelAndView.success();
		return modelAndView;
	}

	/**
	 * ID찾기
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/findID.do")
	public ModelAndView findID(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		Map<String, String> param = getMapFromJson(data);
		
		String id = userService.selectFindId(param);
		if(!StringUtil.isNull(id)) {
			modelAndView.addObject("ID", id);
			modelAndView.success();
		} else {
			modelAndView.error(Message.ERR_0034);
		}
		return modelAndView;
	}
	
	/**
	 * PW변경
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/setPassword.do")
	public ModelAndView setPassword(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		Map<String, String> param  = super.getMapFromJson(data);     
		userService.setPassword(param);
		
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 사용자 세션 설정
	 * @param login
	 * @param projectList
	 * @param session
	 * @return
	 */
	private User setSessionInfo(Map<String, String> login, List<Map<String, String>> projectList, HttpSession session) {
		//super.expireSession(session);
		
		User user = new User();
		user.setId(login.get("ID"));                 
		user.setPassword(login.get("PASSWORD"));      
		user.setName(login.get("NAME"));          
		user.setPriority(login.get("PRIORITY"));      
		user.setCompany(login.get("COMPANY"));       
		user.setBizNo(login.get("BIZ_NO"));        
		user.setAdminId(login.get("ADMIN_ID"));       
		user.setEmail(login.get("E_MAIL"));         
		user.setTel(login.get("TEL"));        
		user.setAppvYn(login.get("APPV_YN"));        
		user.setDelYn(login.get("DEL_YN"));   
		user.setPoint(login.get("POINT").toString());
		user.setProjectId(login.get("PROJECT_ID"));
		user.setProjectAuth(login.get("PROJECT_AUTH"));
		user.setProjectList(projectList);
		
		super.setLoginUser(session, user);
		
		return user;

	}
	
}
