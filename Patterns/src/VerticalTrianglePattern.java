import java.util.Scanner;

public class VerticalTrianglePattern {
	public static void main(String args[]) {
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			for(int i=0;i<n;i++)
			{
				
				for(int j=0;j<=i;j++)
				{
			      System.out.print("*");
			      
			}    
				System.out.println();
			}
			for(int i=0;i<n;i++)
			{
				
				for(int j=0;j<n-i;j++)
				{
			      System.out.print("#");
			      
			}    
				System.out.println();
			}
			
	}

}
