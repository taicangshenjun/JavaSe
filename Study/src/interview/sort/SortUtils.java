package interview.sort;

public class SortUtils {

	public static int[] createArray() {
		int[] result = new int[10];
		for(int i = 0; i < result.length; i ++) {
			result[i] = (int) (Math.random() * 100);
		}
		return result;
	}
	
	public static void showArray(int[] numArray) {
		String showStr = "";
		for(int i = 0; i < numArray.length; i ++) {
			if(i != numArray.length - 1) {
				showStr += numArray[i] + ",";
			}else {
				showStr += numArray[i];
			}
		}
		System.out.println(showStr);
	}
	
}
