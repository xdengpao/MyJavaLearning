/**
 * Copyright (C), 2018-2019
 * FileName: Interrupting
 * Author:   jzhb
 * Date:     2019/4/26 9:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jzhb
 * @create 2019/4/26
 * @since 1.0.0
 */
class SleepBlocked implements Runnable{
    @Override
    public void run() {
        try{
            TimeUnit.SECONDS.sleep(100);
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocaked.run()");
    }
}
class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream is){
        in = is;
    }

    @Override
    public void run() {
        try{
            System.out.println("Waiting for read():");
            in.read();
        }catch (IOException e){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocaked I/O");
            }else{
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
class SynchronizedBlocked implements Runnable{
    public synchronized void f(){
        while(true) //Never releases lock
        {
            Thread.yield();
        }
    }
    public SynchronizedBlocked(){
        new Thread(){
            public void run(){
                f();//Lock acquired by this thread
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");

    }
}
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);//Interrupts if running
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }
    public static void main(String[] args) throws Exception{
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);//... since last 2 interrupts failed
    }
}
