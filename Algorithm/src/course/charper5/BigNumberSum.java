package course.charper5;

import java.util.Arrays;

import course.util.ArrayUtils;

/**
 * 计算两个超越long复制范围大整数相加
 * 
 * 思路：转化为两个int数组，然后从低位向高位依次相加
 * @author cm
 *
 */
public class BigNumberSum {
	
	public static int[] calculateSum(String numberA, String numberB){
		int length = numberA.length() > numberB.length()? numberA.length() + 1: numberB.length() + 1;
		int[] numbersA = intTransferArray(numberA, length);
		int[] numbersB = intTransferArray(numberB, length);
		int[] sumArray = new int[length];
		for(int i = length - 1; i > 0; i --){
			int sum = numbersA[i] + numbersB[i] + sumArray[i];
			sumArray[i] = sum % 10;
			sumArray[i - 1] = sum / 10;
		}
		int[] result = null;
		int from = 0;
		if(sumArray[0] == 0){
			from = 1;
		}
		result = Arrays.copyOfRange(sumArray, from, length);
		return result;
	}
	
	public static int[] intTransferArray(String num, int length){
		int[] numbers = new int[length];
		for(int i = num.length() - 1, index = length - 1; i >= 0; i --, index --){
			numbers[index] = Integer.parseInt(String.valueOf(num.charAt(i)));
		}
		return numbers;
	}
	
	public static void main(String[] args) {
		int[] result = calculateSum("426709752318", "95481253129");
		ArrayUtils.display(result);
	}

}
