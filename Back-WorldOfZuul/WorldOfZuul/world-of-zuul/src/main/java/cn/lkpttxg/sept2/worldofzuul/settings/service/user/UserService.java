package cn.lkpttxg.sept2.worldofzuul.settings.service.user;

import cn.lkpttxg.sept2.worldofzuul.settings.entity.user.User;
import org.springframework.stereotype.Service;

/**
 * 用户service类接口
 *
 * @author PpxiA
 */
public interface UserService {

  /**
   * 用户登录
   *
   * @param username
   * @param password
   * @return 登录成功返回用户 登录失败返回null
   */
  public User login(String username, String password);

  /**
   * 用户注册
   *
   * @param username 用户名
   * @param playerName 玩家名
   * @param email 邮箱
   * @param password 密码
   * @return 如果存在用户返回false 否则返回true
   */
  public boolean register(String username, String playerName, String email, String password);

}
