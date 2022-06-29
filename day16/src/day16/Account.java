package day16;

import java.util.*;

public class Account {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> accountMap =  new HashMap<String, String>();
		AccountInfo account;
		while(true) {
			System.out.println("              ######은행 프로그램######                ");
			System.out.println("1. 계좌 등록 | 2. 계좌 목록 | 3. 입금 | 4. 출금 | 5. 종료하기");
			int menuNum = sc.nextInt();
			if(menuNum == 1) {
				System.out.println("본인의 성함을 적어주십시오: ");
				String member = sc.next();
				System.out.println("등록할 계좌의 이름을 적어주십시오: ");
				String accountName = sc.next();
				account = new AccountInfo(member, accountName);
				accountMap.put(AccountInfo.getMember(), AccountInfo.getAccountName());
			}else if(menuNum == 2) {
				Set<String> keySet = accountMap.keySet();
				for(String key : keySet) {
					System.out.println(key+ " : "+accountMap.get(key));
				}
			}else if(menuNum == 3) {
				Set<String> keySet = accountMap.keySet();
				for(String key : keySet) {
					System.out.println(key+ " : "+accountMap.get(key));
				}
				System.out.println("입금할 계좌를 입력해 주십시오 : ");
				String depositAccount = sc.next();
				System.out.println(AccountInfo.getKey(accountMap, depositAccount)+"님에게 입금하시겠습니까?");
				System.out.println("1. 네 | 2. 아니오");
				int yesOrno = sc.nextInt();
				if(yesOrno == 1) {
					System.out.println("얼마를 입금하시겠습니까? : ");
					int depositMoney = sc.nextInt();
					System.out.println(depositMoney+"원 입금 성공");
				}else if(yesOrno == 2) {
					System.out.println("첫단계로 돌아갑니다.");
					continue;
				}
			}else if(menuNum == 4) {
				Set<String> keySet = accountMap.keySet();
				for(String key : keySet) {
					System.out.println(key+ " : "+accountMap.get(key));
				}
				System.out.println("출할 계좌를 입력해 주십시오 : ");
				String depositAccount = sc.next();
				System.out.println(depositAccount+"계좌에서 출금하시겠습니까?");
				System.out.println("1. 네 | 2. 아니오");
				int yesOrno = sc.nextInt();
				if(yesOrno == 1) {
					System.out.println("얼마를 출금하시겠습니까? : ");
					int withdrawMoney = sc.nextInt();
					System.out.println(withdrawMoney+"원 출금 성공");
				}else if(yesOrno == 2) {
					System.out.println("첫단계로 돌아갑니다.");
					continue;
				}
			}else if(menuNum == 5) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}

	    }

   }
}

class AccountInfo{
	private static String member;
	private static String accountName;
	
	public AccountInfo(String member, String accountName) {
		AccountInfo.member = member;
		AccountInfo.accountName = accountName;
	}
	
	public static String getMember() {
		return member;
	}
	
	public static String getAccountName() {
		return accountName;
	}
	
	public static <K, V> K getKey(Map<K, V> map, V value) {
		for(K key : map.keySet()) {
			if(value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}
}
