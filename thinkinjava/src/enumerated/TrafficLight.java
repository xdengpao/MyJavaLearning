/**
 * Copyright (C), 2018-2019
 * FileName: TrafficLight
 * Author:   jzhb
 * Date:     2019/4/17 11:16
 * Description: Enums in switch statements
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package enumerated;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Enums in switch statements〉
 *
 * @author jzhb
 * @create 2019/4/17
 * @since 1.0.0
 */
enum Signal { GREEN,YELLOW,RED,}
public class TrafficLight {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            //Note that you don't have to say Signal.RED
            //in the case statement;
            case RED: color = Signal.GREEN;
                        break;
            case GREEN: color = Signal.YELLOW;
                        break;
            case YELLOW:color = Signal.RED;
                        break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is" + color+"\n";
    }
    public static void main(String[] args){
        TrafficLight t = new TrafficLight();
        for(int i = 0;i<7;i++){
           System.out.print(t);
            t.change();
        }
    }
}
