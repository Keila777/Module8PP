//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConcurrencyDemo {
    public static void main(String[] args) {
        Thread counterUp = new Thread(new CounterUp());
        Thread counterDown = new Thread(new CounterDown());

        counterUp.start();
        try {
            counterUp.join(); // Ensure counterUp completes before starting counterDown
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counterDown.start();
    }
}

class CounterUp implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Counter Up: " + i);
            try {
                Thread.sleep(100); // Simulate some work with sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CounterDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Counter Down: " + i);
            try {
                Thread.sleep(100); // Simulate some work with sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}