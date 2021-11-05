import java.util.Scanner;

public class SwapCase {

	public static void main(String[] args) {
		
		String inputString = getInput();
		String outputString = "";
		
		for(int i=0 ; i<inputString.length(); i++) {
			
			if(Character.isUpperCase(inputString.charAt(i))) {
				
				outputString = outputString + String.valueOf(inputString.charAt(i)).toLowerCase();
				
			}else if(Character.isLowerCase(inputString.charAt(i))) {
				
				outputString = outputString +  String.valueOf(inputString.charAt(i)).toUpperCase();
			
			}else {
				
				outputString = outputString + String.valueOf(inputString.charAt(i));
			}
		}
		
		System.out.println("Input String : " + inputString);
		System.out.println("Output String : " + outputString);
	}
	
	public final static String getInput() {
		System.out.println("Provide input string : ");
		Scanner sc = new Scanner(System.in);
		String input= sc.nextLine();
		sc.close();
		
		return input;
	}

}
