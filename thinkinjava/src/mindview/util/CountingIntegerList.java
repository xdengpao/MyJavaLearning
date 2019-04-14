package mindview.util;

import java.util.AbstractList;

/**
 * 项目名称：thinkinjava
 * 类 名 称：CountingIntegerList
 * 类 描 述：TODO
 * 创建时间：2019/4/14 4:14 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CountingIntegerList
extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size){
        this.size = size < 0 ? 0 : size;
    }
    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "test";
    }

    public static void main(String[] args){
        AbstractList<Integer> cuntInterL = new CountingIntegerList(40);
        //cuntInterL.add(5,10);
        System.out.println(Integer.valueOf('A'));
        System.out.println(((CountingIntegerList) cuntInterL).size);
        System.out.println(cuntInterL);
    }
}
