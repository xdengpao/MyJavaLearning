/**
 * Copyright (C), 2018-2019
 * FileName: ThreadLocalVariableHolder
 * Author:   jzhb
 * Date:     2019/4/24 16:46
 * Description: 线程本地存储
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程本地存储〉
 *
 * @author jzhb
 * @create 2019/4/24
 * @since 1.0.0
 */
import java.util.concurrent.*;
import java.util.*;
class Accessor implements Runnable{
    private final int id;
    public Accessor(int idn){
        id = idn;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random rand = new Random(47);
        protected synchronized Integer initialValue(){
            return rand.nextInt(10000);
        }
    };
    public static void increment(){
        value.set(value.get() + 1);
    }
    public static int get(){
        return value.get();
    }
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i < 5;i++){
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3); //Run for a while
        exec.shutdown(); //All Accessors will quit
    }
}
