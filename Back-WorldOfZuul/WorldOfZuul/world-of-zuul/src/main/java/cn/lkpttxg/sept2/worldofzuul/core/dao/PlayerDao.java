package cn.lkpttxg.sept2.worldofzuul.core.dao;

import cn.lkpttxg.sept2.worldofzuul.common.util.SerializeUtil;
import cn.lkpttxg.sept2.worldofzuul.core.entity.Item.Item;
import cn.lkpttxg.sept2.worldofzuul.core.entity.Item.Weapon;
import cn.lkpttxg.sept2.worldofzuul.core.entity.Player;
import cn.lkpttxg.sept2.worldofzuul.core.entity.Room;
import java.util.HashMap;
import java.util.Stack;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 玩家类的dao
 *
 * @author PpxiA
 */
public class PlayerDao {
  private RedisTemplate<String, byte[]> redisTemplate;
  // TODO: 依赖注入
  SerializeUtil sru = new SerializeUtil();
  // TODO: redisTemplate无法注入
  public PlayerDao(RedisTemplate redisTemplate){
    this.redisTemplate = redisTemplate;
  }
  /**
   * 创建玩家
   * @param player 玩家对象
   */
  public void createPlayer(Player player){
    byte[] byteArr = sru.serizlize(player);
    redisTemplate.opsForValue().set(player.getId(), byteArr);
  }

  /**
   * 获取玩家
   * @param id 玩家id
   * @return 玩家
   */
  public Player getPlayerById(String id){
    byte[] byteArr = (byte[])redisTemplate.opsForValue().get(id);
    return (Player) sru.deserialize(byteArr);
  }

  /**
   * 获取玩家生命值
   * @param id 玩家id
   * @return 玩家生命值
   */
  public Integer getHealthById(String id){
    Player player = getPlayerById(id);
    return player.getHealth();
  }

  /**
   * 获取玩家位置
   * @param id 玩家id
   * @return 玩家位置
   */
  public int[] getLocationById(String id){
    Player player = getPlayerById(id);
    return new int[]{player.getLocX(), player.getLocY()};
  }

  /**
   * 获取玩家名字
   * @param id 玩家id
   * @return 玩家名字
   */
  public String getNameById(String id){
    Player player = getPlayerById(id);
    return player.getName();
  }

  /**
   * 获取玩家负重
   * @param id 玩家id
   * @return 玩家负重
   */
  public Integer getWeightById(String id){
    Player player = getPlayerById(id);
    return player.getWeight();
  }

  /**
   * 玩家武器
   * @param id 玩家id
   * @return 玩家持有武器
   */
  public Weapon getWeaponById(String id){
    Player player = getPlayerById(id);
    return player.getWeapon();
  }

  /**
   * 获取玩家攻击力
   * @param id 玩家id
   * @return 玩家当前攻击力
   */
  public Integer getAttackById(String id){
    Player player = getPlayerById(id);
    return player.getAttack();
  }

  /**
   * 获取玩家当前房间
   * @param id 玩家id
   * @return 玩家当前所处房间
   */
  public Room getCurrentRoomById(String id){
    Player player = getPlayerById(id);
    return player.getCurrentRoom();
  }

  /**
   * 获取玩家历史房间栈
   * @param id 玩家id
   * @return 玩家历史房间栈
   */
  public Stack<Room> getOldRoomsById(String id){
    Player player = getPlayerById(id);
    return player.getOldRooms();
  }

  /**
   * 获取玩家背包
   * @param id 玩家id
   * @return 玩家背包
   */
  public HashMap<Item, Integer> getBagById(String id){
    Player player = getPlayerById(id);
    return player.getBag();
  }

  /**
   * 获取玩家金钱
   * @param id 玩家id
   * @return 玩家所持金钱
   */
  public Integer getMoneyById(String id){
    Player player = getPlayerById(id);
    return player.getMoney();
  }

  /**
   * 更新玩家生命值
   * @param id 玩家id
   * @param health 玩家生命值
   */
  public void updateHealthById(String id, Integer health){
    Player player = getPlayerById(id);
    player.setHealth(health);
    createPlayer(player);
  }

  /**
   * 更新玩家负重
   * @param id 玩家id
   * @param weight 玩家负重
   */
  public void updateWeightById(String id, Integer weight){
    Player player = getPlayerById(id);
    player.setWeight(weight);
    createPlayer(player);
  }

  /**
   * 更新玩家攻击力
   * @param id 玩家id
   * @param attack 攻击力
   */
  public void updateAttackById(String id, Integer attack){
    Player player = getPlayerById(id);
    player.setAttack(attack);
    createPlayer(player);
  }

  /**
   * 更新玩家当前房间
   * @param id 玩家id
   * @param currentRoom 玩家当前房间
   */
  public void updateCurrentRoom(String id, Room currentRoom){
    Player player = getPlayerById(id);
    player.setCurrentRoom(currentRoom);
    createPlayer(player);
  }

  /**
   * 更新玩家历史房间栈
   * @param id 玩家id
   * @param oldRooms 玩家历史房间
   */
  public void updateOldRooms(String id, Stack<Room> oldRooms){
    Player player = getPlayerById(id);
    player.setOldRooms(oldRooms);
    createPlayer(player);
  }

  /**
   * 更新玩家背包
   * @param id 玩家id
   * @param bag 背包
   */
  public void updateBagById(String id, HashMap<Item, Integer> bag){
    Player player = getPlayerById(id);
    player.setBag(bag);
    createPlayer(player);
  }

  /**
   * 更新玩家武器
   * @param id 玩家id
   * @param weapon 玩家武器
   */
  public void updateWeaponById(String id, Weapon weapon){
    Player player = getPlayerById(id);
    player.setWeapon(weapon);
    createPlayer(player);
  }

  /**
   * 更新玩家持有金钱
   * @param id 玩家id
   * @param money 玩家金钱
   */
  public void updateMoneyById(String id, Integer money){
    Player player = getPlayerById(id);
    player.setMoney(money);
    createPlayer(player);
  }

  /**
   * 更新玩家当前位置
   * @param id 玩家id
   * @param location 玩家坐标
   */
  public void updateLocationById(String id, int[] location){
    Player player = getPlayerById(id);
    player.setLocX(location[0]);
    player.setLocY(location[1]);
    createPlayer(player);
  }
}
