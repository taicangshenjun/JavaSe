package test;

/**
 * ��ӡ�����е� "ˮ�ɻ��� "��
 * ��ν "ˮ�ɻ��� "��ָһ����λ�������λ���������͵��ڸ�������
 * ���磺153��һ�� "ˮ�ɻ��� "����Ϊ153=1�����η���5�����η���3�����η���
 * @author cm
 *
 */
public class Test03 {
	
	public static void main(String[] args) {
		for(int i = 100; i < 1000; i ++){
			int first = i / 100;
			int second = i / 10 % 10;
			int third = i % 10;
			if(i == first * first * first + second * second * second + third * third * third){
				System.out.println("ˮ�ɻ�����" + i);
			}
		}
	}

}
