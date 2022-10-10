/*4) WAP to show usage of Callable and demonstrate how it is different from Runnable
*/

package exe6_multithreading;

import java.util.concurrent.*;

class RunableI implements Runnable {
	public void run() {
		System.out.println("Ruunable ");
	}
}

class CallableI implements Callable {

	@Override
	public Integer call() throws Exception {
		return 5;
	}
}

public class question4 {
	static ExecutorService ex = Executors.newFixedThreadPool(2);

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		RunableI t1 = new RunableI();
		Thread th = new Thread(t1);
		th.start();
		ex.submit(th);

	}
}