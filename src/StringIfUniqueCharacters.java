import java.util.Scanner;

public class StringIfUniqueCharacters {

	public static void main(String[] args) {
		
		String inputStr = getInput();
		
		String[] splitInput = inputStr.split("");
		
		int iCount=0;
		for(int i=0; i<splitInput.length; i++) {			

			iCount=0;
			for(int j=0; j<splitInput.length; j++) {
				
				if(splitInput[i].equalsIgnoreCase(String.valueOf(inputStr.charAt(j)))) {
					iCount++;
				}
			}
			
			if(iCount>1) {
				System.out.println("String does not have all unique characters");
				break;
			}
				
		}
		
		if(iCount==1)
		System.out.println("String has all unique characters");

	}
	
	private static String getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input string: ");
		String input = sc.nextLine();
		sc.close();
		
		return input;
	}

}
