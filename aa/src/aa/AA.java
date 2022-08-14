package aa;
abstract class Display{
	public abstract void m1();
	public  abstract void m3();
}
 class Demo extends Display{
	 public void m1() {
		 System.out.println("I'm implemented");
	 }
	 public void m2() {
			System.out.println("hi i'm m2");
		}
		public static void main() {
			System.out.println("I'm a static method");
		}
		public void m3() {
			System.out.println("hi i'm m3");
		}
}
public class AA {

	public static void main(String[] args) {
	
		Display d = new Demo();
		d.m1();
		d.m3();
	}

}
