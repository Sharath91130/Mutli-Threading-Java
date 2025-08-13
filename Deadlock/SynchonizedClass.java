package Deadlock;

public class SynchonizedClass {

    private int num=0;

    public    void increment(){
        num++;
    }

    public    void decrement(){
        num--;
    }
    public  int getNum(){
        return num;
    }
}
