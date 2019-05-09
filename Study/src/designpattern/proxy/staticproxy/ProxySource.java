package designpattern.proxy.staticproxy;

public class ProxySource implements Sourceable {

	private Sourceable source;
	
	public ProxySource() {
		super();
		this.source = new Source();
	}
	
	@Override
	public void method() {
		before();
		source.method();
		after();
	}
	
	private void before() {
		System.out.println("before proxy!");
	}
	
	private void after() {  
        System.out.println("after proxy!");  
    }

}
