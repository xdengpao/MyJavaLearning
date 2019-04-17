/**
 * Copyright (C), 2018-2019
 * FileName: Reflection
 * Author:   jzhb
 * Date:     2019/4/17 11:30
 * Description: enum反射机制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package enumerated;
import java.util.*;
import java.lang.reflect.*;
/**
 * 〈一句话功能简述〉<br> 
 * 〈enum反射机制〉
 *
 * @author jzhb
 * @create 2019/4/17
 * @since 1.0.0
 */
enum Explore{HEAR,THERE}
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("-----Analyzing " + enumClass + "------");
        System.out.println("Interfaces:");
        for(Type t:enumClass.getGenericInterfaces()){
            System.out.println(t);

        }
        System.out.println("Base: "+enumClass.getSuperclass());
        System.out.println("Methods: ");

        Set<String> methods = new TreeSet<String>();

        for(Method m : enumClass.getMethods()){
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }
    public static void main(String[] args){
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)?"+ exploreMethods.containsAll(enumMethods));
        System.out.println(exploreMethods);
       // OSExecute.command("javap Explore");
    }
}
