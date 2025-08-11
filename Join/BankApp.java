package Join;

public class BankApp {
    public static void main(String[] args) {

        Bank bank=new Bank();
        DepositThread depositThread = new DepositThread(bank,10000);

        WithDrawThread withDrawThread=new WithDrawThread(bank,5000);

        depositThread.start();
        try {
            depositThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        withDrawThread.start();
        try {
            withDrawThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bank.getBalance());
    }

}
