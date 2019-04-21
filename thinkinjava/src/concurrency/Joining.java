package concurrency;

/**
 * 项目名称：thinkinjava
 * 类 名 称：Joining
 * 类 描 述：TODO
 * 创建时间：2019/4/20 8:23 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();

    }

    @Override
    public void run() {
        try{
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}
class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try{
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {
    public static void main(String[] args){
        Sleeper
                sleepy = new Sleeper("Sleepy",1500),
                grumpy = new Sleeper("Grumpy",1500);
        Joiner
                dopey = new Joiner("Dopey",sleepy),
                doc = new Joiner("Doc",grumpy);
        grumpy.interrupt();

    }
}
