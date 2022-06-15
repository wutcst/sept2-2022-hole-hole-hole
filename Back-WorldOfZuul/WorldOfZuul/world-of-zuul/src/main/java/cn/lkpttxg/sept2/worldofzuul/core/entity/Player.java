package cn.lkpttxg.sept2.worldofzuul.core.entity;

import cn.lkpttxg.sept2.worldofzuul.core.entity.Item.Item;
import cn.lkpttxg.sept2.worldofzuul.core.entity.Item.Weapon;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Stack;
import lombok.Data;

/**
 * 玩家类，包含玩家的基本属性
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
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
  private String money;
  /**
   * 玩家负重量
   */
  private String weight;
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
  private Integer locX;
  /**
   * 玩家当前纵坐标
   */
  private Integer locY;
  /**
   * 玩家当前持有的武器
   */
  private Weapon weapon;
  /**
   * 玩家的攻击力
   */
  private Integer attack;
  /**
   * 玩家的血量
   */
  private Integer health;

  public Player(String id, String name, String money, String weight,
      HashMap<Item, Integer> bag, Room currentRoom,
      Stack<Room> oldRooms, Integer locX, Integer locY,
      Weapon weapon, Integer attack, Integer health) {
    this.id = id;
    this.name = name;
    this.money = money;
    this.weight = weight;
    this.bag = bag;
    this.currentRoom = currentRoom;
    this.oldRooms = oldRooms;
    this.locX = locX;
    this.locY = locY;
    this.weapon = weapon;
    this.attack = attack;
    this.health = health;
  }
  public Player(){}
}
