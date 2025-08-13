package Lock;

public class BankAccount {
    public BankAccount(String accNumber) {
        this.accNumber = accNumber;
    }

    private int balance;
    private String accNumber;
    public synchronized  void  withdraw(int amount){




        System.out.println("Withdraw is Processing on "+ accNumber + " .............");


        if(amount>balance){
            System.out.println("Balance is insufficient");
            return;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       balance-=amount;
        System.out.println("withdraw is completed collect you cash " + amount + "Balance is " + balance);

    }

    public synchronized  void deposit(int amount){

        System.out.println("Deposit is Processing on "+ accNumber + " .............");


        if(0>amount){
            System.out.println("Balance is greater than 0");
            return;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        balance+=amount;
        System.out.println("withdraw is completed collect you cash " + amount + "Balance is " + balance);

    }
}
