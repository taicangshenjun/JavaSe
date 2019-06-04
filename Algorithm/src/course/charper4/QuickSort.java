package course.charper4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import course.util.ArrayUtils;

/**
 * 快速排序
 * @author cm
 *
 */
public class QuickSort {

	/**
	 * 递归的方式实现快速排序
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	public static void sort(int[] array, int startIndex, int endIndex){
		if(startIndex >= endIndex){
			return;
		}
		int pivotIndex = partition2(array, startIndex, endIndex);
		sort(array, startIndex, pivotIndex - 1);
		sort(array, pivotIndex + 1, endIndex);
	}
	
	/**
	 * 非递归，使用栈的方式实现快速排序
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	public static void sort2(int[] array, int startIndex, int endIndex) {
		//
		Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
		//
		Map<String, Integer> rootParam = new HashMap<String, Integer>();
		rootParam.put("startIndex", startIndex);
		rootParam.put("endIndex", endIndex);
		quickSortStack.push(rootParam);
		
		while(quickSortStack.size() > 0) {
			Map<String, Integer> param = quickSortStack.pop();
			int leftIndex = param.get("startIndex");
			int rightIndex = param.get("endIndex");
			int pivot = partition(array, leftIndex, rightIndex);
			
			if(pivot > leftIndex + 1) {
				Map<String, Integer> leftParam = new HashMap<String, Integer>();
				leftParam.put("startIndex", leftIndex);
				leftParam.put("endIndex", pivot - 1);
				quickSortStack.push(leftParam);
			}
			if(pivot < rightIndex - 1) {
				Map<String, Integer> rightParam = new HashMap<String, Integer>();
				rightParam.put("startIndex", pivot + 1);
				rightParam.put("endIndex", rightIndex);
				quickSortStack.push(rightParam);
			}
		}
		
	}
	
	/**
	 * 双边循环法
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int partition(int[] array, int startIndex, int endIndex){
		int pivot = array[startIndex];
		int left = startIndex;
		int right = endIndex;
		while(left != right){
			while(left < right && array[right] >= pivot){
				right --;
			}
			while(left < right && array[left] <= pivot){
				left ++;
			}
			if(left < right){
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		array[startIndex] = array[left];
		array[left] = pivot;
		return left;
	}
	
	/**
	 * 单边循环法
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int partition2(int[] array, int startIndex, int endIndex){
		int pivot = array[startIndex];
		int mark = startIndex;
		int key = startIndex + 1;
		while(key <= endIndex){
			if(array[key] < pivot){
				int temp = array[key];
				array[key] = array[ ++ mark];
				array[mark] = temp;
			}
			key ++;
		}
		array[startIndex] = array[mark];
		array[mark] = pivot;
		return mark;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
//		int[] array = new int[]{
//				11,17,23,48,54,70,54,96,98,41
//		};
		ArrayUtils.display(array);
		sort2(array, 0, array.length - 1);
		ArrayUtils.display(array);
	}
	
}
