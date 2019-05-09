package interview.maze;

/**
 * @author cm
 *
 */
public class Maze {

	private int[][] array = {
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 0, 1},
            {0, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0}
 
    };
	
	private int maxLine = 8;
	
    private int maxRow = 9;
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
        new Maze().check(0, 0);
        System.out.println(System.currentTimeMillis());
	}
	
	private void check(int i, int j) {
		if (i == maxRow - 1 && j == maxLine - 1) {
			showMaze(array);
            return;
        }
		//������
        if (canMove(i, j, i, j + 1)) {
            array[i][j] = 5;
            check(i, j + 1);
            array[i][j] = 0;
        }
        //������
        if (canMove(i, j, i, j - 1)) {
            array[i][j] = 5;
            check(i, j - 1);
            array[i][j] = 0;
        }
        //������
        if (canMove(i, j, i + 1, j)) {
            array[i][j] = 5;
            check(i + 1, j);
            array[i][j] = 0;
        }
        //������
        if (canMove(i, j, i - 1, j)) {
            array[i][j] = 5;
            check(i - 1, j);
            array[i][j] = 0;
        }
	}
	
	private boolean canMove(int i, int j, int targetI, int targetJ) {
//      System.out.println("�ӵ�" + (i + 1) + "�е�" + (j + 1) + "�У��ߵ���" + (targetI + 1) + "�е�" + (targetJ + 1) + "��");
		if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxLine) {
//          System.out.println("��������߻����ұߣ�ʧ����");
			return false;
		}
		if (array[targetI][targetJ] == 1) {
//          System.out.println("Ŀ����ǽ��ʧ����");
			return false;
		}
		//�����������ո��������
		if (array[targetI][targetJ] == 5) {
//			System.out.println("�����ߣ�ʧ����");
			return false;
		}

		return true;
	}
	
	public static void showMaze(int[][] maze) {
		System.out.println("�õ�һ���⣺");
		for(int i = 0; i < maze.length; i ++) {
			for(int j = 0; j < maze[i].length; j ++) {
				if(j != maze[i].length - 1) {
					System.out.print(maze[i][j] + ",");
				}else {
					System.out.print(maze[i][j] + "\n");
				}
			}
		}
	}
	
}
