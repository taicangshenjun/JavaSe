package course.charper6;

import java.util.HashMap;

/**
 * LRU��least recently used���㷨
 * @author cm
 *
 */
public class LRUCache {
	
	private Node head;
	
	private Node end;
	
	private int limit;
	
	private HashMap<String, Node> hashMap;
	
	public LRUCache(int limit){
		this.limit = limit;
		hashMap = new HashMap<String, Node>();
	}
	
	/**
	 * ��ѯ�ڵ�
	 * ������ѯ�Ľڵ�����������
	 * @param key
	 * @return
	 */
	public String get(String key){
		Node node = hashMap.get(key);
		if(node != null){
			refreshNode(node);
			return node.value;
		}else{
			return null;
		}
	}
	
	/**
	 * ����ڵ�
	 * �������ڽ��ڵ����������󣬴�����ˢ������
	 * @param key
	 * @param value
	 */
	public void put(String key, String value){
		
	}
	
	/**
	 * ɾ���ڵ�
	 * @param key
	 */
	public void remove(String key){
		
	}
	
	/**
	 * ˢ���������ýڵ�����������
	 * @param node
	 */
	private void refreshNode(Node node){
		if(node == end){
			return;
		}
		removeNode(node);
		addNode(node);
	}
	
	/**
	 * ɾ���ڵ�
	 * @param node
	 * @return
	 */
	private String removeNode(Node node){
		if(node == head){
			head = node.next;
			head.pre = null;
		}
		if(node == end){
			end = node.pre;
			end.next = null;
		}
		if(node != head && node != end){
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		return node.key;
	}
	
	/**
	 * β����ӽڵ�
	 * @param node
	 */
	private void addNode(Node node){
		if(head == null){
			head = node;
		}
		if(end != null){
			end.next = node;
			node.pre = end;
			node.next = null;
		}
		end = node;
	}

	class Node{
		public Node(String key, String value){
			this.key = key;
			this.value = value;
		}
		public Node pre;
		public Node next;
		public String key;
		public String value;
	}
	
}
