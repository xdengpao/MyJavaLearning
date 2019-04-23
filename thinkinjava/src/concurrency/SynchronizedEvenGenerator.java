/**
 * Copyright (C), 2018-2019
 * FileName: SynchronizedEvenGenerator
 * Author:   jzhb
 * Date:     2019/4/23 16:03
 * Description: 同步锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈同步锁〉
 *
 * @author jzhb
 * @create 2019/4/23
 * @since 1.0.0
 */
public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    public synchronized int next(){
        ++currentEvenValue;
        Thread.yield();//cause failure faster

        ++currentEvenValue;
        System.out.println("test yield()"+currentEvenValue);
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

}
