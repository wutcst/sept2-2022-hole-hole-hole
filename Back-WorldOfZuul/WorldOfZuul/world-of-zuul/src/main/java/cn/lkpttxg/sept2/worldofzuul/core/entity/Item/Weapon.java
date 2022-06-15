package cn.lkpttxg.sept2.worldofzuul.core.entity.Item;

import lombok.Data;

/**
 * 武器实体类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
public class Weapon extends Item {

  private static final long serialVersionUID = -8649276121917779517L;
  /**
   * 武器的攻击力
   */
  private Integer weaponAttack;
  /**
   * 武器的耐久
   */
  private Integer durable;

  public Weapon(String id, Integer weight, String describe, String name, Integer weaponAttack,
      Integer durable) {
    super(weight, describe, name, id);
    this.weaponAttack = weaponAttack;
    this.durable = durable;
  }
}
