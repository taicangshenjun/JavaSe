package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * �鲢����
 * @author cm
 *
 */
public class MergeSort {

	public static void sort(int[] array) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is empty!");
		}
		mergeSort(array, 0, array.length - 1);
	}
	
	/**
	 * �ݹ����
	 * @param array		����������
	 * @param start		��ʼ����
	 * @param end		��������
	 */
	private static void mergeSort(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		//��ֹstart + endʱint��ΧԽ��
		int pivot = start + (end - start) / 2;
		mergeSort(array, 0, pivot);
		mergeSort(array, pivot + 1, end);
		merge(array, start, pivot, end);
	}
	
	/**
	 * �ںϺ������������Ϊarray[start, pivot], array[pivot + 1, end]�����֣�
	 * ���ҽ��������ְ�˳����������ʱ����temp�
	 * ���temp�����ݻ�ԭ�滻��ԭ����array��Ӧλ��
	 * @param array		����������
	 * @param start		��ʼ����
	 * @param pivot		�ֽ��
	 * @param end		��������
	 */
	private static void merge(int[] array, int start, int pivot, int end) {
		//��ʱ����
		int[] temp = new int[end - start + 1];
		//������������±�
		int leftIndex = start;
		//������������±�
		int rightIndex = pivot + 1;
		//��ʱ��������÷�ֹ�±�
		int index = 0;
		while(leftIndex <= pivot && rightIndex <= end) {
			if(array[leftIndex] <= array[rightIndex]) {
				temp[index ++] = array[leftIndex ++];
			}else {
				temp[index ++] = array[rightIndex ++];
			}
		}
		while(leftIndex <= pivot) {
			temp[index ++] = array[leftIndex ++];
		}
		while(rightIndex <= end) {
			temp[index ++] = array[rightIndex ++];
		}
		for(int i = 0; i < index; i ++) {
			array[start + i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {
				10, 9, 8, 3, 6, 2, 1, 7, 2, 5
		};
		MergeSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
