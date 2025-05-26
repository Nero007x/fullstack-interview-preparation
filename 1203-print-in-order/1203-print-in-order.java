class Foo {

    private AtomicInteger fristJob = new AtomicInteger(0);
    private AtomicInteger secondJob = new AtomicInteger(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        fristJob.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(fristJob.get()!=1){}
        printSecond.run();
        secondJob.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(secondJob.get()!=1){}
        printThird.run();
    }
}