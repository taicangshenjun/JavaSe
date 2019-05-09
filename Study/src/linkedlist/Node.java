package linkedlist;

public class Node<E> {

	//Êý¾ÝÓò
	public E data;
	
	public Node<E> next;
	
	public Node<E> previous;
	
	public Node() {
		
	}
	
	public Node(E data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.data + "";
	}

	@Override
	public boolean equals(Object obj) {
		return obj.toString().equals(this.toString());
	}
	
	
	
}
