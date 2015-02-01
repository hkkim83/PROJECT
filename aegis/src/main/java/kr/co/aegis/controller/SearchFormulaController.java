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
import kr.co.aegis.patent.parser.ExcelParser;
import kr.co.aegis.service.SearchFormulaService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/searchFormula")
public class SearchFormulaController extends BaseController {
	@Value("${upload.dir}") private String uploadDir;
	@Value("${kipris.plus.userId}") private String userId;
	@Value("${kipris.plus.userKey}") private String userKey;
	@Value("${kipris.plus.url}") private String kiprisUrl;
	@Value("${kipris.plus.path}") private String defaultPath;
	
	private SearchFormulaService searchFormulaService;

	@Autowired
	public void setSearchFormService(SearchFormulaService searchFormService) {
		this.searchFormulaService = searchFormService;
	}
	
	/**
	 * 검색식 화면 요청
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/view.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String dbTypeCdPrevLogin = (String)session.getAttribute("DB_TYPE_CD");
		String contentPrevLogin = (String)session.getAttribute("CONTENT");
		if(dbTypeCdPrevLogin != null){
			request.setAttribute("DB_TYPE_CD", dbTypeCdPrevLogin);
			session.removeAttribute("DB_TYPE_CD");
		}
		if(contentPrevLogin != null){
			request.setAttribute("CONTENT", contentPrevLogin);
			session.removeAttribute("CONTENT");
		}
		
		return new ModelAndView("searchFormula/searchFormulaView");
	}
	
	/**
	 * 수정파업
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/modDlg.do")
	public ModelAndView modDlg(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		return new ModelAndView("searchFormula/searchFormulaModDlg");
	}

	/**
	 * 신규등록팝업
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/rgsDlg.do")
	public ModelAndView rgsPop(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		return new ModelAndView("searchFormula/searchFormulaRgsDlg");
	}

	/**
	 * 리스트 조회 팝업
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/lstDlg.do")
	public ModelAndView lstDlg(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		return new ModelAndView("searchFormula/searchFormulaLstDlg");
	}

	/**
	 * 검색식 저장
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/save.do")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		
		String userId = super.getLoginId(session);
		String data = request.getParameter("DATA");
		
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(data, HashMap.class);
        searchFormulaService.registry(map, userId);
        
		ModelAndView modelAndView = new ModelAndView("jsonView");
		return modelAndView;
	}
	
	/**
	 * 검색식 수정
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/modify.do")
	public ModelAndView modify(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException {

		String userId = super.getLoginId(session);
		String data = request.getParameter("DATA");
		
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(data, HashMap.class);
        searchFormulaService.modify(map, userId);
        
		ModelAndView modelAndView = new ModelAndView("jsonView");
		return modelAndView;
	}
	
	/**
	 * 검색식 삭제
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/remove.do")
	public ModelAndView remove(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {

		String data = request.getParameter("DATA");
		
//        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(data, HashMap.class);
        searchFormulaService.remove(map);
        
		ModelAndView modelAndView = new ModelAndView("jsonView");
		return modelAndView;
	}
	
	/**
	 * 검색식 리스트 조회
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException {

		String userId = super.getLoginId(session);
        List<Map<String, String>> result = searchFormulaService.getList(userId);
        
		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("RESULT" , result);
		
		return modelAndView;
	}
	

	/**
	 * 검색식 DB반영 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/apply.do")
	public ModelAndView apply(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		
		String userId = super.getLoginId(session);
		String data = request.getParameter("DATA");
		
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(data, HashMap.class);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        logger.info("map:::::"+map);
        ExcelParser parser = new ExcelParser();
        int cnt = parser.getAdvancedSearch(list, map, userId, userKey, kiprisUrl, defaultPath);
        logger.info("Controller::::::"+cnt);
        
        //searchFormulaService.registry(map, userId);
        
		ModelAndView modelAndView = new ModelAndView("jsonView");
		return modelAndView;
	}
}
