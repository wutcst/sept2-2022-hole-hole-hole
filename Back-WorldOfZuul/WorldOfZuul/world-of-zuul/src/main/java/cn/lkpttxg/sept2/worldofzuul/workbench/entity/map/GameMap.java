package cn.lkpttxg.sept2.worldofzuul.workbench.entity.map;

import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomDirection;
import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomID;
import cn.lkpttxg.sept2.worldofzuul.common.enums.room.RoomTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import lombok.Data;

import java.util.HashMap;

/**
 * @author TXG
 * @date 2022/6/27$
 *
 * 整个游戏的地图；包括所有的房间，游戏内所有的房间应该存入地图类中，
 * 游戏一启动就创建出地图类，并初始化所有房间。
 */
@Data
public class GameMap {

    private HashMap<String,Room> rooms;

    public GameMap(){
        rooms = new HashMap<>();
        initialGameMap();
    }

    private void initialGameMap(){
        Room outside, theater, pub, lab, office, cave;
        outside = new Room(RoomTypes.OUTSIDE);
        theater = new Room(RoomTypes.THEATER);
        pub = new Room(RoomTypes.PUB);
        lab = new Room(RoomTypes.LAB);
        office = new Room(RoomTypes.OFFICE);
        cave = new Room(RoomTypes.CAVE);
        rooms.put(outside.getId(),outside);
        rooms.put(theater.getId(),theater);
        rooms.put(pub.getId(),pub);
        rooms.put(lab.getId(),lab);
        rooms.put(office.getId(),office);

        //初始化四周方向
        outside.setExit(RoomDirection.NORTH, theater);
        outside.setExit(RoomDirection.SOUTH, lab);
        outside.setExit(RoomDirection.WEST, pub);

        theater.setExit(RoomDirection.WEST, outside);

        pub.setExit(RoomDirection.EAST, outside);

        lab.setExit(RoomDirection.NORTH, outside);
        lab.setExit(RoomDirection.EAST, office);

        office.setExit(RoomDirection.WEST, lab);
        office.setExit(RoomDirection.SOUTH, cave);
    }

    public Room getInitRoom(){
        return rooms.get(RoomID.OUTSIDE);
    }

}
