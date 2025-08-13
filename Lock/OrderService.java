package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderService {

    Lock lock=new ReentrantLock();

            InvenortyService invenortyService;

    public OrderService(InvenortyService invenortyService) {
        this.invenortyService=invenortyService;
    }


    public  void buyProduct(int quantity){

        System.out.println("Processing to Buy the product..");


        lock.lock();
        invenortyService.removeStocks(quantity);

        System.out.println("User successfully buy the product  " + quantity);


         lock.unlock();
    }
}
