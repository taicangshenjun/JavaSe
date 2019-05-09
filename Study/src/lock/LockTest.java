package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.����synchronized��java���ùؼ��֣���jvm���棬Lock�Ǹ�java�ࣻ

	2.synchronized�޷��ж��Ƿ��ȡ����״̬��Lock�����ж��Ƿ��ȡ������
	
	3.synchronized���Զ��ͷ���(a �߳�ִ����ͬ��������ͷ��� ��b �߳�ִ�й����з����쳣���ͷ���)��Lock����finally���ֹ��ͷ�����unlock()�����ͷ�������������������߳�������
	
	4.��synchronized�ؼ��ֵ������߳�1���߳�2�������ǰ�߳�1��������߳�2�̵߳ȴ�������߳�1�������߳�2���һֱ�ȴ���ȥ����Lock���Ͳ�һ����ȴ���ȥ��������Ի�ȡ���������߳̿��Բ���һֱ�ȴ��ͽ����ˣ�
	
	5.synchronized���������롢�����жϡ��ǹ�ƽ����Lock�������롢���жϡ��ɹ�ƽ�����߽Կɣ�
	
	6.Lock���ʺϴ���ͬ���Ĵ����ͬ�����⣬synchronized���ʺϴ���������ͬ�����⡣
 * @author cm
 *
 */
public class LockTest {
	
	private Lock lock = new ReentrantLock();
	
	/*
     * ʹ������ͷź������̲߳��ܻ�ȡ��
     */
    public void lockTest(Thread thread) {
        lock.lock();//��ȡ��
        try {
            System.out.println("�߳�"+thread.getName() + "��ȡ��ǰ��"); //��ӡ��ǰ��������
            Thread.sleep(2000);//Ϊ����ִ��Ч�������̴߳˴�����2��
        } catch (Exception e) {
            System.out.println("�߳�"+thread.getName() + "�������쳣�ͷ���");
        }finally {
            System.out.println("�߳�"+thread.getName() + "ִ������ͷ���");
            lock.unlock(); //�ͷ���
        }
    }
    
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        //����һ���߳� ���߳�һ��
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.lockTest(Thread.currentThread());
            }
        }, "thread1");
        //����һ���߳� ���̶߳���
        Thread thread2 = new Thread(new Runnable() {
 
            @Override
            public void run() {
                lockTest.lockTest(Thread.currentThread());
            }
        }, "thread2");
        // ����2���߳�
        thread2.start();
        thread1.start();
 
    }

}
