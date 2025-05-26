import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;

class H2O {
    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private Semaphore oxygenSemaphore = new Semaphore(1);
    private CyclicBarrier barrier = new CyclicBarrier(3);

    public H2O() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();  // Allow up to 2 H per molecule
        try {
            barrier.await();  // Wait for full molecule
            releaseHydrogen.run();  // Output "H"
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hydrogenSemaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();  // Allow only 1 O per molecule
        try {
            barrier.await();  // Wait for full molecule
            releaseOxygen.run();  // Output "O"
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oxygenSemaphore.release();
        }
    }
}
