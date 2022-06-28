package cn.lkpttxg.sept2.worldofzuul.workbench.service.player.impl;

import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomID;
import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.FoodTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.core.Game;
import cn.lkpttxg.sept2.worldofzuul.workbench.dao.PlayerDao;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Food;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Weapon;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import cn.lkpttxg.sept2.worldofzuul.workbench.service.player.PlayerService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 玩家service
 *
 * @author PpxiA
 */
@Service
public class PlayerServiceImpl implements PlayerService {
  @Resource
  private Game game;

  @Override
  public boolean pick(String playerId, String id, Integer location){
    Player player = game.getPlayer(playerId);
    Item item = player.getCurrentRoom().getItem(id, location);
    int weight = player.getWeight() - item.getWeight();
    if(weight < 0){
      return false;
    }
    player.addItem(item);
    player.setWeight(weight);
    return true;
  }

  @Override
  public void throwAway(String playerId, String id){
    Player player = game.getPlayer(playerId);
    Item item = player.getItem(id);
    if(item != null){
      player.setWeight(player.getWeight() + item.getWeight());
      player.deleteItem(id);
    }
  }

  @Override
  public boolean eat(String playerId, String id){
    Player player = game.getPlayer(playerId);
    Item item = player.getItem(id);
    if(item instanceof Food){
      Food food = (Food)item;
      player.setWeight(player.getWeight() + food.getAddWeight() + food.getWeight());
      player.setAttack(player.getAttack() + food.getAddAttack());
      player.setHealth(player.getHealth() + food.getAddHealth());
      player.deleteItem(id);
      return true;
    }
    return false;
  }

  @Override
  public boolean equipWeapon(String playerId, String id) {
    Player player = game.getPlayer(playerId);
    Item item = player.getItem(id);
    if(item instanceof Weapon){
      Weapon weapon = (Weapon)item;
      Weapon nowWeapon = player.getWeapon();
      if(nowWeapon != null){
        player.addItem(nowWeapon);
        player.setAttack(player.getAttack() - nowWeapon.getWeaponAttack());
      }
      player.setAttack(player.getAttack() + weapon.getWeaponAttack());
      return true;
    }
    return false;
  }
}
