public class ReverseWords {

	public static void main(String[] args) {
		String sInput = "Soumitra Dev";
		String[] sInputArr = sInput.split(" ");
		
		String sOutput="";
		
		for(String st: sInputArr) {
			
			StringBuffer stBfr = new StringBuffer(st);
			
			sOutput += stBfr.reverse() + " ";
			
		}
		
		System.out.print(sOutput);
		

	}

}
