package thread.productor;

public class Consumer implements Runnable {

	//������Դ����
    Person p = null;
    
    public Consumer(Person p) {
        this.p = p;
    }
     
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            //���Ѷ���
            p.pop();
        }
    }
	
}
