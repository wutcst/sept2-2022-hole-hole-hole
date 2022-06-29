package cn.lkpttxg.sept2.worldofzuul.common.consts;


/**
 * 行为结果
 *
 * @author PpxiA
 */
public interface ActionResult {

  /**
   * 成功
   */
  Integer SUCCESS = 1;

  /**
   * 超重
   */
  Integer OVERWEIGHT = 2;

  /**
   * 位置不存在物品
   */
  Integer MISS = 3;

  /**
   * 行为和物品不匹配
   */
  Integer UNMATCH = 4;
}
