import java.util.Scanner;

public class ODDandEvenCount {

	public static void main(String[] args) {
	System.out.println("Enter the number");
	Scanner sc = new Scanner(System.in);
	int num=sc.nextInt();//1234
	int odd_count=0;
	int even_count=0;
	
	while(num>0) {
		int rem = num/10;//123
		if(rem %2==0)
		  even_count++;
		else 
	        odd_count++;
		
		
		num=num/10;
	}
	System.out.println("The number of even count is::"+even_count);
	System.out.println("The number of odd count is::"+odd_count);
	}

}
