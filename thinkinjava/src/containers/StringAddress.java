/**
 * Copyright (C), 2018-2019
 * FileName: StringAddress
 * Author:   jzhb
 * Date:     2019/4/12 16:13
 * Description: 地址输出构造
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package containers;

/**
 * 〈一句话功能简述〉<br> 
 * 〈地址输出构造〉
 *
 * @author jzhb
 * @create 2019/4/12
 * @since 1.0.0
 */
public class StringAddress {
    private String s;
    public StringAddress(String s){
        this.s = s;
    }
    public String toString(){
        return super.toString() + " " + s;
    }
}
