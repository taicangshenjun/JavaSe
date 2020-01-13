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
		this.headNode = new SNode<T>();
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
	
	public LRUBaseLinkedList(Integer capacity) {
		this.headNode = new SNode<T>();
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
			if(size > capacity) {
				deleteElemAtEnd();
			}
			insertElemAtBegin(data);
		}
	}
	
	//删除preNode结点下一个元素
	private void deleteElemOptim(SNode<T> preNode) {
		SNode<T> curNode = preNode.getNext();
		preNode.setNext(curNode.getNext());
		curNode = null;
		if(size == capacity / 4 && capacity / 2 != 0)
			capacityShrink();
		else
			capacity --;
	}
	
	//链表头部插入节点
	private void insertElemAtBegin(T data) {
		
	}
	
	//获取查找到元素的前一个结点
	private SNode<T> findPreNode(T data) {
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
		
	}
	
	//扩容
	private void capacityExpand() {
		
	}
	
	//缩容
	private void capacityShrink() {
		
	}
	
	//
	private void printAll() {
		
	}
	
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
}
