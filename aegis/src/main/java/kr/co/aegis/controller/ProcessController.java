package kr.co.aegis.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLEditorKit.Parser;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.properties.Message;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.dto.User;
import kr.co.aegis.patent.excel2.Excel;
import kr.co.aegis.patent.excel2.HSSExcel;
import kr.co.aegis.patent.excel2.XSSExcel;
import kr.co.aegis.patent.header.ExcelHeader;
import kr.co.aegis.patent.kipris.KrPatentFilePath;
import kr.co.aegis.patent.kipris.OthPatentFilePath;
import kr.co.aegis.patent.kipris.PatentFilePath;
import kr.co.aegis.patent.legal.JpLegalStatus;
import kr.co.aegis.patent.legal.KrLegalStatus;
import kr.co.aegis.patent.legal.LegalStatus;
import kr.co.aegis.patent.parser.ExcelParser;
import kr.co.aegis.patent.parser.FocustExcelParser;
import kr.co.aegis.patent.parser.KiprisAExcelParser;
import kr.co.aegis.patent.parser.KiprisNExcelParser;
import kr.co.aegis.patent.parser.WipsonExcelParser;
import kr.co.aegis.service.PatentService;
import kr.co.aegis.service.UserService;
import kr.co.aegis.util.FileUtil;
import kr.co.aegis.util.StringUtil;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/process")
public class ProcessController extends BaseController {
	
	@Value("${upload.dir}") private String uploadDir;
	@Value("${kipris.plus.userId}") private String userId;
	@Value("${kipris.plus.userKey}") private String userKey;
	@Value("${kipris.plus.url}") private String kiprisUrl;
	@Value("${kipris.plus.path}") private String defaultPath;
	@Value("${kr.legalStatusUrl}") private String krLegalStatusUrl;
	@Value("${jp.legalStatusUrl1}") private String jpLegalStatusUrl1;
	@Value("${jp.legalStatusUrl2}") private String jpLegalStatusUrl2;
	
	private PatentService patentService;
	private UserService userService;

