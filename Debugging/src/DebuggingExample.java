
public class DebuggingExample {
public static void main(String[] args) {
	int firstInt =7;
	int secondInt=8;
	int sum=add(firstInt,secondInt);
	System.out.println("The sum is"+sum);
}
public static int add(int int1 ,int int2) {
	int sum = int1+int2;
	return sum;
}
}
