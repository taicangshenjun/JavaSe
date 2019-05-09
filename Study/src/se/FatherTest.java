package se;

public class FatherTest {

	public static void main(String[] args) {
		Father per = null;
		System.out.println("--------------");
		per = new Son();
		System.out.println("--------------");
		per = new Son();

		Son son = new Son();
		son.play();
	}
	
}
