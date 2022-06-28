package cn.lkpttxg.sept2.worldofzuul.common.util;
import java.util.UUID;

/**
 * 用于生成随机ID
 *
 * @author PpxiA
 */
public class UUIDUtil {

  /**
   * 获取uuid
   * @return 返回uuid
   */
  public static String getUUID(){
    UUID uuid = UUID.randomUUID();
    String str = uuid.toString();
    return str.replace("-", "");
  }
}
