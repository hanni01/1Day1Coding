package day17;

import java.util.*;

public class Account_final {
	
	static Scanner sc1 = new Scanner(System.in); 
	static ArrayList<AccountInfo> accountList = new ArrayList<AccountInfo>();

	public static void main(String[] args) {
		Scanner sc2 = new Scanner(System.in);
		while(true) {
			System.out.println("              ######은행 프로그램######                ");
			System.out.println("1. 계좌 등록 | 2. 계좌 목록 | 3. 입금 | 4. 출금 | 5. 종료하기");
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
		System.out.println("본인의 성함을 적어주십시오 : ");
		String members = sc1.next();
		System.out.println("등록할 계좌의 이름을 적어주십시오 : ");
		String accountName = sc1.next();
		AccountInfo account = new AccountInfo(members, accountName);
		accountList.add(account);
		account.isRegisted();
	}
	
	public static void PrintList() {
		for(AccountInfo a : accountList) {
			System.out.println(a.toString()+"잔액"+a.getBalance()+"원");
		}
	}
	
	public static void Deposit() {
		for(AccountInfo a : accountList) {
			System.out.println(a.toString());
		}
		loop:
		while(true) {
			System.out.println("입금할 계좌를 입력해주십시오 : ");
			String depositAccount = sc1.next();
			for(AccountInfo a: accountList) {
				if(depositAccount.equals(a.getAccountName())) {
					System.out.println(a.getName()+"님 계좌에 입금하시겠습니까?");
					System.out.println("1. 네 | 2. 아니오");
					int yesOrno = sc1.nextInt();
					if(yesOrno == 1) {
						a.deposit();
						break loop;
					}else if(yesOrno ==2) {
						System.out.println("전 단계로 돌아갑니다.");
						break;
					}
				}else if(!a.isCreated){
					System.out.println("해당 계좌를 찾을 수 없습니다.");
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
			System.out.println("출금할 계좌를 입력해주십시오 : ");
			String withdrawAccount = sc1.next();
			for(AccountInfo a: accountList) {
				if(withdrawAccount.equals(a.getAccountName())) {
					System.out.println(a.getName()+"님 계좌에서 출금하시겠습니까?");
					System.out.println("1. 네 | 2. 아니오");
					int yesOrno = sc1.nextInt();
					if(yesOrno == 1) {
						a.withdraw();
						break loop;
					}else if(yesOrno ==2) {
						System.out.println("전 단계로 돌아갑니다.");
						break;
					}
				}else if(!a.isCreated){
					System.out.println("해당 계좌를 찾을 수 없습니다.");
				}
			}
		}
	}
	
	public static void SystemEnd() {
		System.out.println("시스템을 종료합니다.");
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
		System.out.println("입금할 금액을 입력해주십시오 : ");
		int depositMoney = sc.nextInt();
	    balance += depositMoney;
		System.out.println("입금에 성공하셨습니다. 현재 "+getName()+"님의 "+getAccountName()+"계좌 잔액은 "
	    +getBalance()+"입니다");
	}
	
	public void withdraw() {
		System.out.println("출금할 금액을 입력해주십시오 : ");
		int withdrawMoney = sc.nextInt();
		if(balance - withdrawMoney < 0) {
			System.out.println("잔액이 부족합니다.");
		}else {
			balance -= withdrawMoney;
			System.out.println("출금에 성공하셨습니다. 현재 "+getName()+"님의 "+getAccountName()
			+"계좌 잔액은 "+getBalance()+"입니다");
		}
	}
}