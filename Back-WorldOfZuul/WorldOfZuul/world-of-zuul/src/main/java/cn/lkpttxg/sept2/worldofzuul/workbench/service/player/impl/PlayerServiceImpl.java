package cn.lkpttxg.sept2.worldofzuul.workbench.service.player.impl;

import cn.lkpttxg.sept2.worldofzuul.common.consts.ActionResult;
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

  @Override
  public Integer pick(Player player, Integer location){
    Item item = player.getCurrentRoom().getItem(location);
    if(item == null){
      return ActionResult.MISS;
    }
    int weight = player.getWeight() - item.getWeight();
    if(weight < 0){
      player.getCurrentRoom().addItem(item, location);
      return ActionResult.OVERWEIGHT;
    }
    player.addItem(item);
    player.setWeight(weight);
    return ActionResult.SUCCESS;
  }

  @Override
  public void throwAway(Player player, String id){
    Item item = player.getItem(id);
    if(item != null){
      player.setWeight(player.getWeight() + item.getWeight());
      player.deleteItem(id);
    }
  }

  @Override
  public Integer eat(Player player, String id){
    Item item = player.getItem(id);
    if(item instanceof Food){
      Food food = (Food)item;
      player.setWeight(player.getWeight() + food.getAddWeight() + food.getWeight());
      player.setAttack(player.getAttack() + food.getAddAttack());
      player.setHealth(player.getHealth() + food.getAddHealth());
      player.deleteItem(id);
      return ActionResult.SUCCESS;
    }
    return ActionResult.UNMATCH;
  }

  @Override
  public Integer equipWeapon(Player player, String id) {
    Item item = player.getItem(id);
    if(item instanceof Weapon){
      Weapon weapon = (Weapon)item;
      Weapon nowWeapon = player.getWeapon();
      if(nowWeapon != null){
        player.addItem(nowWeapon);
        player.setAttack(player.getAttack() - nowWeapon.getWeaponAttack());
      }
      player.deleteItem(id);
      player.setWeapon(weapon);
      player.setAttack(player.getAttack() + weapon.getWeaponAttack());
      return ActionResult.SUCCESS;
    }
    return ActionResult.UNMATCH;
  }
}
