import java.util.Scanner;

public class NumberPattern12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();

		for(int i=1;i<=n;i++) {
			if(i%2==0) {
				int count=i*(i+1)/2;
				for(int j=1;j<=i;j++) {
					System.out.print(count-(j-1)+" ");
				}

			}

		}
	}
}

        
