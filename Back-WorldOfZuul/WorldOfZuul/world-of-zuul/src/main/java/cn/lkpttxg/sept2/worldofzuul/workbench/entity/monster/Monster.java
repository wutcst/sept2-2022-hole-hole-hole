package cn.lkpttxg.sept2.worldofzuul.workbench.entity.monster;

import cn.lkpttxg.sept2.worldofzuul.common.enums.monster.MonsterTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author TXG
 * @date 2022/6/27$
 */
@ApiModel(description = "怪物信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Monster implements Serializable {
    private static final long serialVersionUID = -2313418473379522963L;
    /**
     * 怪物 ID
     */
    @ApiModelProperty(value = "怪物ID",required = true,dataType = "String")
    private String id;

    /**
     * 怪物名字
     */
    @ApiModelProperty(value = "怪物名字",required = true,dataType = "String")
    private String name;

    /**
     * 怪物描述
     */
    @ApiModelProperty(value = "怪物描述",required = true,dataType = "String")
    private String description;

    /**
     * 怪物血量
     */
    @ApiModelProperty(value = "怪物血量",required = true,dataType = "Integer")
    private Integer health;

    /**
     * 怪物攻击
     */
    @ApiModelProperty(value = "怪物攻击",required = true,dataType = "Integer")
    private Integer attack;

    /**
     * 怪物坐标(不能是2，10，12，14，22)
     */
    private Integer location;


    /**
     * 根据 enum 初始化怪物
     * @param monsterTypes 怪物类型模板
     */
    public Monster(MonsterTypes monsterTypes,int location){
        HashMap attribute  = monsterTypes.getAttribute();
        this.id = (String)attribute.get("id");
        this.name = (String)attribute.get("name");
        this.description = (String)attribute.get("description");
        this.health = (Integer) attribute.get("health");
        this.attack = (Integer) attribute.get("attack");
        this.location = location;
    }
}
