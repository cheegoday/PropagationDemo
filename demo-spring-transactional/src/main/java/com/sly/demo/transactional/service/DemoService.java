package com.sly.demo.transactional.service;

import java.util.Map;

public interface DemoService {

	Map<String, Object> requiredTest01();

	Map<String, Object> requiredTest02();

	Map<String, Object> supportsTest01();
	
	Map<String, Object> supportsTest02();

	Map<String, Object> mandatoryTest01();
	
	Map<String, Object> requiredNewTest01();
	
	Map<String, Object> requiredNewTest02();

	Map<String, Object> notSupportTest01();
	
	Map<String, Object> notSupportTest02();

	Map<String, Object> neverTest01();
	
	Map<String, Object> neverTest02();

	Map<String, Object> nestedTest01();
	
	Map<String, Object> nestedTest02();
}
