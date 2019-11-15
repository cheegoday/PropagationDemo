package com.sly.demo.transactional.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring的七种事务传播行为
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

	/**
	 * PROPAGATION_REQUIRED
	 * <p>
	 * 如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，这是最常见的选择，也是Spring默认的事务传播行为。
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/requiredTest")
	public Object requiredTest() {
		return null;
	}

	/**
	 * PROPAGATION_SUPPORTS
	 * <p>
	 * 支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/supportsTest")
	public Object supportsTest() {
		return null;
	}

	/**
	 * PROPAGATION_MANDATORY
	 * <p>
	 * 支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/mandatoryTest")
	public Object mandatoryTest() {
		return null;
	}

	/**
	 * PROPAGATION_REQUIRES_NEW
	 * <p>
	 * 创建新事务，无论当前存不存在事务，都创建新事务。
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/requiredNewTest")
	public Object requiredNewTest() {
		return null;
	}

	/**
	 * PROPAGATION_NOT_SUPPORTED
	 * <p>
	 * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/notSupportTest")
	public Object notSupportTest() {
		return null;
	}

	/**
	 * PROPAGATION_NEVER
	 * <p>
	 * 以非事务方式执行，如果当前存在事务，则抛出异常。
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	public Object neverTest() {
		return null;
	}

	/**
	 * PROPAGATION_NESTED
	 * <p>
	 * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按REQUIRED属性执行。
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	public Object nestedTest() {
		return null;
	}

}
