/**
 * Copyright (C), 2018-2019
 * FileName: PasswordUtils
 * Author:   jzhb
 * Date:     2019/4/18 10:11
 * Description: 注解测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package annotations;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈注解测试类〉
 *
 * @author jzhb
 * @create 2019/4/18
 * @since 1.0.0
 */
public class PasswordUtils {
    @UseCase(id = 47,description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }
    @UseCase(id = 48)
    public String encryptPssword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49,description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password){
        return !prevPasswords.contains(password);
    }
}
