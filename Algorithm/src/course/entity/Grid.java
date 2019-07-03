package course.entity;

/**
 * �Թ���
 * @author cm
 *
 */
public class Grid {

	/**
	 * ������
	 */
	private int x;
	
	/**
	 * ������
	 */
	private int y;
	
	/**
	 * �ۺ�������f = g + h
	 */
	private int f;
	
	/**
	 * ����㵽��ǰλ�õĲ���
	 */
	private int g;
	
	/**
	 * ���ϰ��£��ӵ�ǰλ�õ��յ�Ĳ���
	 */
	private int h;
	
	/**
	 * ���ڵ�
	 */
	private Grid parent;
	
	public Grid(){
		
	}
	
	public Grid(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void initialize(Grid endGrid, Grid parentGrid){
		if(parent == null){
			this.setG(0);
		}else{
			this.setG(this.getParent().getG() + 1);
		}
		this.setH(Math.abs(this.getX() - endGrid.getX()) + Math.abs(this.getY() - endGrid.getY()));
		this.setF(this.getG() + this.getH());
		this.setParent(parentGrid);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj instanceof Grid){
			Grid grid = (Grid) obj;
			if(grid.getX() == this.getX() && grid.getY() == this.getY()){
				return true;
			}
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Grid getParent() {
		return parent;
	}

	public void setParent(Grid parent) {
		this.parent = parent;
	}
	
}
