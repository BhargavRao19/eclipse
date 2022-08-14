import java.util.Scanner;
public class FindDuplicateWordsPractice {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the String data");
    String str = sc.nextLine();//Welcome to java to java
    String[] word = str.split(" ");
    int count;
    
    for(int i=0;i<word.length;i++) 
    {	
    	count=1;
    
    for(int j=i+1;j<word.length;j++) {
    	if(word[i].equals(word[j])) {
    		count +=1;
    		word[j]="0";
    	}
    }
    if(word[i] !="0") {
    	System.out.println(word[i]+"  "+count);
    }
	}
	}
}
