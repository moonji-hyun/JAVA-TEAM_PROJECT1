package com.show;

import java.util.ArrayList;
import java.util.Scanner;

import com.show.DTO.MemberDTO;
import com.show.DTO.ReviewDTO;
import com.show.DTO.ShowDTO;
import com.show.SV.FIndSV;
import com.show.SV.LoginSV;
import com.show.SV.SearchSV;
import com.show.SV.myPageSV;


public class MainExam {

	public static MemberDTO lSt = new MemberDTO();
	public static Scanner s = new Scanner(System.in);// 단어 입력
	public static Scanner sL = new Scanner(System.in);// 긴 문장 입력
	public static ArrayList<MemberDTO> loginDTOs = new ArrayList<MemberDTO>();
	public static ArrayList<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
	public static ArrayList<ShowDTO> showDTOs = new ArrayList<ShowDTO>();
	private static MemberDTO loginState;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MemberDTO guest = new MemberDTO();
	     loginState=guest;
		
		lSt.setLoginStatus(false);				
		boolean run = true;
		System.out.println("<오잼>(가제 : 오늘은 무엇이 재밌을까?)에 오신것을 환영합니다.");
	
		while (run) {
			if (lSt.getLoginStatus()) {
				System.out.println("아래의 메뉴에서 골라주세요.");
				System.out.println("1. 찾아보기  |  2. 내정보확인");
				System.out.print(">>>");
				String select = s.next();
				
				switch(select) {
				case "1" :
					System.out.println("검색메뉴로 진입합니다.");
					FIndSV.menu(lSt, s, sL, loginDTOs, reviewDTOs, showDTOs);
					break;
				case "2" :
					System.out.println("내정보확인 메뉴로 진입합니다.");
					lSt = myPageSV.menu(lSt, s, sL, loginDTOs, reviewDTOs, showDTOs);
					break;
				default :
					System.out.println("1~2사이에서 입력해주시기 바랍니다.");
				} // switch close
				
				} else {
				System.out.println("아래의 메뉴에서 골라주세요.");
				System.out.println("1. 찾아보기  |  2. 로그인");
				System.out.print(">>>");
				String select = s.next();
				switch(select) {
				case "1" :
					System.out.println("검색메뉴로 진입합니다.");
					FIndSV.menu(lSt, s, sL, loginDTOs, reviewDTOs, showDTOs);
					break;
				case "2" :
					System.out.println("로그인 메뉴로 진입합니다.");
					lSt = LoginSV.menu(lSt, s, sL, loginDTOs, reviewDTOs, showDTOs);
					break;
				default :
					System.out.println("1~2사이에서 입력해주시기 바랍니다.");
				}//switch close
			} // if close
		} // while close

	}// main close

}// class close
