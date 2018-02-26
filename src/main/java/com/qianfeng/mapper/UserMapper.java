package com.qianfeng.mapper;

import com.qianfeng.pojo.po.User;

public interface UserMapper {
	public User selectUser(User user);

	public User selectUserById(Integer uid);
}
