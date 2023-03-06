package com.jf.distribute.ids.fallback;

import com.jf.distribute.ids.api.IdsApi;
import com.jf.distribute.ids.client.IdsClient;
import com.jf.model.enums.GlobalErrorCodeEnum;
import com.jf.model.response.CommonResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 调用分布式Id服务，异常熔断处理
 *
 * @author 江峰
 * @date 2020/7/19 15:04
 */
@Component
@Slf4j
public class IdsClientFallbackFactory implements FallbackFactory<IdsApi> {

    @Override
    public IdsClient create(Throwable throwable) {
        return new IdsClient() {
            @Override
            public CommonResult getId() {
                return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(),
                        GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
            }

            @Override
            public CommonResult batchGetId(Integer count) {
                return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(),
                        GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());

            }
        };
    }
}