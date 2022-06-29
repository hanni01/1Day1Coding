package day21;

public class CountingBlob {
	
	//1이 색칠된 영역, 0은 색칠 되지 않은 영역
	static int count = 0;
	static int visited = 2;
	static int area = 1;
	private static int [][] cells = {
	        {1, 1, 0, 1, 0, 1, 1, 1, 1, 1}, 
	        {1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, 
	        {1, 1, 1, 1, 0, 1, 0, 0, 0, 1}, 
	        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
	        {1, 1, 1, 0, 1, 1, 1, 0, 0, 1}, 
	        {0, 0, 1, 0, 1, 0, 1, 1, 1, 1},  
	    };
	
	public static boolean findBlob(int x, int y) {
		if(x < 0 || y < 0 || x >= cells.length || y >= cells[0].length) {
			return false;
		}else if(cells[x][y] == 0){
			return false;
		}else if(cells[x][y] == visited) {
			return false;
		}
		else {
			cells[x][y] = visited;
			count += 1;
			
			if(findBlob(x-1, y) || findBlob(x+1, y) || findBlob(x, y-1) || findBlob(x, y+1)
					|| findBlob(x-1, y-1) || findBlob(x+1, y+1) || findBlob(x-1, y+1) || findBlob(x+1, y-1)) {
				return true;
			}
		}
		return false;
	}

	public static void result() {
		for(int i = 0; i < cells.length;i++) {
			for(int j = 0; j < cells[i].length;j++) {
				if(j == cells[i].length-1) {
					System.out.print(cells[i][j]);
					System.out.println();
				}else {
					System.out.print(cells[i][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		for(int i = 0; i < cells.length;i++) {
			for(int j = 0; j < cells[i].length;j++) {
				findBlob(i, j);
				if(count != 0) {
					System.out.println(area + " : " + count);
					area += 1;
					count = 0;
				}
			}
		}
		result();

	}

}
