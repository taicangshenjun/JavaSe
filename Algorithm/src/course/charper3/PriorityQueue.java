package course.charper3;

import java.util.Arrays;

/**.
 * ���ȶ��У�
 * ������ȶ��У��������˳����Σ����ǵ�ǰ����Ԫ�����ȳ��ӡ�
 * ��С���ȶ��У��������˳����Σ����ǵ�ǰ��С��Ԫ�����ȳ��ӡ�
 * 
 * ���ѵĶѶ����������е����Ԫ�أ���С�ѵĶѶ����������е���СԪ�أ�
 * ����ʹ�ö���ѿ���ʵ�����ȶ��С�
 * 
 * ������ʹ����С�������С���ȶ��е�ʵ�֡�
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
	 * ���
	 * ��Ԫ�ط����������һ��λ�ã������ϸ�
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
	 * ����
	 * ���Ѷ���Ҳ�������ֵ���ӣ������һ��Ԫ�ط���Ѷ��������³�
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
	 * �ϸ�
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
	 * �³�
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
	 * �ع�����
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
