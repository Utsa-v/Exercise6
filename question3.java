package exe6_multithreading;

class Table {
	// synchronized method
	synchronized static void printTable(int number) {
		System.out.println(Thread.currentThread().getName() + " is running");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i * number);
		}

	}

//synchronized block
	void printTable2(int number) {

		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " is running");
			for (int i = 1; i <= 5; i++) {
				System.out.println(i * number);
			}
		}

	}
}

class ThreadClass1 extends Thread {
	Table obj;
	int number;

	ThreadClass1(Table obj, int number) {

		this.obj = obj;
		this.number = number;
	}

	@Override
	public void run() {
		obj.printTable2(number);
	}
}

class ThreadClass extends Thread {
	int num;

	ThreadClass(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		Table.printTable(num);
		System.out.println();
	}
}

public class question3 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("using synchronized method ");
		ThreadClass t1 = new ThreadClass(10);
		ThreadClass t2 = new ThreadClass(20);
		t1.start();
		t2.start();
		Thread.sleep(1000);
		System.out.println("using synchronized block ");
		Table obj = new Table();
		ThreadClass1 t3 = new ThreadClass1(obj, 20);
		ThreadClass1 t4 = new ThreadClass1(obj, 30);
		t3.start();
		t4.start();

	}

}