package mindview.util;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 项目名称：thinkinjava
 * 类 名 称：CountingMapData
 * 类 描 述：TODO
 * 创建时间：2019/4/14 6:19 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CountingMapData
extends AbstractMap <Integer,String>{
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    public CountingMapData(int size){
        if(size < 0){
            this.size = 0;
        }
        this.size = size;

    }
    private static  class Entry
    implements Map.Entry<Integer,String>{
        int index;
        Entry(int index){
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            return Integer.valueOf(index).equals(obj);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] +
                    Integer.toString(index/chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        //LinkedHashSet retains initialization order
        Set<Map.Entry<Integer,String>> entries = new LinkedHashSet<Map.Entry<Integer, String>>();
        for(int i = 0;i<size;i++){
            entries.add(new Entry(i));
        }
        return entries;
    }
    public static void main(String[] args){
        System.out.println(new CountingMapData(60));
    }
}
