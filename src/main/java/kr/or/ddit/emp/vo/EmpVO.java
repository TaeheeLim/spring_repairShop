package kr.or.ddit.emp.vo;

public class EmpVO {
	private String empNo;
	private String nm;
	private String addr;
	private String hp;
	private String postNo;
	private String addr2;
	private String password;
	
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", nm=" + nm + ", addr=" + addr + ", hp=" + hp + ", postNo=" + postNo
				+ ", addr2=" + addr2 + ", password=" + password + "]";
	}
	
	
	
	
	
}
