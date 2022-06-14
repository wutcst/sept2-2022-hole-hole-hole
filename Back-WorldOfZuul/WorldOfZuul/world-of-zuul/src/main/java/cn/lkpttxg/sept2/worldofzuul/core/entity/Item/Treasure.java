package cn.lkpttxg.sept2.worldofzuul.core.entity.Item;

import lombok.Data;

/**
 * 财宝实体类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
public class Treasure extends Item {
  /**
   * 物品价值
   */
  private Integer value;

  public Treasure(Integer weight, String describe, String name,
      Integer value) {
    super(weight, describe, name);
    this.value = value;
  }
}
