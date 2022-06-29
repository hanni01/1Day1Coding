package day15;
//객체 배열을 이용해서 주문 취소 기능 실현시켜보기

import java.util.*;

public class Cafe {
	
	static class OrderMenu{
		private String selectMenu;
		private int amount;
		static int total;
		
		public OrderMenu(String selectMenu, int amount) {
			this.selectMenu = selectMenu;
			this.amount = amount;
		}
		
		public int calculate() {
			switch(selectMenu) {
			case "아메리카노":
				total += 3800*amount;
				break;
			case "에스프레소":
				total += 2400*amount;
				break;
			case "카페라떼":
				total += 4200*amount;
				break;
			case "바닐라라떼":
				total += 5000*amount;
				break;
			case "민트초코칩":
				total += 5500*amount;
				break;
			case "아이스티":
				total += 2800*amount;
				break;
			}
			return total;
		}
		
		public static int getTotal() {
			return total;
		}
	}

	public static void main(String[] args) {
		OrderMenu m;
		List<String> order = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		boolean program = true;
		while(program) {
			
			System.out.println("=====카페 주문 프로그램=====");
			System.out.println("1. 주문하기");
			System.out.println("2. 취소하기");
			System.out.println("3. 결제하기");
			System.out.println("4. 끝내기");
			
			int menuNum = sc.nextInt();
			
			if(menuNum == 1) {
				boolean menuPro = true;
				while(menuPro) {
					System.out.println("          <MENU>         ");
					System.out.println("아메리카노 3800| 에스프레소 2400| 카페라떼 4200");
					System.out.println("바닐라라떼 5000| 민트초코칩 5500| 아이스티 2800");
					System.out.print("원하시는 음료와 개수를 적어주세요: ");
					String selectMenu = sc.next();
					int amount = sc.nextInt();
					m = new OrderMenu(selectMenu, amount);
					order.add(selectMenu+", "+amount);
					System.out.println(order);
					System.out.println("결제 금액: "+m.calculate());
					menuPro = false;
				}
			}else if(menuNum == 3) {
				
				System.out.println("결제하실 최종 금액은 "+OrderMenu.getTotal()+"원 입니다. 결제하실 방법을 선택해주십시오.");
				System.out.println("1. 카드 | 2. 현금");
				int payMethod = sc.nextInt();
				while(true) {
					if(payMethod == 1) {
						System.out.println("결제가 완료되었습니다. 감사합니다.");
						break;
					}else if(payMethod == 2) {
						System.out.println("얼마를 내시겠습니까? : ");
						int money = sc.nextInt();
						if(money < OrderMenu.getTotal()) {
							System.out.println("금액이 부족합니다.");
							continue;
						}else {
							int change = money - OrderMenu.getTotal();
							System.out.println("거스름돈은 "+change+"원 입니다. 감사합니다.");
							break;
						}
					}
				}
				System.exit(0);
			}else if(menuNum == 4) {
				System.out.println("주문을 종료합니다.");
				System.exit(0);
				
			}
		}
		sc.close();

	}

}
