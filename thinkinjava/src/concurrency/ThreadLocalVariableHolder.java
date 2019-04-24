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
    private static ThreadLocal<Integer> value = new ThreadLocal<>(){
        private Random rand = new Random(47);
        protected synchronized Integer initialValue(){
            return rand.nextInt(10000);
        }
    }
}
