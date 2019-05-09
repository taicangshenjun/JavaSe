package designpattern.adapter;

public class ClassAdapter extends Adaptee implements Target {

	@Override
	public void request() {
		Adaptee adaptee = new Adaptee();
		adaptee.specificRequest();
	}

}
