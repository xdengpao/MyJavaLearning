/**
 * Copyright (C), 2018-2019
 * FileName: CachedThreadPool
 * Author:   jzhb
 * Date:     2019/4/19 10:20
 * Description: 线程池
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程池〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
import java.util.concurrent.*;
public class CachedThreadPool {
    //使用Executor创建线程
    public static void main(String[] args){
//        ExecutorService exec = Executors.newCachedThreadPool();//为每个任务创建一个线程
//        for (int i = 0;i<5;i++){
//            exec.execute(new LiftOff());
//        }
//        exec.shutdown();
        ExecutorService exec2 = Executors.newFixedThreadPool(4);
        for(int i = 0;i<5;i++){
            exec2.execute(new LiftOff());
        }
        exec2.shutdown();
    }
}
