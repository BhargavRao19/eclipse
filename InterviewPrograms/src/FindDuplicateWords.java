import java.util.Scanner;
public class FindDuplicateWords {

	public static void main(String[] args) {
	System.out.println("Enter the String data");
	Scanner sc= new Scanner(System.in);
	String str = sc.nextLine();
	String[] word = str.split(" ");
	int count;
	for(int i=0;i<word.length;i++)
	{
		count=1;
		for(int j=i+1;j<word.length;j++) {
		if(word[i].equals(word[j]))
		{
			count = count+1;
			word[j]="0";
		}
		
	}
		if(word[i]!="0")
			System.out.println(word[i]+"    "+count);
	}
	}

}
