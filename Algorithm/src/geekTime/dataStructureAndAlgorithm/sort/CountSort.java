package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

import geekTime.dataStructureAndAlgorithm.util.ArrayUtils;

/**
 * 计数排序
 * 只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。
 * 而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。
 * @author cm
 *
 */
public class CountSort {

	public static void sort(int[] array) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		int min = array[0];
		int max = array[0];
		for(int num: array) {
			if(num < min) {
				min = num;
			}
			if(num > max) {
				max = num;
			}
		}
		int[] countArray = new int[max - min + 1];
		for(int i = 0; i < array.length; i ++) {
			int index = array[i] - min;
			countArray[index] ++;
		}
		int index = 0;
		for(int i = 0; i < countArray.length; i ++) {
			int num = countArray[i];
			while(num > 0) {
				array[index ++] = i + min;
				num --;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
		System.out.println(Arrays.toString(array));
		QuickSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
