package containertest;

import mindview.util.Generator;
import mindview.util.MapData;
import mindview.util.Pair;

import java.util.Iterator;

/**
 * 项目名称：thinkinjava
 * 类 名 称：MapDataTest
 * 类 描 述：TODO
 * 创建时间：2019/4/13 8:27 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
class Letters implements Generator<Pair<Integer,String>>,
        Iterable<Integer>{
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    /*
     *功能描述 对象对next
     * @author dengpao
     * @date 2019/4/13
      * @Param
     * @return mindview.util.Pair<java.lang.Integer,java.lang.String>
     */
    public Pair<Integer,String> next(){
        return new Pair<>(number++," "+letter++);
    }
    /*
     *功能描述 匿名类生成迭代器
     * @author dengpao
     * @date 2019/4/13
      * @Param
     * @return java.util.Iterator<java.lang.Integer>
     */
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args){
        //pair generator
        System.out.print(MapData.map(new Letters(),11));
        //an iterable and a single value
        System.out.print(MapData.map(new Letters(),"pop"));
    }}
