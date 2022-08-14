import java.util.Scanner;

public class LargestOf3Numbers {

	public static void main(String[] args) {
	System.out.println("Enter the first number");
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	System.out.println("Enter the second number");
	int b = sc.nextInt();
	
	System.out.println("Enter the third number");
	int c = sc.nextInt();
	
	if(a>b && a>c) {
		System.out.print("The largest number is: "+a);
	}
	else if(b>a && b>c){
		System.out.print("The largest number is: "+b);
		
	}
	else if(c>a && c>b){
		System.out.print("The largest number is: "+c);
		
	}// one more way using ternary operator
	 // int largest = a>b?a:b;
	 // largest=c>largest?c:largest;
	
	
	
	
	}

}
