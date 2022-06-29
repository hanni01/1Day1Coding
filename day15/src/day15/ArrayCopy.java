package day15;

public class ArrayCopy {

	public static void main(String[] args) {
		//배열을 순환 할 시, 반복문 보다 편리하게 순환할 수 있도록 새로운 문법 제공
		String a[] = {"안녕", "하세요 ", "감사해요 ", "잘있어요 ","다시 만나요"};
		for(String copy:a) {
			System.out.print(copy);
		}
	}

}
