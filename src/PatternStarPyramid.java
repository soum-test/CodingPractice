import java.util.Scanner;

public class PatternStarPyramid {

	public static void main(String[] args) {
		int iRowLimit = getInput();
		
		if(iRowLimit > 0) {
			
			for(int iRow=1; iRow<=iRowLimit; iRow++) {
//				char[] cSize = [80];
				System.out.println(String.valueOf(new char[iRow]).replace("\0", "*"));
			}
			
			System.out.println("\n\n");
			
			for(int iRow=1; iRow<=iRowLimit; iRow++) {
				
				System.out.print(String.valueOf(new char[iRowLimit-iRow]).replace("\0", " "));
				System.out.println( String.valueOf(new char[iRow]).replace("\0", "*"));
			}
			
			System.out.println("\n\n");
			
			for(int iRow=iRowLimit; iRow>=1; iRow--) {				
				System.out.println( String.valueOf(new char[iRow]).replace("\0", "*"));
			}
			
			System.out.println("\n\n");
			
			for(int iRow=iRowLimit; iRow>=1; iRow--) {		
				System.out.print(String.valueOf(new char[iRowLimit-iRow]).replace("\0", " "));
				System.out.println( String.valueOf(new char[iRow]).replace("\0", "*"));
				
			}
			
			System.out.println("\n\n");
			
			for(int iRow=1; iRow<=iRowLimit; iRow++) {		
				try {
					System.out.print(String.valueOf(new char[iRowLimit-iRow]).replace("\0", " "));
					
				}catch(Exception e) {}
				
					System.out.println(String.valueOf(new char[iRow*2 - 1]).replace("\0", "*"));
			}
		}

	}
	public static int getInput() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter row nums to be displayed : ");
		
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
