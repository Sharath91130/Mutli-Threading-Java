package Join;

public class WithDrawThread extends Thread{
    @Override
    public void run() {
           bank.withDraw(amount);
    }

    private int amount;
    private Bank bank;

    public WithDrawThread(Bank bank, int amount){
        this.amount=amount;
        this.bank=bank;
    }
}
