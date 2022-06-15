package cn.lkpttxg.sept2.worldofzuul.core.entity.Item;

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
}
