package cn.lkpttxg.sept2.worldofzuul.core.entity.Item;

import java.io.Serializable;
import lombok.Data;

/**
 * 物品父类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
public abstract class Item implements Serializable{

  /**
   * 物品重量
   */
  private Integer weight;
  /**
   * 物品描述
   */
  private String describe;
  /**
   * 物品名称
   */
  private String name;

  public Item(Integer weight, String describe, String name) {
    this.weight = weight;
    this.describe = describe;
    this.name = name;
  }
}
