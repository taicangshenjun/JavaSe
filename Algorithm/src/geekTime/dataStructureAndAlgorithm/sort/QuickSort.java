package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

import geekTime.dataStructureAndAlgorithm.util.ArrayUtils;

/**
 * ��������
 * @author cm
 *
 */
public class QuickSort {

	/**
	 * ���򷽷�
	 * @param array
	 */
	public static void sort(int[] array) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		quickSort(array, 0, array.length - 1);
	}
	
	/**
	 * �ݹ���ú���
	 * �����ݹ���������ʼ�±���ڻ���ڽ����±�
	 * @param array		����������
	 * @param start		��ʼ�±�
	 * @param end		�����±�
	 */
	private static void quickSort(int[] array, int start, int end) {
		if(start >= end) {
			return ;
		}
		int index = findIndex(array, start, end);
		if(index - start > 1) {
			quickSort(array, start, index - 1);
		}
		if(end - index > 1) {
			quickSort(array, index + 1, end);
		}
	}
	
	/**
	 * ��array[start]Ϊ��׼���������Ϊ���ȫ��С�ڻ�׼���ұ�ȫ�����ڻ�׼������
	 * @param array		����������
	 * @param start		��ʼ�±�
	 * @param end		�����±�
	 * @return			���ػ�׼�������±�
	 */
	private static int findIndex(int[] array, int start, int end) {
		int index = start;
		int pivot = array[index];
		for(int i = start + 1; i <= end; i ++) {
			if(array[i] < pivot) {
				int temp = array[i];
				array[i] = array[++ index];
				array[index] = temp;
			}
		}
		array[start] = array[index];
		array[index] = pivot;
		return index;
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
		System.out.println(Arrays.toString(array));
		QuickSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
