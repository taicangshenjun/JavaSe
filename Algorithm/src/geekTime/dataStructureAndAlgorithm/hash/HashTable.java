package geekTime.dataStructureAndAlgorithm.hash;

/**
 * 散列表
 * @author cm
 *
 * @param <K>	键
 * @param <V>	值
 */
public class HashTable<K, V> {

	//默认容量
	private static final int DEFAULT_CAPACITY = 16;
	
	//装载因子
	private static final float LOAD_FACTOR = 0.75f;
	
	//初始散列数组
	private Entry<K, V>[] table;
	
	//实际数组尺寸
	private int size = 0;
	
	//数组中实际用到的（及不为空）的数量
	private int use = 0;
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		this.table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		this.table = (Entry<K, V>[]) new Entry[capacity];
	}
	
	/**
	 * 新增
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		//计算数组下标
		int index = hash(key);
		//如果存在key
		if(table[index] == null) {
			table[index] = new Entry<K, V>(null, null, null);
		}
		if(table[index].next != null) {
			Entry<K, V> entry = table[index];
			do {
				entry = entry.next;
				if(entry.key.equals(key)) {
					entry.value = value;
					return ;
				}
			}while(entry.next != null);
			
			Entry<K, V> proEntry = table[index].next;
			table[index].next = new Entry<K, V>(key, value, proEntry);
			size ++;
		}else {
			table[index].next = new Entry<K, V>(key, value, null);
			size ++;
			use ++;
			if(use >= table.length * LOAD_FACTOR) {
				resize();
			}
		}
	}
	
	/**
	 * 删除
	 * @param key
	 */
	public void remove(K key) {
		int index = hash(key);
		if(table[index] == null || table[index].next == null) {
			return ;
		}
		Entry<K, V> pre = table[index];
		Entry<K, V> entry = pre.next;
		do {
			pre = pre.next;
			entry = entry.next;
			if(entry.key.equals(key)) {
				pre.next = entry.next;
				size --;
				if(table[index].next == null) {
					use --;
				}
			}
		}while(entry.next != null);
	}
	
	/**
	 * 查找
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int index = hash(key);
		if(table[index] != null && table[index].next != null) {
			Entry<K, V> entry = table[index];
			while(entry.next != null) {
				entry = entry.next;
				if(entry.key.equals(key)) {
					return entry.value;
				}
			}
		}
		return null;
	}
	
	/**
	 * 计算key哈希值
	 * @param key
	 * @return
	 */
	private int hash(K key) {
		int h;
		return key != null? ((h = key.hashCode()) ^ (h >>> 16)) % table.length: 0;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		Entry<K, V>[] oldTable = table;
		table = (Entry<K, V>[]) new Entry[table.length * 2];
		use = 0;
		for(int i = 0; i < oldTable.length; i ++) {
			if(oldTable[i] == null) {
				continue;
			}
			Entry<K, V> entry = oldTable[i];
			while(entry.next != null) {
				entry = entry.next;
				int index = hash(entry.key);
				if(table[index] == null) {
					table[index] = new Entry<K, V>(null, null, null);
					use ++;
				}
				table[index].next = new Entry<K, V>(entry.key, entry.value, table[index].next);
			}
		}
	}
	
	@SuppressWarnings("hiding")
	public class Entry<K, V>{
		
		private K key;
		
		private V value;
		
		private Entry<K, V> next;
		
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
}
