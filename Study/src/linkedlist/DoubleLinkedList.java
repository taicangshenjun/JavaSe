package linkedlist;

public class DoubleLinkedList<E> {

	//头结点
	private Node<E> first;
	//尾节点
	private Node<E> last;
	
	private long size;
	
	public DoubleLinkedList() {
		first = null;
		last = null;
	}
	
	//判断是否为空
	public boolean isEmpty() {
		return (first ==null);
	}
	
	public boolean add(E data) {
		Node<E> oldLast = last;
		Node<E> last = new Node<E>();
		last.data = data;
		last.next = null;
		if(size == 0L) {
			this.first = last;
			last.previous = null;
		} else {
			last.previous = oldLast;
			oldLast.next = last;
		}
		this.last = last;
		size ++;
		return true;
	}
	
	public boolean remove(E data) {
		Node<E> node = this.first;
		while(node.next != null) {
			if(node.equals(data)) {
				Node<E> previous = node.previous;
				Node<E> next = node.next;
				if(node == this.first) {
					this.first = next;
					next.previous = null;
				}else if(node == this.last) {
					this.last = previous;
					previous.next = null;
				}else {
					previous.next = next;
					next.previous = previous;
				}
				size --;
				break;
			}
			node = node.next;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		Node<E> node = first;
		for (int i = 0; i < size; i ++) {
			if(i < size - 1) {
				str.append(node + ",");
			}else {
				str.append(node);
			}
			node = node.next;
		}
		str.append("]");
		return str.toString();
	}

	public Node<E> getFirst() {
		return first;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	public Node<E> getLast() {
		return last;
	}

	public void setLast(Node<E> last) {
		this.last = last;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
}
