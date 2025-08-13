package Deadlock;

public class App {
    public static void main(String[] args) {
        SynchonizedClass synchonizedClass=new SynchonizedClass();
        Thread t1=new Thread(()->{



                try {
                    for (int i = 1; i <=10; i++) {
                        synchonizedClass.increment();
                        System.out.println(synchonizedClass.getNum());

                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



        });
        Thread t2=new Thread(()->{



                for (int i = 1; i <=10; i++) {
                    synchonizedClass.increment();
                    System.out.println(synchonizedClass.getNum());


            }

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("final output "+synchonizedClass.getNum());

    }
}
