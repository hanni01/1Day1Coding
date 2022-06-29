package day23;

//��ȭ��ȣ�� ���
//1.�� ���� 2. �� �˻� 3. ��ü ���� 4. ������
import java.util.*;

public class CustomerInfo {
	
	public static void main(String[] args) {
		HashMap<String, String> phonebook = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("<��ȭ��ȣ��>");
			System.out.println("1. �� ���� | 2. �� �˻� | 3. ��ü ���� | 4. ������");
			int menuNum = sc.nextInt();
			switch(menuNum) {
			case 1 : 
				System.out.print("������ ������ �̸��� �����ֽʽÿ�: ");
				String name = sc.next();
				System.out.print("������ ��ȭ��ȣ�� �Է����ֽʽÿ�: ");
				String phoneNumber = sc.next();
				phonebook.put(name, phoneNumber);
				System.out.println(name+"�� ������ ��ϵǾ����ϴ�.");
				break;
			case 2 : 
				System.out.print("�˻��Ͻ� ������ �̸��� �����ֽʽÿ�: ");
				String nameSearch = sc.next();
				if(phonebook.containsKey(nameSearch)) {
					System.out.println(nameSearch+"���� ��ȭ��ȣ: "+phonebook.get(nameSearch));
				}else {
					System.out.println(nameSearch+"���� ������ �����ϴ�.");
					continue;
				}
				break;
			case 3 : 
				for(String key : phonebook.keySet()) {
					System.out.println("�̸�: "+key+" | ��ȭ��ȣ: "+phonebook.get(key));
				}
				break;
			case 4 : 
				System.out.println("��ȭ��ȣ�θ� �����մϴ�.");
				System.exit(0);
			}
		}
	}

}
