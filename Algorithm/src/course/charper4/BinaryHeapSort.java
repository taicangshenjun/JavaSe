package course.charper4;

import course.util.ArrayUtils;

/**
 * 堆排序
 * 本类中使用最大堆实现数组的生序排序
 * @author cm
 *
 */
public class BinaryHeapSort {
	
	/**
	 * 构建二叉堆
	 * @param array
	 */
	public static void buildHeap(int[] array){
		for(int i = (array.length - 2) / 2; i >= 0; i --){
			downAdjust(array, i, array.length);
		}
	}
	
	/**
	 * 二叉堆下沉
	 * @param array
	 * @param parentIndex
	 */
	public static void downAdjust(int[] array, int parentIndex, int length){
		//左子节点
		int childIndex = parentIndex * 2 + 1;
		int key = array[parentIndex];
		while(childIndex < length){
			//如果存在右子节点，且比左子节点大，使用右子节点与父节点比较
			if(childIndex < length - 1 && array[childIndex + 1] > array[childIndex]){
				childIndex ++;
			}
			
			if(key < array[childIndex]){
				 array[parentIndex] = array[childIndex];
				 parentIndex = childIndex;
				 childIndex = childIndex * 2 + 1;
			}else{
				break;
			}
		}
		array[parentIndex] = key;
	}
	
	/**
	 * 二叉堆排序方法
	 * @param array
	 */
	public static void sort(int[] array){
		int length = array.length;
		for(int i = array.length - 1; i > 0; i --){
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			downAdjust(array, 0, -- length);
		}
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
//		int[] array = new int[]{
//				32,4,33,15,48,36,39,93,78,91
//		};
		ArrayUtils.display(array);
		buildHeap(array);
		ArrayUtils.display(array);
		sort(array);
		ArrayUtils.display(array);
	}

}
