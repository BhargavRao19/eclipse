import java.util.Scanner;

public class SumOfMatrixDiagonal {

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
		int sumR=0,sumL=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
		      if(i==j) 
		    	  sumL+=a[i][j];
		      if(i+j==n-1) 
		    	  sumR+=a[i][j];
		      
			}
			
		}
		System.out.println("sum of diagonals");
		System.out.println("Sum of left diagonal "+sumL);
		System.out.println("Sum of left diagonal "+sumR);
	}

}
