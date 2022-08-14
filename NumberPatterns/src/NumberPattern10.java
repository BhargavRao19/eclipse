import java.util.Scanner;

public class NumberPattern10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count=n*(n+1)/2;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
			if(count<10)
				System.out.print("0");
			if(count>=1) 
				System.out.print(count-- +" ");
				
			}
			System.out.println();
		}


	}

}
