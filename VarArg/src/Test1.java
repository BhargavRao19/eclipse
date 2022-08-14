
public class Test1 {
	static int x;
	public void methodOne(String...x) {
		System.out.println(x);
		//int sum =0;
		//for(int aa:x)
			//sum = sum+aa;
		//System.out.println(sum);
	}
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.methodOne("sachin"+"aa");
		t.methodOne(10);
		//t.methodOne(10,20);
		//t.methodOne(10,20,30);



	}

}
