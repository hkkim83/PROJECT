package kr.co.aegis.core.resolver;

import java.io.FileNotFoundException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aegis.core.exception.CheckedException;
import kr.co.aegis.core.exception.DataIntegrityException;
import kr.co.aegis.core.properties.Message;
import kr.co.aegis.core.view.JsonModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
//	private JavaMailSender mailSender = null;
//	@Autowired
//	@Qualifier("mailSender")
//	public void setMailSender(JavaMailSender mailSender) {
//		this.mailSender = mailSender;
//	}

	private String printStackTrace(Exception exception){
		
		StackTraceElement[] stackTraceElements = exception.getStackTrace();
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(exception+"\n");
		
		for(StackTraceElement stackTraceElement:stackTraceElements){
			stringBuffer.append(stackTraceElement+"\n");
		}
		
		return stringBuffer.toString();
	}
	
	
	/*
	private void sendEmail(String subject, String serverName, String requestUrl, String stackTrace, User user){
		
		try{
			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm.ss");
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
			//helper.setTo("report.jcdsoft@gmail.com");
			helper.setTo("darby@jcdsoft.com");
			helper.setSubject(subject);
			helper.setText(
					"SERVER : " + serverName + "\n\n"
					+ "SESSION INFO : " + user + "\n\n"
					+ "REQUEST URL : " + requestUrl + "\n\n"
					+ "DATETIME : " + format.format(now) + "\n\n"
					+ "TRACE : \n" + stackTrace);
			
			mailSender.send(message);
			
		}catch(Exception e){
			printStackTrace(e);
		}
	}
	*/
	
	private String getRequestUrl(HttpServletRequest request){
		
		Enumeration<String> param = request.getParameterNames();
        String strParam = ""; 
        while(param.hasMoreElements()) { 
            String name = (String)param.nextElement(); 
            String value = request.getParameter(name); 
            strParam += name + "=" + value + "&"; 
        }
        String URL = request.getRequestURL() + "?" + strParam;
        
        return URL;
	}
	
	
	/*
	private void procException(Exception exception, HttpServletRequest request){
		
		User user = (User)request.getSession().getAttribute(BaseController.USER_SESSION);
		
		String contextPath = request.getServletContext().getContextPath();
		String requestUrl = getRequestUrl(request);
		String stackTrace = printStackTrace(exception);
		
		String subject = "";
		String serverName = "";
		if(Properties.getServerEnv() == ServerEnv.REAL){
			serverName = "[운영 ("+contextPath+")서버]";
			subject = serverName + " " + exception.getMessage();
			sendEmail(subject, serverName, requestUrl, stackTrace, user);
		}else if(Properties.getServerEnv() == ServerEnv.DEV){
			serverName = "[개발 ("+contextPath+")서버]";
			subject = serverName + " " + exception.getMessage();
			sendEmail(subject, serverName, requestUrl, stackTrace, user);
		}else{
			serverName = "[로컬 ("+contextPath+")서버]";
			subject = serverName + " " + exception.getMessage();
			//sendEmail(subject, serverName, requestUrl, stackTrace);
		}
	}
	*/
	
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object controller, Exception exception) {

		String message = "";
		String[] args = null;
		
		exception.printStackTrace();
		
		if(exception instanceof DuplicateKeyException){
//			procException(exception, request);
			message = Message.ERR_0023;
		}else if(exception instanceof DataIntegrityException){
//			procException(exception, request);
			message = Message.ERR_0024;
		}else if(exception instanceof FileNotFoundException){
			//procException(exception);
			message = Message.ERR_0031;
		}else if(exception instanceof CheckedException){
			//procException(exception);
			message = exception.getMessage();
			args = ((CheckedException)exception).getArgs();
		}else {
//			procException(exception, request);
			message = Message.ERR_9997;
		}
		
		return handleMessage(message, args);
	}

	protected ModelAndView handleMessage(String message, String[] args) {
		JsonModelAndView modelAndView = new JsonModelAndView();
		modelAndView.error(message, args);
		return modelAndView;
	}
}
