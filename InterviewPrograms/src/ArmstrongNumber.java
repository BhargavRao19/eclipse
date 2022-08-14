import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number to check if the number is Armstrong");
    int n = sc.nextInt();//153
    int rem=0,arm=0;
    int temp=n;
    while(n>0) {
    	rem=n%10;//1%10
    	arm = rem*rem*rem + arm;//3*3*3 + 0  5*5*5 +27  1*1*1+152
    	n=n/10;//1	
    }
    if(temp==arm)
    	System.out.println("ArmStrong Number");
    else
    	System.out.println("Not a ArmStrong Number");
	}

}
