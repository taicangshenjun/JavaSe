package thread.productor;

public class Producer implements Runnable {
	
	//������Դ����
	Person p = null;
	
    public Producer(Person p){
        this.p = p;
    }
    
    @Override
    public void run() {
        //��������
        for(int i = 0 ; i < 50 ; i++){
            //�����ż������ô�������� Tom--11;��������������������� Marry--21
            if(i%2==0){
                p.push("Tom", 11);
            }else{
                p.push("Marry", 21);
            }
        }
    }

}
