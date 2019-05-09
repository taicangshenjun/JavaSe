package designpattern.adapter;

public class AdapterTest {

	public static void main(String[] args) {
		Target target = new ClassAdapter();
		target.request();
	}
	
}
