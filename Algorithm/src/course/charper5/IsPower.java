package course.charper5;

/**
 * 是否是2的幂次方
 * @author cm
 *
 */
public class IsPower {

	/**
	 * 使用位运算
	 * 2的幂次方的2进制为10000（16）
	 * 减1得1111
	 * 做与运算，得0说明是2的幂次
	 * @return
	 */
	public static boolean isPowerOf2(int num){
		return (num & num - 1) == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf2(3));
		System.out.println(isPowerOf2(7));
		System.out.println(isPowerOf2(8));
		System.out.println(isPowerOf2(15));
		System.out.println(isPowerOf2(256));
	}
	
}
