import java.util.Scanner;

public class Stars {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(i==n/2 || (j==0 && i != 0) || (j ==n-1 && i !=0) || (i==0 && j !=0 && j != n-1))

					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
