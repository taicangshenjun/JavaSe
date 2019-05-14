package course.chapter2;

public class Node<E> {

	private E data;
	
	private Node<E> previous;
	
	private Node<E> next;
	
	public Node(E data){
		this.data = data;
	}
	
	@Override
	public String toString(){
		return data.toString();
	}

	public Node<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
	
}
