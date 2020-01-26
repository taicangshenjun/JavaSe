package geekTime.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

/**
 * ����
 * @author cm
 *
 */
public class Sorts {

	/**
	 * ð������
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int length = array.length;
		for(int i = 0; i < length - 1; i ++) {
			//�����Ƿ�������
			boolean flag = false;
			for(int j = 0; j < length - i - 1; j ++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = true;
				}
			}
			if(!flag)
				break;
		}
	}
	
	/**
	 * ð������Ľ�:��ÿһ��������¼���һ��Ԫ�ؽ�����λ��,��Ϊ�´αȽϵı߽�,
	 * ���ڱ߽����Ԫ�����´�ѭ��������Ƚ�.
	 * @param array
	 */
	public static void bubbleSort2(int[] array) {
		int length = array.length;
		//�Ƚϱ߽�ֵ��ֻ�Ƚϱ߽�ֵ֮ǰ��Ԫ��
		int border = length - 1;
		//��󽻻�λ��
		int lastExchange = border;
		for(int i = 0; i < length - 1; i ++) {
			//�����Ƿ�������
			boolean flag = false;
			for(int j = 0; j < border; j ++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = true;
					lastExchange = j;
				}
			}
			if(!flag)
				break;
			else
				border = lastExchange;
		}
	}
	
	/**
	 * ��������
	 * @param array
	 */
	public static void insertSort(int[] array) {
		for(int i = 1; i < array.length; i ++) {
			int value = array[i];
			int j = i - 1;
			for(; j >= 0; j --) {
				if(value < array[j]) {
					array[j + 1] = array[j];
				}else {
					break;
				}
			}
			array[j + 1] = value;
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {
			10, 9, 8, 3, 6, 2, 1, 7
		};
		Sorts.insertSort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
