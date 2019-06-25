package course.charper5;

import course.util.ArrayUtils;

/**
 * �ҳ�һ������������������ȫ���е���һ����
 * 
 * �ֵ����㷨
 * @author cm
 *
 */
public class FindNearestNumber {
	
	/**
	 * ������������������
	 * @param numbers
	 * @param index
	 */
	public static void reverse(int[] numbers, int index){
		for(int i = index, j = numbers.length - 1; i < j; i ++, j --){
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
	}
	
	/**
	 * ����������ǰһ��Ԫ�������������һ��Ԫ�ص�λ��
	 * @param numbers
	 * @param index
	 */
	public static void exchangeHead(int[] numbers, int index){
		if(index == 0){
			return;
		}
		int head = numbers[index - 1];
		for(int i = numbers.length - 1; i > 0; i --){
			if(numbers[i] > head){
				numbers[index - 1] = numbers[i];
				numbers[i] = head;
				break;
			}
		}
	}
	
	/**
	 * ȷ���������߽�
	 * @param numbers
	 * @return
	 */
	public static int findTransferPoint(int[] numbers){
		for(int i = numbers.length - 1; i > 0; i --){
			if(numbers[i] > numbers[i - 1]){
				return i; 
			}
		}
		return 0;
	}
	
	/**
	 * ������ת��Ϊ����
	 * @param num
	 * @return
	 */
	public static int[] intTransferArray(int num){
		int length = String.valueOf(num).length();
		int[] numbers = new int[length];
		do{
			numbers[-- length] = num % 10;
			num /= 10;
		}while(num > 0);
		return numbers;
	}
	
	public static void main(String[] args) {
//		int num = 163254;
		int num = 1239876;
		int[] numbers = intTransferArray(num);
		int index = findTransferPoint(numbers);
		exchangeHead(numbers, index);
		ArrayUtils.display(numbers);
		reverse(numbers, index);
		ArrayUtils.display(numbers);
	}

}
