package test;
/**
 * �ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
 * С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ�������
 * ��ÿ���µ���������Ϊ���٣�
 * 
 * �⣺
 * ����һ��쳲�������������
 * ����������1,1,2,3,5,8,13,21
 * ����ÿ��������������Ϊ������ǰ����������
 * ���ԣ�ÿһ�����ǰ����֮��
 * @author cm
 *
 */
public class Test01 {

	public static void main(String[] args) {
		int curNum = 1;
		int lastMonthNum = 0;
		for(int i = 1; i <= 10; i ++){
			if(i > 1){
				int temp = curNum;
				curNum += lastMonthNum;
				lastMonthNum = temp;
			}
			System.out.println("��" + i + "�£� ������" + curNum + "��");
		}
		
	}
	
}
