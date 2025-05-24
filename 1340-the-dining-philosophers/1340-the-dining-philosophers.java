import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private final Lock[] forks = new ReentrantLock[5];
    private final Lock table = new ReentrantLock();  // global lock to control philosopher start order

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % 5;

        table.lock(); // enforce strict order by allowing only one philosopher to attempt fork-pick at a time
        forks[right].lock();
        forks[left].lock();
        try {
            // Pick in platform-required order: right then left
            pickRightFork.run();
            pickLeftFork.run();

            eat.run();

            // Put down in platform-required order: left then right
            putLeftFork.run();
            putRightFork.run();
        } finally {
            forks[left].unlock();
            forks[right].unlock();
            table.unlock();
        }
    }
}
