import java.util.Scanner;

public class NumberPattern4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count =n;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
					System.out.print(count);
					count--;
			}
			count=n;
			System.out.println();
			  
		}

	}

}
