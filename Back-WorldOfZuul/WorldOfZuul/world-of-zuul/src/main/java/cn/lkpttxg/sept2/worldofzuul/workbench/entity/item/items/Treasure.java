package cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items;

import java.util.HashMap;

import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.TreasureTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 财宝实体类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
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
