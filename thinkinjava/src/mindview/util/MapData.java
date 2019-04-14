package mindview.util;

import java.util.LinkedHashMap;

/**
 * 项目名称：thinkinjava
 * 类 名 称：MapData
 * 类 描 述：TODO
 * 创建时间：2019/4/13 7:11 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {

    /*
     *功能描述 a single pair generator
     * @author dengpao
     * @date 2019/4/13
      * @Param gen
     * @Param quantity
     * @return
     */
    public MapData(Generator<Pair<K,V>> gen,int quantity){
        for(int i =0;i<quantity;i++){
            Pair<K,V> p = gen.next();
            put(p.key,p.value);
        }
    }

    /*
     *功能描述 tow seperate generators
     * @author dengpao
     * @date 2019/4/13
      * @Param genK
     * @Param genV
     * @Param quantity
     * @return
     */
    public MapData(Generator<K> genK, Generator<V> genV,int quantity){
        for(int i = 0;i<quantity;i++){
            put(genK.next(),genV.next());
        }
    }

    /*
     *功能描述 a key Generator and a single value
     * @author dengpao
     * @date 2019/4/13
      * @Param genK
     * @Param value
     * @Param quantity
     * @return
     */
    public MapData(Generator<K> genK, V value,int quantity){
        for(int i = 0;i<quantity;i++){
            put(genK.next(),value);
        }
    }

    /*
     *功能描述 An Iterable and a value Generator
     * @author dengpao
     * @date 2019/4/13
      * @Param genK
     * @Param genV
     * @return
     */
    public MapData(Iterable<K> genK,Generator<V> genV){
        for(K key : genK){
            put(key,genV.next());
        }
    }

    /*
     *功能描述 an iterable and a single value
     * @author dengpao
     * @date 2019/4/13
      * @Param genK
     * @Param value
     * @return
     */
    public MapData(Iterable<K> genK, V value){
        for(K key : genK){
            put(key,value);
        }
    }

    //generic convenience methods

    /*
     *功能描述 single pair generator convenience methods
     * @author dengpao
     * @date 2019/4/13
      * @Param gen
     * @Param quantity
     * @return mindview.util.MapData<K,V>
     */
    public static <K,V> MapData<K,V>
    map(Generator<Pair<K,V>>gen,int quantity){
        return new MapData<K,V>(gen,quantity);
    }

    /*
     *功能描述 two seperate generators convenience methods
     * @author dengpao
     * @date 2019/4/13
      * @Param genK
     * @Param genV
     * @Param quantity
     * @return mindview.util.MapData<K,V>
     */
    public static <K,V> MapData<K,V>
    map(Generator<K> genK,Generator<V> genV,int quantity){
        return new MapData<>(genK,genV,quantity);
    }

    /*
     *功能描述 an iterable and a generator convenience method
     * @author dengpao
     * @date 2019/4/13
      * @Param genK
     * @Param genV
     * @return mindview.util.MapData<K,V>
     */
    public static <K,V> MapData<K,V>
    map(Iterable<K> genK,Generator<V> genV){
        return new MapData<K,V>(genK,genV);
    }

    /*
     *功能描述 an iterable and a value convenience method
     * @author dengpao
     * @date 2019/4/13
      * @Param genK
     * @Param value
     * @return mindview.util.MapData<K,V>
     */
    public static <K,V> MapData<K,V>
    map(Iterable<K> genK,V value){
        return new MapData<>(genK,value);
    }


}
