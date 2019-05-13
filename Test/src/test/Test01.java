package test;
/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
 * 问每个月的兔子总数为多少？
 * 
 * 解：
 * 这是一个斐波那契数列问题
 * 兔子数量是1,1,2,3,5,8,13,21
 * 即，每个月能生的兔子为两个月前兔子数量，
 * 所以，每一项等于前两项之和
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
			System.out.println("第" + i + "月： 有兔子" + curNum + "对");
		}
		
	}
	
}
