package course.charper5;

/**
 * �����Լ��
 * @author cm
 *
 */
public class GreatestCommonDivisor {
	
	/**
	 * ŷ������㷨��շת�������
	 * ���ľ��������ǣ��ýϴ������Խ�С�������ó��ֵ���������һ������ȥ��������
	 * ���ó��ֵ��������ڶ�������ȥ����һ��������˷�����ֱ�����������0Ϊֹ��
	 * ������������������Լ������ô���ĳ��������������������Լ����
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
	 * ���������
	 * �Խϴ��������С���������Ű����õĲ����С�����Ƚϣ����Դ�����С�����������������ֱ�����õļ����Ͳ����Ϊֹ��
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
	 * ����λ���������
	 * ��a��bͬΪż����gcd(a, b) = 2 * gcd(a / 2, b / 2) = 2 * gcd(a >> 1, b >> 1)
	 * ��a��Ϊż����bΪ������gcd(a, b) = gcd(a / 2, b) = gcd(a >> 1, b)
	 * ��a��bͬΪ������������������������ڲ�ֵ��Ϊż����gcd(a, b) = gcd(b, b - a)��Ȼ�����
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
