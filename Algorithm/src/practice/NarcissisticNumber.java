package practice;

/**
 * ��ӡ�����е� "ˮ�ɻ��� "��
 * ��ν "ˮ�ɻ��� "��ָһ����λ�������λ���������͵��ڸ�������
 * ���磺153��һ�� "ˮ�ɻ��� "����Ϊ153=1�����η���5�����η���3�����η���
 * @author cm
 *
 */
public class NarcissisticNumber {
	
	public static void main(String[] args) {
		for(int i = 100; i < 1000; i ++) {
			int a = i % 10;
			int b = i / 10 % 10;
			int c = i / 100;
			if(a*a*a+b*b*b+c*c*c==i) {
                System.out.println(i);
            }
		}
	}

}
