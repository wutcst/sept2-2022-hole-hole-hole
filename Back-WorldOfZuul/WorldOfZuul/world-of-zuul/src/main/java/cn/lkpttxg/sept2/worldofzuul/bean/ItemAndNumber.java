package cn.lkpttxg.sept2.worldofzuul.bean;

import cn.lkpttxg.sept2.worldofzuul.workbench.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TXG
 * @date 2022/6/29$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemAndNumber {
    private Item item;
    private Integer number;
}
