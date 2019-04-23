/**
 * Copyright (C), 2018-2019
 * FileName: EvenGenerator
 * Author:   jzhb
 * Date:     2019/4/23 14:03
 * Description: IntGenerator 的偶数生成器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈IntGenerator 的偶数生成器〉
 *
 * @author jzhb
 * @create 2019/4/23
 * @since 1.0.0
 */
public class EvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;// Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new EvenGenerator());
    }
}
