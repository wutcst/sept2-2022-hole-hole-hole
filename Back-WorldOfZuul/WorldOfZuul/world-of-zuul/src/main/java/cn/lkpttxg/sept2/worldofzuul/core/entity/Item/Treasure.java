package cn.lkpttxg.sept2.worldofzuul.core.entity.Item;

import cn.lkpttxg.sept2.worldofzuul.core.entity.Item.enums.TreasureTypes;
import java.util.HashMap;
import java.util.Objects;
import lombok.Data;

/**
 * 财宝实体类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
public class Treasure extends Item {

  private static final long serialVersionUID = -4981090747474372788L;
  /**
   * 物品价值
   */
  private Integer value;

  public Treasure(String id, Integer weight, String describe, String name,
      Integer value) {
    super(weight, describe, name, id);
    this.value = value;
  }

  /**
   * 根据财宝种类构造对象
   *
   * @param treasureType 财宝种类
   */
  public Treasure(TreasureTypes treasureType){
    HashMap<String, Object> map = treasureType.getAttribute();
    super.setId((String)map.get("id"));
    super.setName((String)map.get("name"));
    super.setWeight((Integer) map.get("weight"));
    super.setDescribe((String)map.get("describe"));
    this.value = (Integer)map.get("value");
  }
}
