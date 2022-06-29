package day04;

import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 값 하나를 입력하시오: ");
		int num = sc.nextInt();
		
		for(int i = 0;i < num;i++) {
			for(int j = 0;j < num-i;j++) {
				System.out.print(" ");
			}
			for(int n = 0;n < i*2+1;n++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
