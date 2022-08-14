import java.util.*;
public class NumberPattern7 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n =sc.nextInt();
	int count=1;
	int count1=0;
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			/*if(i%2==0) {
				System.out.print(count);
			}
			else {
				System.out.print(count1);
			}*/
			System.out.print((i%2==0)?1:0);
			
		}
		System.out.println();
	}

	}

}
