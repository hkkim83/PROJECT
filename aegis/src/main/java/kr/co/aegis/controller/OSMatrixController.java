package kr.co.aegis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.patent2.excel.Excel;
import kr.co.aegis.service.PatentService;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/OSMatrix")
public class OSMatrixController extends BaseController {
	@Value("${family.dir}") private String familyDir;
	private PatentService patentService;

	@Autowired
	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}
	
	/**
	 * OS매트릭스
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("analysis/OSMatrixListView");
	}
	
	/**
	 * OS매트릭스 리스트 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = super.parseRequest(request);
		
		param.put("FLAG", "01");
		// 목적/효과, 기능 중분류 목록조회
		List<Map<String, String>> list1 = patentService.selectMcateList(param);
		// 목적/효과, 기능 특허목록 조회
		List<Map<String, String>> list2 = patentService.selectOSMatrixList(param);
		param.put("FLAG", "02");
		// 목적/효과, 기능외 중분류 목록조회
		List<Map<String, String>> list3 = patentService.selectMcateList(param);
		// 목적/효과, 기능외 특허목록 조회
		List<Map<String, String>> list4 = patentService.selectOSMatrixList(param);
		
		modelAndView.addObject("MCATE_LIST1", list1);
		modelAndView.addObject("MCATE_LIST2", list3);
		modelAndView.addObject("OSMATRIX_LIST1", list2);
		modelAndView.addObject("OSMATRIX_LIST2", list4);
		modelAndView.success();
		
		return modelAndView;
	}
	
	/**
	 * OS매트릭스 엑셀저장
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveExcel.do")
	public ModelAndView saveExcel(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		
		// 출원인대표명 완료 목록 조회
		List<Map<String, String>> list = super.getListFromJson(data);
		Excel excel = new Excel("/");
		String fileName = "OSMatrix";
		fileName = excel.writeExcelForOSMatrix(familyDir, fileName, list);
		modelAndView.addObject("FILE_PATH", familyDir+"/"+fileName);
		modelAndView.addObject("FILE_NAME", fileName);
		modelAndView.success();
		return modelAndView;
	}
}
