package course.charper5;

import course.util.ArrayUtils;

/**
 * 找出一个正整数的所有数字全排列的下一个数
 * 
 * 字典序算法
 * @author cm
 *
 */
public class FindNearestNumber {
	
	/**
	 * 逆序区进行升序排序
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
	 * 交换逆序区前一个元素与逆序区最后一个元素的位置
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
	 * 确定逆序区边界
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
	 * 将整数转化为数组
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
