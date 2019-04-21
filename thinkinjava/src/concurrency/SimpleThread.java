package concurrency;

/**
 * 项目名称：thinkinjava
 * 类 名 称：SimpleThread
 * 类 描 述：TODO
 * 创建时间：2019/4/20 3:06 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class SimpleThread extends Thread{
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread(){
        //Store the thread name:
        super(Integer.toString(++threadCount));
        start();
    }
    public String toString(){
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while(true){
            System.out.println(this);
            if(--countDown == 0){
                return;
            }
        }
    }
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new SimpleThread();
        }
    }
}
