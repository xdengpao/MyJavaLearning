package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 项目名称：thinkinjava
 * 类 名 称：DeamonsDontRunFinally
 * 类 描 述：TODO
 * 创建时间：2019/4/20 2:23 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
class ADaemon implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            System.out.println("Exiting via InterruptedExcepttion");
        }finally {
            System.out.println("This should always run?");
        }
    }
}
public class DeamonsDontRunFinally {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
