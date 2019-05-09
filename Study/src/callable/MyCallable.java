package callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private long waitTime;
	
    public MyCallable(int timeInMillis) {
        this.waitTime=timeInMillis;  
    }
    
    @Override  
    public String call() throws Exception {
    	System.out.println(Thread.currentThread().getName() + "��ʼ˯�ߣ�" + waitTime + "΢��");
        Thread.sleep(waitTime);  
        return Thread.currentThread().getName();  
    }

}
