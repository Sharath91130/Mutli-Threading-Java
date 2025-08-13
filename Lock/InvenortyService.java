package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InvenortyService {
    public InvenortyService() {
    }

    public InvenortyService(int availableStocks) {
        this.availableStocks = availableStocks;
    }

    private int availableStocks;


    Lock lock=new ReentrantLock();


    public void addStock(int quantity){

        lock.lock();
        try {
            System.out.println("adding items to stock is processing");
            Thread.sleep(2000);
            availableStocks+=quantity;
            System.out.println("Stock Updating Done check new Availabe stocks "+availableStocks);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }






    }

    public void removeStocks(int quantity){
      lock.lock();
        try {
            System.out.println("reducing stock quantity please wait ");
            lock.lock();
            availableStocks-=quantity;
            System.out.println("remove the stock quantity successfully check available stocks ...." + this.availableStocks);


            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }
    }
}
