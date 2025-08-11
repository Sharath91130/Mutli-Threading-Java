package Join;

public class DepositThread extends  Thread{

    private Bank bank;

    private int amount;


    public DepositThread(Bank  bank ,int amount){
        this.amount=amount;
        this.bank= bank;
    }



    public void run(){
        bank.deposit(amount);
    }


}
