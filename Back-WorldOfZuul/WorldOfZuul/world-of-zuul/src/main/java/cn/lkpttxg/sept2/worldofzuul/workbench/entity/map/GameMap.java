package cn.lkpttxg.sept2.worldofzuul.workbench.entity.map;

import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomDirection;
import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomID;
import cn.lkpttxg.sept2.worldofzuul.common.enums.room.RoomTypes;
import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import org.springframework.stereotype.Component;
import java.util.HashMap;

/**
 * @author TXG
 * @date 2022/6/27$
 *
 * 整个游戏的地图；包括所有的房间，游戏内所有的房间应该存入地图类中，
 * 游戏一启动就创建出地图类，并初始化所有房间。
 */
@Component
public class GameMap {

    private HashMap<String,Room> rooms;

    public GameMap(){
        rooms = new HashMap<>();
        initialGameMap();
    }

    public Room getRandomRoom() {
        int random = (int)(5*Math.random())+1;
        String randomRoom = "300"+random;
        return getRoomById(randomRoom);
    }

    public static void main(String[] args) {
        System.out.println(new GameMap().getRandomRoom());
    }
    private void initialGameMap(){
        Room outside, theater, pub, lab, office, cave;
        outside = new Room(RoomTypes.OUTSIDE);
        theater = new Room(RoomTypes.THEATER);
        pub = new Room(RoomTypes.PUB);
        lab = new Room(RoomTypes.LAB);
        office = new Room(RoomTypes.OFFICE);
        cave = new Room(RoomTypes.CAVE);
        cave.setObjects(new Object[25]);
        rooms.put(outside.getId(),outside);
        rooms.put(theater.getId(),theater);
        rooms.put(pub.getId(),pub);
        rooms.put(lab.getId(),lab);
        rooms.put(office.getId(),office);
        rooms.put(cave.getId(),cave);

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

    public Room getRoomById(String id){
        return rooms.get(id);
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * 根据房间id和下一个方向决定下一个房间是哪个
     * @param id
     * @param diection
     * @return
     */
    public Room getNextRoom(String id, String diection) {
        return getRoomById(id).getExit(diection);
    }
}
