package cn.lkpttxg.sept2.worldofzuul.workbench.entity.room;

import cn.lkpttxg.sept2.worldofzuul.bean.NullObject;
import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomDirection;
import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomType;
import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.FoodTypes;
import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.TreasureTypes;
import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.WeaponTypes;
import cn.lkpttxg.sept2.worldofzuul.common.enums.monster.MonsterTypes;
import cn.lkpttxg.sept2.worldofzuul.common.enums.room.RoomTypes;
import cn.lkpttxg.sept2.worldofzuul.common.util.CommonUtil;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Food;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Treasure;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Weapon;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.monster.Monster;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * 房间
 *
 * @author TXG
 * @version 1.0
 */
@ApiModel(description = "房间信息")
public class Room implements Serializable {

  private static final long serialVersionUID = 6861875739170631260L;

  /**
   * 房间id
   */
  @ApiModelProperty(value = "房间唯一id",notes = "普通房间以 3xxx 开头，传送房间以 4xxx 开头",required = true,dataType = "String",example = "3001")
  private String id;
  /**
   * 房间类型
   */
  @ApiModelProperty(value = "房间的类型",notes = "普通房间类型为 1，传送房间为 2",required = true,dataType = "Integer",example = "1")
  private Integer roomType;
  /**
   * 房间名
   */
  @ApiModelProperty(value = "房间的名字",example = "例如：forest")
  private String name;
  /**
   * 房间描述
   */
  @ApiModelProperty(value = "房间的简单描述")
  private String description;

  /**
   * 用 HashMap 存放了一个房间的各种出口与其对应房间的 key-value 值.
   */
  @ApiModelProperty(value = "每个出口指向的方向",dataType = "HashMap")
  @JsonBackReference
  private HashMap<String, Room> exits;
  /**
   * 房间内的所有物品
   *//*
  private Item[] items;*/
  /**
   * 房间内除玩家的所有事物
   */
  @ApiModelProperty(value = "当前房间的所有物品")
  private Object[] objects;


  public static void main(String[] args) {
    System.out.println(new Room(RoomTypes.FOREST));
  }

  public Room(){}
  public Room(RoomTypes roomTypes){
    HashMap map = roomTypes.getAttribute();
    this.id = (String)map.get("id");
    this.roomType  = (Integer) map.get("roomType");
    this.name = (String)map.get("name");
    this.description = (String)map.get("description");

    exits = new HashMap<>();
    //items = new Item[25];
    objects = new Object[25];
    //随机初始化物品
    initialRoom();
  }

  /**
   * 初始化房间内的物品位置
   */
  private void initialRoom() {
    for(int i = 0;i<25;i++){
      this.objects[i] = new NullObject();
    }
      //初始化物品
      //1.初始化食物
      int randomLocation1 =  CommonUtil.getRandomLocation();
      this.objects[randomLocation1] = new Food(FoodTypes.values()[(int)(Math.random()*FoodTypes.values().length)]);
      //2.初始化武器
      int randomLocation2 = CommonUtil.getRandomLocation(new int[]{randomLocation1});
      this.objects[randomLocation2] = new Weapon(WeaponTypes.values()[(int)(Math.random()*WeaponTypes.values().length)]);
      //3.初始化宝物
      int randomLocation3 = CommonUtil.getRandomLocation(new int[]{randomLocation1,randomLocation2});
      this.objects[randomLocation3] = new Treasure(TreasureTypes.values()[(int)(Math.random()*TreasureTypes.values().length)]);
      //4.初始化怪物
      int randomLocation4 = CommonUtil.getRandomLocation(new int[]{randomLocation1,randomLocation2,randomLocation3});
      this.objects[randomLocation4] = new Monster(MonsterTypes.values()[(int)(Math.random()*MonsterTypes.values().length)],randomLocation4);
  }

  /**
   * set方法，为房间添加对应的出口与出口对应的其它房间.
   *
   * @param direction 出口方向
   * @param neighbor 出口对应的房间
   */
  public void setExit(String direction, Room neighbor) {
    exits.put(direction, neighbor);
  }

