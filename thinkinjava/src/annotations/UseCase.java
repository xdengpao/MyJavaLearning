/**
 * Copyright (C), 2018-2019
 * FileName: UseCase
 * Author:   jzhb
 * Date:     2019/4/18 9:53
 * Description: 注解测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package annotations;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈注解测试〉
 *
 * @author jzhb
 * @create 2019/4/18
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    public int id();
    public String description() default "no description";

}
