package kr.or.ddit.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.emp.mapper.EmpMapper;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public List<EmpVO> list() throws Exception {
		return this.empMapper.list();
	}
	
	@Override
	public int insert(EmpVO vo) throws Exception {
		return this.empMapper.insert(vo);
	}
	
	@Override
	public String createEmpNo() throws Exception{
		return this.empMapper.createEmpNo();
	}
	
	@Override
	public EmpVO detail(String empNo) throws Exception{
		return this.empMapper.detail(empNo);
	}
	
	@Override
	public int update(String empNo) {
		return this.empMapper.update(empNo);
	}

}
