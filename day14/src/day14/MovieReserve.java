package day14;

import java.util.*;
import java.util.Map.Entry;

class Member{
	static Map<String, String> memberMap = new HashMap<String, String>();
	String id;
	String pw;
	
	public Member(String id) {
		this.id = id;
	}
	
	public boolean checkId(String id) {
		for(Entry<String, String> entrySet : memberMap.entrySet()) {
			if(entrySet.getKey().equals(id)) {
				System.out.println("이미 동일한 아이디가 존재합니다.");
				return false;
			}
		}
		System.out.println("사용 가능한 아이디 입니다.");
		return true;
	}
	
	public void memCreate(String id, String pw) {
		memberMap.put(id, pw);
	}
	
}

public class MovieReserve {

	public static void main(String[] args) {
		int count = 1;
		String seatArray[][] = new String[5][6];
		for(int i = 0;i < 5;i++) {
			for(int j = 0;j < 6;j++) {
				seatArray[i][j] = Integer.toString(count);
				count++;
			}
		}
		Scanner sc = new Scanner(System.in);
		boolean addMem = true;
		while(addMem) {
			System.out.println("=====영화 예약 프로그램=====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			int num1 = sc.nextInt();
			switch(num1) {
			case 1:
				System.out.print("사용할 아이디를 입력해주세요: ");
				String id = sc.next();
				Member member = new Member(id);
				if(member.checkId(id)) {
					System.out.println("비밀번호를 입력해주세요: ");
					String pw = sc.next();
					member.memCreate(id, pw);
				}else {
					System.out.println("다시 진행해주세요.");
				}
				break;
			case 2:
				System.out.print("ID : ");
				String roginId = sc.next();
				System.out.print("PW : ");
				String roginPw = sc.next();
				
				for(Entry<String, String> entrySet : Member.memberMap.entrySet()) {
					if(entrySet.getKey().equals(roginId)) {
						if((Member.memberMap.get(entrySet.getKey())).equals(roginPw)) {
							System.out.println("로그인에 성공하였습니다!");
							boolean program = true;
							while(program) {
								System.out.println("======Menu======");
								System.out.println("1. 좌석확인");
								System.out.println("2. 예약");
								System.out.println("3. 예약 취소");
								System.out.println("4. 시스템 종료");
								int menuNum = sc.nextInt();
								if(menuNum == 1) {
									for(int i = 0;i < 5;i++) {
										for(int j = 0;j < 6;j++) {
											if(j == 5) {
												System.out.println("["+seatArray[i][j]+"]");
											}else {
												System.out.print("["+seatArray[i][j]+"]"+" ");
											}
										}
									}
									continue;
								}else if(menuNum == 2) {
									boolean t = true;
									while(t) {
										System.out.print("예약할 자리를 선택 해주십시오 : ");
										int reserveNum = sc.nextInt();
										int row = reserveNum / 6;
										int col = (reserveNum % 6) - 1;
										if(col == -1) {
											col = 5;
											row--;
										}
										if(!seatArray[row][col].equals("예약")) {
											seatArray[row][col] = "예약";
											System.out.println("예약되었습니다.");
											t = false;
										}else {
											System.out.println("이미 예약된 좌석입니다.");
											continue;
										}
									}
								}else if(menuNum == 3) {
									boolean t = true;
									while(t) {
										System.out.print("예약 취소 할 자리를 선택 해주십시오 : ");
										int cancelNum = sc.nextInt();
										int row = cancelNum / 6;
										int col = (cancelNum % 6) - 1;
										if(col == -1) {
											col = 5;
											row--;
										}
										if(seatArray[row][col].equals("예약")) {
											seatArray[row][col] = Integer.toString(cancelNum);
											System.out.println("예약이 취소되었습니다.");
											t = false;
										}else {
											System.out.println("예약된 좌석이 아닙니다.");
											continue;
										}
									}
								}else if(menuNum == 4) {
									program = false;
								}
							}
						}else {
							System.out.println("비밀번호가 맞지 않습니다.");
						}
					}else {
						System.out.println("존재하는 아이디가 없습니다.");
						break;
					}
				}
				break;
			case 3:
				addMem = false;
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
		}
			
		sc.close();

	}

}
