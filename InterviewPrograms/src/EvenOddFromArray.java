
public class EvenOddFromArray {

	public static void main(String[] args) {
	int a[] = {1,2,3,4,5,6};
	
	//Extracting even numbers
	System.out.println("even numbers");
	for(int i=0;i<a.length;i++) //6
	{
		if(a[i] %2==0)
			System.out.println(a[i]);
		
	}
	System.out.println("odd numbers");
	for(int i=0;i<a.length;i++) //6
	{
		if(a[i] %2 !=0)
			System.out.println(a[i]);
		
	}
	

	}

}
