package course.charper5;

import course.chapter2.Node;

/**
 * 判断链表是否有环
 * @author cm
 *
 */
public class ChainCycle {
	
	/**
	 * 判断是否有环
	 * 利用数学里面环形跑道追击思想，如果一个人速度为1，另一个人速度为2，那么在环形赛道上两人必将相遇
	 * @param head
	 * @return
	 */
	public static boolean isCycle(Node<Object> head){
		boolean flag = false;
		Node<Object> index1 = head;
		Node<Object> index2 = head;
		while(head != null && head.getNext() != null){
			index1 = index1.getNext();
			index2 = index2.getNext().getNext();
			if(index1 == index2){
				flag = true;
				break;
			}
		}
		
		return flag;
	}

	public static void main(String[] args) {
		Node<Object> node1 = new Node<Object>(5);
		Node<Object> node2 = new Node<Object>(2);
		Node<Object> node3 = new Node<Object>(7);
		Node<Object> node4 = new Node<Object>(2);
		Node<Object> node5 = new Node<Object>(6);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node2);
		System.out.println("是否有环：" + isCycle(node1));
	}
	
}
