package cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.rooms;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.room.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author TXG
 * @date 2022/6/27$
 */

public class TransferRoom extends Room {

    private static final long serialVersionUID = -8856420387406256939L;
    private Room transferDestination;

    public Room getTransferDestination() {
        return transferDestination;
    }

    public void setTransferDestination(Room transferDestination) {
        this.transferDestination = transferDestination;
    }
}
