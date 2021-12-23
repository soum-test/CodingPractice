import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintDuplicateChars {

	public static void main(String[] args) {
		boolean dupFlag = false;
		
		System.out.println("Enter input String: ");
		Scanner sc = new Scanner(System.in);		
		String sInput = sc.nextLine().toLowerCase();
		sc.close();
		
		char[] cInputArr = sInput.toCharArray();		
		Map<Character, Integer> entryMap = new HashMap<Character, Integer>();
		
		for(char entry : cInputArr) {
			
			if(entryMap.containsKey(entry)) {
				entryMap.put(entry, entryMap.get(entry)+1);
			}else {
				entryMap.put(entry, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry: entryMap.entrySet()) {
			
			if(entry.getValue()>1) {
				System.out.println( entry.getKey() + ":" + entry.getValue());
				dupFlag = true;
			}
		}
		
		if(!dupFlag) System.out.println("No Duplicate Characters found");

	}

}
