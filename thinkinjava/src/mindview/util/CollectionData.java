/**
 * Copyright (C), 2018-2019
 * FileName: CollectionData
 * Author:   jzhb
 * Date:     2019/4/12 16:26
 * Description: 容器数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package mindview.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈容器数据〉
 * 适配器模式的一个实例，将generator适配到Collection的构造器上
 *
 * @author jzhb
 * @create 2019/4/12
 * @since 1.0.0
 */
import java.util.*;
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen,int quantity){
        for(int i = 0;i<quantity;i++){
            add(gen.next());
        }
    }
    //A generic convenience method;
    public  static <T> CollectionData<T>
    list(Generator<T> gen, int quantity){
        return new CollectionData<T>(gen,quantity);
    }

}
