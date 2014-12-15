package kr.co.aegis.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.core.properties.Message;
import kr.co.aegis.core.view.JsonModelAndView;
import kr.co.aegis.service.BoardService;
import kr.co.aegis.util.FileUtil;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController extends BaseController {
	
	@Value("${notice.dir}") private String noticeDir;
	
	private BoardService boardService;
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	/**
	 * 마스터 - 게시판관리(공지사항) 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/noticeView");
	}

	/**
	 * 마스터 - 게시판관리(공지사항) 글쓰기 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/noticeRgsDlg.do")
	public ModelAndView noticeRgsDlg(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/noticeRgsDlg");
	}
	
	/**
	 * 마스터 - 게시판관리(Q&A) 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/qnaView.do")
	public ModelAndView qnaView(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/qnaView");
	}		

	/**
	 * 마스터 - 게시판관리(Q&A) 글쓰기 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/qnaRgsDlg.do")
	public ModelAndView qnaRgsDlg(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/qnaRgsDlg");
	}
	
	/**
	 * 마스터 - 게시판관리(FAQ) 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/faqView.do")
	public ModelAndView faqView(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/faqView");
	}	
	
	/**
	 * 마스터 - 게시판관리(FAQ) 글쓰기 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/faqRgsDlg.do")
	public ModelAndView faqRgsDlg(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("master/faqRgsDlg");
	}
	
	/**
	 * 게시판 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = parseRequest(request);
		List<Map<String, String>> list = boardService.selectBoardList(param);

		modelAndView.addObject("LIST"  , list);
		modelAndView.success();
		
		return modelAndView;
	}
	
	/**
	 * 메인화면 하단 게시판 조회
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		Map<String, String> param = new HashMap<String, String>();
		param.put("FLAG", "N");
		List<Map<String, String>> noticeList = boardService.selectBoardList(param);
		param.put("FLAG", "Q");
		List<Map<String, String>> qnaList    = boardService.selectBoardList(param);
		param.put("FLAG", "F");
		List<Map<String, String>> faqList    = boardService.selectBoardList(param);
		
		modelAndView.addObject("NLIST"  , noticeList);
		modelAndView.addObject("QLIST"  , qnaList);
		modelAndView.addObject("FLIST"  , faqList);
		modelAndView.success();
		
		return modelAndView;
	}
	
	/**
	 * 마스터 - 공지사항저장
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/save.do")
	public ModelAndView save(HttpServletRequest request, MultipartHttpServletRequest mulitpartRequest, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		MultipartFile file = mulitpartRequest.getFile("FILE");
		Map<String, String> param = parseRequest(request);
		param.put("LOGIN_ID", getLoginId(session));
		
		if(!file.isEmpty())	{
			String fileName    = file.getOriginalFilename();
			String svrfilePath = noticeDir;
			String svrFileName = FileUtil.getFileName(fileName);
			
			File newFile = new File(svrfilePath, svrFileName);
			// 파일 업로드 실행
			boolean isUploaded = FileUtil.uploadFormFile(file, newFile);
			if(!isUploaded)
				modelAndView.error(Message.ERR_0033);
			else 
			{
				param.put("FILE_NAME", fileName);
				param.put("FILE_SIZE", String.valueOf(file.getSize()));
				param.put("FILE_PATH", svrfilePath+"/"+svrFileName);
			}
		}
			
		boardService.save(param);

		modelAndView.success();
		return modelAndView;
	}
	
	/**
	 * 마스터 - Q&A, FAQ저장
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save2.do")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JsonParseException, JsonMappingException, IOException {
		JsonModelAndView modelAndView = new JsonModelAndView();
		
		String data = request.getParameter("DATA");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> param  = mapper.readValue(data, HashMap.class);     
		param.put("LOGIN_ID", getLoginId(session));
		boardService.save(param);

		modelAndView.success();
		return modelAndView;
	}
	
}
