package kr.co.aegis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aegis.base.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/processStep")
public class StepProcessController extends BaseController {

	/**
	 * 단계별 데이터 처리 화면 요청
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("patent/processStepView");
	}
}
