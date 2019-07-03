package course.charper5;

import course.entity.Node;

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
		while(index2 != null && index2.getNext() != null){
			index1 = index1.getNext();
			index2 = index2.getNext().getNext();
			if(index1 == index2){
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	/**
	 * 计算环的长度
	 * 第二次相遇node1走过的路程，追击问题node2第二次相遇比node1正好多走一圈，且回到起点
	 * node1在第二次相遇所在的点也是入环点
	 * @param head
	 * @return
	 */
	public static int calculateCycleLength(Node<Object> head) {
		Node<Object> node1 = head;
		Node<Object> node2 = head;
		boolean flag = false;
		while(node2 != null && node2.getNext() != null) {
			node1 = node1.getNext();
			node2 = node2.getNext().getNext();
			if(node1 == node2) {
				flag = true;
				break;
			}
		}
		if(flag) {
			int cycleLength = 0;
			do {
				node1 = node1.getNext();
				node2 = node2.getNext().getNext();
				cycleLength ++;
			}while(node1 != node2);
			return cycleLength;
		}else {
			return -1;
		}
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
		System.out.println("环长为：" + calculateCycleLength(node1));
	}
	
}
