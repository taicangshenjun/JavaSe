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
		Node node = hashMap.get(key);
		if(node != null) {
			node.value = value;
			refreshNode(node);
		}else {
			if(hashMap.size() >= limit) {
				remove(head.key);
			}
			Node newNode = new Node(key, value);
			hashMap.put(key, newNode);
			addNode(newNode);
		}
	}
	
	/**
	 * 删除节点
	 * @param key
	 */
	public void remove(String key){
		Node node = hashMap.get(key);
		if(node == null) {
			return;
		}
		hashMap.remove(node.key);
		removeNode(node);
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
	 * 删除链表节点
	 * @param node
	 * @return
	 */
	private String removeNode(Node node){
		if(node != head && node != end){
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		if(node == head){
			head = node.next;
			head.pre = null;
		}
		if(node == end){
			end = node.pre;
			end.next = null;
		}
		return node.key;
	}
	
	/**
	 * 链表尾部添加节点
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
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.put("001", "用户1信息");
		cache.put("002", "用户2信息");
		cache.put("003", "用户3信息");
		cache.put("004", "用户4信息");
		cache.put("005", "用户5信息");
		System.out.println(cache.get("002"));
		cache.put("002", "用户2信息更新");
		cache.put("006", "用户6信息");
		System.out.println(cache.get("001"));
		System.out.println(cache.get("002"));
		System.out.println(cache.get("006"));
	}
	
}
