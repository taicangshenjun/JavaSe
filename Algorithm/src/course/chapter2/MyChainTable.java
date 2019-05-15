package course.chapter2;

import java.util.Collection;
import java.util.Iterator;

/**
 * 双向链表数据结构
 * @author cm
 * @param <E>
 */
public class MyChainTable<E> {
	
	//头元素
	private Node<E> first;
	
	//链表实际元素数量
	private int size;
	
	public MyChainTable(){
		
	}
	
	public MyChainTable(Collection<E> c){
		this.size = c.size();
		
		Iterator<E> iter = c.iterator();
		if(iter.hasNext()){
			E firstData = iter.next();
			this.first = new Node<E>(firstData);
			
			E data = firstData;
			Node<E> preNode = first;
			
			while(iter.hasNext()){
				data = iter.next();
				Node<E> node = new Node<E>(data);
				preNode.setNext(node);
				node.setPrevious(preNode);
				preNode = node;
			}
			
			preNode.setNext(this.first);
			this.first.setPrevious(preNode);
		}
		
	}
	
	public Node<E> add(E e){
		Node<E> node = new Node<E>(e);
		if(size == 0){
			node.setPrevious(node);
			node.setNext(node);
			this.first = node;
		}else{
			Node<E> preLast = this.first.getPrevious();
			node.setPrevious(preLast);
			node.setNext(this.first);
			
			preLast.setNext(node);
			this.first.setPrevious(node);
		}
		size ++;
		return node;
	}
	
	public Node<E> add(E e, int index){
		if(index < 0 || index > size){
			throw new RuntimeException("超出范围！");
		}
		Node<E> node = new Node<E>(e);
		if(index < size){
			Node<E> sourceNode = get(index);
			Node<E> prevNode = sourceNode.getPrevious();
			node.setPrevious(prevNode);
			node.setNext(sourceNode);
			
			prevNode.setNext(node);
			sourceNode.setPrevious(node);
			
			if(index == 0){
				this.first = node;
			}
			size ++;
		}else{
			add(e);
		}
		return node;
	}
	
	public Node<E> remove(int index){
		if(index < 0 || index >= size){
			throw new RuntimeException("超出范围！");
		}
		Node<E> node = get(index);
		Node<E> preNode = node.getPrevious();
		Node<E> nextNode = node.getNext();
		if(index == 0){
			if(size == 1){
				this.first = null;
			}else{
				preNode.setNext(nextNode);
				nextNode.setPrevious(preNode);
				this.first = nextNode;
			}
		}
		if(index == size - 1){
			if(size != 1){
				preNode.setNext(nextNode);
				nextNode.setPrevious(preNode);
			}
		}
		if(index >0 && index < size - 1){
			preNode.setNext(nextNode);
			nextNode.setPrevious(preNode);
		}
		size --;
		return node;
	}
	
	public Node<E> get(int index){
		if(index < 0 || index >= size){
			throw new RuntimeException("超出范围！");
		}
		int circumNum = index;
		Node<E> result = this.first;
		if(index < this.size / 2){
			for(int i = 0; i < circumNum; i ++){
				result = result.getNext();
			}
		}else{
			circumNum = this.size - circumNum;
			for(int i = 0; i < circumNum; i ++){
				result = result.getPrevious();
			}
		}
		return result;
	}
	
	@Override
	public String toString(){
		String result = "[";
		Node<E> node = this.first;
		for(int i = 0; i < this.size; i ++){
			result += node.toString() + ",";
			node = node.getNext();
		}
		result = result.lastIndexOf(",") > -1? result.substring(0, result.lastIndexOf(",")) + "]": result + "]";
		return result;
	}
	
}
