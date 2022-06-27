package cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items;

import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.FoodTypes;
import java.util.HashMap;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 食物实体类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food extends Item {

  private static final long serialVersionUID = 8565511453210334744L;
  /**
   * 对负重的加成
   */
  private Integer addWeight;
  /**
   * 对攻击力的加成
   */
  private Integer addAttack;
  /**
   * 对生命值的恢复
   */
  private Integer addHealth;
  /**
   * 食物类型
   */
  private FoodTypes type;

  /**
   * 根据食物种类构造对象
   *
   * @param foodType 食物种类
   */
  public Food(FoodTypes foodType){
    HashMap<String, Object> map = foodType.getAttribute();
    super.setId((String)map.get("id"));
    super.setName((String)map.get("name"));
    super.setWeight((Integer) map.get("weight"));
    super.setDescribe((String)map.get("describe"));
    this.addWeight = (Integer) map.get("addWeight");
    this.addAttack = (Integer) map.get("addAttack");
    this.addHealth = (Integer) map.get("addHealth");
  }
}
