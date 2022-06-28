package cn.lkpttxg.sept2.worldofzuul.workbench.entity.player;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Weapon;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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

  /**
   * 往背包中加一个物品
   *
   * @param item 加入的物品
   */
  public void addItem(Item item){
    bag.put(item, bag.getOrDefault(item, 0) + 1);
  }

  /**
   * 删除背包中的一项物品 TODO 测试能否正确丢弃物品
   *
   * @param id 要丢弃的物品的id
   */
  public void deleteItem(String id){
    Iterator<Entry<Item, Integer>> it = bag.entrySet().iterator();
    while (it.hasNext()){
      Entry<Item, Integer> itEntry = it.next();
      if(itEntry.getKey().getId().equals(id)){
        int num = itEntry.getValue() - 1;
        if(num == 0){
          it.remove();
          return;
        }
        itEntry.setValue(num);
        return;
      }
    }
  }

  /**
   * 根据物品id获取背包中的物品
   *
   * @param id 物品id
   * @return 有物品返回物品 无物品返回null
   */
  public Item getItem(String id){
    for(Map.Entry<Item, Integer> entry : bag.entrySet()){
      if(entry.getKey().getId().equals(id)){
        return entry.getKey();
      }
    }
    return null;
  }
}
