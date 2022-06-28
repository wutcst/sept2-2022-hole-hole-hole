package cn.lkpttxg.sept2.worldofzuul.workbench.entity.player;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Weapon;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Stack;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 玩家类，包含玩家的基本属性
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable{

  private static final long serialVersionUID = -8097775438557074550L;
  /**
   * 玩家id
   */
  private String id;
  /**
   * 玩家名字
   */
  private String name;
  /**
   * 玩家金钱
   */
  private Integer money = 0;
  /**
   * 玩家负重量
   */
  private Integer weight = 10;
  /**
   * 玩家背包
   */
  private HashMap<Item, Integer> bag;
  /**
   * 玩家当前房间
   */
  private Room currentRoom;
  /**
   * 玩家历史房间
   */
  private Stack<Room> oldRooms;
  /**
   * 玩家当前横坐标
   */
  private Integer loc = 12;
  /**
   * 玩家当前持有的武器
   */
  private Weapon weapon;
  /**
   * 玩家的攻击力
   */
  private Integer attack = 5;
  /**
   * 玩家的血量
   */
  private Integer health = 100;

  /**
   * 构造方法
   * @param id 玩家id
   * @param name 玩家名
   */
  public Player(String id, String name){
    this.id = id;
    this.name = name;
  }
}
