package course.charper5;

/**
 * 求最大公约数
 * @author cm
 *
 */
public class GreatestCommonDivisor {
	
	/**
	 * 欧几里得算法（辗转相除法）
	 * 它的具体做法是：用较大数除以较小数，再用出现的余数（第一余数）去除除数，
	 * 再用出现的余数（第二余数）去除第一余数，如此反复，直到最后余数是0为止。
	 * 如果是求两个数的最大公约数，那么最后的除数就是这两个数的最大公约数。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getGreatestCommonDivisor(int a, int b){
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		while(a % b != 0){
			int temp = a;
			a = b;
			b = temp % b;
		}
		return b;
	}
	
	/**
	 * 更相减损术
	 * 以较大的数减较小的数，接着把所得的差与较小的数比较，并以大数减小数。继续这个操作，直到所得的减数和差相等为止。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getGreatestCommonDivisor2(int a, int b){
		if(a == b){
			return a;
		}
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		return getGreatestCommonDivisor2(b, a - b);
	}
	
	/**
	 * 利用位移运算计算
	 * 若a，b同为偶数，gcd(a, b) = 2 * gcd(a / 2, b / 2) = 2 * gcd(a >> 1, b >> 1)
	 * 若a，为偶数，b为奇数，gcd(a, b) = gcd(a / 2, b) = gcd(a >> 1, b)
	 * 若a，b同为奇数，则先做更相减损术，期差值必为偶数，gcd(a, b) = gcd(b, b - a)，然后继续
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getGreatestCommonDivisor3(int a, int b){
		if(a == b){
			return a;
		}
		if((a & 1) == 0 && (b & 1) == 0){
			return getGreatestCommonDivisor3(a >> 1, b >> 1) << 1;
		}else if((a & 1) == 0){
			return getGreatestCommonDivisor3(a >> 1, b);
		}else if((b & 1) == 0){
			return getGreatestCommonDivisor3(a, b >> 1);
		}else{
			if(a < b){
				int temp = a;
				a = b;
				b = temp;
			}
			return getGreatestCommonDivisor3(b, a - b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getGreatestCommonDivisor3(14, 270));
	}

}
