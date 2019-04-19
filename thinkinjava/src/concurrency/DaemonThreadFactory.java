/**
 * Copyright (C), 2018-2019
 * FileName: DaemonThreadFactory
 * Author:   jzhb
 * Date:     2019/4/19 14:28
 * Description: 后台线程工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈后台线程工厂〉
 *
 * @author jzhb
 * @create 2019/4/19
 * @since 1.0.0
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r){
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
