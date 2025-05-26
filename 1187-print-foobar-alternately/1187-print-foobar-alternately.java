class FooBar {
    private int n;
    private AtomicInteger turn = new AtomicInteger(0); // 0 for foo, 1 for bar

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (turn.get() != 0) {
                // busy wait
            }
            printFoo.run();
            turn.incrementAndGet(); // allow bar to run
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (turn.get() != 1) {
                // busy wait
            }
            printBar.run();
            turn.decrementAndGet(); // allow foo to run
        }
    }
}
