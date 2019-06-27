package course.charper5;

/**
 * 挖金矿问题：
 * 
 * 动态规划
 * 
 * @author cm
 *
 */
public class DynamicProgramming {
	
	/**
	 * 
	 * @param worker	工人数量
	 * @param number	金矿数量
	 * @param people	开采金矿所需工人
	 * @param gold		金矿存量
	 * @return
	 */
	public static int getBestGoldMining(int worker, int number, int[] people, int[] gold){
		//如果工人是0，或者金矿是0，则返回0
		if(worker == 0 || number == 0){
			return 0;
		}
		//如果工人数小于金矿所需的人数，则看能否满足下一个金矿所需的人数
		if(worker < people[number - 1]){
			return getBestGoldMining(worker, number - 1, people, gold);
		}
		//在不开发最后一个金矿和一定开发下一个金矿中选择收益最优解
		return Math.max(getBestGoldMining(worker, number - 1, people, gold), 
							getBestGoldMining(worker - people[number - 1], number - 1, people, gold) + gold[number - 1]);
	}
	
	/**
	 * 
	 * @param worker	工人数量
	 * @param people	开采金矿所需工人
	 * @param gold		金矿存量
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
	 * 对getBestGoldMining2的空间结构优化
	 * 
	 * @param worker	工人数量
	 * @param people	开采金矿所需工人
	 * @param gold		金矿存量
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
		System.out.println("最大可挖掘黄金：" + result);
	}

}
