package Yield;

public class YieldApp {
    public static void main(String[] args) {
        RewardsCalcutor rewardsCalcutor=new RewardsCalcutor();
        AmountTransfer amountTransfer=new AmountTransfer();
        rewardsCalcutor.setPriority(Thread.NORM_PRIORITY);
        amountTransfer.setPriority(Thread.NORM_PRIORITY);
        amountTransfer.start();
        rewardsCalcutor.start();


    }
}