	@Autowired
	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 일괄자동등록 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("patent/processView");
	}
	
	/**
	 * 일괄자동등록진행 팝업 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/progressDlg.do")
	public ModelAndView progress(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("patent/processProgressDlg");
	}
	
	
	/**
	 * 일괄자동등록진행 팝업 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/progressDlg2.do")
	public ModelAndView progress2(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("common/progressDlg");
	}
	
	
	/**
	 * 에러화면
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/error.do")
	public ModelAndView error(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("patent/patentError");
	}

	/**
	 * 파일 업로드
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value = "/upload.do")
	public ModelAndView upload(@RequestParam("type") String type, @RequestParam("file") MultipartFile file, HttpSession session) throws FileNotFoundException, IOException
	{
		logger.info("type::::::"+type);
		
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 파일명
		String fileName = file.getOriginalFilename();
		// 업로드 경로 설정
		String svrfilePath = FileUtil.getFilePath(uploadDir, getLoginId(session));
		String svrFileName = type+"_"+fileName;
		// 파일 업로드 변수 설정
		File newFile = new File(svrfilePath, svrFileName);
		file.transferTo(newFile);

		Map<String, String> map = new HashMap<String, String>();
		map.put("FILE_NAME", svrFileName);
		map.put("FILE_SIZE", String.valueOf(file.getSize()));
		map.put("FILE_PATH", svrfilePath+"/"+svrFileName);
		modelAndView.addObject("FILE_INFO", map);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 차감 예상 포인트 가져오기
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getPoint.do")
	public ModelAndView getPoint(@RequestParam("PROJECT_ID") String projectId, HttpSession session) throws IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 1. 업로드 폴더에서 파일 목록을 가져온다.
		String svrfilePath = FileUtil.getFilePath(uploadDir, getLoginId(session));
		File dirFile = new File(svrfilePath);
		File fileList[] = dirFile.listFiles();

		if(fileList.length == 0) {
			modelAndView.error(Message.ERR_0031);
			return modelAndView;
		}
		
		// 2. 파일 목록만큼 루프를 돌면서 DB종류를 체크한다.
		Excel excel = null;
		int cnt = 0;
		for(File tempFile : fileList) {
			String tempFileName = tempFile.getName();
			String path = dirFile.getPath()+"/"+tempFileName;
			if( tempFileName.indexOf(".xlsx") > -1 || tempFileName.indexOf(".xlsm") > -1)
				excel = new XSSExcel(path);
			else 
				excel = new HSSExcel(path);
			
			cnt += excel.getRowCount() - 1;
		}
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("ID", getLoginId(session));
		param.put("PROJECT_ID", projectId);
		// 3. 잔여 포인트 가져오기
		Map<String, String> user = userService.selectUser(param);
		user.put("COUNT", String.valueOf(cnt));
		
		modelAndView.addObject("USER", user);
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 파일 삭제
	 * @param file
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(value = "/deleteFile.do")
	public ModelAndView deleteFile(@RequestParam("filePath") String filePath) throws Exception
	{
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 파일명
		File file = new File(filePath);
		// 파일 업로드 실행
		boolean isDeleted = FileUtil.deleteFile(file);
		if(!isDeleted)
			modelAndView.error(Message.ERR_0033);
		else
		{
			modelAndView.success();
		}
		return modelAndView;
	}
	
	/**
	 * 파일 목록 가져오기
	 * @param file
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(value = "/getFileList.do")
	public ModelAndView getFileList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
	{
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 1. 업로드 폴더에서 파일 목록을 가져온다.
		String svrfilePath = FileUtil.getFilePath(uploadDir, getLoginId(session));
		File dirFile = new File(svrfilePath);
		File fileList[] = dirFile.listFiles();
		int len = fileList == null ? 0 : fileList.length;
		
		modelAndView.addObject("FILE_COUNT", String.valueOf(len));
		 
		// 2. 파일 목록만큼 루프를 돌면서 DB종류를 체크한다.
		if(len > 0) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for(File tempFile : fileList) {
				Map<String, String> map = new HashMap<String, String>();
				String tempFileName = tempFile.getName();
				map.put("FILE_NAME", tempFileName);
				map.put("FILE_SIZE", String.valueOf(tempFile.length()));
				map.put("FILE_PATH", svrfilePath+"/"+tempFileName);
				list.add(map);
			}
			modelAndView.addObject("FILE_LIST", list);
		}
		modelAndView.success();
		return modelAndView;
	}
	
	
	
	/**
	 * 데이터를 임시테이블에 등록
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/register.do")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException
	{	
		logger.info("registerregisterregisterregisterregister");
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 1. 업로드 폴더에서 파일 목록을 가져온다.
		String svrfilePath = FileUtil.getFilePath(uploadDir, getLoginId(session));
		File dirFile = new File(svrfilePath);
		File fileList[] = dirFile.listFiles();

		if(fileList.length == 0) {
			modelAndView.error(Message.ERR_0031);
			return modelAndView;
		}
		
		Excel excel = null;
		ExcelParser parser = null;
		Map<String, Object> saveMap = new HashMap<String, Object>();
		List<Map<String, String>> saveList = new ArrayList<Map<String, String>>();
		saveMap.put("LOGIN_ID", getLoginId(session));
		// 파일 목록만큼 루프를 돌면서
		for(File tempFile : fileList) {
			String tempFileName = tempFile.getName();
			String path = dirFile.getPath()+"/"+tempFileName;
			excel = tempFileName.indexOf(".xlsx") > -1 || tempFileName.indexOf(".xlsm") > -1 ? new XSSExcel(path) : new HSSExcel(path);
			// 2. DB종류를 체크한다.
			String kindsDB = excel.getKindsDB();
			if(StringUtil.isNull(kindsDB)) {
				modelAndView.error(Message.ERR_0032);
				return modelAndView;
			}
			
			// 3. 파일을 임시테이블에 등록한다.
			List<Map<String, String>> list = excel.readExcel(kindsDB);
			
			// 4. 데이터 가공 처리
			if(kindsDB.equals(ExcelHeader.DB[0])) {			// WIPSON
				parser = new WipsonExcelParser();
			} else if(kindsDB.equals(ExcelHeader.DB[1])) {	// FOCUST
				parser = new FocustExcelParser();
			} else if(kindsDB.equals(ExcelHeader.DB[2])) {	// KIPRIS_N
				parser = new KiprisNExcelParser();
			} else if(kindsDB.equals(ExcelHeader.DB[3])) {	// KIPRIS_A
				parser = new KiprisAExcelParser();
			}
			// 4-1. 문서번호 가져오기 
			parser.setApplNumOrg(list, userId, userKey, kiprisUrl, defaultPath);
			// 4-2. 데이터를 파싱한다.
			parser.parse(list);
			
			for(Map<String, String> map : list) {
				saveList.add(map);			
			}
		}
		// 문서번호 가져오기
		// parser.setApplNumOrg(saveList, userId, userKey, kiprisUrl, defaultPath);
		// 데이터 patent_temp insert 처리
		saveMap.put("list"    , saveList);
		patentService.savePatentTemp(saveMap);

		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 데이터 가공처리( 업로드 임시-> 특허 임시)
	 * @param request
	 * @param response
	 * @return
	 * @throws InterruptedException 
	 * @throws RemoteException 
	 * @throws IOException
	 */
	@RequestMapping(value = "/processing.do")
	public ModelAndView processing(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws RemoteException, InterruptedException
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();
		// 1. 업로드 임시테이블에서 LOGIN_ID로 업로드한 데이터를 가져온다.
		Map<String, String> param = new HashMap<String, String>();
		String loginId =  getLoginId(session);
		param.put("USER_ID", loginId);
		List<Map<String, String>> list = patentService.selectUploadTempList(param);
		List<Map<String, String>> dbList = null;
		List<Map<String, String>> tempList = null;
		List<Map<String, String>> saveList = new ArrayList<Map<String, String>>();
		
		// 2.DB별로 별도의 가공처리
		for(int i=0; i<ExcelHeader.DB.length; i++) {
			dbList = getDBList(list, ExcelHeader.DB[i]);
			// 데이터 가공 처리
			doProcessing(dbList, ExcelHeader.DB[i]);
			
			for(Map<String, String> map : tempList)
				saveList.add(map);
			
		}
		
		// 3. 해외특허일 경우 출원번호원본을 다시 만든다.
		ExcelParser parser = new ExcelParser();
		parser.setApplNumOrg(saveList, userId, userKey, kiprisUrl, defaultPath);
		// 4. 데이터 insert(patent_temp)
		Map<String, Object> saveMap = new HashMap<String, Object>(); 
		saveMap.put("list"    , saveList);
		saveMap.put("LOGIN_ID", loginId);
		patentService.savePatentTemp(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 중복제거
	 * @param projectId
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/deleteDuplication.do")
	public ModelAndView deleteDuplication(@RequestParam("PROJECT_ID") String projectId, HttpSession session) throws IOException, InterruptedException
	{
		logger.info("deleteDuplicationdeleteDuplicationdeleteDuplication");
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = new HashMap<String, String>();
		User user = (User)session.getAttribute(USER_SESSION);
		String loginId = user.getId();
		param.put("USER_ID", loginId);
		List<Map<String, String>> list = patentService.selectPatentTempList(param);
		ExcelParser parser = new ExcelParser();
		// 중복 데이터 삭제
		parser.deleteDuplication(list);
		
		// 해외특허 정보 추출을 위한 문헌정보 추출
		// parser.setApplNumOrg(list, userId, userKey, kiprisUrl, defaultPath);

		// 데이터 delete(patent_temp)
		Map<String, Object> saveMap = new HashMap<String, Object>(); 
		saveMap.put("list"    , list);
		saveMap.put("LOGIN_ID", loginId);
		patentService.deletePatentTemp(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 서지정보 추출
	 * @param projectId
	 * @param session
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	@RequestMapping(value = "/getKiprisData.do")
	public ModelAndView getKiprisData(@RequestParam("PROJECT_ID") String projectId, HttpSession session) throws IOException, InterruptedException
	{	
		logger.info("getKiprisDatagetKiprisDatagetKiprisDatagetKiprisDatagetKiprisData");
		JsonModelAndView modelAndView = new JsonModelAndView();
		int ret = 0;
		Map<String, String> param = new HashMap<String, String>();
		User user = (User)session.getAttribute(USER_SESSION);
		String loginId = user.getId();
		String adminId = user.getAdminId();
		param.put("USER_ID", loginId);
		param.put("ID"     , loginId);
		List<Map<String, String>> list = patentService.selectPatentTempList(param);
		
		ExcelParser parser  = new ExcelParser();
		parser.getPatentFilePath(list, userId, userKey, kiprisUrl, defaultPath);
		
		parser.getBibliography(list, userId, userKey, kiprisUrl, defaultPath);
		
		// 3. 데이터 insert(patent)
		Map<String, Object> saveMap = new HashMap<String, Object>(); 
		saveMap.put("list"      , list);
		saveMap.put("LOGIN_ID"  , loginId);
		saveMap.put("PROJECT_ID", projectId);
		saveMap.put("ADMIN_ID"  , adminId);
		
		ret = patentService.savePatent(saveMap);
		Map<String, String> userMap = userService.selectUser(param);
		modelAndView.addObject("POINT", ret);
		
		// 세션 POINT 변경
		user.setPoint(userMap.get("POINT"));
		
		// 폴더 삭제
		String svrfilePath = FileUtil.getFilePath(uploadDir, getLoginId(session));
		FileUtils.deleteDirectory(new File(svrfilePath));
		
		modelAndView.success();
		return modelAndView;		
	}
	
	/**
	 * 연번 부여
	 * @param projectId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/setSeqNum.do")
	public ModelAndView setSeqNum(@RequestParam("PROJECT_ID") String projectId, HttpSession session)
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();
		String loginId = getLoginId(session);
		Map<String, String> param = new HashMap<String, String>();
		param.put("PROJECT_ID", projectId);
		param.put("FLAG", "02");
		// 1. 연번부여를 위해 정렬을 한 리스트 조회
		List<Map<String, String>> list = patentService.selectSeqNumList(param);
		
		// 2. list index = 연번
		Map<String, Object> saveMap = new HashMap<String, Object>(); 
		saveMap.put("list"      , list);
		saveMap.put("LOGIN_ID"  , loginId);
		saveMap.put("PROJECT_ID", projectId);
		patentService.setSeqNum(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}
	

	/**
	 * 대표명화 수정
	 * @param projectId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/setApplicantRename.do")
	public ModelAndView setApplicantRename(@RequestParam("PROJECT_ID") String projectId, HttpSession session)
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();
		User user = (User)session.getAttribute(USER_SESSION);
		Map<String, String> param = new HashMap<String, String>();
		param.put("PROJECT_ID", projectId);
		param.put("FLAG", "04");
		// 1. 연번부여를 위해 정렬을 한 리스트 조회
		List<Map<String, String>> list = patentService.selectSeqNumList(param);
		
		// 2. 대표명화 저장
		Map<String, Object> saveMap = new HashMap<String, Object>(); 
		saveMap.put("list"      , list);
		saveMap.put("LOGIN_ID"  , user.getId());
		saveMap.put("PROJECT_ID", projectId);
		saveMap.put("ADMIN_ID"  , user.getAdminId());
		patentService.setApplicantRename(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 패밀리연번 부여
	 * @param projectId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/setFmSeqNum.do")
	public ModelAndView setFmSeqNum(@RequestParam("PROJECT_ID") String projectId, HttpSession session)
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();
		
		User user = (User)session.getAttribute(USER_SESSION);
		Map<String, String> param = new HashMap<String, String>();
		param.put("LOGIN_ID"  , user.getId());
		param.put("PROJECT_ID", projectId);
		param.put("ADMIN_ID"  , user.getAdminId());
		param.put("FLAG"      , "01");
		
		// 1. 정렬한 리스트 조회(패밀리번호, 연번 정렬)
		List<Map<String, String>> list = patentService.selectSeqNumList(param);
		String oldStr = "", newStr = "", seqNum = "";
		
		for(Map<String, String> tempMap : list) {
			newStr = tempMap.get("FM_NUM"); 
			if(StringUtil.isNull(newStr)) continue;
			// 패밀리 번호가 이전 행과 같지 않으면 
			if(!oldStr.equals(newStr)) {
				tempMap.put("FM_TYPE", "O");
				seqNum = tempMap.get("SEQ_NUM");
			} else {
				// 패밀리 번호가 이전 행과 같으면
				tempMap.put("FM_TYPE", "F");
				tempMap.put("FM_SEQ_NUM", seqNum+" 패밀리");
			}
			oldStr = newStr;
		}
		
		// 2. 패밀리 연번 저장
		Map<String, Object> saveMap = new HashMap<String, Object>(); 
		saveMap.put("list"      , list);
		saveMap.put("PROJECT_ID", projectId);
		saveMap.put("LOGIN_ID"  , user.getId());
		patentService.setFmSeqNum(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}

	/**
	 * 법적상태갱신
	 * @param projectId
	 * @param natlCode
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/setLegalStatus.do")
	public ModelAndView setLegalStatus(@RequestParam("PROJECT_ID") String projectId, @RequestParam("NATL_CODE") String natlCode, HttpSession session) throws IOException
	{	
		JsonModelAndView modelAndView = new JsonModelAndView();
		String loginId = getLoginId(session);
		Map<String, String> param = new HashMap<String, String>();
		param.put("PROJECT_ID", projectId);
		param.put("FLAG", "04");
		param.put("NATL_CODE", natlCode);
		// 1. 연번으로 정렬을 한 리스트 조회
		List<Map<String, String>> list = patentService.selectSeqNumList(param);
		
		// 2. 국가코드에 따라 다른 웹사이트에 접속한다.
		LegalStatus status = null;
		int index = 0;
		for(Map<String, String> map : list)
		{
			if("KR".equals(natlCode)) {
				status = new KrLegalStatus(krLegalStatusUrl, map);
			} else if("JP".equals(natlCode)) {
				status = new JpLegalStatus(jpLegalStatusUrl1, jpLegalStatusUrl2, ++index, map);
			}
			map.put("LEGAL_STATUS", status.getLegalStatus());
		}

		// 2. 대표명화 저장
		Map<String, Object> saveMap = new HashMap<String, Object>(); 
		saveMap.put("list"      , list);
		saveMap.put("LOGIN_ID"  , loginId);
		saveMap.put("PROJECT_ID", projectId);
		patentService.setLegalStatus(saveMap);
		
		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 전체 리스트에서 DB종류별로 리스트로 분리한다.
	 * @param list
	 * @param kindsDB
	 * @return
	 */
	private List<Map<String, String>> getDBList(List<Map<String, String>> list, String kindsDB) {
		List<Map<String, String>> dbList = new ArrayList<Map<String, String>>();
		for(Map<String, String> map : list) {
			if(kindsDB.equals(map.get("KINDS_DB")))
				dbList.add(map);
		}
		return dbList;
	}
	
	/**
	 * DB종류별로 데이터를 처리한다.
	 * @param list
	 * @param kindsDB
	 * @return
	 */
	private void doProcessing(List<Map<String, String>> list, String kindsDB) {
		ExcelParser parser = null;
		if(kindsDB.equals(ExcelHeader.DB[0])) {			// WIPSON
			parser = new WipsonExcelParser();
		} else if(kindsDB.equals(ExcelHeader.DB[1])) {	// FOCUST
			parser = new FocustExcelParser();
		} else if(kindsDB.equals(ExcelHeader.DB[2])) {	// KIPRIS_N
			parser = new KiprisNExcelParser();
		} else if(kindsDB.equals(ExcelHeader.DB[3])) {	// KIPRIS_A
			parser = new KiprisAExcelParser();
		}
		parser.parse(list);
	}
}
