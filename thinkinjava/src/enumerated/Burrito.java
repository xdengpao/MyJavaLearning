/**
 * Copyright (C), 2018-2019
 * FileName: Burrito
 * Author:   jzhb
 * Date:     2019/4/17 10:07
 * Description: burrito
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package enumerated;
//import  enumerated.Spiciness.*;
/**
 * 〈一句话功能简述〉<br> 
 * 〈burrito〉
 *
 * @author jzhb
 * @create 2019/4/17
 * @since 1.0.0
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree){
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }
    public static void main(String[] args){
        System.out.println(new Burrito(Spiciness.NOT));
        System.out.println(new Burrito(Spiciness.MEDIUM));
        System.out.println(new Burrito(Spiciness.HOT));


    }
}
