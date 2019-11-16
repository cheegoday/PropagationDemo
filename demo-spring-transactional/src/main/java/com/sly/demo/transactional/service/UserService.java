package com.sly.demo.transactional.service;

import java.util.Map;

public interface UserService {
	Map<String, Object> required();

	Map<String, Object> supports();

	Map<String, Object> mandatory();

	Map<String, Object> requiredNew();

	Map<String, Object> notSupport();

	Map<String, Object> never();

	Map<String, Object> nested();
}
