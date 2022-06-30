package cn.lkpttxg.sept2.worldofzuul.bean;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author TXG
 * @date 2022/6/29$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemAndNumber implements Serializable {
    private static final long serialVersionUID = -9180652563977025637L;
    private Item item;
    private Integer number;
}
