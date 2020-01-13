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
		this.headNode = new SNode<T>();
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
	
	public LRUBaseLinkedList(Integer capacity) {
		this.headNode = new SNode<T>();
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
			if(size > capacity) {
				deleteElemAtEnd();
			}
			insertElemAtBegin(data);
		}
	}
	
	//ɾ��preNode�����һ��Ԫ��
	private void deleteElemOptim(SNode<T> preNode) {
		SNode<T> curNode = preNode.getNext();
		preNode.setNext(curNode.getNext());
		curNode = null;
		if(size == capacity / 4 && capacity / 2 != 0)
			capacityShrink();
		else
			capacity --;
	}
	
	//����ͷ������ڵ�
	private void insertElemAtBegin(T data) {
		
	}
	
	//��ȡ���ҵ�Ԫ�ص�ǰһ�����
	private SNode<T> findPreNode(T data) {
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
		
	}
	
	//����
	private void capacityExpand() {
		
	}
	
	//����
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
