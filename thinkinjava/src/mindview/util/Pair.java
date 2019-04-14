package mindview.util;

/**
 * 项目名称：thinkinjava
 * 类 名 称：Pair
 * 类 描 述：信使
 * 创建时间：2019/4/13 2:10 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Pair<K,V> {
    public final K key;
    public final V value;
    public Pair(K k,V v){
        key = k;
        value = v;
    }

}
