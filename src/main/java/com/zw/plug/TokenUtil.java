package com.zw.plug;
import com.zw.cf.model.User;
import java.util.Date;
import java.util.List;

/**
 * Created by zhaowei on 2018/2/26.
 */
public class TokenUtil {

    public static void setToken(String id,String token){
        RedisUtil.getJedis().lpush(id, token);
    }
    public static boolean getToken(String token){
        User user = JwtUtils.unsign(token, User.class);
        Boolean key=false;
        List<String> list=RedisUtil.getJedis().lrange(user.getId(),0,10);
        for(int i=0; i<list.size(); i++) {
            User user1 = JwtUtils.unsign(list.get(i), User.class);
            Date newDate=new Date();
            Date date=user1.getTokenTime();
            if(newDate.getTime()<date.getTime()){
                if(token.equals(list.get(i))){
                    key=true;
                }
            }else{
                RedisUtil.getJedis().rpush(user.getId(),list.get(i));
            }
        }
        return key;
    }
}
