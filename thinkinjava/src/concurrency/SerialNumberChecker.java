/**
 * Copyright (C), 2018-2019
 * FileName: SerialNumberChecker
 * Author:   jzhb
 * Date:     2019/4/24 10:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jzhb
 * @create 2019/4/24
 * @since 1.0.0
 */

//Reuses storage so we don't run out of memory;
    class CircularSet{
        private int[] array;
        private  int len;
        private int index = 0;
        public  CircularSet(int size){
            array = new int[size];
            len = size;
            //Initialize to a value not produced
            //by the SerialNumberGenerator;
            for(int i = 0; i < size; i++){
                array[i] = -1;
            }
        }
        public  synchronized void add(int i){
            array[index] = i;
            //wrap index and write over old elements;
            index = ++index % len;
        }
        public synchronized boolean contains(int val){
            for(int i = 0; i < len;i++){
                if(array[i] == val){
                    return true;
                }
            }
            return  false;
        }
}
public class SerialNumberChecker {
        private static final int SIZE = 10;
        private static CircularSet serials = new CircularSet(1000);
        private static ExecutorService exec = Executors.newCachedThreadPool();
        static class SerialChecker implements Runnable{
            @Override
            public void run() {
                while(true){
                    int serial = SerialNumberGenerator.nextSerialNumber();
                    if(serials.contains(serial)){
                        System.out.println("Duplicaet: " + serial);
                        System.exit(0);
                    }
                    serials.add(serial);
                }
            }
        }
        public static void main(String[] args) throws Exception{
            for(int i = 0; i < SIZE; i++){
                exec.execute(new SerialChecker());
                //Stop after n seconds if there's an argument;
                if(args.length > 0){
                    TimeUnit.SECONDS.sleep(new Integer(args[0]));
                    System.out.println("No duplicates detected");
                    System.exit(0);
                }
            }
        }
}
