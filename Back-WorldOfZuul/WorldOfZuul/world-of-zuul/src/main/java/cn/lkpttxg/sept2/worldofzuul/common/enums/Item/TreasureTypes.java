package cn.lkpttxg.sept2.worldofzuul.common.enums.Item;

import java.util.HashMap;

/**
 * 游戏中的财宝种类
 *
 * @author PpxiA
 * @version 1.0
 */

public enum TreasureTypes {
  /**
   * 钻石
   * 价值 10
   */
  DIAMOND(new Object[]{"#0004", "钻石", "钻石代表永恒", 5, 10}),
  /**
   * 黄金
   * 价值 5
   */
  GOLD(new Object[]{"#0005", "黄金", "是金子总能发光的", 5, 5}),
  /**
   * 宝石
   * 价值 15
   */
  GEM(new Object[]{"#0006", "艾哲红石", "闪烁着妖异的红光", 8, 15});

  /**
   * 属性Map
   */
  private final HashMap<String, Object> attribute;

  /**
   * 构造方法，初始化各类财宝属性
   *
   * @param attribute 属性列表
   */
  TreasureTypes(Object[] attribute){
    this.attribute = new HashMap<>();
    this.attribute.put("id", attribute[0]);
    this.attribute.put("name", attribute[1]);
    this.attribute.put("describe", attribute[2]);
    this.attribute.put("weight", attribute[3]);
    this.attribute.put("value", attribute[4]);
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
