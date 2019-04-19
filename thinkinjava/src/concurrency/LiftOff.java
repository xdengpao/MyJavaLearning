/**
 * Copyright (C), 2018-2019
 * FileName: LiftOff
 * Author:   jzhb
 * Date:     2019/4/19 8:54
 * Description: 实现接口Runnable定义任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实现接口Runnable定义任务〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class LiftOff implements Runnable{
    protected int countDown = 10; //Default
    protected static int taskCount = 0;
    private final  int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id + "(" +(countDown>0?countDown:"Liftoff!")+"). ";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
        System.out.println(" ");

    }
}
