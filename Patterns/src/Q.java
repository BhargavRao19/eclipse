import java.util.Scanner;

public class Q {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if((j==0 && i !=0 && i<3*n/4) || (j ==3*n/4 && i !=0 && i < 3*n/4) || (i ==0 && j !=0 && j < 3*n/4) || 
						(i==3*n/4 && j !=0 && j < 3*n/4) || (i==j && j>=n/2))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
