package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AQSCondition {

    final ReentrantLock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public void awaitTest() throws Exception{
        try {
            lock.lock();
            condition.await();
            System.out.println("解除等待");
        } finally {
            lock.unlock();
        }
    }
    public void signalTest(){
        try {
            lock.lock();
            condition.signal();
            System.out.println("继续执行");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AQSCondition test = new AQSCondition();
        new Thread(()->{
            try {
                test.awaitTest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            test.signalTest();
        }).start();
    }
}
