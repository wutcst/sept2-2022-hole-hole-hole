package cn.lkpttxg.sept2.worldofzuul.workbench.entity.item;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

/**
 * 物品父类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
public abstract class Item implements Serializable{

  private static final long serialVersionUID = -5474275722705402384L;
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
  /**
   * 物品编号
   */
  private String id;

  public Item(Integer weight, String describe, String name, String id) {
    this.weight = weight;
    this.describe = describe;
    this.name = name;
    this.id = id;
  }

  public Item() {
  }

  /**
   * 基于物品编号比对物品是否相等
   *
   * @param o 比对物品
   * @return true相等 false不相等
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return id.equals(item.id);
  }

  /**
   * 生成hashcode方法
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(weight, describe, name, id);
  }
}
