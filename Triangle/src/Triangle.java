import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	int count = 0;
	for(int i=0; i<n; i++) {
		for(int j=1; j<=n-i; j++)
		{
			
				System.out.print(count+ " ");
				count ++;
				
	}
	System.out.println();

	}

}
}
