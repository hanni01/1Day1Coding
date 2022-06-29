package day16;

import java.util.*;

public class Account {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> accountMap =  new HashMap<String, String>();
		AccountInfo account;
		while(true) {
			System.out.println("              ######���� ���α׷�######                ");
			System.out.println("1. ���� ��� | 2. ���� ��� | 3. �Ա� | 4. ��� | 5. �����ϱ�");
			int menuNum = sc.nextInt();
			if(menuNum == 1) {
				System.out.println("������ ������ �����ֽʽÿ�: ");
				String member = sc.next();
				System.out.println("����� ������ �̸��� �����ֽʽÿ�: ");
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
				System.out.println("�Ա��� ���¸� �Է��� �ֽʽÿ� : ");
				String depositAccount = sc.next();
				System.out.println(AccountInfo.getKey(accountMap, depositAccount)+"�Կ��� �Ա��Ͻðڽ��ϱ�?");
				System.out.println("1. �� | 2. �ƴϿ�");
				int yesOrno = sc.nextInt();
				if(yesOrno == 1) {
					System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�? : ");
					int depositMoney = sc.nextInt();
					System.out.println(depositMoney+"�� �Ա� ����");
				}else if(yesOrno == 2) {
					System.out.println("ù�ܰ�� ���ư��ϴ�.");
					continue;
				}
			}else if(menuNum == 4) {
				Set<String> keySet = accountMap.keySet();
				for(String key : keySet) {
					System.out.println(key+ " : "+accountMap.get(key));
				}
				System.out.println("���� ���¸� �Է��� �ֽʽÿ� : ");
				String depositAccount = sc.next();
				System.out.println(depositAccount+"���¿��� ����Ͻðڽ��ϱ�?");
				System.out.println("1. �� | 2. �ƴϿ�");
				int yesOrno = sc.nextInt();
				if(yesOrno == 1) {
					System.out.println("�󸶸� ����Ͻðڽ��ϱ�? : ");
					int withdrawMoney = sc.nextInt();
					System.out.println(withdrawMoney+"�� ��� ����");
				}else if(yesOrno == 2) {
					System.out.println("ù�ܰ�� ���ư��ϴ�.");
					continue;
				}
			}else if(menuNum == 5) {
				System.out.println("�ý����� �����մϴ�.");
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
