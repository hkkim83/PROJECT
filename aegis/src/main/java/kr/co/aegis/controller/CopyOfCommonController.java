//package kr.co.aegis.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.co.aegis.base.BaseController;
//import kr.co.aegis.core.view.JsonModelAndView;
//import kr.co.aegis.service.CommonService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class CopyOfCommonController extends BaseController {
//
//	private CommonService commonService;
//
//	@Autowired
//	public void setCommonService(CommonService commonService) {
//		this.commonService = commonService;
//	}
//	
//	/**
//	 * 로그인 체크
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/checkLogin.do")
//	public ModelAndView checkLogin(HttpServletRequest request, HttpServletResponse response) {
//		JsonModelAndView modelAndView = new JsonModelAndView();
//		modelAndView.success();
//		return modelAndView;
//	}
//	
//	/**
//	 * 공통코드 가져오기
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/commcode.do")
//	public ModelAndView commcode(HttpServletRequest request, HttpServletResponse response) {
//		
//		String groupCode = request.getParameter("GROUP_CODE");
//		List<Map<String, String>> list = commonService.selectCommonList(groupCode);
//		ModelAndView modelAndView = new ModelAndView("jsonView");
//		modelAndView.addObject("COMMON_CODE" , list);
//		return modelAndView;
//	} 
//	
//}
