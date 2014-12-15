package kr.co.aegis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.service.UserService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 마스터 - 고객관리
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/adminView");
	}
	
	/**
	 * 마스터 - 고객관리 승인요청 팝업
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/approvalDlg.do")
	public ModelAndView appvDlg(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/approvalDlg");
	}
	
	/**
	 * 사용가 구분이 관리자(A)인 경우 사용자목록 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = new HashMap<String, String>();
		param.put("PRIORITY", "A");
		
		List<Map<String, String>> list = userService.selectUserList(param);
		modelAndView.addObject("LIST", list);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 승인요청 목록 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/appvList.do")
	public ModelAndView appvList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = new HashMap<String, String>();
		param.put("PRIORITY", "A");
		param.put("APPV_YN" , "0");
		
		List<Map<String, String>> list = userService.selectUserList(param);
		modelAndView.addObject("LIST", list);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * ID중복체크
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/dupCheck.do")
	public ModelAndView dupCheck(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = parseRequest(request);
		Map<String, String> map = null;
		if("ID".equals(param.get("TYPE")))
			map = userService.selectCheckId(param);
		modelAndView.addObject("CHECK_MAP", map);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 사용자 저장
	 * @param request
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public ModelAndView save(HttpServletRequest request, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> list  = mapper.readValue(data, ArrayList.class);     
		Map<String, Object> saveMap = new HashMap<String, Object>();
		String loginId = getLoginId(session);
		saveMap.put("list"    , list);
		saveMap.put("LOGIN_ID", loginId);
		saveMap.put("PRIORITY", "A");
		userService.save(saveMap);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 승인요청 수락
	 * @param request
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveAppv.do")
	public ModelAndView saveAppv(HttpServletRequest request, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> list  = mapper.readValue(data, ArrayList.class);     
		Map<String, Object> saveMap = new HashMap<String, Object>();
		String loginId = getLoginId(session);
		saveMap.put("list"    , list);
		saveMap.put("LOGIN_ID", loginId);
		userService.setAppvYn(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}
}
