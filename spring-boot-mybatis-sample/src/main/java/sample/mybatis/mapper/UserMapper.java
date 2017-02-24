package sample.mybatis.mapper;

import sample.mybatis.domain.User;

/**
 * User的Mapper，用于Mybatis
 *
 * @author 小翼
 * @version 1.0.0
 */
public interface UserMapper {

	User selectUser(String username);
}
