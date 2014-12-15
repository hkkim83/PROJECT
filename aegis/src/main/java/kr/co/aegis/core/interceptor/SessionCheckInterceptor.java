package kr.co.aegis.core.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aegis.base.BaseController;
import kr.co.aegis.controller.LoginController;
import kr.co.aegis.core.properties.Message;
import kr.co.aegis.dto.User;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;


@Controller
public class SessionCheckInterceptor extends HandlerInterceptorAdapter implements ApplicationContextAware {

	private Logger logger = Logger.getLogger(this.getClass());
	
	private ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	
	private void deny(HttpServletRequest request, HttpServletResponse response, String message) throws Exception{
		
		// json 데이터 요청
		if(request.getHeader("accept") != null && request.getHeader("accept").indexOf("application/json") >= 0){
			
			Map<String, String> model = new HashMap<String, String>();
			model.put(Message.RESULT_NAME, Message.getCode(message));
			model.put(Message.RESULT_TEXT, Message.getMessage(message));
			model.put("LOGIN_PATH", this.getLoginPath(request));
			
			MappingJacksonJsonView jsonView = (MappingJacksonJsonView)applicationContext.getBean("jsonView");
			jsonView.render(model, request, response);
		}
		// html 요청
		else{
			String script = "<script>"
					  + "alert('" + Message.getMessage(message) + "');"
					  + "if(window.opener != null){"
					  + "    self.close();"
					  + "    window.opener.location.href='" + this.getLoginPath(request) + "';"
					  + "}else{"				  
					  + "    location.href='" + this.getLoginPath(request) + "'"
					  + "}"
					  + "</script>";
		
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			response.getWriter().write(script);
			response.flushBuffer();
		}
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		User user = (User)request.getSession().getAttribute(BaseController.USER_SESSION);
		String userId = null;
		if(user != null){
			userId = user.getId();
		}
		logger.info("Request Uri ==> " + request.getRequestURI() + "\n"
				+ "userId : " + userId
				);
		String uri  = request.getRequestURI();
		
		if(isSessionPage(request, handler, uri)){
			
			String message = checkAccessable(handler, request);
			
			if(message != null){
				
				this.deny(request, response, message);
				return false;
				
			}
			return true;
		}
		
		return true;
	}

	
	
	/**
	 * 세션검사가 필요한 페이지인지를 확인
	 * @return
	 * @throws NoSuchRequestHandlingMethodException 
	 */
	protected boolean isSessionPage(HttpServletRequest request, Object handler, String uri) throws NoSuchRequestHandlingMethodException {
		
		if(uri.indexOf("index.do") != -1) {					// 인덱스페이지
			return false;
		}
		if(uri.indexOf("login.do") != -1) {					// 로그인처리
			return false;
		}
		if(uri.indexOf("loginDlg.do") != -1) {				// 로그인 다이얼로그
			return false;
		}
		if(uri.indexOf("join.do") != -1) {					// 회원가입페이지
			return false;
		}
		if(uri.indexOf("request.do") != -1) {				// 회원가입처리
			return false;
		}
		if(uri.indexOf("/admin/dupCheck.do") != -1) {				// 회원가입처리
			return false;
		}
		if(uri.indexOf("find.do") != -1) {					// 아이디/비밀번호찾기 페이지
			return false;
		}
		if(uri.indexOf("findDlg.do") != -1) {					// 아이디/비밀번호찾기 페이지
			return false;
		}		
		if(uri.indexOf("findID.do") != -1) {				// 아이디설정
			return false;
		}
		if(uri.indexOf("setPassword.do") != -1) {				// 비밀번호설정
			return false;
		}
		if(uri.indexOf("commcode.do") != -1) {				// 공통코드
			return false;
		}
		if(uri.indexOf("/searchFormula/view.do") != -1) {	// 검색식메인
			return false;
		}
		if(uri.indexOf("/searchFormula/rgsDlg.do") != -1) {	// 검색식신규 다이얼로그
			return false;
		}
		if(uri.indexOf("/searchFormula/modDlg.do") != -1) {	// 검색식수정 다이얼로그
			return false;
		}
		if(uri.indexOf("/searchFormula/lstDlg.do") != -1) {	// 검색식불러오기 다이얼로그
			return false;
		}
		if(uri.indexOf("board") != -1) {					// 게시판화면
			return false;
		}
		if(uri.indexOf("download") != -1) {					// 첨부파일다운
			return false;
		}

		return true;
	}
	
	
	/**
	 * 서버별 로그인페이지 url을 리턴한다.
	 * @return
	 */
	protected String getLoginPath(HttpServletRequest request) {
		String loginPath = "/index.do";
		return loginPath;		
	}
	
	
	
	/**
	 * 사용자 세션체크(접근가능여부)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected String checkAccessable(Object handler, HttpServletRequest request) {
		
		String message = null;
		User user = BaseController.getLoginUser(request.getSession());
		
		if(user == null){
			message = Message.ERR_9999;
		}
		return message;
	}
}