package day21;

public class Mazerunner_ {
	
	static final int visited = 3;
	static final int wall = 0;
	static final int blocked = 2;
	static final int path = 1;
	
	private static int [][] maze = {
	        {1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, 
	        {1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, 
	        {1, 1, 1, 1, 0, 1, 1, 0, 0, 1}, 
	        {0, 1, 0, 0, 0, 0, 1, 0, 1, 0}, 
	        {1, 1, 1, 0, 1, 1, 1, 0, 0, 1}, 
	        {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},  
	    };
	
	public static boolean findpath(int x, int y) {
		
		if(x == 5 && y == 9) {
			maze[x][y] = visited;
			return true;
		}else if(x < 0 || y < 0 || x >= 6 || y >= 10 || maze[x][y] == wall || maze[x][y] == visited) {
			return false;
		}else {
			maze[x][y] = visited;
			if(findpath(x-1, y) || findpath(x+1, y) || findpath(x, y-1) || findpath(x, y+1)) {
				return true;
			}else {
				maze[x][y] = blocked;
				return false;
			}
		}
	}
	
	public static void result() {
		for(int i = 0; i < maze.length;i++) {
			for(int j = 0; j < maze[i].length;j++) {
				if(j == maze[i].length-1) {
					System.out.print(maze[i][j]);
					System.out.println();
				}else {
					System.out.print(maze[i][j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		findpath(0,0);
		result();
	}

}
