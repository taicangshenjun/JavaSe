package thread.productor;

public class Person {

	private String name;
	
    private int age;
     
    /**
     * ��������
     * @param name
     * @param age
     */
    public void push(String name,int age){
        this.name = name;
        this.age = age;
    }
    /**
     * ȡ���ݣ���������
     * @return
     */
    public void pop(){
        System.out.println(this.name+"---"+this.age);
    }
	
}
