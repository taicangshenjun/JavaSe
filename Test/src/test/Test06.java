package test;

/**
 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * @author cm
 *
 */
public class Test06 {
	
	public static void main(String[] args) {
		Integer a = 36;
		Integer b = 27;
		Integer maxCommonFactor = getMaxCommonFactor(a, b);
		Integer minMultiple = getMinMultiple(a, b);
		System.out.println("最大公因数为：" + maxCommonFactor);
		System.out.println("最小公倍数为：" + minMultiple);
	}
	
	public static Integer getMaxCommonFactor(Integer a, Integer b){
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		Integer maxCommonFactor = null;
		for(int i = 2; i <= a / 2 + 1; i ++){
			if(a % i == 0 && b % i == 0){
				maxCommonFactor = i;
			}
		}
		return maxCommonFactor;
	}
	
	public static Integer getMinMultiple(Integer a, Integer b){
		Integer minMultiple = null;
		Integer maxCommonFactor = getMaxCommonFactor(a, b);
		if(maxCommonFactor != null){
			minMultiple = a * b / maxCommonFactor;
		}else{
			minMultiple = a * b;
		}
		return minMultiple;
	}

}
