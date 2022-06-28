package cn.lkpttxg.sept2.worldofzuul.common.consts;

import io.swagger.annotations.ApiModel;

/**
 * @author TXG
 * @date 2022/6/27$
 */
@ApiModel(description = "房间的出口方向")
public interface RoomDirection {
    /**
     * 北方
     */
    String NORTH = "north";
    /**
     * 南方
     */
    String SOUTH = "south";
    /**
     * 西方
     */
    String WEST = "west";
    /**
     * 东方
     */
    String EAST = "east";
}
