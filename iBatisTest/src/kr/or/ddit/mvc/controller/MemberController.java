package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	private Scanner sc;
	// Service객체가 저장될 변수 선언
	private IMemberService service;
	
	//생성자
	public MemberController() {
		sc = new Scanner(System.in);
//		service = new MemberServiceImpl();
		service = MemberServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new MemberController().memberStart();
	}
	
	// 시작 메서드
	public void memberStart() {
		while(true) {
			int choice = displayMenu();

			switch(choice) {
			case 1: 	// 자료 추가
				insertMember();
				break;	
			case 2: 	// 자료 삭제
				deleteMember(); 
				break;
			case 3: 	// 자료 수정
				updateMember();
				break;
			case 4: 	// 전체 출력
				displayMember();
				break;
			case 5: 	// 자료 수정
				updateMember2();
				break;
			case 0: 	// 작업끝
				System.out.println("작업을 마칩니다...");
			default : 
				System.out.println("번호를 잘못입력했습니다 다시 입력해주세요.");
			}
		}
	}
	
	//자료를 수정하는 메서드 -- 원하는 항목만
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >>");
		String memId = sc.next();

		int count = service.getMemberCount(memId);
		if(count==0) {
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수행 작업을 종료합니다");
			return;
		}
		int num;
		String updateField = null; // 수정할 컬럼명이 저장될 변수
		String updateTitle = null; // 수정할 내용을 입력할 때 출력할 내용이 저장될 변수

		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요...");
			System.out.println(" 1.비밀번호 2.회원이름 3.전화번호 4.회원주소");
			System.out.println("----------------------------------------------------");
			System.out.print("수정 항목 선택 >>");
			num = sc.nextInt();
			switch(num) {
			case 1: updateField = "mem_pass"; updateTitle = "비밀번호"; break;
			case 2: updateField = "mem_name"; updateTitle = "회원이름"; break;
			case 3: updateField = "mem_tel"; updateTitle = "전화번호"; break;
			case 4:	updateField = "mem_addr"; updateTitle = "회원주소"; break;
			default : 
				System.out.println("수정 항목을 잘못 선택했습니다. 다시 선택하세요.");
			}
		}while(num < 1 || num > 4);

		System.out.println();
		sc.nextLine();
		System.out.print("새로운" + updateTitle + ">>");
		String updateData = sc.nextLine(); // 변경될 값 입력
		
		// 압출 받은 데이터들을 Map객체에 추가한다
		Map<String, String>paramMap = new HashMap<String, String>(); // Map객체 생성
		paramMap.put("memid", memId);
		paramMap.put("field", updateField);
		paramMap.put("data", updateData);
		
		int cnt = service.updateMember2(paramMap);
		
		if(cnt > 0) {
			System.out.println("수정작업 성공!!");
		}else {
			System.out.println("수정작업실패");
		}
		
	}

	// 자료 추가 메서드
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		int count = 0;			// 해당 회원id개수가 저장될 변수
		String memId = null; 	// 회원ID가 저장될 변수
		do{
			System.out.print("회원 ID >>");
			memId = sc.next();
			count = service.getMemberCount(memId);

			if(count > 0) {
				System.out.println(memId + "은(는) 이미 중복된 회원 ID입니다");
				System.out.println("다른 회원 id를입력하세요");
			}

		}while(count > 0); 

		System.out.print("비밀번호 >>");
		String memPass = sc.next();

		System.out.print(" 회원이름 >> ");
		String memName = sc.next();

		System.out.print("전화번호 >> ");
		String memTel = sc.next();

		sc.nextLine();
		System.out.print("회원 주소 >> ");
		String memAddr = sc.nextLine();
		
		// 입력받은 데이터를 VO객체에 담는다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		//Service에 insert작업을 시킨다.
		int cnt = service.insertMember(memVo);
		
		if(cnt > 0) {
			System.out.println(memId + "회원 정보 추가 성공!");
		}else {
			System.out.println(memId + "회원 정보 추가 실패");
		}
		
	}
	
	// 자료 수정 메서드
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >>");
		String memId = sc.next();

		int count = service.getMemberCount(memId);
		if(count==0) {
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수행 작업을 종료합니다");
			return;

		}
		System.out.println();
		System.out.println("수정할 내용을 입력하세요");
		System.out.print("새로운 비밀번호 >> ");
		String newPass = sc.next();
		System.out.print("새로운 회원이름 >> ");
		String newName = sc.next();
		System.out.print("새로운 전화번호 >> ");
		String newTel = sc.next();
		sc.nextLine();
		System.out.print("새로운 회원주소 >> ");
		String newAddr = sc.nextLine();
		
		// 입력한 데이터를 VO객체에 저장한다
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newPass);
		memVo.setMem_name(newName);
		memVo.setMem_tel(newTel);
		memVo.setMem_addr(newAddr);
		
		// service의 update처리 메서드 호출
		int cnt = service.updateMember(memVo);
		
		if(cnt > 0) {
			System.out.println(memId + "회원 정보 수정 성공!");
		}else {
			System.out.println(memId + "회원 정보 수정 실패");
		}
	}
	
	// 자료 삭제 메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원정보를 입력하세요.");
		System.out.print("삭제할 회원ID >> ");
		String memId = sc.next();
		int cnt = service.deleteMember(memId);
		if(cnt > 0) {
			System.out.println("회원ID가 " + memId + "인 회원정보 삭제 성공");
		}else {
			System.out.println("실패");
		}

	}
	// 전체 자료 출력 메서드
	private void displayMember() {
		// 전체 회원정보 가져오기
		List<MemberVO> memList = service.getAllMember();
		
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println(" ID		비밀번호	이름	전화번호	주소");
		System.out.println("-----------------------------------------------");
		
		if(memList==null || memList.size() == 0) {
			System.out.println("등록된 회원 정보가 하나도 없습니다.");
		}else {
			for(MemberVO memVo : memList) {
				String id = memVo.getMem_id();
				String pass = memVo.getMem_pass();
				String name = memVo.getMem_name();
				String tel = memVo.getMem_tel();
				String addr = memVo.getMem_addr();
				
				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);
				
			}
		}
		System.out.println("------------------------------------------------------------------------");
	}
	
	// 메뉴를 출력하고 선택한 작업번호를 반환하는 메서드
		private int displayMenu() {
			System.out.println();
			System.out.println("===================================================");
			System.out.println("1.자료추가");
			System.out.println("2.자료삭제");
			System.out.println("3.자료수정");
			System.out.println("4.전체 자료 출력");
			System.out.println("0.작업 끝.");
			System.out.println("===================================================");
			System.out.println("작업 번호 입력 >>");
			return sc.nextInt();
		}
}
