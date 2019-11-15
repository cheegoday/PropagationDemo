package com.sly.demo.transactional.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sly.demo.transactional.mapper.UserMapper;
import com.sly.demo.transactional.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

}
