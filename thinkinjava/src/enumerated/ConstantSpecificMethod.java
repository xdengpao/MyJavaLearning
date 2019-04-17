package enumerated;

import java.text.DateFormat;
import java.util.*;

public enum ConstantSpecificMethod {
    DATE_TIME{
        String getInfo(){
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH{
        String getInfo(){
            return System.getProperty("java.version");
        }
    };
    //实例化中的方法继承改方法
    abstract String getInfo();

    public static void main(String[] args){
        for(ConstantSpecificMethod csm : values()){
            System.out.println(csm.getInfo());
        }
    }

}
