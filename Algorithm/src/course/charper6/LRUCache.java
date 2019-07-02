package course.charper6;

import java.util.HashMap;

/**
 * LRU（least recently used）算法
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
	 * 查询节点
	 * 并将查询的节点放入链表最后
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
	 * 插入节点
	 * 若不存在将节点放入链表最后，存在则刷新链表
	 * @param key
	 * @param value
	 */
	public void put(String key, String value){
		
	}
	
	/**
	 * 删除节点
	 * @param key
	 */
	public void remove(String key){
		
	}
	
	/**
	 * 刷新链表，将该节点放入链表最后
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
	 * 删除节点
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
	 * 尾部添加节点
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
