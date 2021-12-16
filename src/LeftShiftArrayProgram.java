import java.util.Arrays;
import java.util.Scanner;

public class LeftShiftArrayProgram {

	public static void main(String[] args) {
		
		System.out.println("Enter number of elements to left shift :");
		Scanner sc = new Scanner(System.in);
		int leftShiftCount = sc.nextInt();		
		int arr[] = {0,1,2,3,4,5,6,7,8,9};
		sc.close();
		for(int count=1; count<=leftShiftCount; count++) {
			int temp =arr[0];
			for(int i=0; i<arr.length-1; i++) {
				arr[i] = arr[i+1];
				//if(i>=leftShiftCount) continue;
	
			}
			arr[arr.length-1] = temp;
		}
	
//		for(int i=1; i<=leftShiftCount; i++) {
//			arr[arr.length-1-i]=
//		}

		System.out.print(Arrays.toString(arr));
	}

}
