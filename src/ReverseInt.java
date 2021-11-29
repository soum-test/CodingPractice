import java.util.Scanner;

public class ReverseInt {

	public static void main(String[] args) {
		int iInput = getInput();
				
		int iAddition = 0;
		
		while(iInput>0) {
			iAddition = iAddition*10 + iInput%10;
			
			iInput /= 10;
		}
		
		System.out.println("\n\nReversed value : "+ iAddition);
	}
	
	public static int getInput() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input Digit : ");
		
		try {
			int iInput = sc.nextInt();
			sc.close();
			return iInput;
		}catch (Exception e) {
			System.out.println("\n\nIncorrect input :" + e);
		}
		
		return -1;
	}
}
