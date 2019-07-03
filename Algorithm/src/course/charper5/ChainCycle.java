package course.charper5;

import course.entity.Node;

/**
 * �ж������Ƿ��л�
 * @author cm
 *
 */
public class ChainCycle {
	
	/**
	 * �ж��Ƿ��л�
	 * ������ѧ���滷���ܵ�׷��˼�룬���һ�����ٶ�Ϊ1����һ�����ٶ�Ϊ2����ô�ڻ������������˱ؽ�����
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
	 * ���㻷�ĳ���
	 * �ڶ�������node1�߹���·�̣�׷������node2�ڶ���������node1���ö���һȦ���һص����
	 * node1�ڵڶ����������ڵĵ�Ҳ���뻷��
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
		System.out.println("�Ƿ��л���" + isCycle(node1));
		System.out.println("����Ϊ��" + calculateCycleLength(node1));
	}
	
}
