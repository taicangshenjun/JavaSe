package designpattern.proxy;

import java.lang.reflect.Proxy;

import designpattern.proxy.dynamicproxy.DynamicProxyHandler;
import designpattern.proxy.staticproxy.ProxySource;
import designpattern.proxy.staticproxy.Source;
import designpattern.proxy.staticproxy.Sourceable;

public class SourceTest {

	public static void main(String[] args) {
		staticTest();
		dynamicTest();
	}
	
	public static void staticTest() {
		Sourceable source = new ProxySource();
		source.method();
	}
	
	public static void dynamicTest() {
		Sourceable source = new Source();
		Sourceable proxySource = (Sourceable) Proxy.newProxyInstance(Sourceable.class.getClassLoader(), 
									new Class[] {Sourceable.class}, new DynamicProxyHandler(source));
		proxySource.method();
	}
	
}
