package course.chapter1;

/**
 * 时间复杂度T，渐进时间复杂度O
 * @author cm
 *
 */
public class TimeComplexity {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 执行次数为线性，T(n) = 2n，T(n) = O(n)
	 * 每2分钟吃掉1cm面包
	 * @param n
	 */
	public static void eat1(int n){
		for(int i = 0; i < n; i ++){
			System.out.println("等待1min");
			System.out.println("等待1min");
			System.out.println("吃掉1cm面包");
		}
	}
	
	/**
	 * 执行次数为对数，T(n) = 4 * logN，T(n) = O(logN)
	 * 每4分钟吃掉一半面包
	 * @param n
	 */
	public static void eat2(int n){
		for(int i = n; i > 1; i /= 2){
			System.out.println("等待1min");
			System.out.println("等待1min");
			System.out.println("等待1min");
			System.out.println("等待1min");
			System.out.println("吃一半面包");
		}
	}
	
	/**
	 * 执行次数为常量，T(n) = n，T(n) = O(1)
	 * 1分钟吃掉一个鸡腿，面包长度为n
	 * @param n
	 */
	public static void eat3(int n){
		System.out.println("等待1min");
		System.out.println("吃掉一个面包");
	}
	
	/**
	 * 执行次数为多项式，T(n) = 0.5 * n ^ 2 + 0.5 * n，T(n) = O(n ^ 2)
	 * 1分钟吃掉一个鸡腿，面包长度为n
	 * @param n
	 */
	public static void eat4(int n){
		for(int i = 1; i <= n; i ++){
			for(int j = 1; j <= i; j ++){
				System.out.println("等待1min");
			}
			System.out.println("吃掉一个面包");
		}
	}
	
}
