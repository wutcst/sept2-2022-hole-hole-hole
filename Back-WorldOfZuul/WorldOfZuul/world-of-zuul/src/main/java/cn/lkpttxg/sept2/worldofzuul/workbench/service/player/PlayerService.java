package cn.lkpttxg.sept2.worldofzuul.workbench.service.player;

import cn.lkpttxg.sept2.worldofzuul.common.consts.ActionResult;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;

/**
 * 玩家service
 *
 * @author PpxiA
 */
public interface PlayerService {

  /**
   * 拾取房间物品
   *
   * @param location 物品位置
   * @param player 玩家
   * @return 成功拾取返回 SUCCESS 超重失败返回 OVERWEIGHT 没有物品返回 MISS
   */
  public Integer pick(Player player, Integer location);

  /**
   * 丢弃物品
   *
   * @param player 玩家id
   * @param id 物品id
   */
  public void throwAway(Player player, String id);

  /**
   * 吃东西
   *
   * @param player 玩家
   * @param id 物品编号
   * @return 可以吃返回 SUCCESS 不能吃返回 UNMATCH
   */
  public Integer eat(Player player, String id);

  /**
   * 装备武器
   *
   * @param player 玩家
   * @param id 物品编号
   * @return 可以装备返回 SUCCESS 不能装备返回 UNMATCH
   */
  public Integer equipWeapon(Player player, String id);
}
