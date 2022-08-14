import java.util.Scanner;

public class DiagonalMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		System.out.println("Enter the data into the matrix");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				System.out.print(a[i][j] +"\t");
			}
			System.out.println();
		}
		int sumL=0,sumR=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(i==j) 
					sumL +=a[i][j];
				
				if(i+j==n-1)
					sumR +=a[i][j];
			}
		
		}
		System.out.println("The sum of left diagonal is::"+sumL);
		System.out.println("The sum of right diagonal is::"+sumR);
		

	}

}
