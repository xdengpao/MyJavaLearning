/**
 * Copyright (C), 2018-2019
 * FileName: MutiLock
 * Author:   jzhb
 * Date:     2019/4/26 10:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈同一个互斥如何被同一个任务多次获得〉
 *
 * @author jzhb
 * @create 2019/4/26
 * @since 1.0.0
 */
public class MutiLock {
    public synchronized void f1(int count){
        if(count-- > 0){
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
        }
    }
    public synchronized void f2(int count){
        if(count-- > 0){
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }
    public static void main(String[] args) throws Exception{
        final MutiLock mutiLock = new MutiLock();
        new Thread(){
            public void run(){
                mutiLock.f1(10);
            }
        }.start();
    }
}
