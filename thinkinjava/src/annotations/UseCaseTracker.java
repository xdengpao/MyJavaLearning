/**
 * Copyright (C), 2018-2019
 * FileName: UseCaseTracker
 * Author:   jzhb
 * Date:     2019/4/18 10:28
 * Description: 注解处理器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package annotations;

/**
 * 〈一句话功能简述〉<br> 
 * 〈注解处理器〉
 *
 * @author jzhb
 * @create 2019/4/18
 * @since 1.0.0
 */
import java.lang.reflect.*;
import java.util.*;
public class UseCaseTracker {
    /*
    追踪实现方法
     */
    public static void
    trackUseCases(List<Integer> useCases,Class<?> cl){
        for (Method m : cl.getDeclaredMethods()){       // 获取声明定义方法
            UseCase uc= m.getAnnotation(UseCase.class);//获取指定类型的注解对象
            if(uc != null){
                System.out.println("Found Use Case:" + uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for(int i : useCases){
            System.out.println("warning: Missing use case-"+i);
        }
    }
    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases,PasswordUtils.class);
    }
}
