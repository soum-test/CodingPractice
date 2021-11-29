import java.util.Scanner;

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iInput = getInput();
		
		if(iInput<0 || iInput>1000) System.out.println("Input out of range. Please provide input b/w 0-1000");
		
		else {			
			int iAddition = 0;
			
			while(iInput>0) {
				if(iInput%10>0) {
					iAddition+= iInput%10;
				}
				
				iInput /= 10;
			}
			
			System.out.println("\n\nTotal of the digits : "+ iAddition);
		}
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
