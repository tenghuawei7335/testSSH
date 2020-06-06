package com.company.project.service.imp;

import com.company.project.pojo.SeeUser;
import com.company.project.service.RedisBaiseTakes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: com.company.project.service.imp
 * @ClassName: SeeUserRedisTakes
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/5/29 0029 21:10
 * @Day: 星期五
 */
@Repository
public class SeeUserRedisTakes implements RedisBaiseTakes<String,String, SeeUser> {
    private  static  final Logger logger= LoggerFactory.getLogger(SeeUserRedisTakes.class);
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public Jedis selectDBindex(int DBindex) {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection connection = RedisConnectionUtils.getConnection(connectionFactory);
        Jedis jedis= (Jedis) connection.getNativeConnection();
        jedis.select(DBindex);
        return jedis;
    }

    @Override
    public void add(String key, String value) {
      if(redisTemplate==null) {
          logger.warn("redisTemplate===add实例化失败！");
          return ;
      }
        logger.warn("redisTemplate===add实例化成功！");
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void addObj(String objectKey, String key, SeeUser object) {
        if(redisTemplate==null) {
            logger.warn("redisTemplate===addObj实例化失败！");
            return ;
        }
        logger.warn("redisTemplate===add实例化成功！");
        redisTemplate.opsForHash().put(objectKey, key, object);
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public void delete(List<String> listKeys) {

    }

    @Override
    public void deletObj(String objecyKey, String key) {

    }

    @Override
    public void update(String key, String value) {

    }

    @Override
    public void updateObj(String objectKey, String key, SeeUser object) {

    }

    @Override
    public String get(Jedis jedis,String key) {
        if(redisTemplate==null) {
            logger.warn("redisTemplate===getj实例化失败！");
            System.exit(-1);
        }
        logger.warn("redisTemplate===add实例化成功！");
        //String key1 = String.valueOf(redisTemplate.opsForValue().get(key));

        String key1 = jedis.get(key);
        return key1;
    }

    @Override
    public SeeUser getObj(String objectKey, String key) {
        if(redisTemplate==null) {
            logger.warn("redisTemplate===getj实例化失败！");
            System.exit(-1);
        }
        logger.warn("redisTemplate===add实例化成功！");
        SeeUser seeUser= (SeeUser) redisTemplate.opsForHash().get(objectKey,key);
        return seeUser;
    }
}
