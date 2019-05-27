package course.charper3;

import java.util.Arrays;

/**.
 * 优先队列：
 * 最大优先队列，无论入队顺序如何，都是当前最大的元素优先出队。
 * 最小优先队列，无论入队顺序如何，都是当前最小的元素优先出队。
 * 
 * 最大堆的堆顶是整个堆中的最大元素，最小堆的堆顶是整个堆中的最小元素，
 * 所以使用二叉堆可以实现优先队列。
 * 
 * 本程序使用最小堆完成最小优先队列的实现。
 * @author cm
 *
 */
public class PriorityQueue {
	
	private int[] array;
	
	private int size;
	
	public PriorityQueue() {
		array = new int[32];
	}
	
	/**
	 * 入队
	 * 将元素放入二叉堆最后一个位置，并做上浮
	 * @param value
	 */
	public void enQueue(int value) {
		if(size >= array.length) {
			resize();
		}
		array[size ++] = value;
		upAdjust();
	}
	
	/**
	 * 出队
	 * 将堆顶，也就是最大值出队，将最后一个元素放入堆顶，并做下沉
	 * @return
	 * @throws Exception
	 */
	public int deQueue() throws Exception {
		if(size <= 0) {
			throw new Exception("the queue is empty!");
		}
		int head = array[0];
		array[0] = array[-- size];
		downAdjust();
		return head;
	}
	
	/**
	 * 上浮
	 */
	private void upAdjust() {
		int childIndex = size - 1;
		int key = array[childIndex];
		int parentIndex = (childIndex - 1) / 2;
		while(childIndex > 0 && key < array[parentIndex]) {
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		array[childIndex] = key;
	}
	
	/**
	 * 下沉
	 */
	private void downAdjust() {
		int parentIndex = 0;
		int key = array[parentIndex];
		int childIndex = parentIndex * 2 + 1;
		while(childIndex < size - 1) {
			if(childIndex + 1 < size && array[childIndex + 1] < array[childIndex]) {
				childIndex ++;
			}
			if(array[childIndex] < key) {
				array[parentIndex] = array[childIndex];
				parentIndex = childIndex;
				childIndex = childIndex * 2 + 1;
			}else {
				break;
			}
		}
		array[parentIndex] = key;
	}
	
	/**
	 * 重构数组
	 */
	private void resize() {
		int newSize = this.size * 2;
		this.array = Arrays.copyOf(this.array, newSize);
	}
	
	private void show() {
		String showStr = "[";
		for(int i = 0; i < size; i ++) {
			if(i < size - 1) {
				showStr += array[i] + ",";
			}else {
				showStr += array[i];
			}
		}
		showStr += "]";
		System.out.println(showStr);
	}
	
	public static void main(String[] args) throws Exception {
		PriorityQueue queue = new PriorityQueue();
		queue.enQueue(10);
		queue.enQueue(3);
		queue.enQueue(5);
		queue.enQueue(2);
		queue.enQueue(7);
		queue.show();
		System.out.println(queue.deQueue());
		queue.show();
		System.out.println(queue.deQueue());
		queue.show();
	}

}
