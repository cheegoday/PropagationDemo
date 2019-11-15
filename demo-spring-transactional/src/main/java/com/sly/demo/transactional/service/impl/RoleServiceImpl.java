package com.sly.demo.transactional.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sly.demo.transactional.mapper.RoleMapper;
import com.sly.demo.transactional.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper RoleMapper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<String, Object> insert(){
		return null;
	}
}
