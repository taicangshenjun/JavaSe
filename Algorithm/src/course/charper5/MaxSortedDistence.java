package course.charper5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import course.util.ArrayUtils;

/**
 * 计算有序数列相邻两个元素的最大差值
 * @author cm
 *
 */
public class MaxSortedDistence {

	/**
	 * 利用计数排序思想，在计数数组中，连续0的元素+1及为最大差值
	 * @param array
	 * @return
	 */
	public static int getMaxSortedDistence(int[] array){
		if(array.length < 2){
			return -1;
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
		int distence = 1;
		int result = 1;
		for(int i = 0; i < countArray.length; i ++){
			if(countArray[i] == 0){
				if(++ distence > result){
					result = distence;
				}
			}else{
				distence = 1;
			}
		}
		return result;
	}
	
	/**
	 * 优化算法
	 * 当数组类似{1, 10000, 10001}时，效率太差
	 * 使用桶排序思想计算最大差值
	 * @param array
	 * @return
	 */
	public static int getMaxSortedDistence2(int[] array){
		if(array.length < 2){
			return -1;
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
		double diff = (max - min) * 1.0 / (array.length - 1);
		List<LinkedList<Integer>> buckedList = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i < array.length; i ++){
			buckedList.add(new LinkedList<Integer>());
		}
		for(int i = 0; i < array.length; i ++){
			int index = (int) ((array[i] - min) / diff);
			buckedList.get(index).add(array[i]);
		}
		
		int result = 0;
		int preMax = buckedList.get(0).get(0);
		for(int i = 0; i < buckedList.size(); i ++){
			LinkedList<Integer> list = buckedList.get(i);
			if(list.size() > 0){
				int bMin = list.get(0);
				int bMax = list.get(0);
				for(Integer num : list){
					if(num < bMin){
						bMin = num;
					}
					if(num > bMax){
						bMax = num;
					}
				}
				if(bMin - preMax > result){
					result = bMin - preMax;
				}
				preMax = bMax;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(5, 20);
		ArrayUtils.display(array);
		int result = getMaxSortedDistence2(array);
		System.out.println(result);
	}
	
}
