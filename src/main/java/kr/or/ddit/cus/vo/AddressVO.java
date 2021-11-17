package kr.or.ddit.cus.vo;

import org.hibernate.validator.constraints.NotBlank;

public class AddressVO {
	@NotBlank
	private String postCode;	//우편번호

	@NotBlank
	private String location;	//주소
	
	private String LOCATION2;	//상세주소

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLOCATION2() {
		return LOCATION2;
	}

	public void setLOCATION2(String lOCATION2) {
		LOCATION2 = lOCATION2;
	}

	@Override
	public String toString() {
		return "AddressVO [postCode=" + postCode + ", location=" + location + ", LOCATION2=" + LOCATION2 + "]";
	}
	
	
	
	
	
}
