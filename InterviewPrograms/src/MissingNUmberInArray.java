
public class MissingNUmberInArray {

	public static void main(String[] args) {
	//Array should not have duplicates
		//No need to be in sorted order
		//values should be in range
	int a[]= {1,2,3,4,5,7,8,9,10};
	int sum1=0;
	for(int i=0; i<a.length; i++)
	{
		sum1 =sum1+a[i];
		
	}
	System.out.println("sum of elemnts in array:"+sum1);
	
	int sum2=0;
	for(int i=1;i<=10;i++)
	{
		sum2=sum2+i;
	}
	System.out.println("sum of range of elements in array:"+sum2);
	System.out.println("Missing number in array:"+(sum2-sum1));	
	}

}
