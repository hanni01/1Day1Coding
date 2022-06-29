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
				System.out.println("�̹� ������ ���̵� �����մϴ�.");
				return false;
			}
		}
		System.out.println("��� ������ ���̵� �Դϴ�.");
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
			System.out.println("=====��ȭ ���� ���α׷�=====");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("3. ����");
			int num1 = sc.nextInt();
			switch(num1) {
			case 1:
				System.out.print("����� ���̵� �Է����ּ���: ");
				String id = sc.next();
				Member member = new Member(id);
				if(member.checkId(id)) {
					System.out.println("��й�ȣ�� �Է����ּ���: ");
					String pw = sc.next();
					member.memCreate(id, pw);
				}else {
					System.out.println("�ٽ� �������ּ���.");
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
							System.out.println("�α��ο� �����Ͽ����ϴ�!");
							boolean program = true;
							while(program) {
								System.out.println("======Menu======");
								System.out.println("1. �¼�Ȯ��");
								System.out.println("2. ����");
								System.out.println("3. ���� ���");
								System.out.println("4. �ý��� ����");
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
										System.out.print("������ �ڸ��� ���� ���ֽʽÿ� : ");
										int reserveNum = sc.nextInt();
										int row = reserveNum / 6;
										int col = (reserveNum % 6) - 1;
										if(col == -1) {
											col = 5;
											row--;
										}
										if(!seatArray[row][col].equals("����")) {
											seatArray[row][col] = "����";
											System.out.println("����Ǿ����ϴ�.");
											t = false;
										}else {
											System.out.println("�̹� ����� �¼��Դϴ�.");
											continue;
										}
									}
								}else if(menuNum == 3) {
									boolean t = true;
									while(t) {
										System.out.print("���� ��� �� �ڸ��� ���� ���ֽʽÿ� : ");
										int cancelNum = sc.nextInt();
										int row = cancelNum / 6;
										int col = (cancelNum % 6) - 1;
										if(col == -1) {
											col = 5;
											row--;
										}
										if(seatArray[row][col].equals("����")) {
											seatArray[row][col] = Integer.toString(cancelNum);
											System.out.println("������ ��ҵǾ����ϴ�.");
											t = false;
										}else {
											System.out.println("����� �¼��� �ƴմϴ�.");
											continue;
										}
									}
								}else if(menuNum == 4) {
									program = false;
								}
							}
						}else {
							System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
						}
					}else {
						System.out.println("�����ϴ� ���̵� �����ϴ�.");
						break;
					}
				}
				break;
			case 3:
				addMem = false;
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			}
		}
			
		sc.close();

	}

}
