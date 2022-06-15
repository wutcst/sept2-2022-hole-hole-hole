package cn.lkpttxg.sept2.worldofzuul.core.dao;

import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 玩家类的dao
 *
 * @author PpxiA
 */
public class PlayerDao {
  @Resource
  private RedisTemplate redisTemplate;


}
