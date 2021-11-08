import java.util.Scanner;

public class RevStringNoPkgMethod {

	public static void main(String[] args) {
		
		String inputStr = getInput();
		
		String outputStr = "";
		
		for(int i=inputStr.length()-1; i>=0; i--) {
			
			outputStr += inputStr.charAt(i);
		}
		
		System.out.println("Reversed string: " + outputStr);

	}
	
	private static String getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input string: ");
		String input = sc.nextLine();
		sc.close();
		
		return input;
	}

}
