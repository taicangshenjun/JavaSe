package course.chapter1;

/**
 * ø’º‰∏¥‘”∂»
 * @author cm
 *
 */
public class SpaceComplexity {

	public static void main(String[] args) {
		
	}
	
	public static void fun1(int n){
		int var = 3;
		System.out.println(var);
	}
	
	public static void fun2(int n){
		int[] array = new int[n];
		System.out.println(array);
	}
	
	public static void fun3(int n){
		int[][] array = new int[n][n];
		System.out.println(array);
	}
	
	public static void fun4(int n){
		if(n <= 1){
			return;
		}
		fun4(n - 1);
	}
	
}
