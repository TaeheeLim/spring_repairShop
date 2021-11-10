package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> list() throws Exception;
}
