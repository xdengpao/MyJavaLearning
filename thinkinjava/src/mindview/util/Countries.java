package mindview.util;

import java.util.*;

/**
 * 项目名称：thinkinjava
 * 类 名 称：Countries
 * 类 描 述：TODO
 * 创建时间：2019/4/14 9:11 AM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Countries {
    public static final String[][] DATA= {
            //Africa
            {"fdsd1","fqwer1"},{"stwer1","turtr1"},
            {"fdsd2","fqwer2"},{"stwer2","turtr2"},
            {"fdsd3","fqwer3"},{"stwer3","turtr3"},
            {"fdsd4","fqwer4"},{"stwer4","turtr4"},
            {"fdsd5","fqwer5"},{"stwer5","turtr5"},
            {"fdsd6","fqwer6"},{"stwer6","turtr6"},
    };
    private static class FlyweightMap
    extends AbstractMap<String,String>{

        private static class Entry
        implements Map.Entry<String,String>{
            int index;
            Entry(int index){
                this.index = index;
            }
            public boolean equals(Object o){
                return DATA[index][0].equals(o);
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }
            public int hashCode(){
                return DATA[index][0].hashCode();
            }
        }

        //use abstractset by implementing size() & iterator
        static class EntrySet
        extends AbstractSet<Map.Entry<String,String>>{
            private int size;
            EntrySet(int size){
                if(size < 0){
                    this.size = 0;
                }else if(size > DATA.length){
                    this.size = DATA.length;
                }else{
                    this.size = size;
                }
            }
            private class Iter
            implements Iterator<Map.Entry<String,String>>{
                //only one entry object per iterator
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index<size -1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }
        }

        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);
        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }
    }
    //
    //create a partial map of 'size' countries;
    static Map<String,String> select(final int size){
        return new FlyweightMap(){
            public Set<Map.Entry<String,String>> entrySet(){
                return new EntrySet(size);
            }
        };
    }
    static Map<String,String> map = new FlyweightMap();
    public static Map<String,String> captials(){
        return map;
    }
    public static Map<String,String> capitals(int size){
        return select(size);
    }
    static List<String> names = new ArrayList<String>(map.keySet());
    //All the names;
    public static List<String> names(){
        return names;
    }
    //a partial list
    public static List<String> names(int size){
        return new ArrayList<>(select(size).keySet());
    }
    public static void main(String[] args){
        System.out.print(capitals(5));
        System.out.print(names(5));
        //System.out.print(entrySet());
    }
}
