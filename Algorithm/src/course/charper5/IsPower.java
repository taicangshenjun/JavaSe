package course.charper5;

/**
 * �Ƿ���2���ݴη�
 * @author cm
 *
 */
public class IsPower {

	/**
	 * ʹ��λ����
	 * 2���ݴη���2����Ϊ10000��16��
	 * ��1��1111
	 * �������㣬��0˵����2���ݴ�
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
