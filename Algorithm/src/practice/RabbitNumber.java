package practice;

/**
 * �ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
 * С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ�������
 * ��ÿ���µ���������Ϊ���٣�
 * @author cm
 *
 */
public class RabbitNumber {

	public static void main(String[] args) {
		calculateNumber(10);
	}
	
	
	public static void calculateNumber(int month) {
		//������ǰ����
		int twoMonthAgoNum = 1;
		//�ϸ�������
		int lastMonthNum = 1;
		//��������
		int currentNum = 1;
		for(int i = 1; i <= month; i ++) {
			if(i > 2) {
				twoMonthAgoNum = lastMonthNum;
				lastMonthNum = currentNum;
				currentNum = twoMonthAgoNum + lastMonthNum;
			}
			System.out.println("��" + i + "���¹������ӣ�" + currentNum + "�ԣ�");
		}
	}
	
}
