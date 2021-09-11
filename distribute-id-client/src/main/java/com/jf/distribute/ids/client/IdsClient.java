package com.jf.distribute.ids.client;

import com.jf.distribute.ids.client.hystrix.IdsClientFallback;
import com.jf.distribute.ids.endpoint.IdsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 分布式Id服务
 *
 * @author 江峰
 * @date 2020/7/19 15:02
 */
@FeignClient(name = "distribute-id-ms", fallbackFactory = IdsClientFallback.class)
public interface IdsClient extends IdsApi {

}