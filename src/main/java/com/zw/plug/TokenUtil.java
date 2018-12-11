package com.zw.plug;

import com.zw.cf.vo.TokenVo;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by zhaowei on 2018/2/26.
 */
public class TokenUtil {

    public static void setToken(Long id, String token, int ...args) {
        Jedis jedis = RedisUtil.getJedis();
        try {
            jedis.lpush(String.valueOf(id), token);
            if(args.length>0){
                jedis.expire(String.valueOf(id),args[0]);
            }

        } catch (Exception e) {
            RedisUtil.close(jedis);
        } finally {
            RedisUtil.close(jedis);
        }
    }

    public static TokenVo getTokenVo(String token) {
        TokenVo tokenVo = JwtUtils.unsign(token, TokenVo.class);
        Jedis jedis = RedisUtil.getJedis();
        try {
            List<String> list = jedis.lrange(String.valueOf(tokenVo.getId()), 0, 10);
            for (int i = 0; i < list.size(); i++) {
                if (JwtUtils.unsign(list.get(i), TokenVo.class) == null) {
                    continue;
                }
                if (token.equals(list.get(i))) {
                    RedisUtil.close(jedis);
                    return tokenVo;
                }
                // jedis.lrem(user.getId(), 0, list.get(i));
            }
            RedisUtil.close(jedis);
            return null;
        } catch (Exception e) {
            RedisUtil.close(jedis);
            return null;
        }
    }
}
