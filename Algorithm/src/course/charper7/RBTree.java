package course.charper7;

/**
 * �����
 * @author cm
 *
 */
public class RBTree<T extends Comparable<T>> {
	
	//���ڵ�
	private RBTNode<T> rootNode;
	
	//��ɫ-�죬��boolean��������Ϊ�ռ�С
	private static final boolean RED = false;
	
	//��ɫ-��
	private static final boolean BLACK = true;

	//�ڵ���
	@SuppressWarnings("hiding")
	public class RBTNode<T extends Comparable<T>>{
		boolean color;
		T key;
		RBTNode<T> parent;
		RBTNode<T> left;
		RBTNode<T> right;
		
		public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
			this.key = key;
			this.color = color;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public T getKey() {
			return this.key;
		}
		
		@Override
		public String toString() {
			return "" + key + (this.color? "B": "(R)");
		}
	}
	
	public RBTree() {
		this.rootNode = null;
	}
	
	private RBTNode<T> parentOf	(RBTNode<T> node){
		return node != null? node.parent: null;
	}
	
	private boolean colorOf(RBTNode<T> node) {
        return node!=null? node.color: BLACK;
    }
	
	private boolean isRed(RBTNode<T> node) {
        return ((node != null) && (node.color == RED))? true :false;
    }
	
	private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }
	
	private void setBlack(RBTNode<T> node) {
		if(node != null)
			node.color = BLACK;
	}
	
	private void setRed(RBTNode<T> node) {
		if(node != null)
			node.color = RED;
	}
	
	private void setParent(RBTNode<T> node, RBTNode<T> parent) {
		if(node != null)
			node.parent = parent;
	}
	
	private void setColor(RBTNode<T> node, boolean color) {
		if(node != null) {
			node.color = color;
		}
	}
	
	/**
	 * ǰ�����
	 * @param node
	 */
	private void preOrder(RBTNode<T> node) {
		if(node != null) {
			System.out.print(node.key + "");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/**
	 * ǰ�����
	 */
	public void preOrder() {
		preOrder(this.rootNode);
	}
	
	/**
	 * �������
	 * @param node
	 */
	private void inOrder(RBTNode<T> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.key + "");
			inOrder(node.right);
		}
	}
	
	/**
	 * �������
	 */
	public void inOrder() {
		inOrder(this.rootNode);
	}
	
	/**
	 * �������
	 * @param node
	 */
	private void postOrder(RBTNode<T> node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.key + "");
		}
	}
	
	/**
	 * �������
	 */
	public void postOrder() {
		postOrder(this.rootNode);
	}
	
	/**
	 * (�ݹ�ʵ��)����"�����x"�м�ֵΪkey�Ľڵ�
	 * @param x
	 * @param key
	 * @return
	 */
	private RBTNode<T> search(RBTNode<T> x, T key){
		if(x == null)
			return x;
		
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return search(x.left, key);
		else if(cmp > 0)
			return search(x.right, key);
		else
			return x;
	}
	
	/**
	 * (�ݹ�ʵ��)����"�����x"�м�ֵΪkey�Ľڵ�
	 * @param key
	 * @return
	 */
	public RBTNode<T> search(T key){
		return search(this.rootNode, key);
	}
	
	/**
	 * (�ǵݹ�ʵ��)����"�����x"�м�ֵΪkey�Ľڵ�
	 * @param x
	 * @param key
	 * @return
	 */
	private RBTNode<T> iterativeSearch(RBTNode<T> x, T key){
		while(x != null) {
			int cmp = key.compareTo(x.key);
			
			if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
			else
				return x;
		}
		
		return x;
	}
	
	/**
	 * (�ǵݹ�ʵ��)����"�����x"�м�ֵΪkey�Ľڵ�
	 * @param key
	 * @return
	 */
	public RBTNode<T> iterativeSearch(T key){
		return iterativeSearch(this.rootNode, key);
	}
	
	/**
	 * ������nodeΪ���ڵ����С�ڵ�
	 * @param node
	 * @return
	 */
	private RBTNode<T> minimum(RBTNode<T> node){
		if(node == null) {
			return node;
		}
		while(node.left != null)
			node = node.left;
		return node;
	}
	
	/**
	 * ��������������С�ڵ�
	 * @return
	 */
	public T minimum(){
		RBTNode<T> node = minimum(this.rootNode);
		if(node == null)
			return null;
		return node.key;
	}
	
	/**
	 * ������nodeΪ���ڵ�����ڵ�
	 * @param node
	 * @return
	 */
	private RBTNode<T> maximum(RBTNode<T> node){
		if(node == null)
			return node;
		while(node.right != null)
			node = node.right;
		return node;
	}
	
	/**
	 * ���������������ڵ�
	 * @return
	 */
	public T maximum(){
		RBTNode<T> node = maximum(this.rootNode);
		if(node == null)
			return null;
		return node.key;
	}
	
	/**
	 * �ҽ��(x)�ĺ�̽�㡣��������"�����������ֵ���ڸý��"��"��С���"��
	 * @param x
	 * @return
	 */
	public RBTNode<T> successor(RBTNode<T> x){
		//����ýڵ���������������С�ڵ�������������С�ڵ�
		if(x.right != null)
			return minimum(x.right);
		
		//����ýڵ�û�������������ٷ�Ϊ�������
		//1.�ýڵ��������ڵ�����ӽڵ㣬�����ĸ��ڵ�Ϊ��С�ڵ�
		//2.�Ľڵ��������ڵ�����ӽڵ㣬��������ģ�����������������������Ƚڵ�
		RBTNode<T> y = x.parent;
		while(y != null && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * �ҽ��(x)��ǰ����㡣��������"�����������ֵС�ڸý��"��"�����"��
	 * @param x
	 * @return
	 */
	public RBTNode<T> predecessor(RBTNode<T> x){
		//����ýڵ����������������ڵ��������������ڵ�
		if(x.left != null)
			return maximum(x.left);
		
		RBTNode<T> y = x.parent;
		while(y != null && y.left == x) {
			x = y;
			y = y.parent;
		}
		return maximum(y.left);
	}
	
	
	
	
	
	
}
