package course.util;

/**
 * 数组的工具类
 * @author cm
 *
 */
public class ArrayUtils {
	
	public static void display(int[] array){
		String result = "[";
		for(int i: array){
			result += i + ",";
		}
		result = result.indexOf(",") > -1? result.substring(0, result.lastIndexOf(",")) + "]": result + "]";
		System.out.println(result);
	}
	
	public static int[] createArray(int length){
		int[] array = new int[length];
		for(int i = 0; i < length; i ++){
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

}
