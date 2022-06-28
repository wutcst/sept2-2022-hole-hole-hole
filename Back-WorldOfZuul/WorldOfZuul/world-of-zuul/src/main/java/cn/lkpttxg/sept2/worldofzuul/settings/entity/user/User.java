package cn.lkpttxg.sept2.worldofzuul.settings.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * @author PpxiA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  /**
   * 用户id
   */
  private int userId;
  /**
   * 用户绑定玩家id
   */
  private String playerId;
  /**
   * 用户密码
   */
  private String password;
  /**
   * 用户名
   */
  private String username;
  /**
   * 用户邮箱
   */
  private String email;
}
