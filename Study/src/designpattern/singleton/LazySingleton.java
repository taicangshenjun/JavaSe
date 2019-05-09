package designpattern.singleton;

public class LazySingleton {

	//��֤ instance �������߳���ͬ��
	private static volatile LazySingleton instance = null;
	
	//private ���������ⲿ��ʵ����
	private LazySingleton() {
		
	}
	
	public static synchronized LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
}
