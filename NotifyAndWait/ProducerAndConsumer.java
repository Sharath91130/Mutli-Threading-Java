package NotifyAndWait;

import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumer {

    private final static  int capacity=5;

    List<Integer> buffer=new ArrayList<>();


    public synchronized void produce(int value) throws InterruptedException{
        while(buffer.size()==capacity){
            System.out.println("Buffer is Full ....Producer is waiting");

            wait();

        }
        buffer.add(value);
        System.out.println("Produce value "+value);;
        notify();
    }
    public synchronized void consume( ) throws InterruptedException{
        while(buffer.isEmpty()){
            System.out.println("buffer is emptyyy consumer waiting");
            wait();
        }
        int i=buffer.remove(buffer.size()-1);
        System.out.println("consume value "+ " "+ i);
        notify();
    }
}
