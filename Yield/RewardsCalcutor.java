package Yield;

public class RewardsCalcutor extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Rewards Calculator Increasing ..." + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.yield();
        }
    }
}
