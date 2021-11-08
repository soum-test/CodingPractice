import java.util.Scanner;

public class RevStringPkgMethod {

	public static void main(String[] args) {
		
		String inputStr = getInput();
		
		StringBuffer sb = new StringBuffer(inputStr);
		
		System.out.println("Reversed string: " + sb.reverse());

	}
	
	private static String getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input string: ");
		String input = sc.nextLine();
		sc.close();
		
		return input;
	}

}
