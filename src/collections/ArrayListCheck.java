package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListCheck {

	public static void main(String[] args) {
		
		Student s1 = new Student(12, "Soumitra", 29);
		Student s2 = new Student(01, "Agrata", 26);
		
		ArrayList<Student> a1= new ArrayList<Student>();
		
		a1.add(s1);
		a1.add(s2);
		
		Iterator<Student> it = a1.iterator();
		
		while(it.hasNext()) {
			
			Student st = it.next();
			
			System.out.println(st.getRollNo() + " " + st.getName() + " " + st.getAge());
		}
	}

}
