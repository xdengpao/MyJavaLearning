/**
 * Copyright (C), 2018-2019
 * FileName: SingleThreadExecutor
 * Author:   jzhb
 * Date:     2019/4/19 10:56
 * Description: 相当于线程数量为1的FixedThreadPool
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈相当于线程数量为1的FixedThreadPool〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();//可用于序列化任务
        for(int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
