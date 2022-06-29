package day18;

public class Interface1 {

	public static void main(String[] args) {
		

	}

}

interface Ainter{
	final int x = 10;
	int y = 20;  //final생략 가능
	abstract void f1();
	void f2();  //abstract 생략 가능
}
//interface에 있는 변수들은 전부 상수들이며, 메소드들은 전부 추상 메소드이다.