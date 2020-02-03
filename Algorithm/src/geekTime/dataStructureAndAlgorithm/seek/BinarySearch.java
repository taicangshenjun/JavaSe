package geekTime.dataStructureAndAlgorithm.seek;

import java.util.Arrays;
import java.util.Random;

import geekTime.dataStructureAndAlgorithm.sort.QuickSort;
import geekTime.dataStructureAndAlgorithm.util.ArrayUtils;

/**
 * 二分查找法及其变种
 * @author cm
 *
 */
public class BinarySearch {

	/**
	 * 查找第一个值等于给定值的元素
	 * @param array
	 * @param target
	 * @return
	 */
	public static int indexOf(int[] array, int target) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid =  low + ((high - low) >> 1);
			if (array[mid] > target) {
				high = mid - 1;
			}else if(array[mid] < target) {
				low = mid + 1;
			}else {
				if ((mid == 0) || (array[mid - 1] != target)) {
					return mid;
				}else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找最后一个值等于给定值的元素
	 * @param array
	 * @param target
	 * @return
	 */
	public static int lastIndexOf(int[] array, int target) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		int low = 0;
		int high = array.length - 1;
		while(low <= high) {
			int mid = low + ((high - low) >> 1);
			if(target > array[mid]) {
				low = mid + 1;
			}else if(target < array[mid]) {
				high = mid - 1;
			}else {
				if(high == array.length - 1 || array[mid + 1] != target) {
					return mid;
				}else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找第一个大于等于给定值的元素
	 * @param array
	 * @param target
	 * @return
	 */
	public static int firstBigger(int[] array, int target) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		int low = 0;
		int high = array.length - 1;
		while(low <= high) {
			int mid = low + ((high - low) >> 1);
			if(array[mid] >= target) {
				if(mid == 0 || array[mid - 1] < target) {
					return mid;
				}else {
					high = mid - 1;
				}
			}else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 查找最后一个小于等于给定值的元素
	 * @param array
	 * @param target
	 * @return
	 */
	public static int lastSmaller(int[] array, int target) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		int low = 0;
		int high = array.length - 1;
		while(low <= high) {
			int mid = low + ((high - low) >> 1);
			if(array[mid] <= target) {
				if(mid == array.length - 1 || array[mid + 1] > target) {
					return mid;
				}else {
					low = mid + 1;
				}
			}else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
		QuickSort.sort(array);
		System.out.println(Arrays.toString(array));
		Random random = new Random();
		int num = random.nextInt(100);
		System.out.println("num: " + num);
		int result = BinarySearch.firstBigger(array, num);
		System.out.println("result: " + result);
	}
	
}
