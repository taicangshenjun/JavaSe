package geekTime.dataStructureAndAlgorithm.list;

/**
 * ���ڵ�����LRU�㷨
 * @author cm
 * @create 2020-01-12
 *
 */
public class LRUBaseLinkedList<T> {

	//��������
	private final static Integer DEFAULT_CAPACITY = 10;
	
	//ͷ���
	private SNode<T> headNode;
	
	//����ߴ�
	private Integer size;
	
	//��������
	private Integer capacity;
	
	public LRUBaseLinkedList() {
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
	
	public LRUBaseLinkedList(Integer capacity) {
		this.capacity = capacity;
		this.size = 0;
	}
	
	//���Ԫ��
	public void add(T data) {
		SNode<T> preNode = findPreNode(data);
		//��������б�������
		if(preNode != null) {
			//ɾ���ýڵ�
			deleteElemOptim(preNode);
			//��ͷ������
			insertElemAtBegin(data);
		}else {
			if(size >= capacity)
				deleteElemAtEnd();
			insertElemAtBegin(data);
		}
	}
	
	//ɾ��preNode�����һ��Ԫ��
	private void deleteElemOptim(SNode<T> preNode) {
		SNode<T> curNode = preNode.getNext();
		preNode.setNext(curNode.getNext());
		curNode = null;
		size --;
	}
	
	//����ͷ������ڵ�
	private void insertElemAtBegin(T data) {
		SNode<T> beforeheadNode = headNode;
		headNode = new SNode<T>(data);
		headNode.setNext(beforeheadNode);
		if(size < capacity)
			size ++;
		else
			deleteElemAtEnd();
	}
	
	//��ȡ���ҵ�Ԫ�ص�ǰһ�����
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
	
	//ɾ��β���
	private void deleteElemAtEnd() {
		if(headNode != null) {
			SNode<T> node = headNode;
			//�����ڶ����ڵ�
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
