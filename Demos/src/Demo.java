
public class Demo {
	int a=20,b=30;
	int sum=a+b;
	public void Dog(int a)
	{
		System.out.println("aabbcc");
		System.out.println(sum);
	}
	public void Dog(char b)
	{
		System.out.println("23");
	}
	public void Cat(float... a)
	{
		System.out.println("floating numbers");
	}
	
	

	public static void main(String[] args) {
		
		       Demo a =new Demo();
		       //a.Dog(2);
		       //a.Dog('C');
		       a.Cat(5.3f);
	}
	
	}
	

