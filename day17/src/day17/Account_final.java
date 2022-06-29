package day17;

import java.util.*;

public class Account_final {
	
	static Scanner sc1 = new Scanner(System.in); 
	static ArrayList<AccountInfo> accountList = new ArrayList<AccountInfo>();

	public static void main(String[] args) {
		Scanner sc2 = new Scanner(System.in);
		while(true) {
			System.out.println("              ######���� ���α׷�######                ");
			System.out.println("1. ���� ��� | 2. ���� ��� | 3. �Ա� | 4. ��� | 5. �����ϱ�");
			int menuNum = sc2.nextInt();
			switch(menuNum) {
			case 1:
				Registration();
				break;
			case 2:
				PrintList();
				break;
			case 3:
				Deposit();
				break;
			case 4:
				Withdraw();
				break;
			case 5:
				SystemEnd();
				break;
			}
		}
	}
	
	public static void Registration() {
		System.out.println("������ ������ �����ֽʽÿ� : ");
		String members = sc1.next();
		System.out.println("����� ������ �̸��� �����ֽʽÿ� : ");
		String accountName = sc1.next();
		AccountInfo account = new AccountInfo(members, accountName);
		accountList.add(account);
		account.isRegisted();
	}
	
	public static void PrintList() {
		for(AccountInfo a : accountList) {
			System.out.println(a.toString()+"�ܾ�"+a.getBalance()+"��");
		}
	}
	
	public static void Deposit() {
		for(AccountInfo a : accountList) {
			System.out.println(a.toString());
		}
		loop:
		while(true) {
			System.out.println("�Ա��� ���¸� �Է����ֽʽÿ� : ");
			String depositAccount = sc1.next();
			for(AccountInfo a: accountList) {
				if(depositAccount.equals(a.getAccountName())) {
					System.out.println(a.getName()+"�� ���¿� �Ա��Ͻðڽ��ϱ�?");
					System.out.println("1. �� | 2. �ƴϿ�");
					int yesOrno = sc1.nextInt();
					if(yesOrno == 1) {
						a.deposit();
						break loop;
					}else if(yesOrno ==2) {
						System.out.println("�� �ܰ�� ���ư��ϴ�.");
						break;
					}
				}else if(!a.isCreated){
					System.out.println("�ش� ���¸� ã�� �� �����ϴ�.");
				}
			}
		}
	}
	
	public static void Withdraw() {
		for(AccountInfo a : accountList) {
			System.out.println(a.toString());
		}
		loop:
		while(true) {
			System.out.println("����� ���¸� �Է����ֽʽÿ� : ");
			String withdrawAccount = sc1.next();
			for(AccountInfo a: accountList) {
				if(withdrawAccount.equals(a.getAccountName())) {
					System.out.println(a.getName()+"�� ���¿��� ����Ͻðڽ��ϱ�?");
					System.out.println("1. �� | 2. �ƴϿ�");
					int yesOrno = sc1.nextInt();
					if(yesOrno == 1) {
						a.withdraw();
						break loop;
					}else if(yesOrno ==2) {
						System.out.println("�� �ܰ�� ���ư��ϴ�.");
						break;
					}
				}else if(!a.isCreated){
					System.out.println("�ش� ���¸� ã�� �� �����ϴ�.");
				}
			}
		}
	}
	
	public static void SystemEnd() {
		System.out.println("�ý����� �����մϴ�.");
		System.exit(0);
	}

}

class AccountInfo{
	private String name;
	private String accountName;
	private int balance;
	private int depositMoney;
	private int withdrawMoney;
	boolean isCreated = false;
	
	Scanner sc = new Scanner(System.in);
	
	public AccountInfo(String name, String accountName) {
		this.name = name;
		this.accountName = accountName;
		this.balance = 0;
	}
	
	public void isRegisted() {
		isCreated = true;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int getDepositMoney() {
		return depositMoney;
	}
	
	public int getWithdrawMoney() {
		return withdrawMoney;
	}
	
	@Override
	public String toString() {
		return "["+name+", "+accountName+"]";
	}
	
	public void deposit() {
		System.out.println("�Ա��� �ݾ��� �Է����ֽʽÿ� : ");
		int depositMoney = sc.nextInt();
	    balance += depositMoney;
		System.out.println("�Աݿ� �����ϼ̽��ϴ�. ���� "+getName()+"���� "+getAccountName()+"���� �ܾ��� "
	    +getBalance()+"�Դϴ�");
	}
	
	public void withdraw() {
		System.out.println("����� �ݾ��� �Է����ֽʽÿ� : ");
		int withdrawMoney = sc.nextInt();
		if(balance - withdrawMoney < 0) {
			System.out.println("�ܾ��� �����մϴ�.");
		}else {
			balance -= withdrawMoney;
			System.out.println("��ݿ� �����ϼ̽��ϴ�. ���� "+getName()+"���� "+getAccountName()
			+"���� �ܾ��� "+getBalance()+"�Դϴ�");
		}
	}
}