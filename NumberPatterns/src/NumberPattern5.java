import java.util.Scanner;
public class NumberPattern5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
			if(count<10)
				System.out.print("0");
			System.out.print(count++ +" ");
			if(j<=n-1)
				System.out.print("*");
	}
        System.out.println();
}       sc.close();
}
}