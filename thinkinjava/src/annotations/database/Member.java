/**
 * Copyright (C), 2018-2019
 * FileName: Member
 * Author:   jzhb
 * Date:     2019/4/18 11:46
 * Description: 测试数据库注解
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package annotations.database;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试数据库注解〉
 *
 * @author jzhb
 * @create 2019/4/18
 * @since 1.0.0
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;
    public String getHandle(){
        return handle;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String toString(){
        return handle;
    }
    public Integer getAge(){
        return age;
    }
}
