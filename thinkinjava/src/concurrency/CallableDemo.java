/**
 * Copyright (C), 2018-2019
 * FileName: CallableDemo
 * Author:   jzhb
 * Date:     2019/4/19 11:05
 * Description:  线程中回调函数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import  java.util.concurrent.*;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈 任务中的回调函数〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() {
        return "result of TaskWithResult " + id;
    }
}
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0;i<10;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results){
            try{
                //get() blocks until completion:
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }
            finally {
                exec.shutdown();
            }
        }

    }
}
