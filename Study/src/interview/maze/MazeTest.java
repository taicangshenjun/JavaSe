package interview.maze;

public class MazeTest {
	 
	// ����һ����ά�������Թ�
	private int[][] maze = null;
	//��ʾ���Թ�һ���м����߷�
	private int count = 0;
 
	// �Թ��Ŀ�ʼλ�úͽ���λ�õ�����
	private static int endI;
	private static int  endJ;
 
	private void setEnd(int endI, int endJ) {
		MazeTest.endI = endI;
		MazeTest.endJ = endJ;
	}
 
	/**
	 * ��ӡ�Թ�
	 */
	private void show() {
		System.out.println("��" + (++count) + "���߷�");
		for (int i = 0; i < maze.length; i++) {
 
			for (int j = 0; j < maze[0].length; j++) {
 
				if (maze[i][j] == 0) {// ֵΪ0��ʾ ������·��ͨ����ӡ�ո�
					System.out.print(" ");
				} else if (maze[i][j] == 1) {// ֵΪ1 ��ʾ������ͨ��· ��ӡ*
					System.out.print("*");
				} else {// ʣ�µľ���ǽ���� ǽ����Ȼ��2��ʾ
					System.out.print(maze[i][j]);
				}
 
			}
 
			System.out.println();
		}
	}
 
	/**
	 * ��ʼ���Թ� 
	 */
	public void play(int x,int y) {
		maze[x][y] = 1;
		
		//�����յ�
		if(x == endI && y == endJ){
			show();
		}
		
		//���������
		//������
		if(check(x, y - 1))
		play(x, y-1);	
		
		//������ 
		if(check(x, y + 1))
		play(x, y+1);	
		
		//������ 
		if(check(x - 1, y))
		play(x-1, y);	
		
		//������ 
		if(check(x + 1, y))
		play(x+1, y);	
		
		//��ʾ��ǰλ�õ��������Ҷ��߲�ͨ����ô��λ�� Ҳ��ͨ ����Ϊ0
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

