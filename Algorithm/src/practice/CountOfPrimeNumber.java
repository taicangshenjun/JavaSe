package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断101-200之间有多少个素数，并输出所有素数。
 * @author cm
 *
 */
public class CountOfPrimeNumber {

	public static void main(String[] args) {
		List<Integer> resultList = calculatePrimeNumber(2, 100);
		displayPrimeNumber(resultList);
	}
	
	public static List<Integer> calculatePrimeNumber(int startNum, int endNum) {
		List<Integer> resultList = new ArrayList<Integer>();
		if(startNum < 2) {
			System.out.println("起始值大于1！");
			return null;
		}
		if(startNum >= endNum) {
			System.out.println("起始值必须小于终值！");
			return null;
		}
	
		
		for(int i = startNum; i <= endNum; i ++) {
			boolean flag = false;
			int limitNum = i / 2;
			for(int j = 2; j <= limitNum; j ++) {
				if(i % j == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				resultList.add(i);
			}
		}
		return resultList;
	}
	
	public static void displayPrimeNumber(List<Integer> numberList) {
		if(numberList != null) {
			String result = "";
			for(Integer i: numberList) {
				result += i + ",";
			}
			if(result.endsWith(",")) {
				result = result.substring(0, result.lastIndexOf(","));
			}
			System.out.println(result);
		}else {
			System.out.println("无");
		}
	}
	
}
