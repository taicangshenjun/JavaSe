package test;

/**
 * ��Ŀ����s=a+aa+aaa+aaaa+aa...a��ֵ������a��һ�����֡�
 * ����2+22+222+2222+22222(��ʱ����5�������)������������м��̿��ơ�
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
