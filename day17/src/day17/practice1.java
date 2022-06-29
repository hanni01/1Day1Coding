package day17;

import java.util.*;

public class practice1 {

	public static void main(String[] args) {
		ArrayList<Student> members = new ArrayList<Student>();
		Student student = new Student("정하은", 21);
		members.add(student);
		members.add(new Student("이창섭", 31));
		
		for(Student s : members) {
			System.out.println(s.toString());
		}

	}

}

class Student{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "["+name+", "+age+"]";
	}
}
