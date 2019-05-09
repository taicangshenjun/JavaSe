package lock;

public class JStackDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new DeadLockTest(true));//����һ���߳�
        Thread t2 = new Thread(new DeadLockTest(false));//������һ���߳�
        t1.setName("thread-dufy-1");
        t2.setName("thread-dufy-2");
        t1.start();//����һ���߳�
        t2.start();//������һ���߳�
	}
	
}

class DeadLockTest implements Runnable {
    public boolean flag;// �����߳�
    DeadLockTest(boolean flag) {
        this.flag = flag;
    }
    public void run() {
        /**
         * ���flag��ֵΪtrue�����t1�߳�
         */
        if (flag) {
            while (true) {
                synchronized (Demo.o1) {
                    System.out.println("o1 " + Thread.currentThread().getName());
                    synchronized (Demo.o2) {
                        System.out.println("o2 " + Thread.currentThread().getName());
                    }
                }
            }
        }
        /**
         * ���flag��ֵΪfalse�����t2�߳�
         */
        else {
            while (true) {
                synchronized (Demo.o2) {
                    System.out.println("o2 " + Thread.currentThread().getName());
                    synchronized (Demo.o1) {
                        System.out.println("o1 " + Thread.currentThread().getName());
                    }
                }
            }
        }
    }
}

class Demo {
    static Object o1 = new Object();
    static Object o2 = new Object();
}