import java.util.Scanner;

public class NumberPattern11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			int count=i*(i+1)/2;
			for(int j=1;j<=i;j++) {
			if(count<10)
				System.out.print("0");
			if(count>=1) 
				System.out.print(count-- +" ");
				
			}
			System.out.println();

	}

}
}
