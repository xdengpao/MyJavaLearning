/**
 * Copyright (C), 2018-2019
 * FileName: SleepingTask
 * Author:   jzhb
 * Date:     2019/4/19 11:43
 * Description: sleep方法测试
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
 * 〈sleep方法测试〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try{
            while(countDown-- > 0){
                System.out.print(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i < 5;i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
