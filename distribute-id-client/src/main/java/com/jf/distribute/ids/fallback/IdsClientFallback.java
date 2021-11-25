package com.jf.distribute.ids.fallback;

import com.jf.common.utils.meta.enums.GlobalErrorCodeEnum;
import com.jf.common.utils.result.BaseResult;
import com.jf.distribute.ids.client.IdsClient;
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
public class IdsClientFallback implements IdsClient {

    @Override
    public BaseResult getId() {
        return BaseResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(),
                GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
    }

    @Override
    public BaseResult batchGetId(Integer count) {
        return BaseResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(),
                GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());

    }
}