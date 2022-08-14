import java.util.Scanner;

public class CountWords {

	public static void main(String[] args) {
		System.out.println("Enter the String");
	Scanner sc = new Scanner(System.in);
	String words = sc.nextLine();//Welcome to java
	int count=1;
	for(int i=0;i<words.length();i++) {
		if( (words.charAt(i)==' ') && (words.charAt(i+1) != ' ')) {
			count++;
		}
	}
	System.out.println("The total number of words is::"+count);

	}

}
