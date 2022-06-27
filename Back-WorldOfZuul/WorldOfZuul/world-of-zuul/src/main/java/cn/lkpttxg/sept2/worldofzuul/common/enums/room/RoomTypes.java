package cn.lkpttxg.sept2.worldofzuul.common.enums.room;

import cn.lkpttxg.sept2.worldofzuul.common.consts.RoomType;

import java.util.HashMap;

/**
 * @author TXG
 * @date 2022/6/27$
 */
public enum RoomTypes {

    OUTSIDE(new Object[]{"#3001", RoomType.GENERAL_ROOM,"outside","outside the main entrance of the university"}),
    THEATER(new Object[]{"#3002", RoomType.GENERAL_ROOM,"theater","in a lecture theater"}),
    PUB(new Object[]{"#3003", RoomType.GENERAL_ROOM,"pub","in the campus pub"}),
    LAB(new Object[]{"#3004", RoomType.GENERAL_ROOM,"lab","in a computing lab"}),
    OFFICE(new Object[]{"#3005", RoomType.GENERAL_ROOM,"office","in the computing admin office"}),
    FOREST(new Object[]{"#3006", RoomType.GENERAL_ROOM,"forest","一个神秘的森林"}),
    CAVE(new Object[]{"#4001", RoomType.TRANSFER_ROOM,"cave","一个神秘的洞穴。你觉得很诡异，这时一股强光突然出现，\"\n" +
            "                + \"你看不到任何东西，只知道自己好像身体不受支配，随意飘动...\\n过来好一会，你才突然发现，\"\n" +
            "                + \"你所处的早已不是洞穴，而是另一个地方"});


    private final HashMap<String,Object> attribute;

    RoomTypes(Object[] objects){
        attribute = new HashMap<>();
        attribute.put("id",objects[0]);
        attribute.put("roomType",objects[1]);
        attribute.put("name",objects[2]);
        attribute.put("description",objects[3]);
    }

    /**
     * 获取参数
     *
     * @return 参数map
     */
    public HashMap<String, Object> getAttribute() {
        return attribute;
    }
}
