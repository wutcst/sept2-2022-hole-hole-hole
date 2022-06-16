package cn.lkpttxg.sept2.worldofzuul.common.enums.Item;

import java.util.HashMap;

/**
 * 游戏中的武器种类
 *
 * @author PpxiA
 * @version 1.0
 */

public enum WeaponTypes {
  /**
   * 小刀
   * 攻击力 5 耐久 5
   */
  KNIFE(new Object[]{"#0007", "匕首", "短小精悍", 5, 5, 5}),
  /**
   * 铁剑
   * 攻击力 10, 耐久 10
   */
  SWORD(new Object[]{"#0008", "铁剑", "精准而优雅", 15, 10, 10}),
  /**
   * 誓约胜利之剑
   * 攻击力 50, 耐久100
   */
  EXCALIBUR(new Object[]{"#0009", "誓约胜利之剑", "Excalibur!!", 25, 50, 100});

  /**
   * 属性Map
   */
  private final HashMap<String, Object> attribute;

  /**
   * 构造方法，初始化各类武器属性
   *
   * @param attribute 属性列表
   */
  WeaponTypes(Object[] attribute){
    this.attribute = new HashMap<>();
    this.attribute.put("id", attribute[0]);
    this.attribute.put("name", attribute[1]);
    this.attribute.put("describe", attribute[2]);
    this.attribute.put("weight", attribute[3]);
    this.attribute.put("weaponAttack", attribute[4]);
    this.attribute.put("durable", attribute[5]);
  }

  /**
   * 获取参数
   *
   * @return 参数map
   */
  public HashMap<String, Object> getAttribute() {
    return attribute;
  }
}
