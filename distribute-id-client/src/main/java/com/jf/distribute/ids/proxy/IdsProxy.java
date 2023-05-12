package com.jf.distribute.ids.proxy;

import com.alibaba.fastjson.JSON;
import com.jf.distribute.ids.client.IdsClient;
import com.jf.model.exception.BizException;
import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Ids对外暴露的实现类
 *
 * @author 江峰
 * @since 2021/9/12
 */
@Service
@Slf4j
public class IdsProxy {

	@Autowired
	private IdsClient idsClient;

	/**
	 * 获取一个id
	 */
	public Long getId() {
		CommonResult<Long> result = idsClient.getId();
		if (!result.getSuccess()) {
			log.error("调用ids服务获取一个id失败, result = [{}]", JSON.toJSON(result));
			throw new BizException(result.getCode(), result.getMessage());
		}
		return result.getData();
	}

	/**
	 * 获取count个id
	 */
	public List<Long> batchGetId(Integer count) {

		CommonResult<List<Long>> result = idsClient.batchGetId(count);

		if (!result.getSuccess()) {
			log.error("调用ids服务获取count个id失败, result = [{}]",
					JSON.toJSON(result));
			throw new BizException(result.getCode(), result.getMessage());
		}
		return result.getData();
	}
}
