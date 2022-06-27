package cn.lkpttxg.sept2.worldofzuul.settings.dao;

import cn.lkpttxg.sept2.worldofzuul.settings.entity.user.User;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;

/**
 * 用户的DAO接口
 *
 * @author PpxiA
 */
@Mapper
public interface UserMapper {

  /**
   * 插入一条用户记录
   * @param user 插入的用户数据
   * @return 改动记录数
   */
  int insertUser(@Param("user") User user);

  /**
   * 通过密码和用户名查找用户
   * @param username 用户名
   * @param password 密码
   * @return 查找到的一条用户数据
   */
  User selectUserByPasswordAndUsername(@Param("username") String username, @Param("password") String password);

  /**
   * 更新用户密码
   * @param userId 用户id
   * @return 改动记录数
   */
  int updatePasswordById(@Param("id") String userId, @Param("password") String password);
}
