package practice;

/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
 * 问每个月的兔子总数为多少？
 * @author cm
 *
 */
public class RabbitNumber {

	public static void main(String[] args) {
		calculateNumber(10);
	}
	
	
	public static void calculateNumber(int month) {
		//两个月前数量
		int twoMonthAgoNum = 1;
		//上个月数量
		int lastMonthNum = 1;
		//现在数量
		int currentNum = 1;
		for(int i = 1; i <= month; i ++) {
			if(i > 2) {
				twoMonthAgoNum = lastMonthNum;
				lastMonthNum = currentNum;
				currentNum = twoMonthAgoNum + lastMonthNum;
			}
			System.out.println("第" + i + "个月共有兔子：" + currentNum + "对！");
		}
	}
	
}
