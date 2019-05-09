package thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {

	private List<String> producters = new ArrayList<String>();
	
	private List<String> customers = new ArrayList<String>();
	
	public static void main(String[] args) {
		Runnable proRunnable = new Runnable() {
			ThreadDemo demo = new ThreadDemo();
			@Override
			public void run() {
				while(true) {
					try {
						demo.addPro();
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread proThread = new Thread(proRunnable);
		Thread proThread2 = new Thread(proRunnable);
		proThread.start();
		proThread2.start();
	}
	
	public void addPro() {
		if(producters.size() < 20) {
			producters.add("product:" + (producters.size() + 1));
			System.out.println(Thread.currentThread().getName() +  "--����" + producters.size() + "�ţ�");
		}else {
			System.out.println(Thread.currentThread().getName() +  "--�ֿ����ˣ��������ˣ�");
		}
	}
	
	public void removePro() {
		if(producters.size() > 0) {
			producters.remove(producters.size() - 1);
			System.out.println(Thread.currentThread().getName() + "--" + (producters.size() - 1) + "�ѱ��Ƴ���");
		}else {
			System.out.println(Thread.currentThread().getName() +  "--û�л��ˣ��޷��Ƴ���");
		}
	}
	
}
