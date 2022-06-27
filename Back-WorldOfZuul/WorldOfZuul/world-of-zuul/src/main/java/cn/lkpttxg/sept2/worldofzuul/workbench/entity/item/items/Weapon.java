package cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items;

import java.util.HashMap;

import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.WeaponTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 武器实体类
 *
 * @author PpxiA
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
  /**
   * 武器类型
   */
  private WeaponTypes type;

  /**
   * 根据武器种类构造对象
   *
   * @param weaponType 武器种类
   */
  public Weapon(WeaponTypes weaponType){
    HashMap<String, Object> map = weaponType.getAttribute();
    super.setId((String)map.get("id"));
    super.setName((String)map.get("name"));
    super.setWeight((Integer) map.get("weight"));
    super.setDescribe((String)map.get("describe"));
    this.durable = (Integer)map.get("durable");
    this.weaponAttack = (Integer)map.get("weaponAttack");
  }
}
