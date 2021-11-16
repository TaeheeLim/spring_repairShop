package kr.or.ddit.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.vo.EmpVO;
import kr.or.ddit.emp.vo.Member;

@Controller
@RequestMapping("/emp")
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	private EmpService empSerivce;

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 로그아웃
		session.invalidate();

		// redirect
		return "redirect:/emp/loginForm";
	}

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		List<EmpVO> list = this.empSerivce.list();

		model.addAttribute("list", list);

		return "emp/list";
	}

	@RequestMapping("/register")
	public String register(Model model) throws Exception {
		logger.info("register");

		EmpVO empVO = new EmpVO();

		// 직원번호 자동생성
		String empNo = this.empSerivce.createEmpNo();

		empVO.setEmpNo(empNo);

		model.addAttribute("emp", empVO);

		return "emp/register";
	}

	// 요청 파라미터 목록을 VO에 할당 시 ModelAttribute 어노테이션이 필요함
	@PostMapping("/registerPost")
	public String registerPost(@ModelAttribute("emp") @Validated EmpVO emp, BindingResult result) throws Exception {
		logger.info("result : " + result.hasErrors());
		// validate 후 문제가 발생하면 실행
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();

			logger.info("allErrors.size() : " + allErrors.size());
			logger.info("globalErrors.size() : " + globalErrors.size());
			logger.info("fieldErrors.size() : " + fieldErrors.size());

			for (int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				logger.info("objectError : " + objectError);
			}
			for (int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				logger.info("objectError : " + objectError);
			}
			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				logger.info("objectError : " + fieldError.getDefaultMessage());
			}

			return "emp/register";
		}

		// 직원 등록 처리
		int insertResult = this.empSerivce.insert(emp);

		// 직원 목록으로 이동
		return "redirect:/emp/list";
	}

	// 직원 상세보기 화면
	@GetMapping("/detail")
	public String detail(@RequestParam("empNo") String empNo, Model model) throws Exception {
		logger.info("detail에 도착했습니다.");

		EmpVO empVO = this.empSerivce.detail(empNo);

		logger.info("empVO : " + empVO);
		model.addAttribute("emp", empVO);

		// forwarding
		return "emp/detail";
	}

	// 요청 파라미터 목록을 VO에 할당 시 ModelAttribute 어노테이션이 필요함
	@PostMapping("/detailPost")
	public String detailPost(@ModelAttribute("emp") @Validated EmpVO emp, BindingResult result, Model model)
			throws Exception {
		logger.info("result : " + result.hasErrors());
		// validate 후 문제가 발생하면 실행
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();

			logger.info("allErrors.size() : " + allErrors.size());
			logger.info("globalErrors.size() : " + globalErrors.size());
			logger.info("fieldErrors.size() : " + fieldErrors.size());

			for (int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				logger.info("objectError : " + objectError);
			}
			for (int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				logger.info("objectError : " + objectError);
			}
			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				logger.info("objectError : " + fieldError.getDefaultMessage());
			}

			model.addAttribute("emp", emp);

			return "emp/detail";
		}

		// 직원 등록 및 직원 존재 시 정보 업데이트 처리
		int insertResult = this.empSerivce.insert(emp);

		// 직원 목록으로 이동
		return "redirect:/emp/list";
	}

	// 직원 퇴직 처리
	@PostMapping("/deletePost")
	public String deletePost(@RequestParam("empNo") String empNo) {

		int update = this.empSerivce.update(empNo);

		return "redirect:/emp/detail?empNo=" + empNo;
	}

	// 직원로그인폼
	@GetMapping("/loginForm")
	public String loginForm(Model model) {

		model.addAttribute("emp", new EmpVO());

		// forwarding
		return "emp/loginForm";
	}

	// 로그인 처리
	@PostMapping("/login")
	public String login(@ModelAttribute("emp") @Validated EmpVO empVO, BindingResult result, HttpServletRequest request,
			Model model, HttpServletResponse response, 
			@RequestParam(value="customCheck", required=false) String customCheck) throws Exception {
		logger.info("이엠피비오는 : " + empVO.toString());
		logger.info("에러 확인 : " + result.getAllErrors());
		logger.info("customcheck : " + customCheck);
		//아이디 기억하기 체크박스
		
		if (result.hasErrors()) { // validated 결과 문제가 발생
			return "emp/loginForm";
		} else { // 문제가 없으면..
			HttpSession session = request.getSession();

			// 아이디에 해당되는 직원이 있는가?
			String empNo = empVO.getEmpNo(); // 1
			String password = empVO.getPassword(); // java
			// db정보
			EmpVO dbEmpVO = this.empSerivce.detail(empNo);
			
			if (dbEmpVO != null) { // 아이디에 해당되는 직원이 있다면
				logger.info("디비 결과 : " + dbEmpVO.toString());
				// 그리고 입력한 비밀번호와 해당 아이디의 db쪽 비밀번호가 일치하면 로그인
				if (password.equals(dbEmpVO.getPassword())) {
					// LoginCheckFilter.java에서 session.getAttribute("EMPVO")
					session.setAttribute("EMPVO", dbEmpVO);
					logger.info("emp 로그인 성공");
					if(customCheck != null) {
						//아이디 기억하기를 체크했을 경우..
						if(customCheck.equals("on")) {
							logger.info("custom check on 실행");
							//쿠키 생성(브라우저에서 직원번호로 아이디 저장)
							Cookie cookie = new Cookie("empNo", empVO.getEmpNo());
							//초단위 설정(60초 -> 1분 -> 하루 -> 한달)
							cookie.setMaxAge(60 * 60 * 24 * 30);
							response.addCookie(cookie);	
						} else {	//아이디기억하기를 체크하지 않았을 경우
							//쿠키 삭제
							Cookie cookie = new Cookie("empNo", "");
							//초단위 설정(0)
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					} else {
						//쿠키 삭제
						Cookie cookie = new Cookie("empNo", "");
						//초단위 설정(0)
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					// forwarding
					return "emp/index";
				} else { // 로그인 실패
					empVO = new EmpVO();
					model.addAttribute("loginFail", "해당 아이디가 없습니다.");
					return "emp/loginForm";
				}
			} else { // 아이디에 해당하는 직원이 없다면..
				empVO = new EmpVO();
				model.addAttribute("loginFail", "비밀번호가 잘못 되었습니다.");
				return "emp/loginForm";
			}

		}
	}
	//도메인 시작 메인 화면
	@GetMapping("/")
	public String initMain() {
		//redirect
		return "redirect:/emp/index";
	}
	
	// 메인화면
	@GetMapping("/index")
	public String index() {
		// forwarding
		return "emp/index";
	}

	/*
	 * 스프링 폼 태그 라이브러리 - 스프링 폼은 HTML 폼을 표시하기 위한 태그 라이브러리 - 스프링 폼을 이용하면 HTML 폼과 자바객체를
	 * 쉽게 바인딩 할 수있음
	 * 
	 * 1) form:form (폼 요소) 2) form:input (텍스트 필드) 3) form:password (패스워드 필드) 4)
	 * form:textarea (텍스트 영역) 5) form:checkboxes (다중 체크박스) 6) form:checkbox (단일
	 * 체크박스) 7) form:radiobuttons (다중 라디오버튼) 8) form:radiobutton (단일 라디오 버튼) 9)
	 * form:select (셀렉트 박스) 10) form:hidden (숨겨진 필드) 11) form:label (라벨) 12)
	 * form:button (버튼) 13) form:errors (입력값을 검증 후 오류를 표시)
	 */
	// 테스트 폼
	@RequestMapping("/registerForm02")
	public String registerForm02(Model model, HttpServletRequest request) {
		logger.info("registerForm02~@~!~!~~~");

		// 로그인 후 세션정보 다루기
		HttpSession session = request.getSession();
		// 직원id를 받아올 수 있음
		String userId = (String) session.getAttribute("userId");

		if (userId == null) {
			userId = "a001";
		}

		Member member = new Member();
		// 폼 객체의 프로퍼티 값을 지정
		member.setUserId(userId);
		member.setUserName("개똥이");
		member.setEmail("test@test.com");
		member.setPassword("java");
		member.setIntroduction("하이\n빅스비");
		// 개발자 여부 Y
		member.setDeveloper("Y");
		// 외국인 여부 true
		member.setForeigner(true);

		// checkboxes 데이터 바인딩
		Map<String, String> hobbyMap = new HashMap<String, String>();
		hobbyMap.put("01", "Sports");
		hobbyMap.put("02", "Music");
		hobbyMap.put("03", "Chess");

		// 취미 기본 체킹
		List<String> hobbySelected = new ArrayList<>();
		hobbySelected.add("01");
		hobbySelected.add("03");
		member.setHobbyList(hobbySelected);

		// 성별 라디오 버튼들
		Map<String, String> genderCodeMap = new HashMap<String, String>();
		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");

		// 국적 셀렉트 박스
		Map<String, String> nationalityCodeMap = new HashMap<String, String>();
		nationalityCodeMap.put("01", "R.O.K");
		nationalityCodeMap.put("02", "Germany");
		nationalityCodeMap.put("03", "Austrailia");

		// 소유차량 멀티셀렉트박스
		Map<String, String> carCodeMap = new HashMap<String, String>();
		carCodeMap.put("01", "르노삼성");
		carCodeMap.put("02", "현대");
		carCodeMap.put("03", "쌍용");

		// 속성명에 member는 폼 객체의 모델로 사용됨
		model.addAttribute("member", member);
		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("genderCodeMap", genderCodeMap);
		model.addAttribute("nationalityCodeMap", nationalityCodeMap);
		model.addAttribute("carCodeMap", carCodeMap);

		return "emp/registerForm";
	}

	@PostMapping("/register")
	public String register(Member fakemember, Model model) {
		logger.info("register~@~!~!");
		fakemember.setUserName("임태희");

		// 취미 체크박스를 확인
		List<String> hobbyList = fakemember.getHobbyList();
		if (hobbyList != null) {
			logger.info("hobbyList != null : " + hobbyList.size());

			for (int i = 0; i < hobbyList.size(); i++) {
				logger.info("hobbyList(" + i + ") : " + hobbyList.get(i));
			}
		}

		// 소유차량 확인
		List<String> carList = fakemember.getCarList();
		if (carList != null) {
			logger.info("carList != null : " + carList.size());
			for (int i = 0; i < carList.size(); i++) {
				logger.info("carList(" + i + ") = " + carList.get(i));
			}
		} else {
			logger.info("carList is null!!!");
		}

		logger.info("fakemember에 관한 정보 : " + fakemember.toString());

		model.addAttribute("member", fakemember);
		model.addAttribute("hobbyList", hobbyList);
		model.addAttribute("carList", carList);

		return "emp/result";
	}
}
