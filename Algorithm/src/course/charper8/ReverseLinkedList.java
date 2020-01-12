package course.charper8;

public class ReverseLinkedList {
	
	public static Node head;

	private static class Node{
		private int data;
		private Node next;
		
		private Node(int data) {
			this.data = data;
		}
	}
	
	public static void reverseLinkedList() {
		Node firstNode = head;
		Node preNode = head;
		Node curNode = preNode.next;
		while(curNode != null) {
			head = curNode;
			Node nextNode = curNode.next;
			curNode.next = preNode;
			if(nextNode != null) {
				preNode = curNode;
				curNode = nextNode;
			}else {
				break;
			}
		}
		firstNode.next = null;
	}
	
	public static void main(String[] args) {
		head = new Node(3);
		head.next = new Node(5);
		Node temp = head.next;
		temp.next = new Node(1);
		temp = temp.next;
		temp.next =	new Node(4);
		temp = temp.next;
		temp.next =	new Node(9);
		
		temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
		reverseLinkedList();
		
		temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
}
