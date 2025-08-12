package NotifyAndWait;

public class App {

    public static void main(String[] args) {

        ProducerAndConsumer producerAndConsumer=new ProducerAndConsumer();
        Thread produce=new Thread(()->{
            int i=1;
            try{
                while(true) {
                    producerAndConsumer.produce(i++);
                    Thread.sleep(1000);
                }
            }catch (Exception e){

            }
        });

        Thread consume=new Thread(()->{


                try {
                    while (true) {
                        producerAndConsumer.consume();
                        Thread.sleep(2000);
                    }


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        });
        produce.start();
        consume.start();
    }
}
