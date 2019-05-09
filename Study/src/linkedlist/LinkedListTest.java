package linkedlist;

/**
 * 自定义双向链表
 * @author cm
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.add("a1");
		list.add("b2");
		list.add("c3");
		list.add("d4");
		list.add("e5");
		list.remove("c3");
		System.out.println(list.toString());
	}
	
}
