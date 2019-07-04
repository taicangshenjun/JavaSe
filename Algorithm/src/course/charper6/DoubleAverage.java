package course.charper6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 二倍均值法：
 * 主要解决抢红包分布均匀问题
 * 
 * 金额 = random[0.01，m / n * 2 - 0.01]
 * @author cm
 *
 */
public class DoubleAverage {
	
	public static List<Map<String, Integer>> divideRedPackage(int totalAmount, List<String> people){
		int peopleNum = people.size();
		Random random = new Random();
		List<Map<String, Integer>> resultList = new ArrayList<Map<String,Integer>>();
		for(int i = 0; i < people.size() - 1; i ++){
			int amount = random.nextInt(totalAmount / peopleNum * 2 - 1) + 1;
			Map<String, Integer> amountMap = new HashMap<String, Integer>();
			amountMap.put(people.get(i), amount);
			resultList.add(amountMap);
			
			totalAmount -= amount;
		}
		Map<String, Integer> amountMap = new HashMap<String, Integer>();
		amountMap.put(people.get(peopleNum - 1), totalAmount);
		resultList.add(amountMap);
		return resultList;
	}
	
	public static void main(String[] args) {
		List<String> people = new ArrayList<String>();
		people.add("张三");
		people.add("李四");
		people.add("王五");
		people.add("赵六");
		people.add("田七");
		int totalAmount = 100;
		List<Map<String, Integer>> resultList = divideRedPackage(totalAmount, people);
		System.out.println(resultList);
	}

}
