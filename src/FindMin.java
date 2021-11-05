
public class FindMin {

	public static void main(String[] args) {
		int arr[]= {0,23,5,3,2,11,17,1};
		
		int min=0;
		
		for(int i=0; i<arr.length-1; i++) {
			
			min=arr[i];
			
			for(int j =0 ; j<arr.length; j++) {
				 if(min>arr[j]) min=arr[j];
			}
		}
		
//		if(min==0) System.out.println("Could not find minimum");
		
		System.out.println(min);
	}

}
