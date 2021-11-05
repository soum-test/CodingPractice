package collections;

public class Student {
	
	public Student(int rollNo,String name,int age) {		
		
		this.setRollNo(rollNo);
		this.setName(name);
		this.setAge(age);
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	private int rollNo;
	private String name;
	private int age;
	
	
}
