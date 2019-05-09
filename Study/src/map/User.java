package map;

public class User {
	
	public User() {
		
	}
	
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String say() {
		System.out.println("11");
		return "my name is " + this.name + ", " + this.age + "years old.";
	}

	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
