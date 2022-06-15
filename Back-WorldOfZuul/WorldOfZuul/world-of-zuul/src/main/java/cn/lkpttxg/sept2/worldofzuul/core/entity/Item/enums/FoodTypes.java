package cn.lkpttxg.sept2.worldofzuul.core.entity.Item.enums;

import java.util.HashMap;

/**
 * 游戏中的食物种类
 *
 * @author PpxiA
 * @version 1.0
 */

public enum FoodTypes {
  /**
   * 魔法饼干
   * 负重+5, 血量+3, 攻击力+0
   */
  MAGICCOOKIE(new Object[]{"#0001", "魔法饼干", "一块可以增强负重的饼干", 1, 5, 0, 3}),
  /**
   * 面包
   * 负重+0, 血量+10, 攻击力+0
   */
  BREAD(new Object[]{"#0002", "面包", "一块平平无奇的面包", 3, 0, 0, 10}),
  /**
   * 酒
   * 负重+0, 血量+0, 攻击力+10
   */
  WINE(new Object[]{"#0003", "茅台酒", "过度饮酒有害健康", 5, 0, 10, 0});

  /**
   * 属性Map
   */
  private final HashMap<String, Object> attribute;

  /**
   * 构造方法，初始化各类食物属性
   *
   * @param attribute 属性列表
   */
  FoodTypes(Object[] attribute){
    this.attribute = new HashMap<>();
    this.attribute.put("id", attribute[0]);
    this.attribute.put("name", attribute[1]);
    this.attribute.put("describe", attribute[2]);
    this.attribute.put("weight", attribute[3]);
    this.attribute.put("addWeight", attribute[4]);
    this.attribute.put("addAttack", attribute[5]);
    this.attribute.put("addHealth", attribute[6]);
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
