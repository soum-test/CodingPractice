import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		
		String inputStr1 = "Soumitra";
		String inputStr2 = "mitrSoua";
		
		if(inputStr1.length() != inputStr2.length()) {
			System.out.println("Length differs for both strings. Not a Anagram candidate");
		}
		
		String[] inputArr1 = inputStr1.split("");
		String[] inputArr2 = inputStr2.split("");
		
		Arrays.sort(inputArr1);
		Arrays.sort(inputArr2);
		
		if(Arrays.equals(inputArr1,inputArr2)) {
			System.out.println("ANAGRAM");
		}
		else { 
			System.out.println("NOT ANAGRAM");
		}
		
		
	}
	

}
