package com.jf.ids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.result.BaseResult;
import com.jf.ids.service.IdsService;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-25 4:17
 * @since: 2.22.1
 */
@RestController
public class IdsController {

	@Autowired
	private IdsService idsService;

	/**
	 * 获取一个id
	 * 
	 * @return
	 */
	@GetMapping("/getId")
	public BaseResult<Long> getId() {
		long id = idsService.getId();
		return BaseResult.success(id);
	}

	/**
	 * 获取count个id
	 * 
	 * @param count
	 * @return
	 */
	@GetMapping("/batchGetId/{count}")
	public BaseResult<List<Long>> batchGetId(@PathVariable Integer count) {
		List<Long> idList = idsService.batchGetId(count);
		return BaseResult.success(idList);
	}
}
