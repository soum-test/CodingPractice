import java.util.Scanner;

public class CountWords {

	public static void main(String[] args) {
		System.out.println("Enter the string: ");
		Scanner sc = new Scanner(System.in);
		
		String sInput = sc.nextLine().replaceAll(" +", " ");
		
		sc.close();
		
		String[] sInputArr = sInput.split(" ");
		
		System.out.println("Number of words : " + sInputArr.length);
		
	}

}
