/**
 * Copyright (C), 2018-2019
 * FileName: EvenChecker
 * Author:   jzhb
 * Date:     2019/4/22 16:16
 * Description: 共享资源
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈共享资源〉
 *
 * @author jzhb
 * @create 2019/4/22
 * @since 1.0.0
 */
public class EvenChecker implements Runnable{
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g, int ident){
        generator = g;
        id = ident;
    }
    @Override
    public void run() {
        while(!generator.isCanceled()){
            int val = generator.next();
            if(val % 2 != 0){
                System.out.println(val + " not even!");
                generator.cancel();//Cancels all EvenCheckers
            }
        }

    }
    //Test any type of IntGenerator:
    public static void test(IntGenerator gp, int count){
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i < count; i++){
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }
    //Default value for count:
    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
