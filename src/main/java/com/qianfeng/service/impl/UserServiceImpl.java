package com.qianfeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qianfeng.mapper.UserMapper;
import com.qianfeng.pojo.po.User;
import com.qianfeng.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 登录查询用户是否存在
	 */
	@Override
	public User selectUser(User user) {
		return userMapper.selectUser(user);
	}

}
