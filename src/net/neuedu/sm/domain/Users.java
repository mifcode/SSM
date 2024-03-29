package net.neuedu.sm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Users implements Serializable {

	private static final long serialVersionUID = -5615770171187525012L;
	private Integer id;
	private String username;
	private Date birthday;
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", birthday=" + birthday + ", address=" + address + "]";
	}

}
