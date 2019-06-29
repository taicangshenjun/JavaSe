package course.charper5;

import course.util.ArrayUtils;

/**
 * 发现特殊数字
 * @author cm
 *
 */
public class SpecialNumber {

	/**
	 * 求出1-100内99个不重复整数，所缺的那个
	 * @param num	数字范围
	 * @param sum	和
	 * @return
	 */
	public static int findLostNumber(int num, int sum){
		int originalSum = (1 + num) * num / 2;
		return originalSum - sum;
	}
	
	/**
	 * 一个数组中除了一个整数外，其他所有整数都出现了偶数次，找出这个整数
	 * 
	 * 异或运算，自己异或自己等于0，
	 * 根据异或运算的交换定律，一次异或数组所有的数字，剩下的就是出现奇数次的数字
	 * @param array
	 * @return
	 */
	public static int findAppearOddNumber(int[] numbers){
		int result = numbers[0];
		for(int i = 1; i < numbers.length; i ++){
			result = result ^ numbers[i];
		}
		return result;
	}
	
	/**
	 * 一个数组中有两个整数出现了奇数次，其他所有整数都出现了偶数次，找出这个两整数
	 * 
	 * 分治法：
	 * 所有元素做异或运算，得出的结果为两个整数的异或结果，
	 * 因为这两个整数不等，所以所得结果在二进制中，必然有一位或一位以上为1，即该位不相同，一个为0，一个为1
	 * 将整个数组以此分为两个子数组，并分别异或，及可得出所需结果。
	 * @param array
	 * @return
	 */
	public static int[] findAppearOddNumber2(int[] numbers){
		int xorResult = 0;
		for(int i = 0; i < numbers.length; i ++){
			xorResult ^= numbers[i];
		}
		int bitPos = 0;
		while(xorResult > 0){
			if((xorResult & 1) == 1){
				break;
			}
			xorResult = xorResult >> 1;
			bitPos ++;
		}
		
		int pivotIndex = getPosition(numbers, bitPos);

		int resultA = 0;
		for(int i = 0; i <= pivotIndex; i ++){
			resultA ^= numbers[i];
		}
		
		int resultB = 0;
		for(int i = pivotIndex + 1; i < numbers.length; i ++){
			resultB ^= numbers[i];
		}
		
		int[] resultArray = new int[]{
				resultA, resultB
		};
		return resultArray;
	}
	
	/**
	 * 
	 * @param numbers		待分治数组
	 * @param bitPos		第几位为1
	 * @return
	 */
	public static int getPosition(int[] numbers, int bitPos){
		int mark = 0;
		for(int i = 1; i < numbers.length; i ++){
			//该位为0
			if((numbers[i] >> bitPos & 1) == 0){
				int temp = numbers[i];
				numbers[i] = numbers[++ mark];
				numbers[mark] = temp;
			}
		}
		if((numbers[0] >> bitPos & 1) != 0){
			int temp = numbers[0];
			numbers[0] = numbers[mark];
			numbers[mark --] = temp;
			
		}
		return mark;
	}
	
	public static void main(String[] args) {
		int result = findLostNumber(100, 4994);
		System.out.println(result);
		
		int[] numbers = new int[]{
				3, 1, 3, 2, 4, 1, 4, 2, 6
		};
		System.out.println(findAppearOddNumber(numbers));
		
		int[] numbers2 = new int[]{
				4, 1, 10, 2, 2, 5, 1, 4, 38, 5
		};
		int[] resultArray = findAppearOddNumber2(numbers2);
		ArrayUtils.display(resultArray);
	}
	
}
