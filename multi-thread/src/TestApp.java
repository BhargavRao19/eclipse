
class MyThread extends Thread{
	static Thread m1;

	@Override
	public void run() {

		try {
			m1.join();
		}
		catch(InterruptedException ie) {
			for(int i=1;i<=10;i++) {
				System.out.println("child thread");
			}
		}
	}

	public class TestApp {

		public static void main(String[] args) throws InterruptedException {
			MyThread.m1 = Thread.currentThread();

		}

	}

}

