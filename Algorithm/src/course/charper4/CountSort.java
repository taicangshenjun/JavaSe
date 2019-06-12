package course.charper4;

import course.util.ArrayUtils;

/**
 * 计数排序
 * 适用于一定范围内的整数排序
 * @author cm
 *
 */
public class CountSort {
	
	public static int[] sort(int[] array){
		if(array.length < 2){
			return array;
		}
		
		int min = array[0];
		int max = array[0];
		for(int i = 1; i < array.length; i ++){
			if(array[i] < min){
				min = array[i];
			}
			if(array[i] > max){
				max = array[i];
			}
		}
		
		int[] countArray = new int[max - min + 1];
		
		for(int i = 0; i < array.length; i ++){
			countArray[array[i] - min] ++;
		}
		
		int[] sortArray = new int[array.length];
		int index = 0;
		for(int i = 0; i < countArray.length; i ++){
			for(int j = 0; j < countArray[i]; j ++){
				sortArray[index ++] = i + min;
			}
		}
		return sortArray;
	}
	
	/**
	 * 优化排序
	 * 相比方法sort，优化算法可确定值一定时，先后顺序不发生改变
	 * @param array
	 * @return
	 */
	public static int[] sort2(int[] array){
		if(array.length < 2){
			return array;
		}
		
		int min = array[0];
		int max = array[0];
		for(int i = 1; i < array.length; i ++){
			if(array[i] < min){
				min = array[i];
			}
			if(array[i] > max){
				max = array[i];
			}
		}
		
		int[] countArray = new int[max - min + 1];
		
		for(int i = 0; i < array.length; i ++){
			for(int j = array[i] - min; j < countArray.length; j ++){
				countArray[j] ++;
			}
		}
		
		int[] result = new int[array.length];
		for(int i = array.length - 1; i >= 0; i --){
			result[-- countArray[array[i] - min]] = array[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10, 20);
		ArrayUtils.display(array);
		int[] result = sort2(array);
		ArrayUtils.display(result);
	}

}
