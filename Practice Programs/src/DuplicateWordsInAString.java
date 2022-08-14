import java.util.Scanner;

public class DuplicateWordsInAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] words =str.split(" ");
		  int count;
		for(int i=0;i<words.length;i++) {
			count=1;
			for(int j=i+1;j<words.length;j++) {
			if(words[i].equals(words[j])) {
				count++;
				words[j]="0";
			}		
			}
			if(words[i] !="0")
			System.out.println(words[i]+" "+count);
		}
	}

}
