package se;

public class Father {

	public Demo demo = null;
	
	public final static int num = 1;
	
	public Father() {
		System.out.println("i am father");
	}
	
	static {
		System.out.println("father static block");
	}
	
	{
		System.out.println("father block");
	}

	public static void say() {
		System.out.println("father");
	}
	
	void play() {
		System.out.println("fa speak");
	}
	
}
