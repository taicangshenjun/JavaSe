package course.charper6;

import java.util.ArrayList;
import java.util.List;

import course.entity.Grid;

/**
 * a星搜索算法
 * @author cm
 *
 */
public class AStarSearch {
	
	private static int[][] MAZE = new int[][]{
		{0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 1, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0}
	};

	public Grid aStarSearch(Grid startGrid, Grid endGrid){
		if(startGrid.equals(endGrid)){
			return startGrid;
		}
		List<Grid> openList = new ArrayList<Grid>();
		List<Grid> closeList = new ArrayList<Grid>();
		
		startGrid.initialize(endGrid, null);
		openList.add(startGrid);
		Grid minFGrid = findMinFGrid(openList);
		openList.remove(minFGrid);
		closeList.add(minFGrid);
		
		do{
			List<Grid> neightbors = findNeighborsGrid(minFGrid, endGrid);
			for(Grid grid: neightbors){
				if(!openList.contains(openList) && !closeList.contains(grid)){
					openList.add(grid);
				}
			}
			minFGrid = findMinFGrid(openList);
			if(endGrid.equals(minFGrid)){
				return minFGrid;
			}
			openList.remove(minFGrid);
			closeList.add(minFGrid);
		}while(!openList.isEmpty() && !endGrid.equals(minFGrid));
		
		return null;
	}
	
	public List<Grid> findNeighborsGrid(Grid parentGrid, Grid endGrid){
		int x = parentGrid.getX();
		int y = parentGrid.getY();
		List<Grid> neighbours = new ArrayList<Grid>();
		if(x - 1 >= 0 && MAZE[x - 1][y] != 1){
			Grid upGrid = new Grid(x - 1, y);
			upGrid.initialize(endGrid, parentGrid);
			neighbours.add(upGrid);
		}
		if(x + 1 < MAZE.length && MAZE[x + 1][y] != 1){
			Grid downGrid = new Grid(x + 1, y);
			downGrid.initialize(endGrid, parentGrid);
			neighbours.add(downGrid);
		}
		if(y - 1 >= 0 && MAZE[x][y - 1] != 1){
			Grid leftGrid = new Grid(x, y - 1);
			leftGrid.initialize(endGrid, parentGrid);
			neighbours.add(leftGrid);
		}
		if(y + 1 < MAZE[0].length && MAZE[x][y + 1] != 1){
			Grid rightGrid = new Grid(x, y + 1);
			rightGrid.initialize(endGrid, parentGrid);
			neighbours.add(rightGrid);
		}
		return neighbours;
	}
	
	/**
	 * 找出openList中F值最小的元素
	 * @param openList
	 * @return
	 */
	public Grid findMinFGrid(List<Grid> openList){
		int minFIndex = 0;
		for(int i = 1; i < openList.size(); i ++){
			if(openList.get(i).getF() < openList.get(minFIndex).getF()){
				minFIndex = i;
			}
		}
		return openList.get(minFIndex);
	}
	
	public void displayPath(Grid grid){
		int[][] array = new int[MAZE.length][MAZE[0].length];
		if(grid == null){
			System.out.println("无解");
			return;
		}
		do{
			array[grid.getX()][grid.getY()] = 1;
			grid = grid.getParent();
		}while((grid != null));
		for(int i = 0; i < array.length; i ++){
			for(int j = 0; j < array[i].length; j ++){
				if(array[i][j] != 1){
					System.out.print("- ");
				}else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		AStarSearch search = new AStarSearch();
		Grid startGrid = new Grid(2, 1);
		Grid endGrid = new Grid(2, 5);
		Grid result = search.aStarSearch(startGrid, endGrid);
		search.displayPath(result);
	}
	
}
