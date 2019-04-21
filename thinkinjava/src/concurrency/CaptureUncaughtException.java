package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 项目名称：thinkinjava
 * 类 名 称：CaptureUncaughtException
 * 类 描 述：TODO
 * 创建时间：2019/4/21 10:49 AM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler()
        );
        throw new RuntimeException();

    }
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught" + e);
    }
}
class HandlerThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t= new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
public class CaptureUncaughtException {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory()
        );
        exec.execute(new ExceptionThread2());
    }
}
