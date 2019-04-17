package mindview.util;

//import java.util.Random;
import java.util.*;

/**
 * 项目名称：thinkinjava
 * 类 名 称：Enums
 * 类 描 述：随机选取
 * 创建时间：2019/4/17 9:12 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Enums {
    private  static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
