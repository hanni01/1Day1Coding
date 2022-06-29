package day20;

public class swapswap {
	
	int a = 10;
	int b = 20;

	public static void main(String[] args) {
		swapswap swap1 = new swapswap();
		
		System.out.println("a : "+swap1.a+" b: "+swap1.b);
		
		swap1.swapAB(swap1.a, swap1.b);
		
		System.out.println("a : "+swap1.a+" b: "+swap1.b);
	}
	
	public void swapAB(int c, int d) {
		this.a = c;
		this.b = d;
		
		int temp = c;
		c = d;
		d = temp;
	}

}
