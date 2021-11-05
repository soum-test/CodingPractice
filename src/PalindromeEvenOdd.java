import java.util.Scanner;

public class PalindromeEvenOdd {

	public static void main(String[] args) {
		String sInput = getInput();
		String sOutput ="";
		
		for(int i=sInput.length()-1; i>=0; i--) {
			
			sOutput += sInput.charAt(i);
			
		}
		
		System.out.println("Input String : " + sInput);
		System.out.println("Output String : " + sOutput);
		
		if(sInput.equalsIgnoreCase(sOutput)) {
			
			if(sInput.length()%2==0) System.out.println("EVEN PALINDROME");
			else System.out.println("ODD PALINDROME");
		}else {
			System.out.println("NOT PALINDROME");
		}

	}
	
	public final static String getInput() {
		System.out.println("Provide input string : ");
		Scanner sc = new Scanner(System.in);
		String input= sc.nextLine();
		sc.close();
		
		return input;
	}
}
