/**
 * Copyright (C), 2018-2019
 * FileName: BasicThreads
 * Author:   jzhb
 * Date:     2019/4/19 9:13
 * Description: Runnable对象转变为工作任务并提交给Thread构造器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Runnable对象转变为工作任务并提交给Thread构造器〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class BasicThreads {
    public static void main(String[] args){
        for (int i = 0;i<5;i++){
            new Thread(new LiftOff()).start();

        }
        System.out.println("Waiting for Liftoff");


    }
}
