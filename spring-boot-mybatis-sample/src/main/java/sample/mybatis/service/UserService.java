package sample.mybatis.service;

import sample.mybatis.domain.User;

/**
 * 类名称：UserService
 * 类描述：
 *
 * @version 1.0.0
 * @author: Zhugh
 * @since: 2017/2/23
 */
public interface UserService {

    public User selectUser(String username);
}
