/**
 * Copyright (C), 2018-2019
 * FileName: SimpleDaemons
 * Author:   jzhb
 * Date:     2019/4/19 14:15
 * Description: 后台线程测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈后台线程测试〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class SimpleDaemons implements Runnable{

    @Override
    public void run(){
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");

        }

    }
    public static void main(String[] args) throws  Exception{
        for(int i = 0;i<10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); //Must call before start()启动之前设置为后天运行
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
