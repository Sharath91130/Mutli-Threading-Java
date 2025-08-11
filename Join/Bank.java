package Join;

public class Bank {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Bank() {
    }

    private String accountNumber;

    public Bank(int balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }


    public void deposit(int amount){


        if(amount<0){
            System.out.println("Deposit Amount have greater than  0... please Try Again");
            return;
        }
        this.balance+=amount;

        System.out.println("Deposit Successfully Done to "+ accountNumber+" ... Your Balance is " + this.balance);

        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void withDraw(int amount){
        if(amount>this.balance){
            System.out.println("Withdraw Amount have greater than  Balance amount... please Try Again");
        }
     this.balance-=amount;
        System.out.println("WithDraw Successfully Done to "+ accountNumber+" ... Your Balance is " + this.balance);

        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
