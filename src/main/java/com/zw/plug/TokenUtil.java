package com.zw.plug;

import com.zw.cf.vo.TokenVo;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by zhaowei on 2018/2/26.
 */
public class TokenUtil {

    public static void setToken(String id, String token, int ...args) {
        Jedis jedis = RedisUtil.getJedis();
        try {
            jedis.lpush(id, token);
            if(args.length>0){
                jedis.expire(id,args[0]);
            }

        } catch (Exception e) {
            RedisUtil.close(jedis);
        } finally {
            RedisUtil.close(jedis);
        }
    }

    public static boolean isAuth(String token) {
        TokenVo tokenVo = JwtUtils.unsign(token, TokenVo.class);
        Boolean key = false;
        Jedis jedis = RedisUtil.getJedis();
        try {
            List<String> list = jedis.lrange(tokenVo.getId(), 0, 10);
            for (int i = 0; i < list.size(); i++) {
                TokenVo tokenVo1 = JwtUtils.unsign(list.get(i), TokenVo.class);
                if (tokenVo1 == null) {
                    continue;
                }
                if (token.equals(list.get(i))) {
                    key = true;
                    break;
                }
                // jedis.lrem(user.getId(), 0, list.get(i));
            }


            RedisUtil.close(jedis);
            return key;
        } catch (Exception e) {
            RedisUtil.close(jedis);
            return false;
        }
    }
}
