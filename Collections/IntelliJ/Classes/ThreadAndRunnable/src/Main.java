import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private final static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i < 100; i++) {
                number.incrementAndGet();
            }
        };
        Runnable dec = () -> {
            for (int i = 0; i < 100; i++) {
                number.decrementAndGet();
            }
        };
        Runnable show = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(number);
            }
        };

        var execInc = new Thread(inc);
        execInc.start();
        var execDec = new Thread(dec);
        execDec.start();
        var execShow = new Thread(show);
        execShow.start();

        System.out.println(execInc.getName());
        System.out.println(execDec.getName());
        System.out.println(execShow.getName());
    }
}
/*
Code 1:

    private static final Queue<Integer> numbers = new LinkedBlockingQueue<>(250_000);

    private static void inc(int number){
        synchronized (numbers){
            numbers.add(number);
        }
    }

    private static void show(){
        synchronized (numbers){
            System.out.println(numbers);
        }
    }

    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i < 100; i++) {
                inc(i);
            }
        };
        Runnable dec = () -> {
            for (int i = 100; i > 0; i--) {
                inc(i);
            }
        };
        Runnable show = () -> {
            for (int i = 0; i < 250; i++) {
                show();
            }
        };

        var execInc = new Thread(inc);
        execInc.start();
        var execDec = new Thread(dec);
        execDec.start();
        var execShow = new Thread(show);
        execShow.start();

        System.out.println(execInc.getName());
        System.out.println(execDec.getName());
        System.out.println(execShow.getName());
*/
