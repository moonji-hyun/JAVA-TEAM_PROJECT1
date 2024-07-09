package com.show.SV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.show.DTO.DramaDTO;
import com.show.DTO.MemberDTO;
import com.show.DTO.ReviewDTO;
import com.show.DTO.ShowDTO;
import com.show.DTO.VarietyDTO;

public class LoginSV {

	public static MemberDTO menu(MemberDTO lSt, Scanner s, Scanner sL, ArrayList<MemberDTO> loginDTOs,
			ArrayList<ReviewDTO> reviewDTOs, ArrayList<ShowDTO> showDTOs, ArrayList<DramaDTO> dramaDTOs,
			ArrayList<VarietyDTO> varietyDTOs) {
		boolean run = true;

		while (run) {
			if (!lSt.getLoginStatus()) {
				System.out.println("1. 로그인 | 2. 회원가입 | 3. exit | 4. 영화 정보 찾기");
				System.out.print(">>>");
				String select = s.next();
				switch (select) {

				case "1":
					System.out.println("로그인을 위한 ID / PW를 입력하세요.");
					lSt = login(loginDTOs, lSt, s);
					break;

				case "2":
					register(lSt, s, sL, loginDTOs, reviewDTOs, showDTOs,  dramaDTOs, varietyDTOs);
					
					break;
				case "3":
					System.out.println("메인메뉴로 돌아갑니다.");
					run=false;
					break;
				case "4":
					System.out.println("영화정보 찾기 메뉴로 돌아갑니다.");
					SearchSV.menu(lSt, s, sL, loginDTOs, reviewDTOs, showDTOs, dramaDTOs, varietyDTOs);
					break;
				default:
					System.out.println("1~3사이에서 입력해주시기 바랍니다.");

				} // switch 종료
			} else {
				System.out.println("1. 마이페이지 | 2. 로그아웃 | 3. exit | 4. 영화정보찾기");
				System.out.print(">>>");
				String select = s.next();
				switch (select) {

				case "1":
					lSt = MyPageSV.menu(sL, loginDTOs, lSt);
					break;
				case "2":
					lSt = null;
					lSt = new MemberDTO();
					lSt.setLoginStatus(false);
					run = false;
					break;

				case "3":
					System.out.println("메인메뉴로 돌아갑니다.");
					run=false;
					break;
				case "4":
					System.out.println("영화정보 찾기 메뉴로 돌아갑니다.");
					SearchSV.menu(lSt, s, sL, loginDTOs, reviewDTOs, showDTOs, dramaDTOs, varietyDTOs);
					break;
				default:
					System.out.println("1~3사이에서 입력해주시기 바랍니다.");
				}
			}

		}
		return lSt;
	}

	private static void register(MemberDTO lSt, Scanner s, Scanner sL, ArrayList<MemberDTO> loginDTOs,
			ArrayList<ReviewDTO> reviewDTOs, ArrayList<ShowDTO> showDTOs, ArrayList<DramaDTO> dramaDTOs,
			ArrayList<VarietyDTO> varietyDTOs) {
		MemberDTO join = new MemberDTO();

		System.out.println("회원 가입을 시작합니다.");
		boolean run = true;
		String joinID = "";
		while (run) {
			System.out.println("원하시는 ID를 입력하세요");
			System.out.print(">>>");
			joinID = s.next();
			boolean pass = true;
			pass = join.setId(joinID, loginDTOs, pass);
			
			if (pass) {
				join.setUsability(true);
				if(join.isUsability()) {
					System.out.println("사용 가능한 ID입니다.");
					System.out.println("--------------------");
					run=false;
				}
			}
		}
				System.out.println("원하시는 PW를 입력하세요");
				System.out.print(">>>");
				String joinPW = s.next();
				
				System.out.println("--------------------");
				System.out.println("이름을 입력하세요");
				System.out.print(">>>");
				String joinName = s.next();
				
				System.out.println("--------------------");
				System.out.println("생년월일을 입력하세요");
				System.out.print(">>>");		
				String joinBirth = s.next();
				
				System.out.println("--------------------");
				System.out.println("닉네임을 입력하세요");
				System.out.print(">>>");
				String joinNickName = s.next();
				
				System.out.println("--------------------");
				System.out.println("e-mail을 입력하세요");
				System.out.print(">>>");
				String joinEmail = s.next();
				
				System.out.println("--------------------");
				System.out.println("전화번호를 입력하세요");
				System.out.print(">>>");
				String joinpNo = s.next();
				
				MemberDTO join1 = new MemberDTO(joinID, joinPW, joinName, joinBirth, joinNickName, joinpNo, joinEmail);
				loginDTOs.add(join1);
		
		
	}

	private static MemberDTO login(ArrayList<MemberDTO> loginDTOs, MemberDTO lSt, Scanner s) {
		System.out.print("ID : ");
		String id = s.next();
		System.out.print("PW : ");
		String pw = s.next();
		MemberDTO login = new MemberDTO(id, pw); // 입력받은 ID,PW를 넣을 객체 생성

		try {
			for (MemberDTO find : loginDTOs) {// memberDTOs 배열을 돌려
				int i = 0;
				if (find.getId().equals(id)) {
					if (find.getPw().equals(pw)) {
						System.out.println("로그인 성공!!");
						i = loginDTOs.indexOf(find);
						login = loginDTOs.get(i);
						login.setLoginStatus(true);
						lSt = login;
						break;
					} else {
//						System.out.println("id, pw를 확인해주세요.");
					} // if close
				} else {
//					System.out.println("id, pw를 확인해주세요.");
				}  // if close

			} // for close
			if(login.getLoginStatus()==false) {
				System.out.println("id, pw를 확인해주세요.");
			}

		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
		}//try catch close

		return lSt;
	}// login method close

}
