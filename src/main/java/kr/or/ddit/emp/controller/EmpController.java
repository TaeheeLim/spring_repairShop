package kr.or.ddit.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.vo.EmpVO;
import kr.or.ddit.emp.vo.Member;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService empSerivce;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		List<EmpVO> list = this.empSerivce.list();
		
		model.addAttribute("list",list);
		
		return "emp/list";
	}
	
//	@RequestMapping("/register")
//	public String register() {
//		return "emp/register";
//	}
	
	@RequestMapping("/update")
	public String update() {
		return "emp/update";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "emp/delete";
	}
	/*
	스프링 폼 태그 라이브러리
	 - 스프링 폼은 HTML 폼을 표시하기 위한 태그 라이브러리
	 - 스프링 폼을 이용하면 HTML 폼과 자바객체를 쉽게 바인딩 할 수있음
	 
	 1) form:form (폼 요소)
	 2) form:input (텍스트 필드)
	 3) form:password (패스워드 필드)
	 4) form:textarea (텍스트 영역)
	 5) form:checkboxes (다중 체크박스)
	 6) form:checkbox (단일 체크박스)
	 7) form:radiobuttons (다중 라디오버튼)
	 8) form:radiobutton (단일 라디오 버튼)
	 9) form:select (셀렉트 박스)
	 10) form:hidden (숨겨진 필드)
	 11) form:label (라벨)
	 12) form:button (버튼)
	 13) form:errors (입력값을 검증 후 오류를 표시)
	 */
	//테스트 폼
	@RequestMapping("/registerForm02")
	public String registerForm02(Model model) {
		logger.info("registerForm02~@~!~!~~~");
		
		Member member = new Member();
		//폼 객체의 프로퍼티 값을 지정
		member.setUserId("a001");
		member.setUserName("개똥이");
		//속성명에 member는 폼 객체의 모델로 사용됨
		model.addAttribute("member", member);
		
		return "emp/registerForm";
	}
	
	@PostMapping("/register")
	public String register(Member fakemember) {
		logger.info("register~@~!~!");
		logger.info("fakemember에 관한 정보 : " + fakemember.toString());
		
//		model.addAttribute("member",member);
		
		return "emp/result";
	}
}
