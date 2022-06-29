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
		//2. element : front에 위치한 데이터 반환
		System.out.println("element : "+q.element());
		//3. remove : front에 위치한 데이터를 반환 후 삭제
		System.out.println("remove : "+q.remove());
		System.out.println(q);
		//4. offer(e) : rear위치에 데이터 삽입
		q.offer("peach");
		System.out.println(q);
		//5. peek() : front에 위취한 데이터를 가져오기만 함
		System.out.println("peek : "+q.peek());
		//6. poll() : front에 위치한 데이터를 반환 후 삭제
		System.out.println("poll : "+q.poll());
		System.out.println(q);
		
		Stack<String> s = new Stack<String>();
		s.push("apple");
		s.push("banana");
		s.push("cherry");
		System.out.println(s);
		
		s.pop(); //top데이터 반환 후삭제
		System.out.println(s);
		
		
	}

}
