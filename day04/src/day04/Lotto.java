package day04;

import java.util.Scanner;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int[] lottoN = new int[6];
		for(int i = 0;i < lottoN.length;i++) {
			lottoN[i] = r.nextInt(45)+1;
		}
		int bonusN = r.nextInt(45)+1;
		
		int[] InputLottoN = new int[6];
		
		System.out.println("Lotto number? : ");
		for(int i = 0;i < 6;i++) {
			InputLottoN[i] = sc.nextInt();
		}
		
		int count = 0;
		int BCount = 0;
		for(int i = 0;i < 6;i++) {
			for(int j = 0;j < lottoN.length;j++) {
				if(InputLottoN[i] == lottoN[j]) {
					count++;
				}
			}
		}
		for(int i = 0;i < InputLottoN.length;i++) {
			if(InputLottoN[i]==bonusN) {
				BCount++;
			}
		}
		System.out.println("");
		
		sc.close();
		
		for(int i = 0;i < lottoN.length;i++) {
			System.out.print(lottoN[i]+" ");
		}
		System.out.println(bonusN);
		
		System.out.println("맞춘 번호 개수: "+count);
		System.out.println("보너스 점수: "+BCount);
		
		if(count == 6 && BCount == 0) {
			System.out.println("1등입니다!");
		}else if(count == 5 && BCount == 1) {
			System.out.println("2등입니다!");
		}else if(count == 5 && BCount == 0) {
			System.out.println("3등입니다!");
		}else if(count == 4) {
			System.out.println("4등입니다!");
		}else if(count == 3) {
			System.out.println("5등입니다!");
		}else {
			System.out.println("다시 도전하세요!");
		}
	}

}
