package geekTime.dataStructureAndAlgorithm.list;

/**
 * 基于单链表LRU算法
 * @author cm
 * @create 2020-01-12
 *
 */
public class LRUBaseLinkedList<T> {

	//链表容量
	private final static Integer DEFAULT_CAPACITY = 10;
	
	//头结点
	private SNode<T> headNode;
	
	//链表尺寸
	private Integer size;
	
	//链表容量
	private Integer capacity;
	
	public LRUBaseLinkedList() {
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
	
	public LRUBaseLinkedList(Integer capacity) {
		this.capacity = capacity;
		this.size = 0;
	}
	
	//添加元素
	public void add(T data) {
		SNode<T> preNode = findPreNode(data);
		//如果链表中本来存在
		if(preNode != null) {
			//删除该节点
			deleteElemOptim(preNode);
			//在头部插入
			insertElemAtBegin(data);
		}else {
			if(size >= capacity)
				deleteElemAtEnd();
			insertElemAtBegin(data);
		}
	}
	
	//删除preNode结点下一个元素
	private void deleteElemOptim(SNode<T> preNode) {
		SNode<T> curNode = preNode.getNext();
		preNode.setNext(curNode.getNext());
		curNode = null;
		size --;
	}
	
	//链表头部插入节点
	private void insertElemAtBegin(T data) {
		SNode<T> beforeheadNode = headNode;
		headNode = new SNode<T>(data);
		headNode.setNext(beforeheadNode);
		if(size < capacity)
			size ++;
		else
			deleteElemAtEnd();
	}
	
	//获取查找到元素的前一个结点
	private SNode<T> findPreNode(T data) {
		if(headNode == null)
			return null;
		SNode<T> node = headNode;
		while(node.getNext() != null) {
			if(node.getNext().getElement().equals(data))
				return node;
			node = node.getNext();
		}
		return null;
	}
	
	//删除尾结点
	private void deleteElemAtEnd() {
		if(headNode != null) {
			SNode<T> node = headNode;
			//倒数第二个节点
			SNode<T> preNode = null;
			while(node.getNext() != null) {
				preNode = node;
				node = node.getNext();
			}
			node = null;
			if(preNode != null) {
				preNode.setNext(node);
			}
			size --;
		}
			
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Array size: %d, capacity: %d", size, capacity));
		builder.append("[");
		SNode<T> node = headNode;
		while(node != null) {
			builder.append(node.getElement().toString()).append(", ");
			node = node.getNext();
		}
		if(builder.lastIndexOf(", ") == (builder.length() - 2))
			builder.delete(builder.length() - 2, builder.length());
		builder.append("]");
		return builder.toString();
	}



	@SuppressWarnings("hiding")
	public class SNode<T>{
		
		private T element;
		
		private SNode<T> next;
		
		public SNode(){
			this.element = null;
			this.next = null;
		}
		
		public SNode(T element) {
            this.element = element;
            this.next = null;
        }
		
		public SNode(T element, SNode<T> next) {
            this.element = element;
            this.next = next;
        }

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public SNode<T> getNext() {
			return next;
		}

		public void setNext(SNode<T> next) {
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) {
		LRUBaseLinkedList<String> lru = new LRUBaseLinkedList<String>(5);
		lru.add("111");
		lru.add("222");
		lru.add("333");
		lru.add("444");
		lru.add("555");
		lru.add("666");
		System.out.println(lru.toString());
	}
	
}
