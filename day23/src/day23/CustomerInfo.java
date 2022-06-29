package day23;

//전화번호부 기능
//1.고객 저장 2. 고객 검색 3. 전체 보기 4. 끝내기
import java.util.*;

public class CustomerInfo {
	
	public static void main(String[] args) {
		HashMap<String, String> phonebook = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("<전화번호부>");
			System.out.println("1. 고객 저장 | 2. 고객 검색 | 3. 전체 보기 | 4. 끝내기");
			int menuNum = sc.nextInt();
			switch(menuNum) {
			case 1 : 
				System.out.print("저장할 고객님의 이름을 적어주십시오: ");
				String name = sc.next();
				System.out.print("고객님의 전화번호를 입력해주십시오: ");
				String phoneNumber = sc.next();
				phonebook.put(name, phoneNumber);
				System.out.println(name+"님 정보가 등록되었습니다.");
				break;
			case 2 : 
				System.out.print("검색하실 고객님의 이름을 적어주십시오: ");
				String nameSearch = sc.next();
				if(phonebook.containsKey(nameSearch)) {
					System.out.println(nameSearch+"님의 전화번호: "+phonebook.get(nameSearch));
				}else {
					System.out.println(nameSearch+"님의 정보가 없습니다.");
					continue;
				}
				break;
			case 3 : 
				for(String key : phonebook.keySet()) {
					System.out.println("이름: "+key+" | 전화번호: "+phonebook.get(key));
				}
				break;
			case 4 : 
				System.out.println("전화번호부를 종료합니다.");
				System.exit(0);
			}
		}
	}

}