  /**
   * 得到房间简单的描述.
   *
   *@return 对房间进行一个简短的描述
   */
  @ApiModelProperty(value = "房间的简单描述")
  public String getShortDescription() {
    return this.description;
  }

  /**
   * 得到房间细致的描述.
   *
   *@return 对房间进行一个细致描述
   */
  @ApiModelProperty(value = "房间的长描述",example = "你发现自己在 XXX ")
  public String getLongDescription() {
    return "你发现自己在 " + this.description + ".\n" + getItemsDescription() + getExitString();
  }

  /**
   * 获取所有物品的描述信息.
   *
   *@return 物品们的描述信息
   */
  @ApiModelProperty(value = "物品的描述信息",example = "这个地方啥都没有")
  public String getItemsDescription() {
    if (isEmpty()) {
      return "这个地方啥都没有" + '\n';
    }
    StringBuilder s = new StringBuilder("");
    for (Object object : objects) {
      if(object instanceof Item) {
        Item item = (Item)object;
        s.append(item.getName() + "\t" + item.getDescribe() + "\t" + item.getWeight() + "kg" + "\n");
      }
      if(object instanceof Monster) {
        Monster monster = (Monster) object;
        s.append(monster.getName() + "\t" + monster.getDescription() + "\t血量：" + monster.getHealth() + "\t攻击：" +monster.getAttack()+ "\n");
      }
    }
    return "这个地方有:\n" + s.toString();
  }

  /**
   * 检测房间物品是否为空
   * @return
   */
  private boolean isEmpty() {
     for(int i=0;i<25;i++){
       if(objects[i]!=null){
         return false;
       }
     }
     return true;
  }

  /**
   * 获得所有出口的信息.
   *
   * @return 返回房间的所有出口信息
   */
  @ApiModelProperty(value = "所有出口信息")
  private String getExitString() {
    String returnString = "Exits:";
    //获取map对应的set
    Set<String> keys = exits.keySet();
    //输出出口
    for (String exit : keys) {
      returnString += " " + exit;
    }
    return returnString;
  }

  /**
   * 通过方向指令，获得该方向对应的<code>Room</code>对象.
   *
   * @param direction 方向指令
   * @return 返回这个房间某个出口对应的<code>Room</code>对象
   */
  public Room getExit(String direction) {
    return exits.get(direction);
  }

  /**
   * 根据物品名，查看该房间的物品列表，看是否有该物品.
   *
   * @param name 物品名
   * @return 有该物品，返回该物品对象；无则返回 null
   */
  public Item getItem(String name) {
    for (Object object: objects) {
      if (object instanceof Item &&((Item)object).getName().equals(name)) {
        return (Item)object;
      }
    }
    return null;
  }

  /**
   * TODO 拿房间指定位置的物品
   *
   * @param location 物品坐标
   * @return 获取的物品
   */
  public Item getItem(Integer location){
    Item item = null;
    if(objects[location] instanceof Item) {
      item = (Item) objects[location];
    }
    objects[location] = new NullObject();
    return item;
  }

  /**
   * 向房间中增加一个物品。
   *
   * @param item 物品对象
   */
  public void addItem(Item item,Integer location) {
    objects[location] = item;
  }

  /**
   * 判断是否存在某个出口.
   *
   * @param description 出口名
   * @return 存在则返回 true,否则返回 false
   */
  public boolean hasExit(RoomDirection description) {
    if (exits.containsKey(description)) {
      return true;
    }
    return false;
  }

  /**
   * 判断是否是传送房间
   */
  @ApiModelProperty(value = "房间是否是传送房间")
  public boolean isTransferRoom()
  {
    return RoomType.TRANSFER_ROOM.equals(this.roomType);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getRoomType() {
    return roomType;
  }

  public void setRoomType(Integer roomType) {
    this.roomType = roomType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public HashMap<String, Room> getExits() {
    return exits;
  }

  public void setExits(HashMap<String, Room> exits) {
    this.exits = exits;
  }

  public Object[] getObjects() {
    return objects;
  }

  public void setObjects(Object[] objects) {
    this.objects = objects;
  }
}
