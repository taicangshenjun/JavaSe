package course.chapter2;



public class MyChainTable<E> {
	
	private Node<E> first;
	
	private Node<E> last;
	
	private int size;
	
	public MyChainTable(){
		
	}
	
	public Node<E> add(E e){
		Node<E> node = new Node<E>(e);
		if(size == 0){
			node.setPrevious(node);
			node.setNext(node);
			this.first = node;
			this.last = node;
		}else{
			Node<E> preLast = this.last;
			node.setPrevious(preLast);
			node.setNext(this.first);
			
			preLast.setNext(node);
			this.first.setPrevious(node);
			this.last = node;
		}
		size ++;
		return node;
	}
	
	public Node<E> add(E e, int index){
		if(index < 0 || index > size){
			throw new RuntimeException("³¬³ö·¶Î§£¡");
		}
		Node<E> node = new Node<E>(e);
		if(index < size){
			Node<E> sourceNode = get(index);
			System.out.println(index + "," + sourceNode);
			Node<E> prevNode = sourceNode.getPrevious();
			node.setPrevious(prevNode);
			node.setNext(sourceNode);
			
			prevNode.setNext(node);
			sourceNode.setPrevious(node);
			
			if(index == 0){
				this.first = node;
			}
			if(index == size - 1){
				this.last = node;
			}
			
			size ++;
		}else{
			add(e);
		}
		return node;
	}
	
	public Node<E> remove(int index){
		if(index < 0 || index >= size){
			throw new RuntimeException("³¬³ö·¶Î§£¡");
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
			if(size == 1){
				this.last = null;
			}else{
				preNode.setNext(nextNode);
				nextNode.setPrevious(preNode);
				this.last = preNode;
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
			throw new RuntimeException("³¬³ö·¶Î§£¡");
		}
		int circumNum = index;
		Node<E> result = null;
		if(index < this.size / 2){
			result = this.first;
			for(int i = 0; i < circumNum; i ++){
				result = result.getNext();
			}
		}else{
			result = this.last;
			circumNum = this.size - circumNum - 1;
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
	
	public static void main(String[] args) {
		MyChainTable<String> myChain = new MyChainTable<String>();
		myChain.add("a");
		myChain.add("b");
		myChain.add("c");
		myChain.add("d");
		myChain.add("e");
		myChain.add("z", 5);
		System.out.println(myChain.toString());
		myChain.remove(2);
		System.out.println(myChain.toString());
		myChain.remove(0);
		System.out.println(myChain.toString());
		myChain.remove(3);
		System.out.println(myChain.toString());
		myChain.remove(1);
		System.out.println(myChain.toString());
	}
	
}
