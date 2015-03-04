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
import kr.co.aegis.patent2.excel.Excel;
import kr.co.aegis.service.PatentService;
import kr.co.aegis.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/omission")
public class OmissionController extends BaseController {
	
	@Value("${family.dir}") private String familyDir;
	
	private PatentService patentService;

	@Autowired
	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}
	
	/**
	 * 특허문헌 누락처리 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView omissionView(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("patent/omissionView");
	}
	
	
	/**
	 * 특허문헌 누락처리 진행 팝업 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/progressDlg.do")
	public ModelAndView progress(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("patent/omissionProgressDlg");
	}

	/**
	 * 패밀리연번 부여
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkFamily.do")
	public ModelAndView checkFamily(@RequestParam("PROJECT_ID") String projectId, @RequestParam("COL_NAME") String colName, HttpSession session) throws IOException
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();
		User user = (User)session.getAttribute(USER_SESSION);
		Map<String, String> param = new HashMap<String, String>();
		String loginId   = user.getId();
		String adminId   = user.getAdminId();
		param.put("LOGIN_ID"  , loginId);
		param.put("PROJECT_ID", projectId);
		param.put("ADMIN_ID"  , adminId);
		param.put("COL_NAME"  , colName);
		param.put("FLAG"      , "03");
		// 1. 연번부여를 위해 정렬을 한 리스트 조회
		List<Map<String, String>> list = patentService.selectSeqNumList(param);
		List<Map<String, String>> saveList = doCheckNum(list, colName, loginId);
		
		if(!saveList.isEmpty() && saveList.size() > 0) {
			Map<String, Object> saveMap = new HashMap<String, Object>();
			saveMap.put("list"      , saveList);
			saveMap.put("LOGIN_ID"  , loginId);			
			patentService.saveOmissionTemp(saveMap);
		}
		
		modelAndView.success();
		return modelAndView;
	}
	

	/**
	 * 엑셀파일 만들기
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveExcel.do")
	public ModelAndView saveExcel(@RequestParam("PROJECT_ID") String projectId) throws IOException
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();

		Map<String, String> param = new HashMap<String, String>();
		param.put("PROJECT_ID", projectId);
		// 1. 연번부여를 위해 정렬을 한 리스트 조회
		List<Map<String, String>> list = patentService.selectOmissionTempList(param);
		Excel excel = new Excel(null);
		String fileName = "특허문헌누락DB";
		String colList[] = {"FM_NUM:패밀리문헌번호", "FC_FE_NUM:Forward문헌번호", "BC_BE_NUM:Backward문헌번호"};
		fileName = excel.writeExcelForFamily(familyDir, fileName, list, colList);
		
		modelAndView.addObject("FILE_PATH", familyDir+"/"+fileName);
		modelAndView.addObject("FILE_NAME", fileName);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 엑셀파일 만들기(컬럼단위로 만들기)
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveExcelColName.do")
	public ModelAndView saveExcel(@RequestParam("PROJECT_ID") String projectId, @RequestParam("COL_NAME") String colName) throws IOException
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();

		Map<String, String> param = new HashMap<String, String>();
		param.put("PROJECT_ID", projectId);
		String title = colName.equals("FM_NUM") ? "패밀리" : colName.equals("FC_FE_NUM") ? "Forward" : "Backward";
		
		// 1. 연번부여를 위해 정렬을 한 리스트 조회
		List<Map<String, String>> list = patentService.selectOmissionTempList(param);
		Excel excel = new Excel(null);
		String fileName = title+"누락DB";
		String colList[] = {colName+":"+title+"문헌번호"};
		fileName = excel.writeExcelForFamily(familyDir, fileName, list, colList);

		modelAndView.addObject("FILE_PATH", familyDir+"/"+fileName);
		modelAndView.addObject("FILE_NAME", fileName);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 번호 파싱하기
	 * @param list
	 * @param colName
	 * @param loginId
	 * @return
	 */
	private List<Map<String, String>> doCheckNum(List<Map<String, String>> list, String colName, String loginId) {
		List<Map<String, String>> saveList = new ArrayList<Map<String, String>>();
		boolean bool = false;
		for(int i=0; i<list.size(); i++) {
			Map<String, String> map = list.get(i);

			if(StringUtil.isNull(map.get(colName))) continue;
			String strNum = map.get(colName).replaceAll(" ", "");
			strNum = strNum.replaceAll(",", "|");
			String[] numList = strNum.split("[|]");
			for(String str : numList) {
				// 국가가 KR, US, JP, EP, CN이 아니면 건너뜀
				if(!str.startsWith("KR") && !str.startsWith("US") && !str.startsWith("JP") && !str.startsWith("EP") && !str.startsWith("CN")) 
					continue;
				bool = false;
				// 출원번호(조합키)가 일치할 경우 목록에서 제외 
				for(Map<String, String> tempMap : list) {
					String applKey = tempMap.get("APPL_KEY");
					if(str.equals(applKey)) 
					{
						bool = true;
						break;
					}
				}
				if(!bool) {
					Map<String, String> saveMap = new HashMap<String, String>();
					saveMap.put("PROJECT_ID", map.get("PROJECT_ID"));
					saveMap.put("COL_NAME"  , colName);
					saveMap.put("NUM"       , str);
					saveList.add(saveMap);
				}
			}
		}
		return saveList;
	}
}
