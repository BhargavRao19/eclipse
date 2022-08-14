import java.util.Scanner;

public class CountNumberOfWords {

	public static void main(String[] args) {
		System.out.println("Enter the String");
	Scanner sc = new Scanner(System.in);
	String word=sc.nextLine();//Welcome to Java
	int count=1;
	for(int i=0;i<word.length();i++) {
		if((word.charAt(i)==' ') && (word.charAt(i+1) !=' ') ) {
			count++;
		}
		
	}
	System.out.println(count);

	}

}
