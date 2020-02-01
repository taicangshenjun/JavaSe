package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

import geekTime.dataStructureAndAlgorithm.util.ArrayUtils;

/**
 * ��������
 * ֻ���������ݷ�Χ����ĳ����У�������ݷ�Χ k ��Ҫ��������� n ��ܶ࣬�Ͳ��ʺ��ü��������ˡ�
 * ���ң���������ֻ�ܸ��Ǹ������������Ҫ������������������͵ģ�Ҫ�����ڲ��ı���Դ�С������£�ת��Ϊ�Ǹ�������
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
