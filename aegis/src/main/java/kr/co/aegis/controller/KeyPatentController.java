package kr.co.aegis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.service.PatentService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/keyPatent")
public class KeyPatentController extends BaseController {
	private PatentService patentService;

	@Autowired
	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}
	
	/**
	 * 핵심특허 분석
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "view.do")
	public ModelAndView processView(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("analysis/keyPatentListView");
	}
	
	/**
	 * 특허리스트 조회
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request, HttpSession session, 
			HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		Map<String, String> param = super.getMapFromJson(data);
		param.put("PROJECT_ID", request.getParameter("PROJECT_ID"));
		List<Map<String, String>> list = patentService.selectKeyPatentList(param);
		modelAndView.addObject("LIST", list);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 특허 상세 조회
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/detail.do")
	public ModelAndView detail(HttpServletRequest request, HttpSession session, 
			HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, Object> param = super.parseRequest(request);
		Map<String, String> map = patentService.selectPatentDtl(param);

//		logger.info("map::::"+map);
		modelAndView.addObject("LIST", map);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 특허 저장
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
		Map<String, String> param = super.getMapFromJson(data);
		patentService.updatePatent(param);
		modelAndView.success();
		return modelAndView;
	}
	
}
