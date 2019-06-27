package course.charper5;

/**
 * �ڽ�����⣺
 * 
 * ��̬�滮
 * 
 * @author cm
 *
 */
public class DynamicProgramming {
	
	/**
	 * 
	 * @param worker	��������
	 * @param number	�������
	 * @param people	���ɽ�����蹤��
	 * @param gold		������
	 * @return
	 */
	public static int getBestGoldMining(int worker, int number, int[] people, int[] gold){
		//���������0�����߽����0���򷵻�0
		if(worker == 0 || number == 0){
			return 0;
		}
		//���������С�ڽ����������������ܷ�������һ��������������
		if(worker < people[number - 1]){
			return getBestGoldMining(worker, number - 1, people, gold);
		}
		//�ڲ��������һ������һ��������һ�������ѡ���������Ž�
		return Math.max(getBestGoldMining(worker, number - 1, people, gold), 
							getBestGoldMining(worker - people[number - 1], number - 1, people, gold) + gold[number - 1]);
	}
	
	/**
	 * 
	 * @param worker	��������
	 * @param people	���ɽ�����蹤��
	 * @param gold		������
	 * @return
	 */
	public static int getBestGoldMining2(int worker, int[] people, int[] gold){
		int[][] resultTable = new int[gold.length + 1][worker + 1];
		for(int i = 1; i <= gold.length; i ++){
			for(int j = 1; j <= worker; j ++){
				if(j < people[i - 1]){
					resultTable[i][j] = resultTable[i - 1][j];
				}else{
					resultTable[i][j] = Math.max(resultTable[i - 1][j], resultTable[i - 1][j - people[i - 1]] + gold[i - 1]);
				}
			}
		}
		return resultTable[gold.length][worker];
	}
	
	/**
	 * ��getBestGoldMining2�Ŀռ�ṹ�Ż�
	 * 
	 * @param worker	��������
	 * @param people	���ɽ�����蹤��
	 * @param gold		������
	 * @return
	 */
	public static int getBestGoldMining3(int worker, int[] people, int[] gold){
		int[] results = new int[worker + 1];
		for(int i = 1; i <= gold.length; i ++){
			for(int j = worker; j >= 1; j --){
				if(j >= people[i - 1]){
					results[j] = Math.max(results[j], results[j - people[i - 1]] + gold[i - 1]);
				}
			}
		}
		return results[worker];
	}
	
	public static void main(String[] args) {
		int worker = 10;
		int[] people = {5, 3, 5, 3, 4};
		int[] gold = {400, 350, 500, 200, 300};
		int result = getBestGoldMining3(worker, people, gold);
		System.out.println("�����ھ�ƽ�" + result);
	}

}
