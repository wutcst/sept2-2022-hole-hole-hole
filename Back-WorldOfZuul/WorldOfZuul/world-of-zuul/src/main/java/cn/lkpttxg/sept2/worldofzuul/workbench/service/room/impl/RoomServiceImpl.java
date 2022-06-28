package cn.lkpttxg.sept2.worldofzuul.workbench.service.room.impl;

import cn.lkpttxg.sept2.worldofzuul.workbench.dao.room.RoomDao;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import cn.lkpttxg.sept2.worldofzuul.workbench.service.room.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author TXG
 * @date 2022/6/28$
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomDao roomDao;
    /**
     * 获取当前游戏中某个房间的数据
     * @param id
     * @return
     */
    @Override
    public Room getRoomByRoomId(String id) {
        return roomDao.getGameRoomById(id);
    }

    @Override
    public Room getNextRoom(String id, String direction) {
        return roomDao.getNextRoom(id,direction);
    }

    @Override
    public Room getRandomRoom() {
        return roomDao.getRandomRoom();
    }
}
