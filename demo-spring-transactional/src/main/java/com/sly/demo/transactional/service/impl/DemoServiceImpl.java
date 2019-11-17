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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation=Propagation.REQUIRED，然后在测试方法中同时调用两个方法并在调用结束后抛出异常。</p>
	 * <p>结果分析：外围方法未开启事务，插入用户表和用户角色表的方法在自己的事务中独立运行，外围方法异常不影响内部插入，所以两条记录都新增成功。</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation=Propagation.REQUIRED，然后在测试方法中同时调用两个方法并在调用结束后抛出异常。</p>
	 * <p>结果分析：外围方法开启事务，内部方法加入外围方法事务，外围方法回滚，内部方法也要回滚，所以两个记录都插入失败。</p>
	 * <p>结论：以上结果证明在外围方法开启事务的情况下Propagation.REQUIRED修饰的内部方法会加入到外围方法的事务中，所以Propagation.REQUIRED修饰的内部方法和外围方法均属于同一事务，只要一个方法回滚，整个事务均回滚。</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation=Propagation.SUPPORTS，然后在测试方法中同时调用两个方法并在调用结束后抛出异常。</p>
	 * <p>结果分析：外围方法未开启事务，插入用户表和用户角色表的方法以非事务的方式独立运行，外围方法异常不影响内部插入，所以两条记录都新增成功。</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation=Propagation.SUPPORTS，然后在测试方法中同时调用两个方法并在调用结束后抛出异常。</p>
	 * <p>结果分析：外围方法开启事务，内部方法加入外围方法事务，外围方法回滚，内部方法也要回滚，所以两个记录都插入失败。</p>
	 * <p>结论：以上结果证明在外围方法开启事务的情况下Propagation.SUPPORTS修饰的内部方法会加入到外围方法的事务中，所以Propagation.SUPPORTS修饰的内部方法和外围方法均属于同一事务，只要一个方法回滚，整个事务均回滚。</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.MANDATORY，主要代码如下。</p>
	 * <p>结果分析：运行日志如下，可以发现在调用userService.add()时候已经报错了，所以两个表都没有新增数据，验证了“如果当前不存在事务，就抛出异常”。</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.REQUIRES_NEW，主要代码如下。</p>
	 * <p>结果分析：无论当前存不存在事务，都创建新事务，所以两个数据新增成功。</p>
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
	@Override
	@Transactional
	public Map<String, Object> requiredNewTest02() {
		roleService.requiredNew();
		userService.requiredNew();
		
		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>NOT_SUPPORTED</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法不开启事务。</p>
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.NOT_SUPPORTED，主要代码如下。</p>
	 * <p>结果分析：以非事务方式执行，所以两个数据新增成功。</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.NOT_SUPPORTED，主要代码如下。</p>
	 * <p>结果分析：如果当前存在事务，就把当前事务挂起，相当于以非事务方式执行，所以两个数据新增成功。</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.NEVER，主要代码如下。</p>
	 * <p>结果分析：当前存在事务，则抛出异常。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	@Transactional
	public Map<String, Object> neverTest01() {
		roleService.never();
		userService.never();
		
		throw new RuntimeException("手动抛异常");
	}
	
	/**
	 * <p>NEVER</p>
	 * <p>场景二：</p>
	 * <p>此场景外围方法没有开启事务。</p>
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.NEVER，主要代码如下。</p>
	 * <p>结果分析：相当于以非事务方式执行，所以两个数据新增成功。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月16日
	 */
	@Override
	public Map<String, Object> neverTest02() {
		roleService.never();
		userService.never();
		
		throw new RuntimeException("手动抛异常");
	}

	/**
	 * <p>NESTED</p>
	 * <p>场景一：</p>
	 * <p>此场景外围方法没有开启事务。</p>
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.NESTED，主要代码如下。</p>
	 * <p>结果分析：外层没有事务会以REQUIRED属性的方式运行，两个表新增成功</p>
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
	 * <p>两个实现类UserServiceImpl和RoleServiceImpl制定事物传播行为propagation = Propagation.NESTED，主要代码如下。</p>
	 * <p>结果分析：有事务但是用的是一个事务，方法最后抛出了异常导致回滚，两个表都都没有新增数据。</p>
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
