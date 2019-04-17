/**
 * Copyright (C), 2018-2019
 * FileName: RoShamBo
 * Author:   jzhb
 * Date:     2019/4/17 17:50
 * Description: 执行分发
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package enumerated;

import mindview.util.Enums;

/**
 * 〈一句话功能简述〉<br> 
 * 〈执行分发〉
 *
 * @author jzhb
 * @create 2019/4/17
 * @since 1.0.0
 */
public class RoShamBo {
    public static <T extends Competitor<T>>
    void match(T a,T b){
        System.out.println(a + " vs. "+b+": "+a.compete(b));
    }
    public static <T extends Enum<T> & Competitor<T>>
    void play(Class<T> rsbClass, int size){
        for(int i = 0;i < size;i++){
            match(Enums.random(rsbClass),Enums.random(rsbClass));
            System.out.println("test!");
        }
    }
}
