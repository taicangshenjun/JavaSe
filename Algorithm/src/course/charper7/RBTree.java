package course.charper7;

/**
 * 红黑树
 * @author cm
 *
 */
public class RBTree<T extends Comparable<T>> {
	
	//根节点
	private RBTNode<T> rootNode;
	
	//颜色-红，用boolean可能是因为空间小
	private static final boolean RED = false;
	
	//颜色-黑
	private static final boolean BLACK = true;

	//节点类
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
	 * 前序遍历
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
	 * 前序遍历
	 */
	public void preOrder() {
		preOrder(this.rootNode);
	}
	
	/**
	 * 中序遍历
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
	 * 中序遍历
	 */
	public void inOrder() {
		inOrder(this.rootNode);
	}
	
	/**
	 * 后序遍历
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
	 * 后序遍历
	 */
	public void postOrder() {
		postOrder(this.rootNode);
	}
	
	/**
	 * (递归实现)查找"红黑树x"中键值为key的节点
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
	 * (递归实现)查找"红黑树x"中键值为key的节点
	 * @param key
	 * @return
	 */
	public RBTNode<T> search(T key){
		return search(this.rootNode, key);
	}
	
	/**
	 * (非递归实现)查找"红黑树x"中键值为key的节点
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
	 * (非递归实现)查找"红黑树x"中键值为key的节点
	 * @param key
	 * @return
	 */
	public RBTNode<T> iterativeSearch(T key){
		return iterativeSearch(this.rootNode, key);
	}
	
	/**
	 * 查找以node为根节点的最小节点
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
	 * 查找整个树的最小节点
	 * @return
	 */
	public T minimum(){
		RBTNode<T> node = minimum(this.rootNode);
		if(node == null)
			return null;
		return node.key;
	}
	
	/**
	 * 查找以node为根节点的最大节点
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
	 * 查找整个树的最大节点
	 * @return
	 */
	public T maximum(){
		RBTNode<T> node = maximum(this.rootNode);
		if(node == null)
			return null;
		return node.key;
	}
	
	/**
	 * 找结点(x)的后继结点。即，查找"红黑树中数据值大于该结点"的"最小结点"。
	 * @param x
	 * @return
	 */
	public RBTNode<T> successor(RBTNode<T> x){
		//如果该节点有右子树，则最小节点是右子树中最小节点
		if(x.right != null)
			return minimum(x.right);
		
		//如果该节点没有右子树，则再分为两种情况
		//1.该节点是它父节点的左子节点，则它的父节点为最小节点
		//2.改节点是它父节点的右子节点，则它最近的，并在其左子树的最近的祖先节点
		RBTNode<T> y = x.parent;
		while(y != null && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * 找结点(x)的前驱结点。即，查找"红黑树中数据值小于该结点"的"最大结点"。
	 * @param x
	 * @return
	 */
	public RBTNode<T> predecessor(RBTNode<T> x){
		//如果该节点有左子树，则最大节点是左子树中最大节点
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
