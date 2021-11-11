package kr.or.ddit.emp.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import kr.or.ddit.cus.vo.AddressVO;
import kr.or.ddit.cus.vo.CardVO;

public class Member {
	//NotBlank : 문자열이 null이 아님, trim(공백제거)한 길이가 0보다 커야함
	//Size : 글자 수, 컬렉션의 요소 개수를 검사
	//Email : 이메일 주소 형식인지 검사
	@NotBlank
	private String userId;
	@NotBlank
	@Size(max=3)
	private String userName;
	@Email
	private String email;
	@NotBlank
	private String password;
	private String introduction;
	private List<String> hobbyList; //취미
	private String developer;	//개발자여부 Y or N
	private boolean foreigner;	//외국인여부 true or false
	private String gender;
	private String nationality;
	private List<String> carList;	//소유차량 목록
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;	//생년월일
	
	//중첩된 자바빈즈의 컬렉션의 입력값 검증
	@Valid
	private List<CardVO> cardList;
	
	//중첩된 자바빈즈 입력값 검증
	@Valid
	private AddressVO address;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public List<String> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}
	
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public boolean isForeigner() {
		return foreigner;
	}
	public void setForeigner(boolean foreigner) {
		this.foreigner = foreigner;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public List<String> getCarList() {
		return carList;
	}
	public void setCarList(List<String> carList) {
		this.carList = carList;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth= dateOfBirth;
	}
	
	public List<CardVO> getCardList() {
		return cardList;
	}
	public void setCardList(List<CardVO> cardList) {
		this.cardList = cardList;
	}
	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", introduction=" + introduction + ", hobbyList=" + hobbyList + ", developer=" + developer
				+ ", foreigner=" + foreigner + ", gender=" + gender + ", nationality=" + nationality + ", carList="
				+ carList + ", dateOfBirth=" + dateOfBirth + ", cardList=" + cardList + ", address=" + address + "]";
	}
}
