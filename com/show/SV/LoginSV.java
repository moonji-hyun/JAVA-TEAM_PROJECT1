package com.show.SV;

import java.util.ArrayList;
import java.util.Scanner;

import com.show.DTO.MemberDTO;
import com.show.DTO.ReviewDTO;
import com.show.DTO.ShowDTO;

public class LoginSV {

	public static MemberDTO menu(MemberDTO lSt, Scanner s, Scanner sL, ArrayList<MemberDTO> loginDTOs,
			ArrayList<ReviewDTO> reviewDTOs, ArrayList<ShowDTO> showDTOs) {
		System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원정보찾기");
		System.out.print(">>>");
		String select = s.next();
		switch (select) {
		case "1":
			System.out.println("로그인을 위한 ID / PW를 입력하세요.");
			System.out.print("ID : ");
			String id = s.next();
			System.out.print("PW : ");
			String pw = s.next();
			MemberDTO login = new MemberDTO(id, pw);
			
			for (MemberDTO find : loginDTOs) { 

				if (find.getId().equals(id)) {
					System.out.println("ID를 확인했습니다.");

					if (find.getPw().equals(pw)) {
						System.out.println("PW를 확인했습니다.");
						System.out.println("로그인 성공!!");
					} else {
						System.out.println("ID와 PW를 확인 해주세요");
					} // if-if문 종료
				} else {
					System.out.println("ID와 PW를 확인 해주세요");
				} // if문 종료
			} // for문 종료
			break;
		case "2":
			MemberDTO join = new MemberDTO();

			System.out.println("회원 가입을 시작합니다.");
			System.out.println("원하시는 ID를 입력하세요");
			System.out.print(">>>");
			String joinID = s.next();
			join.setId(joinID, loginDTOs);

			System.out.println("원하시는 PW를 입력하세요");
			System.out.print(">>>");
			String joinPW = s.next();
			
			System.out.println("생년월일을 입력하세요");
			System.out.print(">>>");
			String joinBirth = s.next();
			
			System.out.println("닉네임을 입력하세요");
			System.out.print(">>>");
			String joinNickName = s.next();
			
			
			join.setPw(joinPW);
			join.setBirth(joinBirth);
			join.setNickName(joinNickName);
			loginDTOs.add(join);
			break;
		case "3":
			break;
		default:
			System.out.println("1~3사이에서 입력해주시기 바랍니다.");

		} // switch 종료

		return lSt;
	}

}
