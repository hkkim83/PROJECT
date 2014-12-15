package kr.co.aegis.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.service.GraphService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/graph")
public class GraphController extends BaseController {
	private GraphService graphService;

	@Autowired
	public void setGraphService(GraphService graphService) {
		this.graphService = graphService;
	}
	
	/**
	 * 국가별 연도별분석
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/yearView.do")
	public ModelAndView yearView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("graph/yearView");
	}
	
	/**
	 * 국가별 등급별분석
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/gradeView.do")
	public ModelAndView gradeView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("graph/gradeView");
	}

	/**
	 * 출원인별등급별분석
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/applView.do")
	public ModelAndView applView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("graph/applView");
	}

	/**
	 * 기술분류별 분석
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cateView.do")
	public ModelAndView cateView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("graph/cateView");
	}
	
	/**
	 * 국가별 연도별 목록 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/yearList.do")
	public ModelAndView yearList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = super.parseRequest(request);
		param.put("TYPE", "1");
		List<Map<String, String>> list = graphService.selectGraph(param);
		
		modelAndView.addObject("LIST",  list);
		modelAndView.success();
		
		return modelAndView;
	}
	
	/**
	 * 국가별 등급별 목록 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/gradeList.do")
	public ModelAndView gradeList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = super.parseRequest(request);
		param.put("TYPE", "2");
		List<Map<String, String>> list = graphService.selectGraph(param);
		modelAndView.addObject("LIST",  list);
		modelAndView.success();
		
		return modelAndView;
	}
	
	/**
	 * 출원인별 등급별 목록 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/applList.do")
	public ModelAndView applList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = super.parseRequest(request);
		param.put("TYPE", "3");
		List<Map<String, String>> listAll = graphService.selectGraph(param);
		param.put("NATL_CODE", "KR");
		List<Map<String, String>> listKr  = graphService.selectGraph(param);
		param.put("NATL_CODE", "US");
		List<Map<String, String>> listUs  = graphService.selectGraph(param);
		param.put("NATL_CODE", "JP");
		List<Map<String, String>> listJp  = graphService.selectGraph(param);
		param.put("NATL_CODE", "EP");
		List<Map<String, String>> listEp  = graphService.selectGraph(param);
		param.put("NATL_CODE", "CN");
		List<Map<String, String>> listCn  = graphService.selectGraph(param);
		param.put("NATL_CODE", "PCT");
		List<Map<String, String>> listPct = graphService.selectGraph(param);
		
		modelAndView.addObject("LIST_ALL",  listAll);
		modelAndView.addObject("LIST_KR",   listKr);
		modelAndView.addObject("LIST_US",   listUs);
		modelAndView.addObject("LIST_JP",   listJp);
		modelAndView.addObject("LIST_EP",   listEp);
		modelAndView.addObject("LIST_CN",   listCn);
		modelAndView.addObject("LIST_PCT",  listPct);
		modelAndView.success();
		
		return modelAndView;
	}
	
	/**
	 * 기술분류별 리스트 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cateList.do")
	public ModelAndView cateList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = super.parseRequest(request);
		param.put("TYPE", "4");
		param.put("FLAG", "01");
		List<Map<String, String>> list1  = graphService.selectGraph(param);
		param.put("FLAG", "02");
		List<Map<String, String>> list2  = graphService.selectGraph(param);
		param.put("FLAG", "03");
		List<Map<String, String>> list3  = graphService.selectGraph(param);
		
		param.put("TYPE", "5");
		param.put("FLAG", "01");
		List<Map<String, String>> list4  = graphService.selectGraph(param);
		param.put("FLAG", "02");
		List<Map<String, String>> list5  = graphService.selectGraph(param);
		param.put("FLAG", "03");
		List<Map<String, String>> list6  = graphService.selectGraph(param);
		
		modelAndView.addObject("LIST1", list1);
		modelAndView.addObject("LIST2", list2);
		modelAndView.addObject("LIST3", list3);

		modelAndView.addObject("LIST4", list4);
		modelAndView.addObject("LIST5", list5);
		modelAndView.addObject("LIST6", list6);
		modelAndView.success();
		
		return modelAndView;
	}
}
