/**
 * Copyright (C), 2018-2019
 * FileName: AtomicityTest
 * Author:   jzhb
 * Date:     2019/4/24 8:40
 * Description: 原子性测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈原子性测试〉
 *
 * @author jzhb
 * @create 2019/4/24
 * @since 1.0.0
 */
public class AtomicityTest implements Runnable{
    private int i = 0;
    public int getValue(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;

    }
    @Override
    public void run() {
        while(true){
            evenIncrement();
        }

    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while(true){
            int val = at.getValue();
            System.out.println(val);
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
