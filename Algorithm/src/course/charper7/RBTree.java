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
		//2.�ýڵ��������ڵ�����ӽڵ㣬��������ģ�����������������������Ƚڵ�
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
		
		//����ýڵ�û�������������ٷ�Ϊ�������
		//1.�ýڵ��������ڵ�����ӽڵ㣬�����ĸ��ڵ�Ϊ���ڵ�
		//2.�ýڵ��������ڵ�����ӽڵ㣬��������ģ�����������������������Ƚڵ�
		RBTNode<T> y = x.parent;
		while(y != null && y.left == x) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * �Ժ�����Ľڵ�(x)��������ת
     *
     * ����ʾ��ͼ(�Խڵ�x��������)��
     *      px                              px
     *     /                               /
     *    x                               y                
     *   /  \      --(����)-.            /  \          
     *  lx   y                          x   ry     
     *     /   \                       /  \
     *    ly   ry                     lx  ly  
	 * @param x
	 */
	private void leftRotate(RBTNode<T> x) {
		// ����x���Һ���Ϊy
        RBTNode<T> y = x.right;
        
        if(y == null)
        	return;

        // �� ��y�����ӡ� ��Ϊ ��x���Һ��ӡ���
        // ���y�����ӷǿգ��� ��x�� ��Ϊ ��y�����ӵĸ��ס�
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        // �� ��x�ĸ��ס� ��Ϊ ��y�ĸ��ס�
        y.parent = x.parent;

        if (x.parent == null) {
            this.rootNode = y;            // ��� ��x�ĸ��ס� �ǿսڵ㣬��y��Ϊ���ڵ�
        } else {
            if (x.parent.left == x)
                x.parent.left = y;    // ��� x�������ڵ�����ӣ���y��Ϊ��x�ĸ��ڵ�����ӡ�
            else
                x.parent.right = y;    // ��� x�������ڵ�����ӣ���y��Ϊ��x�ĸ��ڵ�����ӡ�
        }

        // �� ��x�� ��Ϊ ��y�����ӡ�
        y.left = x;
        // �� ��x�ĸ��ڵ㡱 ��Ϊ ��y��
        x.parent = y;
	}
	
	/**
	 * �Ժ�����Ľڵ�(y)��������ת
     *
     * ����ʾ��ͼ(�Խڵ�y��������)��
     *            py                               py
     *           /                                /
     *          y                                x                  
     *         /  \      --(����)-.             /  \                     
     *        x   ry                           lx   y  
     *       / \                                   / \                   
     *      lx  rx                                rx  ry
     *      
     * ��Ҫ�������y-rx, rx-y, x-py, py-x, x-y, y-x�ı任
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
	 * �����������������
     *
     * ���������в���ڵ�֮��(ʧȥƽ��)���ٵ��øú�����
     * Ŀ���ǽ������������һ�ź������
     *
     * ����˵����
     *     node ����Ľ��        // ��Ӧ���㷨���ۡ��е�z
	 * @param node
	 */
	private void insertFixUp(RBTNode<T> node) {
		RBTNode<T> parent, gparent;
		
		//�����ڵ���ڣ����Ҹ��ڵ��Ǻ�ɫ
		while(((parent = parentOf(node)) != null) && isRed(parent)) {
			gparent = parentOf(parent);
			
			//�������ڵ㡱�ǡ��游�ڵ�����ӡ�
			if(parent == gparent.left) {
				RBTNode<T> uncle = gparent.right;
				
				// Case 1����������ڵ��Ǻ�ɫ
                if (uncle != null && isRed(uncle)) {
                	setRed(gparent);
                	setBlack(parent);
                    setBlack(uncle);
                    node = gparent;
                    continue;
                }
                
                // Case 2�����������Ǻ�ɫ���ҵ�ǰ�ڵ����Һ���
                if (parent.right == node) {
                    leftRotate(parent);
                    RBTNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }
                
                // Case 3�����������Ǻ�ɫ���ҵ�ǰ�ڵ������ӡ�
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
			}else {//����z�ĸ��ڵ㡱�ǡ�z���游�ڵ���Һ��ӡ�
				RBTNode<T> uncle = gparent.left;
                
				// Case 1����������ڵ��Ǻ�ɫ
				if(uncle != null && isRed(uncle)) {
					setRed(gparent);
					setBlack(parent);
					setBlack(uncle);
					node = gparent;
					continue;
				}
				
				// Case 2�����������Ǻ�ɫ���ҵ�ǰ�ڵ�������
				if(parent.left == node) {
					rightRotate(parent);
					RBTNode<T> temp = parent;
					parent = node;
					node = temp;
				}
				
				// Case 3�����������Ǻ�ɫ���ҵ�ǰ�ڵ������ӡ�
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
			}
		}
		
	}
	
	/**
	 * �������뵽�������
     *
     * ����˵����
     *     node ����Ľ��        // ��Ӧ���㷨���ۡ��е�node
	 * @param node
	 */
	private void insert(RBTNode<T> node) {
		int cmp;
		RBTNode<T> x = this.rootNode;
		RBTNode<T> y = null;
		
		//�ҵ����ڵ�
		while(x != null) {
			y = x;
			cmp = node.key.compareTo(x.key);
			if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
		}
		node.parent = y;
		
		//ȷ���Ǹ��ڵ���Ǹ��ӽڵ�
		if(y != null) {
			cmp = node.key.compareTo(y.key);
			if(cmp < 0)
				y.left = node;
			else
				y.right = node;
		}else {
			this.rootNode = node;
		}
		
		//������ɫ
		node.color = RED;
		
		//���������ƽ��
		insertFixUp(node);
	}
	
	/**
	 * �½����(key)����������뵽�������
     *
     * ����˵����
     *     key ������ļ�ֵ
	 * @param key
	 */
	public void insert(T key) {
		RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
		if(node != null)
			insert(node);
	}
	
	/**
	 * �����ɾ����������
     *
     * �ڴӺ������ɾ������ڵ�֮��(�����ʧȥƽ��)���ٵ��øú�����
     * Ŀ���ǽ������������һ�ź������
     *
     * ����˵����
     *     node �������Ľڵ�
     *     
     * �ж����͵�ʱ���ȿ���ɾ���Ľڵ����ɫ���ٿ��ֵܽڵ����ɫ��
     * �ٿ�ֶ�ӽڵ����ɫ��ֶ�ӽڵ��ȿ�Զֶ���ٿ���ֶ�ӣ�����󿴸��׽ڵ����ɫ��
	 * @param node
	 * @param parent
	 */
	private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
		RBTNode<T> other;

        while ((node == null || isBlack(node)) && (node != this.rootNode)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    // Case 1: x���ֵ�w�Ǻ�ɫ��  
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left == null || isBlack(other.left)) &&
                    (other.right == null || isBlack(other.right))) {
                    // Case 2: x���ֵ�w�Ǻ�ɫ����w����������Ҳ���Ǻ�ɫ��  
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.right == null || isBlack(other.right)) {
                        // Case 3: x���ֵ�w�Ǻ�ɫ�ģ�����w�������Ǻ�ɫ���Һ���Ϊ��ɫ��  
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // Case 4: x���ֵ�w�Ǻ�ɫ�ģ�����w���Һ����Ǻ�ɫ�ģ�����������ɫ��
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
                    // Case 1: x���ֵ�w�Ǻ�ɫ��  
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left == null || isBlack(other.left)) &&
                    (other.right == null || isBlack(other.right))) {
                    // Case 2: x���ֵ�w�Ǻ�ɫ����w����������Ҳ���Ǻ�ɫ��  
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.left == null || isBlack(other.left)) {
                        // Case 3: x���ֵ�w�Ǻ�ɫ�ģ�����w�������Ǻ�ɫ���Һ���Ϊ��ɫ��  
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    // Case 4: x���ֵ�w�Ǻ�ɫ�ģ�����w���Һ����Ǻ�ɫ�ģ�����������ɫ��
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
	 * ɾ�����(node)�������ر�ɾ���Ľ��
     *
     * ����˵����
     *     node ɾ���Ľ��
	 * @param node
	 */
	private void remove(RBTNode<T> node) {
		RBTNode<T> child, parent;
		boolean color;
		
		//��ɾ���ڵ��"���Һ��Ӷ���Ϊ��"�������
		if(node.left != null && node.right != null) {
			//��ɾ�ڵ�ĺ�̽ڵ㡣(��Ϊ"ȡ���ڵ�")
            //������ȡ��"��ɾ�ڵ�"��λ�ã�Ȼ���ٽ�"��ɾ�ڵ�"ȥ����
			RBTNode<T> replace = node;
			
			//��ȡ��̽ڵ�
			replace = replace.right;
			while(replace.left != null)
				replace = replace.left;
			
			//"node�ڵ�"���Ǹ��ڵ�(ֻ�и��ڵ㲻���ڸ��ڵ�)
			if(parentOf(node) != null) {
				if(parentOf(node).left == node)
					parentOf(node).left = replace;
				else
					parentOf(node).right = replace;
			}else {
				this.rootNode = replace;
			}
			
			//child��"ȡ���ڵ�"���Һ��ӣ�Ҳ����Ҫ"�����Ľڵ�"��
            //"ȡ���ڵ�"�϶����������ӣ���Ϊ����һ����̽ڵ㡣
			child = replace.right;
			parent = parentOf(replace);
			//����"ȡ���ڵ�"����ɫ
			color = colorOf(replace);
			
			//"��ɾ���ڵ�"��"���ĺ�̽ڵ�ĸ��ڵ�"
			if(parent == node) {
				parent = replace;
			}else {
				//child��Ϊ��
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
		
		//����һ���ӽڵ�Ϊnull�����������ݺ����ƽ�⣬��һ���ڵ�һ��ʱnull���ڵ�
		//��ڵ��Ǻ�ɫ��һ���ӽڵ�Ϊnull����һ��һ��ҲΪnull
		//�ڵ��Ǻ�ɫ��һ���ӽڵ�Ϊnull����һ��Ϊ��ɫ���ӽڵ�Ľڵ��null
		if(node.left != null) {
			child = node.left;
		}else {
			child = node.right;
		}
		
		parent = node.parent;
		color = node.color;
		
		if(child != null)
			child.parent = parent;
		
		//"node�ڵ�"���Ǹ��ڵ�
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
	 * ɾ�����(z)�������ر�ɾ���Ľ��
     *
     * ����˵����
     *     tree ������ĸ����
     *     z ɾ���Ľ��
	 * @param key
	 */
	public void remove(T key) {
		RBTNode<T> node;
		if((node = search(this.rootNode, key)) != null)
			remove(node);
	}
	
	/**
	 * ���ٽڵ�����������
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
	 * ��պ����
	 */
	public void clear() {
		destroy(this.rootNode);
		this.rootNode = null;
	}
	
	/**
	 * ��ӡ���������
	 * @param node			
	 * @param key			�ڵ�ļ�ֵ
	 * @param direction		0����ʾ�ýڵ��Ǹ��ڵ�
	 * 						-1����ʾ�Ǹ��ڵ������
	 * 						1����ʾ�Ǹ��ڵ���Һ���
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
