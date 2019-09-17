package course.charper8;

import java.util.Arrays;

/**
 * 寻找数组中第k大的数字
 * @author cm
 *
 */
public class FindKBigNumber {
	
	/**
	 * 构建二叉堆
	 * @param array
	 */
	public static void buildHeap(int[] array) {
		int length = array.length;
		for(int i = (length - 2) / 2; i >= 0; i --) {
			downAdjust(array, i, length);
		}
	}
	
	/**
	 * 下沉操作
	 * @param array
	 * @param parentIndex
	 * @param length
	 */
	public static void downAdjust(int[] array, int parentIndex, int length) {
		int childIndex = parentIndex * 2 + 1;
		int key = array[parentIndex];
		while(childIndex < length) {
			if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
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
	
	public static int findKBigNumer(int[] array, int k) {
		if(k < 1 || k > array.length) {
			System.out.println("k值错误，无法查询！");
			return -1;
		}
		int[] heapArr = Arrays.copyOfRange(array, 0, k);
		buildHeap(heapArr);
		int heapLength = heapArr.length;
		for(int i = k; i < array.length; i ++) {
			if(heapArr[0] < array[i]) {
				heapArr[0] = array[i];
				downAdjust(heapArr, 0, heapLength);
			}
		}
		return heapArr[0];
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {
				7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8
		};
		int k = 6;
		System.out.println(Arrays.toString(array));
		buildHeap(array);
		System.out.println(Arrays.toString(array));
		int result = findKBigNumer(array, k);
		System.out.println(result);
	}

}
