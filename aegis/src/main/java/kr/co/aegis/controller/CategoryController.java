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
import kr.co.aegis.dto.User;
import kr.co.aegis.service.CategoryService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

	private CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	/**
	 * OS관리
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("patent/categoryView");
	}
	
	/**
	 * 기술분류 리스트 조회
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = parseRequest(request);
		// 기술분류 완료 목록 조회
		List<Map<String, String>> cmplList = categoryService.selectProjectCategoryCmpl(param);
		// 기술분류 미완료 목록 조회
		List<Map<String, String>> incmplList = categoryService.selectProjectCategoryIncmpl(param);
		
		modelAndView.addObject("CMPL_LIST"  , cmplList);
		modelAndView.addObject("INCMPL_LIST", incmplList);
		modelAndView.success();
		
		return modelAndView;
	}
	
	/**
	 * 기술분류 저장
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		User user = (User)session.getAttribute(USER_SESSION);
		String data = request.getParameter("DATA");
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> saveList  = mapper.readValue(data, ArrayList.class);     
		Map<String, Object> saveMap = new HashMap<String, Object>();
		saveMap.put("list"    , saveList);
		saveMap.put("LOGIN_ID", user.getId());
		saveMap.put("ADMIN_ID", user.getAdminId());
		categoryService.save(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 기술분류 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/categoryList.do")
	public ModelAndView categoryList(HttpServletRequest request, HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = parseRequest(request);
		List<Map<String, String>> list = categoryService.selectCategoryList(param);
		
		modelAndView.addObject("LIST"  , list);
		modelAndView.success();
		
		return modelAndView;
	}
	
}
