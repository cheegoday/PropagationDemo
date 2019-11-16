package com.sly.demo.transactional.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sly.demo.transactional.service.DemoService;
import com.sly.demo.transactional.service.RoleService;
import com.sly.demo.transactional.service.UserService;

@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	/**
	 * <p>REQUIRED</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法没有开启事务</p>
	 * <p>两个实现类UserServiceImpl和UserRoleServiceImpl制定事物传播行为propagation=Propagation.REQUIRED，然后在测试方法中同时调用两个方法并在调用结束后抛出异常。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> requiredTest01() {
		roleService.required();
		userService.required();

		throw new RuntimeException("手动抛异常");
	}
	
	/**
	 * <p>REQUIRED</p>
	 * <p>场景二：</p>
	 * <p>此场景外围方法开启事务。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	@Transactional
	public Map<String, Object> requiredTest02() {
		roleService.required();
		userService.required();

		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>SUPPORTS</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法没有开启事务。</p>
	 * <p>两个实现类UserServiceImpl和UserRoleServiceImpl制定事物传播行为propagation=Propagation.SUPPORTS，然后在测试方法中同时调用两个方法并在调用结束后抛出异常。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> supportsTest01() {
		roleService.supports();
		userService.supports();
		
		throw new RuntimeException("手动抛异常");
	}
	
	/**
	 * <p>SUPPORTS</p>
	 * <p>场景二：</p>
	 * <p>此场景外围方法开启事务。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	@Transactional
	public Map<String, Object> supportsTest02() {
		roleService.supports();
		userService.supports();
		
		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>MANDATORY</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法没有开启事务。</p>
	 * <p>两个实现类UserServiceImpl和UserRoleServiceImpl制定事物传播行为propagation = Propagation.MANDATORY，主要代码如下。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> mandatoryTest01() {
		roleService.mandatory();
		userService.mandatory();
		
		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>REQUIRES_NEW</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法没有开启事务。</p>
	 * <p>两个实现类UserServiceImpl和UserRoleServiceImpl制定事物传播行为propagation = Propagation.REQUIRES_NEW，主要代码如下。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> requiredNewTest01() {
		roleService.requiredNew();
		userService.requiredNew();
		
		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>NOT_SUPPORTED</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法不开启事务。</p>
	 * <p>两个实现类UserServiceImpl和UserRoleServiceImpl制定事物传播行为propagation = Propagation.NOT_SUPPORTED，主要代码如下。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> notSupportTest01() {
		roleService.notSupport();
		userService.notSupport();

		throw new RuntimeException("手动抛异常");
	}
	
	/**
	 * <p>NOT_SUPPORTED</p>
	 * <p>场景二：</p>
	 * <p>此场景外围方法开启事务。</p>
	 * <p>两个实现类UserServiceImpl和UserRoleServiceImpl制定事物传播行为propagation = Propagation.NOT_SUPPORTED，主要代码如下。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	@Transactional
	public Map<String, Object> notSupportTest02() {
		roleService.notSupport();
		userService.notSupport();

		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>NEVER</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法开启事务。</p>
	 * <p></p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	@Transactional
	public Map<String, Object> neverTest01() {
		roleService.never();
		roleService.never();
		
		throw new RuntimeException("手动抛异常");
	}
	
	/**
	 * <p>NEVER</p>
	 * <p>场景二：</p>
	 * <p>此场景外围方法没有开启事务。</p>
	 * <p></p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> neverTest02() {
		roleService.never();
		roleService.never();
		
		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>NESTED</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法没有开启事务。</p>
	 * <p></p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> nestedTest01() {
		roleService.nested();
		userService.nested();
		
		throw new RuntimeException("手动抛异常");
	}
	
	/**
	 * <p>NESTED</p>
	 * <p>场景二：</p>
	 * <p>此场景外围方法开启事务。</p>
	 * <p></p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	@Transactional
	public Map<String, Object> nestedTest02() {
		roleService.nested();
		userService.nested();
		
		throw new RuntimeException("手动抛异常");
	}

}
