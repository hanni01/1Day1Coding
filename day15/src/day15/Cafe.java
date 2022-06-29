package day15;
//��ü �迭�� �̿��ؼ� �ֹ� ��� ��� �������Ѻ���

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
			case "�Ƹ޸�ī��":
				total += 3800*amount;
				break;
			case "����������":
				total += 2400*amount;
				break;
			case "ī���":
				total += 4200*amount;
				break;
			case "�ٴҶ��":
				total += 5000*amount;
				break;
			case "��Ʈ����Ĩ":
				total += 5500*amount;
				break;
			case "���̽�Ƽ":
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
			
			System.out.println("=====ī�� �ֹ� ���α׷�=====");
			System.out.println("1. �ֹ��ϱ�");
			System.out.println("2. ����ϱ�");
			System.out.println("3. �����ϱ�");
			System.out.println("4. ������");
			
			int menuNum = sc.nextInt();
			
			if(menuNum == 1) {
				boolean menuPro = true;
				while(menuPro) {
					System.out.println("          <MENU>         ");
					System.out.println("�Ƹ޸�ī�� 3800| ���������� 2400| ī��� 4200");
					System.out.println("�ٴҶ�� 5000| ��Ʈ����Ĩ 5500| ���̽�Ƽ 2800");
					System.out.print("���Ͻô� ����� ������ �����ּ���: ");
					String selectMenu = sc.next();
					int amount = sc.nextInt();
					m = new OrderMenu(selectMenu, amount);
					order.add(selectMenu+", "+amount);
					System.out.println(order);
					System.out.println("���� �ݾ�: "+m.calculate());
					menuPro = false;
				}
			}else if(menuNum == 3) {
				
				System.out.println("�����Ͻ� ���� �ݾ��� "+OrderMenu.getTotal()+"�� �Դϴ�. �����Ͻ� ����� �������ֽʽÿ�.");
				System.out.println("1. ī�� | 2. ����");
				int payMethod = sc.nextInt();
				while(true) {
					if(payMethod == 1) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�. �����մϴ�.");
						break;
					}else if(payMethod == 2) {
						System.out.println("�󸶸� ���ðڽ��ϱ�? : ");
						int money = sc.nextInt();
						if(money < OrderMenu.getTotal()) {
							System.out.println("�ݾ��� �����մϴ�.");
							continue;
						}else {
							int change = money - OrderMenu.getTotal();
							System.out.println("�Ž������� "+change+"�� �Դϴ�. �����մϴ�.");
							break;
						}
					}
				}
				System.exit(0);
			}else if(menuNum == 4) {
				System.out.println("�ֹ��� �����մϴ�.");
				System.exit(0);
				
			}
		}
		sc.close();

	}

}
