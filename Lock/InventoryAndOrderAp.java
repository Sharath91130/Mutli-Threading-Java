package Lock;

public class InventoryAndOrderAp {
    public static void main(String[] args) {

        InvenortyService invenortyService=new InvenortyService(100);
        OrderService orderService=new OrderService(invenortyService);
        Thread t1=new Thread(()->{
            invenortyService.addStock(100);
        });

        Thread t2=new Thread(()->{
            orderService.buyProduct(10);

        });

        t1.start();
        try {
            Thread.sleep(3000);

            t1.join();
            t2.start();

            t2.interrupt();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
