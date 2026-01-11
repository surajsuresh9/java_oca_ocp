package concurrency;

public class MyClass2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " is being executed");
    }

    public static void main(String[] args) {
//        new Thread(new MyClass2()).start();
//        System.out.println("Thread: " + Thread.currentThread().getName() + " is being executed");
        new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " is being executed");
        }).start();
        System.out.println("Thread: " + Thread.currentThread().getName() + " is being executed");
    }
}
