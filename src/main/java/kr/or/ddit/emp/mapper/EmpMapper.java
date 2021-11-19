package kr.or.ddit.emp.mapper;

import java.util.List;

import kr.or.ddit.emp.vo.EmpVO;

public interface EmpMapper {
	//직원 목록
	public List<EmpVO> list();
	//직원등록
	public int insert(EmpVO vo);
	//직원번호 자동생성
	public String createEmpNo();
	//직원정보 상세
	public EmpVO detail(String empNo);
	//직원 퇴직 처리
	public int update(String empNo);
	
	
	
	
}
