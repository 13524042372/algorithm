import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Consumer;

public class ThisEscape {
    private int a = 10;

    public ThisEscape(List source){
        source.add(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("a:" + a);

            }

        });

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.a = 10;
    }


    public static void main(String[] args) throws InterruptedException {
        List<Consumer> source = new ArrayList<>(100);

        Thread t1 = new Thread(()->{
            System.out.println();
            while(true){
               if(source.size()>0){
                   Consumer consumer = source.get(0);
                   consumer.accept(null);
                   break;
               }
            }
        });
        t1.start();
        ThisEscape thisEscape = new ThisEscape(source);
           System.out.println(thisEscape.toString());
        Thread.sleep(1000);
//        Thread.sleep(10);
//        Thread t2 = new Thread(()->{
//            ThisEscape thisEscape = new ThisEscape(source);
//            System.out.println(thisEscape.toString());
//        });
//        t2.start();
    }


}
