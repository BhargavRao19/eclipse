import java.util.Scanner;

public class SumOfRowsAndSumColumns {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    System.out.println("Enter the size of the square matrix");
		int n=in.nextInt();
		int a[][]=new int[n][n];
		System.out.println("Enter the array elements");
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				a[i][j]=in.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
		      System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=0;j<n;j++) {
				sum+=a[i][j];
			}
			System.out.println("sum of row " +(i+1)+ " is "+sum);
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=0;j<n;j++) {
				sum+=a[j][i];
			}
			System.out.println(" sum of col " +(i+1)+ "is "+sum);
		}

	}

}
