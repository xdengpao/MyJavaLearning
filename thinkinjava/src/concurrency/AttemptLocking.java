/**
 * Copyright (C), 2018-2019
 * FileName: AttemptLocking
 * Author:   jzhb
 * Date:     2019/4/23 16:45
 * Description: 尝试获取锁一段时间，然后放弃它
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br> 
 * 〈尝试获取锁一段时间，然后放弃它〉
 *
 * @author jzhb
 * @create 2019/4/23
 * @since 1.0.0
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public  void untimed(){
        boolean captured = lock.tryLock();
        try{
            System.out.println("tryLock(): " + captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }
    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2,TimeUnit.SECONDS);
        }catch (InterruptedException e ){
            System.out.println("tryLock(2,TimeUnit.SECONDS): "+captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }
    public static void main(String[] args){
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); //true -- lock is available
        al.timed(); //true -- lock is available
        //now create a separate task to grab the lock:
        new Thread(){
            {setDaemon(true);}
            public void run(){
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();//Give the 2nd task a chance
        al.untimed(); //False -- lock grabbed by task
        al.timed(); //False -- lock grabbed by task

    }
}
