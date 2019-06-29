package course.charper5;

import course.util.ArrayUtils;

/**
 * ������������
 * @author cm
 *
 */
public class SpecialNumber {

	/**
	 * ���1-100��99�����ظ���������ȱ���Ǹ�
	 * @param num	���ַ�Χ
	 * @param sum	��
	 * @return
	 */
	public static int findLostNumber(int num, int sum){
		int originalSum = (1 + num) * num / 2;
		return originalSum - sum;
	}
	
	/**
	 * һ�������г���һ�������⣬��������������������ż���Σ��ҳ��������
	 * 
	 * ������㣬�Լ�����Լ�����0��
	 * �����������Ľ������ɣ�һ������������е����֣�ʣ�µľ��ǳ��������ε�����
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
	 * һ�����������������������������Σ���������������������ż���Σ��ҳ����������
	 * 
	 * ���η���
	 * ����Ԫ����������㣬�ó��Ľ��Ϊ�����������������
	 * ��Ϊ�������������ȣ��������ý���ڶ������У���Ȼ��һλ��һλ����Ϊ1������λ����ͬ��һ��Ϊ0��һ��Ϊ1
	 * �����������Դ˷�Ϊ���������飬���ֱ���򣬼��ɵó���������
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
	 * @param numbers		����������
	 * @param bitPos		�ڼ�λΪ1
	 * @return
	 */
	public static int getPosition(int[] numbers, int bitPos){
		int mark = 0;
		for(int i = 1; i < numbers.length; i ++){
			//��λΪ0
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
