package com.sly.demo.transactional.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sly.demo.transactional.mapper.UserMapper;
import com.sly.demo.transactional.model.User;
import com.sly.demo.transactional.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> required() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setUsername("用户名");
		user.setPassword("密码");
		userMapper.add(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Map<String, Object> supports() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setUsername("用户名");
		user.setPassword("密码");
		userMapper.add(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Map<String, Object> mandatory() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setUsername("用户名");
		user.setPassword("密码");
		userMapper.add(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Map<String, Object> requiredNew() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setUsername("用户名");
		user.setPassword("密码");
		userMapper.add(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> notSupport() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setUsername("用户名");
		user.setPassword("密码");
		userMapper.add(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public Map<String, Object> never() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setUsername("用户名");
		user.setPassword("密码");
		userMapper.add(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public Map<String, Object> nested() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setUsername("用户名");
		user.setPassword("密码");
		userMapper.add(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}
}
