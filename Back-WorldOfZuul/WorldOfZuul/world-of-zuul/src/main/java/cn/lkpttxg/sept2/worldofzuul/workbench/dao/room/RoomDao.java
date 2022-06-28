package cn.lkpttxg.sept2.worldofzuul.workbench.dao.room;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.map.GameMap;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author TXG
 * @date 2022/6/28$
 */
@Component
public class RoomDao {
    @Resource
    private GameMap gameMap;

    public Room getGameRoomById(String id){
        return gameMap.getRoomById(id);
    }

    public Room getNextRoom(String id,String diection) {
        return gameMap.getNextRoom(id,diection);
    }

    public Room getRandomRoom() {
        return gameMap.getRandomRoom();
    }
}
