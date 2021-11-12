package kr.or.ddit.emp.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class EmpVO implements Serializable {
	@NotBlank
	private String empNo;
	@NotBlank
	private String nm;
	@NotBlank
	private String addr;
	@NotBlank
	private String hp;
	@NotBlank
	private String postNo;

	private String addr2;
	private String password;
	private String fireYn;	//퇴직여부
	
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
	
	public String getFireYn() {
		return fireYn;
	}
	public void setFireYn(String fireYn) {
		this.fireYn = fireYn;
	}
	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", nm=" + nm + ", addr=" + addr + ", hp=" + hp + ", postNo=" + postNo
				+ ", addr2=" + addr2 + ", password=" + password + ", fireYn=" + fireYn + "]";
	}
}
