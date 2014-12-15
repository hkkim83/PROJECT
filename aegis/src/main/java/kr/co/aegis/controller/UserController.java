package kr.co.aegis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.dto.User;
import kr.co.aegis.service.ProjectService;
import kr.co.aegis.service.UserService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	private UserService userService;
	private ProjectService projectService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * 사용자관리 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("admin/userView");
	}
		
	/**
	 * 사용자 리스트 조회
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = new HashMap<String, String>();
		String loginId = getLoginId(session);
		param.put("PRIORITY", "U");
		param.put("ADMIN_ID", loginId);
		
		List<Map<String, String>> list = userService.selectUserList(param);
		modelAndView.addObject("LIST", list);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 사용자별 프로젝트권한 조회
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/detail.do")
	public ModelAndView detail(HttpServletRequest request, HttpSession session, 
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = parseRequest(request);
		User user = getLoginUser(session);
		param.put("ADMIN_ID", user.getAdminId());
		List<Map<String, String>> userList = projectService.selectProjectAuthList2(param);
		param.put("WRITE_YN", "1");		// 편집권한
		List<Map<String, String>> writeList = projectService.selectProjectAuthList(param);
		param.put("WRITE_YN", "0");		// 제한편집 권한
		List<Map<String, String>> readList  = projectService.selectProjectAuthList(param);
		modelAndView.addObject("USER_LIST"   , userList);
		modelAndView.addObject("WRITE_LIST"  , writeList);
		modelAndView.addObject("READ_LIST"   , readList);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 사용자 저장
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/save.do")
	public ModelAndView save(HttpServletRequest request, HttpSession session, 
			HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		List<Map<String, String>> list = super.getListFromJson(data);  
		Map<String, Object> saveMap = new HashMap<String, Object>();
		String loginId = getLoginId(session);
		saveMap.put("list"    , list);
		saveMap.put("PRIORITY", "U");
		saveMap.put("LOGIN_ID", loginId);
		saveMap.put("ADMIN_ID", loginId);
		
		userService.save(saveMap);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 프로젝트 권한 저장
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveAuth.do")
	public ModelAndView saveAuth(HttpServletRequest request, HttpSession session, 
			HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		List<Map<String, String>> list = getListFromJson(data);
		Map<String, Object> saveMap = new HashMap<String, Object>();
		String loginId = getLoginId(session);
		saveMap.put("list"    , list);
		saveMap.put("LOGIN_ID", loginId);
		projectService.saveAuth(saveMap);
		modelAndView.success();
		return modelAndView;
	}
}
