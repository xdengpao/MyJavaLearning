/**
 * Copyright (C), 2018-2019
 * FileName: SyncObject
 * Author:   jzhb
 * Date:     2019/4/24 15:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈两个任务同时进入同一个对象〉
 *
 * @author jzhb
 * @create 2019/4/24
 * @since 1.0.0
 */
 class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f(){
        for(int i = 0;i < 5; i++){
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g(){
        synchronized (syncObject){
            for(int i = 0;i < 5; i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
public class SyncObject{
    public static void main(String[] args){
        final DualSynch ds = new  DualSynch();
        new Thread(){
            public void run(){
                ds.f();
            }
        }.start();
        ds.g();
    }

}
