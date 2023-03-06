package com.jf.distribute.ids.api;

import com.jf.model.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 江峰
 * @since 2020/2/17
 */
public interface IdsApi {

	/**
	 * 获取一个id
	 */
	@GetMapping(value = "/id")
	CommonResult<Long> getId();

	/**
	 * 获取count个id
	 */
	@GetMapping(value = "/id/{count}")
	CommonResult<List<Long>> batchGetId(@PathVariable Integer count);
}
