package com.sly.demo.transactional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sly.demo.transactional.service.DemoService;

/**
 * Spring的七种事务传播行为
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private DemoService demoService;

	/**
	 * PROPAGATION_REQUIRED
	 * <p>如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，这是最常见的选择，也是Spring默认的事务传播行为。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/requiredTest01")
	public Object requiredTest01() {
		return demoService.requiredTest01();
	}
	
	/**
	 * PROPAGATION_REQUIRED
	 * <p>如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该事务，这是最常见的选择，也是Spring默认的事务传播行为。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/requiredTest02")
	public Object requiredTest02() {
		return demoService.requiredTest02();
	}

	/**
	 * PROPAGATION_SUPPORTS
	 * <p>支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/supportsTest01")
	public Object supportsTest01() {
		return demoService.supportsTest01();
	}
	
	/**
	 * PROPAGATION_SUPPORTS
	 * <p>支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/supportsTest02")
	public Object supportsTest02() {
		return demoService.supportsTest02();
	}

	/**
	 * PROPAGATION_MANDATORY
	 * <p>支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就抛出异常。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/mandatoryTest01")
	public Object mandatoryTest01() {
		return demoService.mandatoryTest01();
	}

	/**
	 * PROPAGATION_REQUIRES_NEW
	 * <p>创建新事务，无论当前存不存在事务，都创建新事务。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/requiredNewTest01")
	public Object requiredNewTest01() {
		return demoService.requiredNewTest01();
	}

	/**
	 * PROPAGATION_NOT_SUPPORTED
	 * <p>以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/notSupportTest01")
	public Object notSupportTest01() {
		return demoService.notSupportTest01();
	}
	
	/**
	 * PROPAGATION_NOT_SUPPORTED
	 * <p>以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/notSupportTest02")
	public Object notSupportTest02() {
		return demoService.notSupportTest02();
	}

	/**
	 * PROPAGATION_NEVER
	 * <p>以非事务方式执行，如果当前存在事务，则抛出异常。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/neverTest01")
	public Object neverTest01() {
		return demoService.neverTest01();
	}
	
	/**
	 * PROPAGATION_NEVER
	 * <p>以非事务方式执行，如果当前存在事务，则抛出异常。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/neverTest02")
	public Object neverTest02() {
		return demoService.neverTest02();
	}

	/**
	 * PROPAGATION_NESTED
	 * <p>如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按REQUIRED属性执行。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/nestedTest01")
	public Object nestedTest01() {
		return demoService.nestedTest01();
	}
	
	/**
	 * PROPAGATION_NESTED
	 * <p>如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按REQUIRED属性执行。</p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月15日
	 */
	@RequestMapping("/nestedTest02")
	public Object nestedTest02() {
		return demoService.nestedTest02();
	}

}
