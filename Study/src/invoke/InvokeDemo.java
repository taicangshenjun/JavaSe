package invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import map.User;

public class InvokeDemo {

	/**
	 * ¶¯Ì¬´úÀí
	 * @param args
	 */
	public static void main(String[] args) {
		final User user = new User();
		Object proxyInstance =  Proxy.newProxyInstance(user.getClass().getClassLoader(), 
				user.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						return method.invoke(user, args);
					}
					
				});
		System.out.println(proxyInstance.getClass().getName());
	}
	
}
