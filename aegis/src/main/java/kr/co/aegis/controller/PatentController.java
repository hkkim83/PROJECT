package kr.co.aegis.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.dto.User;
import kr.co.aegis.paging.PagingHelper;
import kr.co.aegis.patent2.excel.Excel;
import kr.co.aegis.patent2.pdf.PDF;
import kr.co.aegis.service.CategoryService;
import kr.co.aegis.service.PatentService;
import kr.co.aegis.service.ProjectService;
import kr.co.aegis.util.FileUtil;
import kr.co.aegis.util.StringUtil;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping(value = "/patent")
public class PatentController extends BaseController {
	@Value("${patent.dir}") private String patentDir;
	@Value("${image.dir}")  private String imageDir;
	@Value("${image.path}") private String imagePath;
	@Value("${pdf.path}")   private String pdfPath;
	
	private PatentService patentService;
	private ProjectService projectService;
	private CategoryService categoryService;

	@Autowired
	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}
	
	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	/**
	 * 특허검색 기본리스트 화면 요청
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		ModelAndView modelAndView = new ModelAndView("analysis/patentListView");
		modelAndView = search(request, session, modelAndView);
		
		return modelAndView;
	}
	
	/**
	 * 원본 이미지 보기
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/imageView.do")
	public ModelAndView imageView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		ModelAndView modelAndView = new ModelAndView("analysis/imageView");
		modelAndView.addObject("IMAGE", (request.getQueryString()).substring(6));
		
		return modelAndView;
	}
	

	/**
	 * PDF 보기
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/pdfView.do")
	public ModelAndView pdfView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		String query = (request.getQueryString()).substring(4);
		String viewName = "analysis/pdfView";
		if(query.indexOf("cntry") > -1)
			viewName = "analysis/pdfView2";
		
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("PDF", query);
		
		return modelAndView;
	}
	
	
	/**
	 * 특허검색 초록대표도 화면 요청
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/abstractView.do")
	public ModelAndView abstractView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		
		ModelAndView modelAndView = new ModelAndView("analysis/patentAbsView");
		modelAndView = search(request, session, modelAndView);
		
		return modelAndView;
	}
	
	/**
	 * 특허검색 요지리스트 화면 요청
	 * @param request
	 * @param response
	 * @return
	 * @throws InterruptedException 
	 * @throws RemoteException 
	 */
	@RequestMapping(value = "/summaryView.do")
	public ModelAndView summaryView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws RemoteException, InterruptedException {
		ModelAndView modelAndView = new ModelAndView("analysis/patentSumView");
		User user = (User)session.getAttribute(USER_SESSION);
		Map<String, Object> param = parseRequest(request);
		// 세션에서 현재 선택된 프로젝트 정보 가져오기
		param.put("PROJECT_ID"  , user.getProjectId());
		if(StringUtil.isNull((String)param.get("PAGE_NO"))) {
			param.put("PAGE_NO"     , "1");
		}
		if(StringUtil.isNull((String)param.get("DEL_YN"))) {
			param.put("DEL_YN"     , "0");
		}
		
		int numPerPage   = Integer.parseInt((String)param.get("NUM_PER_PAGE"));
		int pageNo  = Integer.parseInt((String)param.get("PAGE_NO"));
		
		// 요지리스트는 한건씩만 화면에 보여줌
		String requestURI = request.getRequestURI();
		param.put("LOGIN_ID"    , getLoginId(session));
		param.put("PAGE_FR"     , pageNo-1);
		param.put("PAGE_CNT"    , 1);
		// 전체
		Map<String, Object> map = patentService.selectPatentCnt(param);
		// 쓰기권한 조회		
		String writeYn = projectService.selectWriteYn(param);
		// 특허상세 조회
		List<Map<String, String>> list = patentService.selectPatentList(param);
		Map<String, String> patentMap = null;
		String strKeywordList = null;
		if(list != null && !list.isEmpty()) {
			patentMap = list.get(0);
			// 2015.05.12 출원인 기존 방식 유지 
			// StringUtil.convertToBr(patentMap, "APPLICANT_RENAME");
			List<Map<String, String>> keywordList = categoryService.selectPatentCategoryList(patentMap);
			strKeywordList = getKeywordList(keywordList);
			// 키워드리스트 조회
			patentMap.put("KEYWORD_LIST", strKeywordList);	// 키워드 리스트 만들기
		}
		
		PagingHelper pagingHelper = new PagingHelper(Integer.parseInt(String.valueOf(map.get("PA_TOTAL_CNT"))), pageNo, 1, requestURI, param);
		String pageNavi = pagingHelper.getPageNavigation();
		
		param.put("QUERY_STRING", pagingHelper.getQueryString());				// 검색식 정보
		param.put("INPUT_STRING", pagingHelper.getInputString());				// 입력검색식창에 보여줄 내용
		param.put("LIST_PAGE_NO", (int)Math.ceil((double)pageNo/numPerPage));	// 리스트로 돌아가기 위한 PAGE_NO
		param.put("WRITE_YN"    , writeYn);										// 프로젝트 권한
		
		modelAndView.addObject("PAGING_INFO", pageNavi);
		modelAndView.addObject("TOTAL", map);
		modelAndView.addObject("PARAM", param);
		modelAndView.addObject("PATENT", patentMap);
		
		return modelAndView;
	}
	
	/**
	 * 특허검색 요지리스트 팝업
	 * @param request
	 * @param response
	 * @return
	 * @throws InterruptedException 
	 * @throws RemoteException 
	 */
	@RequestMapping(value = "/summaryDlg.do")
	public ModelAndView summaryDlg(HttpServletRequest request, HttpServletResponse response) throws RemoteException, InterruptedException {
		return new ModelAndView("analysis/patentSumDlg");
	}
	
	
	/**
	 * 특허검색 결과 word로 출력
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/wordView.do")
	public ModelAndView wordView(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("analysis/wordView");
		Map<String, String> param = new HashMap<String, String>();
		// 세션에서 현재 선택된 프로젝트 정보 가져오기
		User user = (User)session.getAttribute(USER_SESSION);
		param.put("PROJECT_ID"  , user.getProjectId());
//		logger.info("param>>>>>>>>>>>>"+param);
		Map<String, String> map = patentService.selectGradeConstCount(param);
		List<Map<String, String>> list = patentService.selectGradeConst(param);
//		logger.info("map:::::"+map);
//		logger.info("list:::::"+list);
		
		modelAndView.addObject("MAP", map);
		modelAndView.addObject("LIST", list);
		
		return modelAndView;
	}
	
	/**
	 * 특허검색 결과 hwp로 출력
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/hwpView.do")
	public ModelAndView hwpView(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("analysis/hwpView");
		Map<String, String> param = new HashMap<String, String>();
		// 세션에서 현재 선택된 프로젝트 정보 가져오기
		User user = (User)session.getAttribute(USER_SESSION);
		param.put("PROJECT_ID"  , user.getProjectId());
//		logger.info("param>>>>>>>>>>>>"+param);
		Map<String, String> map = patentService.selectGradeConstCount(param);
		List<Map<String, String>> list = patentService.selectGradeConst(param);
//		logger.info("map:::::"+map);
//		logger.info("list:::::"+list);
		
		modelAndView.addObject("MAP", map);
		modelAndView.addObject("LIST", list);
		
		return modelAndView;
	}
	
	/**
	 * 특허저장
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/save.do")
	public ModelAndView save(HttpServletRequest request, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		List<Map<String, String>> saveList  = super.getListFromJson(data);
		Map<String, Object> saveMap = new HashMap<String, Object>();
		saveMap.put("list", saveList);
		saveMap.put("LOGIN_ID", getLoginId(session));
		patentService.save(saveMap);
		modelAndView.success();
		// 재조회 한다.
		return modelAndView;
	}
	
	/**
	 * 선택문헌 중요특허 추가/삭제
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/setImportantYn.do")
	public ModelAndView setImportantYn(HttpServletRequest request, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		List<Map<String, String>> saveList  = super.getListFromJson(data);
		Map<String, Object> saveMap = new HashMap<String, Object>();
		saveMap.put("list", saveList);
		saveMap.put("LOGIN_ID", getLoginId(session));
		patentService.setImportantYn(saveMap);
		modelAndView.success();
		// 재조회 한다.
		return modelAndView;
	}
	
	/**
	 * 선택문헌 삭제/복구
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/setDelYn.do")
	public ModelAndView setDelYn(HttpServletRequest request, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		List<Map<String, String>> saveList  = super.getListFromJson(data);
		Map<String, Object> saveMap = new HashMap<String, Object>();
		saveMap.put("list", saveList);
		saveMap.put("LOGIN_ID", getLoginId(session));
		patentService.setDelYn(saveMap);
		modelAndView.success();
		// 재조회 한다.
		return modelAndView;
	}
	
	/**
	 * 키워드 저장
	 * @param request
	 * @param session
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveKeyword.do")
	public ModelAndView saveKeyword(HttpServletRequest request, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		User user = (User)session.getAttribute(USER_SESSION);
		Map<String, String> param = parseRequest(request);
		param.put("PROJECT_ID"  , user.getProjectId());
		String[] keywordList = {
			param.get("KEYWORD_MAIN"), param.get("KEYWORD_TITLE"), param.get("KEYWORD_ABSTRACT"), param.get("KEYWORD_CLAIM_MAIN") 
		};
		
		Map<String, Object> saveMap = new HashMap<String, Object>();
		saveMap.put("list"    , keywordList);
		saveMap.put("LOGIN_ID", user.getId());
		saveMap.put("ADMIN_ID", user.getAdminId());
		saveMap.put("map"     , param);
		patentService.saveKeyword(saveMap);
		modelAndView.success();

		return modelAndView;
	}
	
	/**
	 * 도면 업로드
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value = "/upload.do")
	public ModelAndView upload(@RequestParam("file") MultipartFile file, @RequestParam("PROJECT_ID") String PROJECT_ID, @RequestParam("PATENT_ID") String PATENT_ID, HttpServletRequest request, HttpSession session) throws FileNotFoundException, IOException
	{
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 파일명
		String fileName = file.getOriginalFilename();
		// 업로드 경로 설정
		String rootPath     = request.getSession().getServletContext().getRealPath("/");
		String svrfilePath  = FileUtil.getFilePath(rootPath+imagePath, PROJECT_ID);
		String svrfilePath2 = "";

		if(!rootPath.equals(imageDir+"/"))
			svrfilePath2 = FileUtil.getFilePath(imageDir+"/"+imagePath, PROJECT_ID);
		
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String svrFileName = PATENT_ID+ext;
		// 파일 업로드 변수 설정
		File newFile = new File(svrfilePath, svrFileName);
		file.transferTo(newFile);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("FILE_NAME" , fileName);
		map.put("FILE_SIZE" , String.valueOf(file.getSize()));
		map.put("IMAGE_MAIN", "/"+imagePath+"/"+PROJECT_ID+"/"+svrFileName);
		map.put("PROJECT_ID", PROJECT_ID);
		map.put("PATENT_ID" , PATENT_ID);
		map.put("LOGIN_ID"  , getLoginId(session));
		
		patentService.setImageMain(map);
		
		// 파일복사
		if(!rootPath.equals(imageDir))
			FileUtil.fileCopy(svrfilePath+"/"+svrFileName, svrfilePath2+"/"+svrFileName);
		
		modelAndView.addObject("FILE_INFO", map);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 전문 업로드
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value = "/uploadPDF.do")
	public ModelAndView uploadPDF(@RequestParam("file1") MultipartFile file, @RequestParam("PROJECT_ID") String PROJECT_ID, @RequestParam("PATENT_ID") String PATENT_ID, HttpServletRequest request, HttpSession session) throws FileNotFoundException, IOException
	{
//		logger.info("uploadPDF:::::::::::::::::::");
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 파일명
		String fileName = file.getOriginalFilename();
		// 업로드 경로 설정
		String rootPath     = request.getSession().getServletContext().getRealPath("/");
		String svrfilePath  = FileUtil.getFilePath(rootPath+pdfPath, PROJECT_ID);
		String svrfilePath2 = "";

		if(!rootPath.equals(imageDir+"/"))
			svrfilePath2 = FileUtil.getFilePath(imageDir+"/"+pdfPath, PROJECT_ID);
		
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String svrFileName = PATENT_ID+ext;
		// 파일 업로드 변수 설정
		File newFile = new File(svrfilePath, svrFileName);
		file.transferTo(newFile);
		
//		logger.info("svrfilePath:::"+svrfilePath);
//		logger.info("svrfilePath2:::"+svrfilePath2);
//		logger.info("svrFileName:::"+svrFileName);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("FILE_NAME"     , fileName);
		map.put("FILE_SIZE"     , String.valueOf(file.getSize()));
		map.put("PATENT_FULLTXT", "/"+pdfPath+"/"+PROJECT_ID+"/"+svrFileName);
		map.put("PROJECT_ID"    , PROJECT_ID);
		map.put("PATENT_ID"     , PATENT_ID);
		map.put("LOGIN_ID"      , getLoginId(session));
		
		patentService.setPatentFulltxt(map);
		// 파일복사
		if(!rootPath.equals(imageDir))
			FileUtil.fileCopy(svrfilePath+"/"+svrFileName, svrfilePath2+"/"+svrFileName);
		
		modelAndView.addObject("FILE_INFO", map);
		modelAndView.success();

		return modelAndView;
	}	
	
	/**
	 * 특허 리스트 파일다운로드
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws DocumentException 
	 */
	@RequestMapping(value = "/saveExcel.do")
	public ModelAndView saveExcel(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException, DocumentException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		List<Map<String, String>> list = null;
		String docType = request.getParameter("DOC_TYPE");
		// 선택된 데이터가 없으면 검색조건에 맞는 전체리스트 조회
		if(request.getParameter("DATA") == null || request.getParameter("DATA").isEmpty()) {
			User user = (User)session.getAttribute(USER_SESSION);
			Map<String, Object> param = null;
			if("excel".equals(docType)) {
				param = parseRequest(request);
				if(StringUtil.isNull((String)param.get("DEL_YN")))
					param.put("DEL_YN"  	, "0");
			} else {
				param = new HashMap<String, Object>();
				param.put("DEL_YN"  	, "0");
			}
			param.put("PROJECT_ID"  , user.getProjectId());
			
			list = patentService.selectPatentList(param);
		} else {
			// 선택된 데이터가 있으면 선택된 데이터로 리스트 생성
			String data = request.getParameter("DATA");
			list = super.getListFromJson(data);
		}
		
		// 특허 목록 조회
		String fileName = "patentList";
		if("pdf".equals(docType)) 				// PDF다운
			fileName = new PDF().writePdfForPatentList(patentDir, fileName, list);
		else if("excel".equals(docType)) 		// 엑셀다운
			fileName = new Excel("/").writeExcelForPatentList(patentDir, fileName, list);
		else if("excelAll".equals(docType)) 	// 전체필드다운
			fileName = new Excel("/").writeExcelForPatentListAll(patentDir, fileName+"All", list);
		modelAndView.addObject("FILE_PATH", patentDir+"/"+fileName);
		modelAndView.addObject("FILE_NAME", fileName);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 요지리스트 엑셀다운
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveExcelDtl.do")
	public ModelAndView saveExcelDtl(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		String data = request.getParameter("DATA");
		List<Map<String, Object>> list  = super.getListFromJson(data);
		Map<String, Object> param = list.get(0);
		Map<String, String> map = patentService.selectPatentDtl(param);
		// 출원인대표명 완료 목록 조회
		Excel excel = new Excel("/");
		String fileName = "patentDetail";
		fileName = excel.writeExcelForPatentDtl(patentDir, imageDir, fileName, map);
		modelAndView.addObject("FILE_PATH", patentDir+"/"+fileName);
		modelAndView.addObject("FILE_NAME", fileName);
		modelAndView.success();
		return modelAndView;
	}

	/**
	 * 특허 검색(기본리스트/초록대표도)
	 * @param request
	 * @param session
	 * @param modelAndView
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	private ModelAndView search(HttpServletRequest request, HttpSession session, ModelAndView modelAndView) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		
		User user = (User)session.getAttribute(USER_SESSION);
		Map<String, Object> param = parseRequest(request);
		// 세션에서 현재 선택된 프로젝트 정보 가져오기
		param.put("PROJECT_ID"  , user.getProjectId());
		// 검색을 위한 기본 설정
		if(StringUtil.isNull((String)param.get("NUM_PER_PAGE"))) {
			param.put("NUM_PER_PAGE", "50");
		}
		if(StringUtil.isNull((String)param.get("PAGE_NO"))) {
			param.put("PAGE_NO"     , "1");
		}
		if(StringUtil.isNull((String)param.get("DEL_YN"))) {
			param.put("DEL_YN"      , "0");
		}
		
		int pageNo  = Integer.parseInt((String)param.get("PAGE_NO"));
		int numPerPage   = Integer.parseInt((String)param.get("NUM_PER_PAGE"));
		String requestURI = request.getRequestURI();
		
		// 전체
		Map<String, Object> map = patentService.selectPatentCnt(param);
				
		PagingHelper pagingHelper = new PagingHelper(Integer.parseInt(String.valueOf(map.get("PA_TOTAL_CNT"))), pageNo, numPerPage, requestURI, param);
		String pageNavi = pagingHelper.getPageNavigation();
		
		// 특허리스트 조회
		param.put("PAGE_FR" , numPerPage*(pageNo-1));
		param.put("PAGE_CNT", numPerPage);
		param.put("QUERY_STRING", pagingHelper.getQueryString());	// 검색식 정보
		param.put("INPUT_STRING", pagingHelper.getInputString());	// 입력검색식창에 보여줄 정보
		
		List<Map<String, String>> list = patentService.selectPatentList(param);
		
		// 키워드 굵은 글씨처리
		String[][] boldList = {
			{"TITLE"   , (String)param.get("KEYWORD_MAIN")},
			{"ABSTRACT", (String)param.get("KEYWORD_MAIN")},
			{"TITLE"   , (String)param.get("KEYWORD_TITLE")},
			{"ABSTRACT", (String)param.get("KEYWORD_ABSTRACT")},
		};
		
		list = setKeywordBold(list, boldList, pageNo, numPerPage);
		
		modelAndView.addObject("PAGING_INFO", pageNavi);
		modelAndView.addObject("TOTAL", map);
		modelAndView.addObject("PARAM", param);
		modelAndView.addObject("PATENT_LIST", list);
		
		return modelAndView;
	}
	
	/**
	 * 키워드에 굵은 글씨 태그 추가 ( 제목, 요약 )
	 * @param list
	 * @param boldList
	 * @return
	 */
	private List<Map<String, String>> setKeywordBold(List<Map<String, String>> list, String[][] boldList, int pageNo, int numPerPage) {
		int index = 0;
		for(Map<String, String> map : list) {
			for(int i=0; i<boldList.length; i++) {
				if(StringUtil.isNull(boldList[i][1]) || StringUtil.isNull(map.get(boldList[i][0]))) continue;
				String value = map.get(boldList[i][0]);
				value = value.replaceAll("(?i)"+boldList[i][1], "<strong>"+boldList[i][1]+"</strong>");
				map.put(boldList[i][0], value);
			}
			++index;
			map.put("ROW_NUM", String.valueOf(index));
			map.put("ROW_PAGE_NO", String.valueOf((pageNo-1)*numPerPage+index));
		}
		return list;
	}
	
	/**
	 * 키워드 리스트 가져오기
	 * @param list
	 * @return
	 */
	private String getKeywordList(List<Map<String, String>> list) {
		String keywordList = "";
		if(list.isEmpty() || list.size() < 1) return keywordList;
		for(Map<String, String> map : list) {
			keywordList += map.get("KEYWORD") + ",";
		}
		keywordList = keywordList.substring(0, keywordList.length()-1);
		return keywordList;
	}
}
