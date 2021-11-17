package kr.or.ddit.cus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.vo.Member;

@Controller
@RequestMapping("/cus")
public class CusController {
	private static final Logger logger = 
			LoggerFactory.getLogger(CusController.class);
	
	@GetMapping("/registerForm01")
	public String list(Model model) {
		model.addAttribute("member", new Member());
		
		return "cus/registerForm";
	}
	
	//입력값 검증을 할 도메인 클래스에 Validated 어노테이션을 지정하면 됨
	@PostMapping("/register")
	public String register(@Validated Member member, BindingResult result) {
		logger.info(member.getUserId());
		logger.info("result.hasErrors() : " + result.hasErrors());
		
		//validation 한 결과, 오류가 있을 시 forwarding
		if(result.hasErrors()) {
			return "cus/registerForm";
		}
		return "cus/success";
	}
}
