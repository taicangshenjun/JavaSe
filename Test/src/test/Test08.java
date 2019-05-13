package test;

/**
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 * @author cm
 *
 */
public class Test08 {

	public static void main(String[] args) {
		int a = 3;
		int n = 5;
		int b = a;
		int sum = 0;
		for(int i = 0; i < n; i ++){
			sum += a;
			a = a * 10 + b;
		}
		System.out.println(sum);
	}
	
}
