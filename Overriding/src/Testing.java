class Test
{
	Object show()
	{
		System.out.println("1");
		return null;
	}
	class Abc extends Test
	{
		String show()
		{
			System.out.println("2");
			return null;
		}
	}
}
public class Testing {

	public static void main(String[] args) {



		Test t =new Test();
		t.show();
	



	}

}
