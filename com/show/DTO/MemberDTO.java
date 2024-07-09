package com.show.DTO;

import java.util.ArrayList;

public class MemberDTO {
	// 필드
	private String id;
	private String pw;
	private String name;
	private String nickName;
	private String birth;// 주민번호 앞자리 string으로 저장
	private int sex; // 주민번호 뒷자리 첫번째 숫자 x%2이용하여 판별
	private String pNo; // 전화번호 - 없이 저장
	private String mail;
	private Boolean loginStatus;
	private Author author;

	// 생성자
	public MemberDTO() {
		this.id = "guest";
		this.nickName = "guest";
		this.author = Author.GUEST;
		this.loginStatus=false;
	}
	
	public MemberDTO(String id,String pw) {//로그인시 생성자
		this.id = id;
		this.pw = pw;		
		this.loginStatus=false; //로그인 검증후 성공시 변경
	}
	
	public MemberDTO(String id,String pw,String name,String ssn,String nickName,String pNo,String mail) {//회원가입시 생성자
		this.id = id;
		this.pw = pw;
		this.birth = ssn.substring(0, 6);
		this.sex = (int)ssn.charAt(6) ;
		this.name = name;
		this.nickName = nickName;
		this.pNo = pNo;
		this.mail = mail;
		this.author = Author.USER; //회원가입시 권한부여
		this.loginStatus=false; //로그인하면 상태수정
	}

	// 메서드
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getNickName() {
		return nickName;
	}

	public String getBirth() {
		return birth;
	}

	public int getSex() {
		return sex;
	}

	public String getpNo() {
		return pNo;
	}

	public String getMail() {
		return mail;
	}

	public void setId(String id, ArrayList<MemberDTO> loginDTOs) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}