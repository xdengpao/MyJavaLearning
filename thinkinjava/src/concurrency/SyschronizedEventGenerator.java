/**
 * Copyright (C), 2018-2019
 * FileName: SyschronizedEventGenerator
 * Author:   jzhb
 * Date:     2019/4/23 16:18
 * Description: 互斥锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;
import java.util.concurrent.locks.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈互斥锁〉
 *
 * @author jzhb
 * @create 2019/4/23
 * @since 1.0.0
 */
public class SyschronizedEventGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try{
            ++currentEvenValue;
            Thread.yield();//Cause failure faster
            ++currentEvenValue;
            System.out.println("test thread:"+currentEvenValue);
            return currentEvenValue;
        }finally {
            lock.unlock();
        }

    }
    public static void main(String[] args){
        EvenChecker.test(new SyschronizedEventGenerator());
    }
}
