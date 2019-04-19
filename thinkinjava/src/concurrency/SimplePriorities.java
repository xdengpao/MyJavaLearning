/**
 * Copyright (C), 2018-2019
 * FileName: SimplePriorities
 * Author:   jzhb
 * Date:     2019/4/19 13:49
 * Description: 设置优先级
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设置优先级〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class SimplePriorities implements  Runnable{
    private int countDown = 5;
    private volatile double d;//No optimization
    private int priority;
    public SimplePriorities(int priority){
        this.priority = priority;
    }
    public String toString(){
        return Thread.currentThread() + ": " +countDown;
    }
    public void run(){
        Thread.currentThread().setPriority(priority);
        while(true){
            // An expensive, interruptable operation;
            for(int i = 1;i < 100000;i++){
                d += (Math.PI + Math.E) /(double)i;
                if(i%1000 == 0){
                    Thread.yield();
                }

            }
            System.out.println(this);
            if(--countDown == 0)
                return;
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
