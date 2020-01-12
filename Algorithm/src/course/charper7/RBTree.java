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
		//2.该节点是它父节点的右子节点，则它最近的，并在其左子树的最近的祖先节点
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
		
		//如果该节点没有左子树，则再分为两种情况
		//1.该节点是它父节点的右子节点，则它的父节点为最大节点
		//2.该节点是它父节点的左子节点，则它最近的，并在其左子树的最近的祖先节点
		RBTNode<T> y = x.parent;
		while(y != null && y.left == x) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y                
     *   /  \      --(左旋)-.            /  \          
     *  lx   y                          x   ry     
     *     /   \                       /  \
     *    ly   ry                     lx  ly  
	 * @param x
	 */
	private void leftRotate(RBTNode<T> x) {
		// 设置x的右孩子为y
        RBTNode<T> y = x.right;
        
        if(y == null)
        	return;

        // 将 “y的左孩子” 设为 “x的右孩子”；
        // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        // 将 “x的父亲” 设为 “y的父亲”
        y.parent = x.parent;

        if (x.parent == null) {
            this.rootNode = y;            // 如果 “x的父亲” 是空节点，则将y设为根节点
        } else {
            if (x.parent.left == x)
                x.parent.left = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
            else
                x.parent.right = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
        }

        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将 “x的父节点” 设为 “y”
        x.parent = y;
	}
	
	/**
	 * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x                  
     *         /  \      --(右旋)-.             /  \                     
     *        x   ry                           lx   y  
     *       / \                                   / \                   
     *      lx  rx                                rx  ry
     *      
     * 需要处理的是y-rx, rx-y, x-py, py-x, x-y, y-x的变换
	 * @param x
	 */
	private void rightRotate(RBTNode<T> y) {
		RBTNode<T> x = y.left;
		if(x == null)
			return;
		
		//y-rx
		y.left = x.right;
		//rx-y
		if(x.right != null)
			x.right.parent = y;
		
		//x-py
		x.parent = y.parent;
		
		if(y.parent == null) {
			this.rootNode = y.parent;
		}else {
			//py-x
			if(y.parent.left == y)
				y.parent.left = x;
			else
				y.parent.right = x;
		}
		//x-y
		x.right = y;
		//y-x
		y.parent = x;
	}
	
	/**
	 * 红黑树插入修正函数
     *
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     node 插入的结点        // 对应《算法导论》中的z
	 * @param node
	 */
	private void insertFixUp(RBTNode<T> node) {
		RBTNode<T> parent, gparent;
		
		//若父节点存在，并且父节点是红色
		while(((parent = parentOf(node)) != null) && isRed(parent)) {
			gparent = parentOf(parent);
			
			//若“父节点”是“祖父节点的左孩子”
			if(parent == gparent.left) {
				RBTNode<T> uncle = gparent.right;
				
				// Case 1条件：叔叔节点是红色
                if (uncle != null && isRed(uncle)) {
                	setRed(gparent);
                	setBlack(parent);
                    setBlack(uncle);
                    node = gparent;
                    continue;
                }
                
                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    leftRotate(parent);
                    RBTNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }
                
                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
			}else {//若“z的父节点”是“z的祖父节点的右孩子”
				RBTNode<T> uncle = gparent.left;
                
				// Case 1条件：叔叔节点是红色
				if(uncle != null && isRed(uncle)) {
					setRed(gparent);
					setBlack(parent);
					setBlack(uncle);
					node = gparent;
					continue;
				}
				
				// Case 2条件：叔叔是黑色，且当前节点是左孩子
				if(parent.left == node) {
					rightRotate(parent);
					RBTNode<T> temp = parent;
					parent = node;
					node = temp;
				}
				
				// Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
			}
		}
		
	}
	
	/**
	 * 将结点插入到红黑树中
     *
     * 参数说明：
     *     node 插入的结点        // 对应《算法导论》中的node
	 * @param node
	 */
	private void insert(RBTNode<T> node) {
		int cmp;
		RBTNode<T> x = this.rootNode;
		RBTNode<T> y = null;
		
		//找到父节点
		while(x != null) {
			y = x;
			cmp = node.key.compareTo(x.key);
			if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
		}
		node.parent = y;
		
		//确定是父节点的那个子节点
		if(y != null) {
			cmp = node.key.compareTo(y.key);
			if(cmp < 0)
				y.left = node;
			else
				y.right = node;
		}else {
			this.rootNode = node;
		}
		
		//设置颜色
		node.color = RED;
		
		//红黑树重新平衡
		insertFixUp(node);
	}
	
	/**
	 * 新建结点(key)，并将其插入到红黑树中
     *
     * 参数说明：
     *     key 插入结点的键值
	 * @param key
	 */
	public void insert(T key) {
		RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
		if(node != null)
			insert(node);
	}
	
	/**
	 * 红黑树删除修正函数
     *
     * 在从红黑树中删除插入节点之后(红黑树失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     node 待修正的节点
     *     
     * 判断类型的时候，先看待删除的节点的颜色，再看兄弟节点的颜色，
     * 再看侄子节点的颜色（侄子节点先看远侄子再看近侄子），最后看父亲节点的颜色。
	 * @param node
	 * @param parent
	 */
	private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
		RBTNode<T> other;

        while ((node == null || isBlack(node)) && (node != this.rootNode)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的  
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left == null || isBlack(other.left)) &&
                    (other.right == null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的  
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.right == null || isBlack(other.right)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。  
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.rootNode;
                    break;
                }
            } else {

                other = parent.left;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的  
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left == null || isBlack(other.left)) &&
                    (other.right == null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的  
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.left == null || isBlack(other.left)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。  
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.rootNode;
                    break;
                }
            }
        }

        if (node != null)
            setBlack(node);
	}
	
	/**
	 * 删除结点(node)，并返回被删除的结点
     *
     * 参数说明：
     *     node 删除的结点
	 * @param node
	 */
	private void remove(RBTNode<T> node) {
		RBTNode<T> child, parent;
		boolean color;
		
		//被删除节点的"左右孩子都不为空"的情况。
		if(node.left != null && node.right != null) {
			//被删节点的后继节点。(称为"取代节点")
            //用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
			RBTNode<T> replace = node;
			
			//获取后继节点
			replace = replace.right;
			while(replace.left != null)
				replace = replace.left;
			
			//"node节点"不是根节点(只有根节点不存在父节点)
			if(parentOf(node) != null) {
				if(parentOf(node).left == node)
					parentOf(node).left = replace;
				else
					parentOf(node).right = replace;
			}else {
				this.rootNode = replace;
			}
			
			//child是"取代节点"的右孩子，也是需要"调整的节点"。
            //"取代节点"肯定不存在左孩子！因为它是一个后继节点。
			child = replace.right;
			parent = parentOf(replace);
			//保存"取代节点"的颜色
			color = colorOf(replace);
			
			//"被删除节点"是"它的后继节点的父节点"
			if(parent == node) {
				parent = replace;
			}else {
				//child不为空
				if(child != null)
					setParent(child, parent);
				parent.left = child;
				
				replace.right = node.right;
				setParent(node.right, replace);
			}
			
			replace.parent = node.parent;
			replace.color = node.color;
			replace.left = node.left;
            node.left.parent = replace;

            if (color == BLACK)
                removeFixUp(child, parent);

            node = null;
            return ;
		}
		
		//对于一个子节点为null的子树，根据红黑树平衡，另一个节点一定时null或红节点
		//如节点是红色，一个子节点为null，另一个一定也为null
		//节点是黑色，一个子节点为null，另一个为红色无子节点的节点或，null
		if(node.left != null) {
			child = node.left;
		}else {
			child = node.right;
		}
		
		parent = node.parent;
		color = node.color;
		
		if(child != null)
			child.parent = parent;
		
		//"node节点"不是根节点
		if(parent != null) {
			if(parent.left == node)
				parent.left = child;
			else
				parent.right = child;
		}else {
			this.rootNode = child;
		}
		
		if(color == BLACK)
			removeFixUp(child, parent);
		node = null;
	}
	
	/**
	 * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明：
     *     tree 红黑树的根结点
     *     z 删除的结点
	 * @param key
	 */
	public void remove(T key) {
		RBTNode<T> node;
		if((node = search(this.rootNode, key)) != null)
			remove(node);
	}
	
	/**
	 * 销毁节点下所有子树
	 * @param node
	 */
	private void destroy(RBTNode<T> node) {
		if(node == null)
			return;
		
		if(node.left != null)
			destroy(node.left);
		if(node.right != null)
			destroy(node.right);
		
		node = null;
	}
	
	/**
	 * 清空红黑树
	 */
	public void clear() {
		destroy(this.rootNode);
		this.rootNode = null;
	}
	
	/**
	 * 打印“红黑树”
	 * @param node			
	 * @param key			节点的键值
	 * @param direction		0，表示该节点是根节点
	 * 						-1，表示是父节点的左孩子
	 * 						1，表示是父节点的右孩子
	 */
	private void print(RBTNode<T> node, T key, int direction) {
		if(node != null) {
			if(direction == 0)
				System.out.printf("%2d(B) is root\n", node.key);
			else
				System.out.printf("%2d(%s) is %2d's %6s child\n", node.key, isRed(node)?"R":"B", key, direction==1?"right" : "left");
			print(node.left, node.key, -1);
            print(node.right,node.key,  1);
		}
	}
	
	public void print() {
		if(this.rootNode != null)
			print(this.rootNode, this.rootNode.key, 0);
	}
	
	public static void main(String[] args) {
		RBTree<Integer> tree = new RBTree<Integer>();
		tree.insert(8);
		tree.insert(12);
		tree.insert(9);
		tree.insert(6);
		tree.print();
	}
	
}
