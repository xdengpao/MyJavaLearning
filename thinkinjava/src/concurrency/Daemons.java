package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 项目名称：thinkinjava
 * 类 名 称：Daemons
 * 类 描 述：TODO
 * 创建时间：2019/4/20 1:42 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
class Daemon implements Runnable{
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for(int i = 0;i<t.length;i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn "+i+" started, ");
        }
        for(int i = 0;i<t.length;i++){
            System.out.println("t[" + i +"].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while(true){
            Thread.yield();
        }

    }

}
class DaemonSpawn implements Runnable{
    @Override
    public void run() {
        while(true)
            Thread.yield();
    }
}
public class Daemons{
    public static void main(String[] args) throws Exception{
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        // Allow the daemon threads to
        // finish their startup processes:
        TimeUnit.SECONDS.sleep(1);
    }
}