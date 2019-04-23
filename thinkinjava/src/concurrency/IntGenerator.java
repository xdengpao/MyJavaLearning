/**
 * Copyright (C), 2018-2019
 * FileName: IntGenerator
 * Author:   jzhb
 * Date:     2019/4/22 16:24
 * Description: 数字生成器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

/**
 * 〈一句话功能简述〉<br> 
 * 〈数字生成器〉
 *
 * @author jzhb
 * @create 2019/4/22
 * @since 1.0.0
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    //allow this to be canceled;
    public void  cancel(){
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
