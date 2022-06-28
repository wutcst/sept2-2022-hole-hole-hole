package cn.lkpttxg.sept2.worldofzuul.workbench.service.room;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;

/**
 * @author TXG
 * @date 2022/6/28$
 */
public interface RoomService {

    Room getRoomByRoomId(String id);

    Room getNextRoom(String id,String direction);

    Room getRandomRoom();
}
