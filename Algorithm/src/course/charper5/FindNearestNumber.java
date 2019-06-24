package course.charper5;

/**
 * 找出一个正整数的所有数字全排列的下一个数
 * 
 * 字典序算法
 * @author cm
 *
 */
public class FindNearestNumber {
	
	public static int findTransferPoint(int[] numbers){
		for(int i = numbers.length - 1; i > 0; i --){
			if(numbers[i] < numbers[i - 1]){
				return i - 1; 
			}
		}
		return 0;
	}
	
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
		int num = 163254;
	}

}
