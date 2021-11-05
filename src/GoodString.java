import java.util.ArrayList;
import java.util.Scanner;

public class GoodString {
	public static void main(String[] args) {
		System.out.print("Enter input string : ");
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		sc.close();
		
		final ArrayList<String> vowels = new ArrayList<String>();
		vowels.add("a");vowels.add("e");vowels.add("i");vowels.add("o");vowels.add("u");
		
		int goodStringlen = 0;
		int counter = 0;
		
		for(int i=0; i< st.length(); i++) {
			String character = String.valueOf(st.charAt(i)).toLowerCase();		
			
			if(vowels.contains(character)) {				
				counter++;				
			}else {				
				counter=0;
			}			

			if(goodStringlen<counter) {
				goodStringlen=counter;
			}
		}		
		System.out.println(goodStringlen);
	}
}
