import java.util.Arrays;

public class FindMinBySort {

	public static void main(String[] args) {
		int arr[]= {23,5,3,2,11,-1,17};
		
		if(arr.length == 0) {
			System.out.println("Empty Array");
		}
		else if(arr.length == 1) {
			System.out.println(arr[0]);
		}
		else {
			Arrays.sort(arr);
			System.out.println(arr[0]);
		}
	}

}
