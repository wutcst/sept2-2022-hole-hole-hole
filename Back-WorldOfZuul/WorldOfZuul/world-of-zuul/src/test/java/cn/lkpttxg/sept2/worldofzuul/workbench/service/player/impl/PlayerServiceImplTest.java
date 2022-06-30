package cn.lkpttxg.sept2.worldofzuul.workbench.service.player.impl;

import static org.junit.jupiter.api.Assertions.*;
import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.FoodTypes;
import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.TreasureTypes;
import cn.lkpttxg.sept2.worldofzuul.common.enums.Item.WeaponTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Food;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Treasure;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.items.Weapon;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.player.Player;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import cn.lkpttxg.sept2.worldofzuul.workbench.service.player.PlayerService;
import org.junit.jupiter.api.Test;

class PlayerServiceImplTest {

  PlayerService playerService = new PlayerServiceImpl();

  @Test
  void pick() {
    Player player = new Player();
    Room room = new Room();
    room.setObjects(new Object[30]);
    player.setCurrentRoom(room);
    Item weapon = new Weapon(WeaponTypes.EXCALIBUR);
    Item food = new Food(FoodTypes.MAGICCOOKIE);
    Item treasure = new Treasure(TreasureTypes.GEM);
    room.addItem(weapon, 5);
    room.addItem(food, 10);
    room.addItem(treasure, 15);
    playerService.pick(player, 5);
    Item item = player.getItem(weapon.getId());
    assertNull(item);
    assertEquals(player.getWeight(), 10);
    playerService.pick(player, 10);
    item = player.getItem(food.getId());
    assertEquals(item, food);
    assertEquals(player.getWeight(), 9);
    playerService.pick(player, 15);
    item = player.getItem(treasure.getId());
    assertEquals(item, treasure);
    assertEquals(player.getWeight(), 1);
  }

  @Test
  void throwAway() {
    Player player = new Player();
    Room room = new Room();
    room.setObjects(new Object[30]);
    player.setCurrentRoom(room);
    Item food = new Food(FoodTypes.MAGICCOOKIE);
    room.addItem(food, 10);
    playerService.pick(player, 10);
    assertEquals(player.getWeight(), 9);
    playerService.throwAway(player, food.getId());
    assertEquals(player.getWeight(), 10);
  }

  @Test
  void eat() {
    Player player = new Player();
    Room room = new Room();
    room.setObjects(new Object[30]);
    player.setCurrentRoom(room);
    Item food1 = new Food(FoodTypes.BREAD);
    Item food2 = new Food(FoodTypes.MAGICCOOKIE);
    Item food3 = new Food(FoodTypes.WINE);
    player.addItem(food1);
    player.addItem(food2);
    player.addItem(food3);
    playerService.eat(player, food1.getId());
    assertEquals(player.getHealth(), 110);
    playerService.eat(player, food2.getId());
    assertEquals(player.getWeight(), 19);
    assertEquals(player.getHealth(), 113);
    playerService.eat(player, food3.getId());
    assertEquals(player.getAttack(), 15);
  }

  @Test
  void equipWeapon() {
    Player player = new Player();
    Room room = new Room();
    Item weapon = new Weapon(WeaponTypes.KNIFE);
    player.addItem(weapon);
    playerService.equipWeapon(player, weapon.getId());
    assertEquals(player.getAttack(), 10);
  }
}