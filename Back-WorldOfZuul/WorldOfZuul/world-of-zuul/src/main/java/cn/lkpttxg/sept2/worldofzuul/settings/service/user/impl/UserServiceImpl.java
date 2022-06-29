package cn.lkpttxg.sept2.worldofzuul.settings.service.user.impl;

import cn.lkpttxg.sept2.worldofzuul.common.enums.room.RoomTypes;
import cn.lkpttxg.sept2.worldofzuul.common.util.UUIDUtil;
import cn.lkpttxg.sept2.worldofzuul.settings.dao.UserMapper;
import cn.lkpttxg.sept2.worldofzuul.settings.entity.user.User;
import cn.lkpttxg.sept2.worldofzuul.settings.service.user.UserService;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.dao.PlayerDao;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import java.util.Stack;
import javax.annotation.Resource;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import org.springframework.stereotype.Service;

import java.util.Stack;

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
  public Player login(String username, String password) {
    User user = userDao.selectUserByPasswordAndUsername(username, password);
    Player player = null;
    if(user != null) {
      player = playerDao.getPlayerById(user.getPlayerId());
      String roomId = player.getCurrentRoom().getId();
      player.setCurrentRoom(game.getGameMap().getRoomById(roomId));
      player.setOldRooms(new Stack<Room>());
      game.addPlayer(player);
    }
    return player;
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
    Player player = new Player();
    player.setId(playerId);
    player.setName(playerName);
    player.setCurrentRoom(new Room(RoomTypes.OUTSIDE));
    playerDao.createPlayer(player);
    userDao.insertUser(user);
    return true;
  }
}
