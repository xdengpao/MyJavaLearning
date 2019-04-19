/**
 * Copyright (C), 2018-2019
 * FileName: MainThread
 * Author:   jzhb
 * Date:     2019/4/19 9:05
 * Description: test my thread
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test my thread〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class MainThread {
    public static void main(String[] args){
        LiftOff launch = new LiftOff(20);
        launch.run();
    }
}
