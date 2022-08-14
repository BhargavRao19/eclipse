import java.util.Scanner;

public class ReverseWord {
    //Approach1
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the words");
	String word=sc.nextLine();
	String[] strsplit = word.split(" ");
	String reverseString="";
	for(String w:strsplit) {
		String reverseword="";
	
	for(int i=w.length()-1;i>=0;i--) {
		reverseword=reverseword+w.charAt(i);
	}
	 reverseString =reverseString + reverseword+" ";
	}
	System.out.println(reverseString);
	}
}





	
	//Approach2
	/*public static void main(String[] args) {
		String str = "Welcome to java";
		String[] words = str.split("\\s");
		String reverseword="";
		for(String w:words) {
			StringBuilder sb = new StringBuilder(w);
			sb.reverse();
			
			reverseword= reverseword+sb.toString()+" ";
		                         }//
				System.out.println(reverseword);*/

