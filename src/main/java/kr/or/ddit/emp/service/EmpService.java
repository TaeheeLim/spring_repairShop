package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.vo.EmpVO;

public interface EmpService {
	//직원목록
	public List<EmpVO> list() throws Exception;

	//직원등록
	public int insert(EmpVO vo) throws Exception;

	//직원번호 자동생성
	String createEmpNo() throws Exception;
	
	//직원 정보 상세
	EmpVO detail(String empNo) throws Exception;

	int update(String empNo);
}
