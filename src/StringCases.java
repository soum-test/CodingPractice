
public class StringCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hi";
		
		System.out.println(s1.hashCode());
		
		s1= "Hello";
		System.out.println(s1.hashCode());
		
		String s2 = new String("Hello");
		String s3 = new String("Hello");
		System.out.println(s2.hashCode());
		System.out.println(s1 == s2);
		System.out.println(s2.equals(s3));
		String s4 = "Hello";
		System.out.println(s4 == s1);
		
	}

}
