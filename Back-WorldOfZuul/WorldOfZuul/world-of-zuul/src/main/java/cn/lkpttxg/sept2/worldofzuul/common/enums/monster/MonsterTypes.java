package cn.lkpttxg.sept2.worldofzuul.common.enums.monster;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TXG
 * @date 2022/6/27$
 */
public enum MonsterTypes {
    /**
     * 普通小怪：皮皮虾
     * 血量：10 攻击：1
     */
    GENERAL_MONSTER1(new Object[]{"#1001","皮皮虾","喜欢用皮燕子攻击的近战虾米",10,1}),
    /**
     * 普通小怪：史莱姆
     * 血量：15 攻击：1
     */
    GENERAL_MONSTER2(new Object[]{"#1002","史莱姆","软软的史莱姆，喜欢粘液攻击",15,1});

    private final HashMap<String,Object> attribute;

    MonsterTypes(Object[] objects){
        attribute = new HashMap<>();
        attribute.put("id",objects[0]);
        attribute.put("name",objects[1]);
        attribute.put("description",objects[2]);
        attribute.put("health",objects[3]);
        attribute.put("attack",objects[4]);
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
