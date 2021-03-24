package com.jf.ids.service;

import java.util.List;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-25 3:56
 * @since: 2.22.1
 */
public interface IdsService {

	/**
	 * 获取一个id
	 * 
	 * @return
	 */
	long getId();

	/**
	 * 批量获取count个id
	 * 
	 * @param count
	 * @return
	 */
	List<Long> batchGetId(int count);
}
