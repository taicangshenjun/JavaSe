package interview.maze;

public class MazeTest {
	 
	// 定义一个二维数组做迷宫
	private int[][] maze = null;
	//表示此迷宫一共有几种走法
	private int count = 0;
 
	// 迷宫的开始位置和结束位置的坐标
	private static int endI;
	private static int  endJ;
 
	private void setEnd(int endI, int endJ) {
		MazeTest.endI = endI;
		MazeTest.endJ = endJ;
	}
 
	/**
	 * 打印迷宫
	 */
	private void show() {
		System.out.println("第" + (++count) + "种走法");
		for (int i = 0; i < maze.length; i++) {
 
			for (int j = 0; j < maze[0].length; j++) {
 
				if (maze[i][j] == 0) {// 值为0表示 这条线路不通，打印空格
					System.out.print(" ");
				} else if (maze[i][j] == 1) {// 值为1 表示，这是通线路 打印*
					System.out.print("*");
				} else {// 剩下的就是墙壁了 墙壁任然用2表示
					System.out.print(maze[i][j]);
				}
 
			}
 
			System.out.println();
		}
	}
 
	/**
	 * 开始走迷宫 
	 */
	public void play(int x,int y) {
		maze[x][y] = 1;
		
		//到达终点
		if(x == endI && y == endJ){
			show();
		}
		
		//否则继续走
		//向上走
		if(check(x, y - 1))
		play(x, y-1);	
		
		//向下走 
		if(check(x, y + 1))
		play(x, y+1);	
		
		//向左走 
		if(check(x - 1, y))
		play(x-1, y);	
		
		//向右走 
		if(check(x + 1, y))
		play(x+1, y);	
		
		//表示当前位置的上下左右都走不通，那么此位置 也不通 重设为0
		maze[x][y] = 0;
		
 
	}
	
	public boolean check(int x, int y) {
		boolean result = false;
		if(x >= 0 && x < maze[0].length && y >= 0 && y < maze.length && maze[x][y] == 0) {
			result = true;
		}
		return result;
	}
 
	public static void main(String[] args) {
		MazeTest myMaze = new MazeTest();
		int[][] maze = {    
			{ 2, 2, 2, 2, 2, 2, 2, 2 }, 
			{ 0, 0, 0, 0, 0, 2, 2, 2 }, 
			{ 2, 0, 2, 0, 0, 0, 2, 2 }, 
			{ 2, 0, 0, 2, 0, 2, 0, 2 }, 
			{ 2, 0, 0, 2, 0, 2, 2, 0 },
			{ 2, 0, 2, 0, 0, 0, 0, 2 }, 
			{ 2, 0, 0, 0, 0, 2, 0, 0 }, 
			{ 2, 2, 2, 2, 2, 2, 2, 2 } 
		};
 
		myMaze.maze = maze;
//		myMaze.setStart(1, 1);
		myMaze.setEnd(6, 7);
		
		myMaze.play(1, 0);
	}
 
}

