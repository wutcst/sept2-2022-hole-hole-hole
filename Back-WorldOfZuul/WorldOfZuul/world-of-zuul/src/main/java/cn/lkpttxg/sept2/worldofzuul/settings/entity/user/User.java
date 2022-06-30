package cn.lkpttxg.sept2.worldofzuul.settings.entity.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * @author PpxiA
 */
@ApiModel(description = "用户信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  /**
   * 用户id
   */
  @ApiModelProperty(value = "用户唯一id",dataType = "Integer")
  private Integer userId;
  /**
   * 用户绑定玩家id
   */
  @ApiModelProperty(value = "用户绑定的玩家id",notes = "UUID",dataType = "String")
  private String playerId;
  /**
   * 用户密码
   */
  @ApiModelProperty(value = "用户密码",dataType = "String")
  private String password;
  /**
   * 用户名
   */
  @ApiModelProperty(value = "用户名",dataType = "String")
  private String username;
  /**
   * 用户邮箱
   */
  @ApiModelProperty(value = "用户邮箱",dataType = "String")
  private String email;
}
