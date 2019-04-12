/**
 * Copyright (C), 2018-2019
 * FileName: FillingLists
 * Author:   jzhb
 * Date:     2019/4/12 15:57
 * Description: //containers/FillingLists.java
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package containers;

/**
 * 〈一句话功能简述〉<br> 
 *  容器填充
 *
 * @author jzhb
 * @create 2019/4/12
 * @since 1.0.0
 */
import java.util.*;

public class FillingLists {
    public static void main(String[] args){
        List<StringAddress> list = new ArrayList<>(
            Collections.nCopies(4,new StringAddress("Hello"))
        );
        System.out.println(list);
        Collections.fill(list,new StringAddress("World!"));
        System.out.println(list);
    }

}
