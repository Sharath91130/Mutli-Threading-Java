package Lock;

public class BankApp {
    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount("acc123");

        Thread t1=new Thread(()->{
            bankAccount.withdraw(100);

        });

        Thread t2=new Thread(()->{
            bankAccount.deposit(3000);

        });

        t1.start();
        t2.start();
    }
}
