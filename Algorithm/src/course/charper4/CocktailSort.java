package course.charper4;

import course.util.ArrayUtils;

/**
 * ��β������
 * ������ð������Ľ��װ棬��˫��ð��
 * @author cm
 *
 */
public class CocktailSort {
	
	public static void sort(int[] array) {
		//�����������ƶ���Сֵ����߽�
		int leftIndex = 0;
		//�����������ƶ����ֵ���ұ߽�
		int rightIndex = array.length - 1;
		for(int i = 0; i < array.length / 2; i ++) {
			//����ð�����ֵ
			boolean flag = true;
			int rightBorderIndex = array.length - 1 - i;
			for(int j = leftIndex; j < rightIndex; j ++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					rightBorderIndex = j;
					flag = false;
				}
			}
			rightIndex = rightBorderIndex;
			if(flag) {
				break;
			}
			
			//����ð����Сֵ
			flag = true;
			int leftBorderIndex = 0;
			for(int j = rightIndex; j > leftIndex; j --) {
				if(array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					leftBorderIndex = j;
					flag = false;
				}
			}
			leftIndex = leftBorderIndex;
			//�����߽���ڵ����ұ߽磬����������ϣ����˳�ѭ��
			if(leftIndex >= rightIndex) {
				flag = true;
			}
			if(flag) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
//		int[] array = new int[] {
//				43,1,12,20,41,84,47,7,20,33
//		};
		ArrayUtils.display(array);
		sort(array);
		ArrayUtils.display(array);
	}

}
