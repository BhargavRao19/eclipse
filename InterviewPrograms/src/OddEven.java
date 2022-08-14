import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
	System.out.println("enter a number");
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int even_count=0;
	int odd_count=0;
	
	while(num>0) {
		int rem=num%10;//4 3 2 1
		if(rem %2 ==0) {
			even_count++;//2
		}else {
			odd_count++;//2
			
		}
		num = num/10;//123 12 1
	
	}
	System.out.println("the number of even digits are: "+even_count++);
	System.out.println("the number of odd digits are: "+odd_count++);
	}

}
