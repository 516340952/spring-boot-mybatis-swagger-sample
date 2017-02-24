package sample.mybatis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * User实体类，将同时用于Mybatis和JPA使用
 *
 * @author 小翼
 * @version 1.0.0
 */
@Entity
public class User {
	@Id
	private String username;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
