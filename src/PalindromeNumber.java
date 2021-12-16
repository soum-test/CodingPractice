import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
		int num = getInput();
		int itrVal = num;
		int revNum = 0;
		if(num>=0) {
			while(itrVal > 0) {
				revNum = revNum*10 + itrVal%10;
				
				itrVal=itrVal/10;
			}
			
			if(num%10==0) revNum = revNum*10;
			
			System.out.println("Input  : " + num);
			System.out.println("Output : " + revNum);
			
			if(num==revNum) System.out.println("PALINDROME");
			else System.out.println("NOT PALINDROME");
		}
	}
	
	public static int getInput() {
		System.out.println("Enter Number : ");
		Scanner sc = new Scanner(System.in);
		
		try {
			int input = sc.nextInt();			
			sc.close();
			return input;
		}catch(Exception e) {
			System.out.println("Invalid input. Please enter only integer");
			sc.close();
			return -1;
		}
	}

}
