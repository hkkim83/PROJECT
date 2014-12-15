package kr.co.aegis.core.view;

import kr.co.aegis.core.properties.Message;

import org.springframework.web.servlet.ModelAndView;

public class CustomModelAndView extends ModelAndView{

	public CustomModelAndView(String viewName) {
		super(viewName);
	}

	/**
	 * 처리결과 메시지 설정
	 * @param resultCd
	 */
	private void setResult(String message, String[] args){
		this.addObject(Message.RESULT_NAME, Message.getCode(message));
		this.addObject(Message.RESULT_TEXT, Message.getMessage(message, args));
	}
	
	/**
	 * 처리결과 메시지 설정
	 * @param resultCd
	 */
	private void setResult(String message){
		this.addObject(Message.RESULT_NAME, Message.getCode(message));
		this.addObject(Message.RESULT_TEXT, Message.getMessage(message));
	}

	public void success(){
		this.setResult(Message.SUCC_0001);
	}
	
	public void error(String message, String[] args){
		this.setResult(message, args);
	}
	
	public void error(String message){
		this.setResult(message);
	}
}