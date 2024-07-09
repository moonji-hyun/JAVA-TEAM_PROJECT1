package com.show.SV;

import java.util.ArrayList;
import java.util.Scanner;

import com.show.DTO.MemberDTO;
import com.show.DTO.ReviewDTO;
import com.show.DTO.ShowDTO;

public class LoginSV {

	public static MemberDTO menu(MemberDTO loginState, Scanner s, Scanner sL, ArrayList<MemberDTO> memberDTOs,
			ArrayList<ReviewDTO> reviewDTOs, ArrayList<ShowDTO> showDTOs) {
		try {
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원정보찾기");
			System.out.print(">>>");
			int select = s.nextInt();
			switch (select) {
			case 1:
				System.out.println("로그인을 위한 ID / PW를 입력하세요.");
				loginState = login(memberDTOs, loginState, s);

				break;
			case 2:
				MemberDTO join = new MemberDTO(); 	//
				System.out.println("회원 가입을 시작합니다.");

				boolean run = true;
				while (run) {
					System.out.println("원하시는 ID를 입력하세요");
					System.out.print(">>>");
					String joinID = s.next();
					boolean pass = true;
					pass = join.setId(joinID, memberDTOs, pass);
					if (pass) {
						join.setUsability(true);

						if (join.isUsability()) {
							System.out.println("사용 가능한  ID 입니다.");
							System.out.println("------------------");
							run = false;
							} 
						}
					}

				System.out.println("원하시는 PW를 입력하세요");
				System.out.print(">>>");
				String joinPW = s.next();
				
				System.out.println("------------------");
				System.out.println("이름을 입력하세요");
				System.out.print(">>>");
				String joinName = s.next();

				System.out.println("------------------");
				System.out.println("생년월일을 입력하세요");
				System.out.print(">>>");
				String joinBirth = s.next();

				System.out.println("------------------");
				System.out.println("닉네임을 입력하세요");
				System.out.print(">>>");
				String joinNickName = s.next();

				System.out.println("------------------");
				System.out.println("이메일을 입력하세요");
				System.out.print(">>>");
				String joinEmail = s.next();

				System.out.println("------------------");
				System.out.println("전화번호를 입력하세요");
				System.out.print(">>>");
				String joinPNo = s.next();

				
				join.setPw(joinPW);
				join.setName(joinName);
				join.setBirth(joinBirth);
				join.setMail(joinEmail);
				join.setNickName(joinNickName);
				join.setpNo(joinPNo);
				memberDTOs.add(join);
				System.out.println("Id : " + join.getId());
				System.out.println("PW : " + join.getPw());
				System.out.println("으로 가입이 완료 되었습니다.");
				System.out.println("---------------------");
				break;
			case 3:

				break;
			default:
				System.out.println("1~3사이에서 입력해주시기 바랍니다.");

			} // switch 종료
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
		//	e.printStackTrace();
		}

	return loginState;

	}



	private static MemberDTO login(ArrayList<MemberDTO> memberDTOs, MemberDTO loginState, Scanner s) {
		System.out.print("ID : ");
		String id = s.next();
		System.out.print("PW : ");
		String pw = s.next();

		MemberDTO login = new MemberDTO(id, pw); // 입력받은 ID, PW를 넣을 객체 생성

		try {
			for (MemberDTO find : memberDTOs) { // memberDTOs 배열을 돌려
				int i = 0;
				if (find.getId().equals(id)) { // 입력바다은 id 와 같은것이 있다면
			//		System.out.println("ID를 확인했습니다.");
					// 인덱스 번호
					if (find.getPw().equals(pw)) { // 입력바다은 pw 와 같은것이 있다면
						System.out.println("PW를 확인했습니다.");
						System.out.println("로그인 성공!!");
						i = memberDTOs.indexOf(find); // 그것의 인덱스 번호를 i에 삽입

						login = memberDTOs.get(i); // 배열 i번에 있는 내용을 login에 삽입
						login.setLoginStatus(true); // login의 logStatus를 변경

						loginState = login;
				//		System.out.println(login.toString());
						break;

					} else {
			//			System.out.println("현우냐?");
						break;
					} // if-if문 종료
				} else {
					System.out.println("id, pw를 확인해주세요");
			//		System.out.println("누구냐 넌?");
//					System.out.println(loginState.getId());
//					System.out.println(find.getId());
//					System.out.println(login.getPw());
					//System.out.println(login.toString());
					
				} // if문 종료
				
			
			} // for문 종료
		
		} catch (Exception e) {
		
			System.out.println("숫자를 입력해주세요");
		//	e.printStackTrace();
		}

		return loginState;

	} // login() 메서드 종료

}
