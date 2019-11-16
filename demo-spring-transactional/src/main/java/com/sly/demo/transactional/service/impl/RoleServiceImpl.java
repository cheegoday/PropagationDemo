package com.sly.demo.transactional.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sly.demo.transactional.mapper.RoleMapper;
import com.sly.demo.transactional.model.Role;
import com.sly.demo.transactional.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> required(){
		Role role = new Role();
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		role.setRoleName("角色");
		roleMapper.add(role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Map<String, Object> supports(){
		Role role = new Role();
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		role.setRoleName("角色");
		roleMapper.add(role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Map<String, Object> mandatory(){
		Role role = new Role();
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		role.setRoleName("角色");
		roleMapper.add(role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Map<String, Object> requiredNew() {
		Role role = new Role();
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		role.setRoleName("角色");
		roleMapper.add(role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> notSupport() {
		Role role = new Role();
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		role.setRoleName("角色");
		roleMapper.add(role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public Map<String, Object> never() {
		Role role = new Role();
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		role.setRoleName("角色");
		roleMapper.add(role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public Map<String, Object> nested() {
		Role role = new Role();
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		role.setRoleName("角色");
		roleMapper.add(role);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		map.put("message", "成功！");
		return map;
	}
	
}
