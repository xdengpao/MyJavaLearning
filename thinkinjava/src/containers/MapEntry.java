/**
 * Copyright (C), 2018-2019
 * FileName: MapEntry
 * Author:   jzhb
 * Date:     2019/4/16 14:05
 * Description: mapentry
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package containers;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈mapentry〉
 *
 * @author jzhb
 * @create 2019/4/16
 * @since 1.0.0
 */
public class MapEntry<K,V>implements Map.Entry<K,V> {
    private K key;
    private V value;
    public MapEntry(K key,V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }
    public int hashCode(){
        return(key == null?0:key.hashCode())^(value==null?0:value.hashCode());
    }
    public boolean equals(Object o){
        if(!(o instanceof MapEntry)){
            return false;
        }
        MapEntry me = (MapEntry)o;
        return(key == null?me.getKey()==null:key.equals(me.getKey()))&&
                (value ==null?
                me.getValue()==null:value.equals(me.getValue()));
    }
    public String toString(){
        return key + "=" + value;
    }
}
