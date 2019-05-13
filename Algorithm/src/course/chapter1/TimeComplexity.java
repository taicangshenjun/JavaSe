package course.chapter1;

/**
 * ʱ�临�Ӷ�T������ʱ�临�Ӷ�O
 * @author cm
 *
 */
public class TimeComplexity {

	public static void main(String[] args) {
		
	}
	
	/**
	 * ִ�д���Ϊ���ԣ�T(n) = 2n��T(n) = O(n)
	 * ÿ2���ӳԵ�1cm���
	 * @param n
	 */
	public static void eat1(int n){
		for(int i = 0; i < n; i ++){
			System.out.println("�ȴ�1min");
			System.out.println("�ȴ�1min");
			System.out.println("�Ե�1cm���");
		}
	}
	
	/**
	 * ִ�д���Ϊ������T(n) = 4 * logN��T(n) = O(logN)
	 * ÿ4���ӳԵ�һ�����
	 * @param n
	 */
	public static void eat2(int n){
		for(int i = n; i > 1; i /= 2){
			System.out.println("�ȴ�1min");
			System.out.println("�ȴ�1min");
			System.out.println("�ȴ�1min");
			System.out.println("�ȴ�1min");
			System.out.println("��һ�����");
		}
	}
	
	/**
	 * ִ�д���Ϊ������T(n) = n��T(n) = O(1)
	 * 1���ӳԵ�һ�����ȣ��������Ϊn
	 * @param n
	 */
	public static void eat3(int n){
		System.out.println("�ȴ�1min");
		System.out.println("�Ե�һ�����");
	}
	
	/**
	 * ִ�д���Ϊ����ʽ��T(n) = 0.5 * n ^ 2 + 0.5 * n��T(n) = O(n ^ 2)
	 * 1���ӳԵ�һ�����ȣ��������Ϊn
	 * @param n
	 */
	public static void eat4(int n){
		for(int i = 1; i <= n; i ++){
			for(int j = 1; j <= i; j ++){
				System.out.println("�ȴ�1min");
			}
			System.out.println("�Ե�һ�����");
		}
	}
	
}
