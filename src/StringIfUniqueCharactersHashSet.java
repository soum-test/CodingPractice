import java.util.HashSet;
import java.util.Scanner;

public class StringIfUniqueCharactersHashSet {

	public static void main(String[] args) {
		
		String inputStr = getInput();
		boolean isUniqueChars = true;
		HashSet<String> sInput = new HashSet<String>();
		
		for(int i=0; i<=inputStr.length()-1; i++) {
			
			if(!sInput.add(String.valueOf(inputStr.charAt(i)))) {
				System.out.println("String does NOT have all unique characters");
				isUniqueChars=false;
				break;
			}
			
		}
				
		if(isUniqueChars) {
			System.out.println("String has all unique characters");
		}

	}
	
	private static String getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input string: ");
		String input = sc.nextLine();
		sc.close();
		
		return input;
	}

}
