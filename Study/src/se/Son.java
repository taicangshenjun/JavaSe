package se;

public class Son extends Father {

	public Son() {
		System.out.println("i am Son");
	}
	
	static {
		System.out.println("Son static block");
	}
	
	{
		System.out.println("Son block");
	}

	public static void say() {
		System.out.println("Son");
	}
	
	@Override
	protected void play() {
		System.out.println("son speak");
	}
	
}
