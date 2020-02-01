package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

import geekTime.dataStructureAndAlgorithm.util.ArrayUtils;

/**
 * 基数排序，比如手机号码
 * @author cm
 *
 */
public class RadixSort {
	
	public static void sort(int[] array) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		radixSort(array);
		
	}
	
	/**
	 * 排序
	 * @param array
	 */
	private static void radixSort(int[] array) {
		int maxNumber = getMaxNumber(array);
		int divisor = 1;
		int[] bucket = new int[10];
		while(maxNumber / divisor > 0) {
			for(int num: array) {
				int index = num / divisor % 10;
				bucket[index] ++;
			}
			for(int i = 1; i < bucket.length; i ++) {
				bucket[i] += bucket[i - 1];
			}
			int[] result = new int[array.length];
			for(int i = array.length - 1; i >= 0; i --) {
				result[bucket[(array[i] / divisor) % 10] - 1] = array[i];
				bucket[(array[i] / divisor) % 10] --;
			}
			for(int i = 0; i < array.length; i ++) {
				array[i] = result[i];
			}
			bucket = new int[10];
			divisor *= 10;
		}
	}
	
	/**
	 * 获取最大值
	 * @param array
	 * @return
	 */
	private static int getMaxNumber(int[] array) {
		int maxNumber = array[0];
		for(int number: array) {
			if(number > maxNumber) {
				maxNumber = number;
			}
		}
		return maxNumber;
	}
	
    public static void main(String[] args) {
    	int[] array = ArrayUtils.createArray(10, 1000);
		System.out.println(Arrays.toString(array));
		RadixSort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
