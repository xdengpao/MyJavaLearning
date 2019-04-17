/**
 * Copyright (C), 2018-2019
 * FileName: RoShamBol
 * Author:   jzhb
 * Date:     2019/4/17 16:53
 * Description: 多路分发
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package enumerated;

//import java.awt.print.Paper;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br> 
 * 〈多路分发〉
 *
 * @author jzhb
 * @create 2019/4/17
 * @since 1.0.0
 */
interface Item{
    Outcome compete(Item it);
    Outcome eval(Paper p);
    Outcome eval(Scissors s);
    Outcome eval(Rock r);
}
class Paper implements Item{
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}
class Scissors implements Item{
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
class Rock implements Item{
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
public class RoShamBol {
    static final int SIZE = 20;
    private static Random rand = new Random(47);
    public static Item newItem(){
        switch (rand.nextInt(3)){
            default:
            case 0: return new Scissors();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }
    public static void match(Item a,Item b){
        System.out.println(a+" vs. "+b+": "+a.compete(b));
    }
    public static void main(String[] args){
        for(int i = 0;i<SIZE;i++){
            match(newItem(),newItem());

        }
    }
}
