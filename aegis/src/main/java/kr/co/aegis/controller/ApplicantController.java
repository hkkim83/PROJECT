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
import kr.co.aegis.service.ApplicantService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/applicant")
public class ApplicantController extends BaseController {
	private ApplicantService applicantService;

	@Autowired
	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}
	
	/**
	 * 대표명화 관리
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("patent/applicantView");
	}
	
	/**
	 * 출원인 리스트 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		
		Map<String, String> param = parseRequest(request);
		// 출원인대표명 완료 목록 조회
		List<Map<String, String>> cmplList = applicantService.selectProjectApplicantCmpl(param);
		// 출원인대표명 미완료 목록 조회
		List<Map<String, String>> incmplList = applicantService.selectProjectApplicantIncmpl(param);
		
		modelAndView.addObject("CMPL_LIST"  , cmplList);
		modelAndView.addObject("INCMPL_LIST", incmplList);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 대표명화 저장
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/save.do")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response
			, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		User user = (User)session.getAttribute(USER_SESSION);
		String data = request.getParameter("DATA");
		
		// 출원인대표명 완료 목록 조회
		List<Map<String, String>> list = super.getListFromJson(data);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("list"    , list);
		param.put("LOGIN_ID", user.getId());
		param.put("ADMIN_ID", user.getAdminId());
		
		applicantService.save(param);
		modelAndView.success();
		return modelAndView;
	}
}
