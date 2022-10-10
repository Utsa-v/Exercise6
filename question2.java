/*2) Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool() 
 * to submit a list of tasks and wait for completion of all tasks.
*/
package exe6_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class question2 {
    public static void main(String[] args) {
      ExecutorService executorService = Executors.newFixedThreadPool(2);
          ExecutorService executorService1=Executors.newCachedThreadPool();

        System.out.println("**********using singleThreadExecutor()********** ");
        for (int i = 0; i < 6; i++) {
            executorService.submit(() -> {
                System.out.println("Submitting to Executors: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.DAYS);
            System.out.println(".Here Shutdown");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        System.out.println("**********using newCachedThreadPool()********** ");
        for (int i = 0; i < 10; i++) {
            executorService1.submit(() -> {
                System.out.println("Submitting to Executors: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService1.shutdown();
        try {
            executorService1.awaitTermination(2, TimeUnit.DAYS);
            System.out.println(".Here Shutdown");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}