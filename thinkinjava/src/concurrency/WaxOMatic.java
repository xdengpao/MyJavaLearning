/**
 * Copyright (C), 2018-2019
 * FileName: WaxOMatic
 * Author:   jzhb
 * Date:     2019/4/26 13:41
 * Description: 挂起和重启任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;
import java.util.concurrent.*;
/**
 * 〈一句话功能简述〉<br> 
 * 〈挂起和重启任务〉
 *
 * @author jzhb
 * @create 2019/4/26
 * @since 1.0.0
 */
class Car{
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn = true; //Ready to buff
        notifyAll();
    }
    public synchronized void buffed(){
        waxOn = false; //Ready for another coat of wax
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException{
        while(waxOn == false){
            wait();
        }

    }
    public synchronized void waitForBuffing() throws InterruptedException{
        while(waxOn == true){
            wait();
        }
    }
}
class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car c){
        car = c;
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                System.out.println("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");

    }
}
class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car c){
        car = c;
    }
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitForBuffing();
                System.out.println("Wax off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();

            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax off task");
    }
}
public class WaxOMatic {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);//Run for a while...
        exec.shutdownNow();//interrupt all tasks
    }
}
