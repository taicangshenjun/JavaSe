package thread.productor;

public class Person {

	private String name;
	
    private int age;
     
    /**
     * 生产数据
     * @param name
     * @param age
     */
    public void push(String name,int age){
        this.name = name;
        this.age = age;
    }
    /**
     * 取数据，消费数据
     * @return
     */
    public void pop(){
        System.out.println(this.name+"---"+this.age);
    }
	
}
