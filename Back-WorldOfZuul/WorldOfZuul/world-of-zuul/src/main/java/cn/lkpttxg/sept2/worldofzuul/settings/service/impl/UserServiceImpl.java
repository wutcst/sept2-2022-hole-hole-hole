package cn.lkpttxg.sept2.worldofzuul.settings.service.impl;

import cn.lkpttxg.sept2.worldofzuul.common.util.UUIDUtil;
import cn.lkpttxg.sept2.worldofzuul.settings.dao.UserMapper;
import cn.lkpttxg.sept2.worldofzuul.settings.entity.user.User;
import cn.lkpttxg.sept2.worldofzuul.settings.service.UserService;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.dao.PlayerDao;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 用户服务类
 *
 * @author PpxiA
 */
@Service
public class UserServiceImpl implements UserService {
  @Resource
  private UserMapper userDao;
  @Resource
  private PlayerDao playerDao;
  @Resource
  private Game game;

  /**
   * 用户登录
   *
   * @param username 用户名
   * @param password 用户密码
   */
  @Override
  public User login(String username, String password) {
    User user = userDao.selectUserByPasswordAndUsername(username, password);
    game.addPlayer(playerDao.getPlayerById(user.getPlayerId()));
    return user;
  }

  /**
   * 用户注册
   *
   * @param username 用户名
   * @param playerName 玩家名
   * @param email 邮箱
   * @param password 密码
   */
  @Override
  public boolean register(String username, String playerName, String email, String password) {
    User user = userDao.selectUserByUsername(username);
    if(user != null){
      return false;
    }
    String playerId = UUIDUtil.getUUID();
    user = new User(null, playerId, password, username, email);
    Player player = new Player(playerId, playerName);
    playerDao.createPlayer(player);
    userDao.insertUser(user);
    return true;
  }
}
