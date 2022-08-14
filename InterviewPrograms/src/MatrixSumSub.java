import java.util.Scanner;
public class MatrixSumSub {

	public static void main(String[] args) {
	int a[] [],b[] [],c[] [],i,j;
	a=new int[3][3];
	b=new int[3][3];
	c=new int[3][3];
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the first matrix");
	for(i=0;i<3;i++) {
		for(j=0;j<3;j++) {
			a[i][j]= sc.nextInt();
		}
	}
	System.out.println("Enter the second matrix");
	for(i=0;i<3;i++) {
		for(j=0;j<3;j++) {
			b[i][j]= sc.nextInt();
		}
	}
	
	System.out.println("Addition");
	for(i=0;i<3;i++) {
		for(j=0;j<3;j++) {
			c[i][j]= a[i][j] + b[i][j];
			System.out.print(c[i][j]+"\t");
		}
		System.out.println();
	}
	System.out.println("Subtraction");
	for(i=0;i<3;i++) {
		for(j=0;j<3;j++) {
			c[i][j]= a[i][j] - b[i][j];
			System.out.print(c[i][j]+"\t");
		}
		System.out.println();
	}
	}

}
