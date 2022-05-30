package cc.tianbin.pattern.proxy;

import cc.tianbin.pattern.proxy.agent.Select;

/**
 * Created by nibnait on 2022/05/31
 */
public interface UserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
