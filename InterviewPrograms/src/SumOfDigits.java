import java.util.Scanner;
public class SumOfDigits {

	public static void main(String[] args) {
	System.out.println("Enter a number");
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int sum=0;
	while(num>0) {//1234
		sum +=num%10;
		num=num/10;//123 12 1 0
	}
     System.out.println("the total sum is: "+sum);
	}

}
