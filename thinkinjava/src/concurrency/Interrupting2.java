/**
 * Copyright (C), 2018-2019
 * FileName: Interrupting2
 * Author:   jzhb
 * Date:     2019/4/26 11:14
 * Description: ReentrantLock阻塞终端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈ReentrantLock阻塞终端〉
 *
 * @author jzhb
 * @create 2019/4/26
 * @since 1.0.0
 */
//Interrupting a task blocked with a ReentrantLock.
class BlockedMutex{
    private Lock lock = new ReentrantLock();
    public BlockedMutex(){
        //Acquire it right away. to demonstrate interruptioon
        //of a task blocked on a ReentrantLock:
        lock.lock();
    }
    public void f(){
        try{
            //This will newver be available to a second task
            lock.lockInterruptibly();;//Special call
            System.out.println("lock acquired in f()");
        }catch (InterruptedException e){
            System.out.println("Interrupted from lock acquiisition in f()");
        }
    }

}
class Blocked2 implements Runnable{
    BlockedMutex blocked = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}
public class Interrupting2 {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Blocked2());
        t.start();;
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}
