package course.charper5;

import java.util.Stack;

/**
 * 求一个数字，去掉k位后的最小值。
 * 
 * 贪心算法:
 * 利用局部最优解获取全局最优解
 * @author cm
 *
 */
public class GreedyAlgorithm {

	public static int[] intTransferArray(int num){
		int bitNum = String.valueOf(num).length();
		int[] numbers = new int[bitNum];
		while(num > 0){
			numbers[-- bitNum] = num % 10;
			num /= 10;
		}
		return numbers;
	}
	
	public static int removeDigits(int num, int k){
		int[] numbers = intTransferArray(num);
		int result = 0;
		if(k > numbers.length){
			result = -1;
		}else if(k < numbers.length){
			while(k -- > 0){
				for(int i = 0; i < numbers.length - 1; i ++){
					if(numbers[i] > numbers[i + 1]){
						numbers[i] = -1;
						break;
					}
				}
			}
			int multiplier = 1;
			for(int i = numbers.length - 1; i >= 0; i --){
				if(numbers[i] != -1){
					result += numbers[i] * multiplier;
					multiplier *= 10;
				}
			}
		}
		return result;
	}
	
	/**
	 * 利用栈的特性，不断比较数组和栈顶的大小
	 * @param num
	 * @param k
	 * @return
	 */
	public static int removeDigits2(int num, int k) {
		int[] numbers = intTransferArray(num);
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < numbers.length; i ++) {
			if(stack.isEmpty()) {
				stack.push(numbers[i]);
			}
			if(numbers[i] < stack.peek() && k > 0) {
				stack.pop();
				k --;
			}
			if(i > 0) {
				stack.push(numbers[i]);
			}
		}
		while(k -- > 0) {
			stack.pop();
		}
		
		int multiplier = 1;
		while(!stack.isEmpty()) {
			result += stack.pop() * multiplier;
			multiplier *= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(removeDigits(541270936, 3));
		System.out.println(removeDigits2(4123, 2));
	}
	
}
