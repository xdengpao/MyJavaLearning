/**
 * Copyright (C), 2018-2019
 * FileName: DaemonFromFactory
 * Author:   jzhb
 * Date:     2019/4/19 15:01
 * Description: 后台线程工厂测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈后台线程工厂测试〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class DaemonFromFactory implements Runnable{
    @Override
    public void run() {
        try{
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool( new DaemonThreadFactory());
        for (int i = 0;i<10;i++){
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);//Run for a while
    }
}
