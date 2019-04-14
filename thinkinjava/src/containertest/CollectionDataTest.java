package containertest;

import mindview.util.CollectionData;
import mindview.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 项目名称：thinkinjava
 * 类 名 称：CollectionDataTest
 * 类 描 述：测试LinkList类
 * 创建时间：2019/4/12 11:18 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds "+"distributing swords is no basis for a system of "+"government").split(" ");
    private  int index;
    public String next(){
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args){
        Set<String> set1 = new LinkedHashSet<>(new CollectionData<>(new Government(),15));
        //using the convenience method
        Set<String> set2 = new LinkedHashSet<>();
        set2.addAll(CollectionData.list(new Government(),15));
        System.out.println(set1);
        System.out.println(set2);
    }

}
