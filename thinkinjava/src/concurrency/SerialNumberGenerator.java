/**
 * Copyright (C), 2018-2019
 * FileName: SerialNumberGenerator
 * Author:   jzhb
 * Date:     2019/4/24 10:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jzhb
 * @create 2019/4/24
 * @since 1.0.0
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public  static int nextSerialNumber(){
        return serialNumber++; //Not thread-safe
    }
}
