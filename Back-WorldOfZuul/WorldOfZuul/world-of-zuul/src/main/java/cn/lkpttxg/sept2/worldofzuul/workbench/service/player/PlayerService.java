package cn.lkpttxg.sept2.worldofzuul.workbench.service.player;

/**
 * 玩家service
 *
 * @author PpxiA
 */
public interface PlayerService {

  /**
   * 拾取房间物品
   *
   * @param id 物品编号
   * @param location 物品位置
   * @param playerId 玩家编号
   * @return 成功拾取返回true 拾取失败返回false
   */
  public boolean pick(String playerId, String id, Integer location);

  /**
   * 丢弃物品
   *
   * @param playerId 玩家id
   * @param id 物品id
   */
  public void throwAway(String playerId, String id);

  /**
   * 吃东西
   *
   * @param playerId 玩家id
   * @param id 物品编号
   * @return 可以吃返回true 不能吃返回false
   */
  public boolean eat(String playerId, String id);

  /**
   * 装备武器
   *
   * @param playerId 玩家id
   * @param id 物品编号
   * @return 可以装备返回true 不能装备返回false
   */
  public boolean equipWeapon(String playerId, String id);
}
