package day21;

import java.util.*;

public class QueueEx {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		//1. add(e)
		q.add("apple");
		q.add("banana");
		q.add("cherry");
		q.add("tomato");
		
		System.out.println(q);
		//2. element : front�� ��ġ�� ������ ��ȯ
		System.out.println("element : "+q.element());
		//3. remove : front�� ��ġ�� �����͸� ��ȯ �� ����
		System.out.println("remove : "+q.remove());
		System.out.println(q);
		//4. offer(e) : rear��ġ�� ������ ����
		q.offer("peach");
		System.out.println(q);
		//5. peek() : front�� ������ �����͸� �������⸸ ��
		System.out.println("peek : "+q.peek());
		//6. poll() : front�� ��ġ�� �����͸� ��ȯ �� ����
		System.out.println("poll : "+q.poll());
		System.out.println(q);
		
		Stack<String> s = new Stack<String>();
		s.push("apple");
		s.push("banana");
		s.push("cherry");
		System.out.println(s);
		
		s.pop(); //top������ ��ȯ �Ļ���
		System.out.println(s);
		
		
	}

}
