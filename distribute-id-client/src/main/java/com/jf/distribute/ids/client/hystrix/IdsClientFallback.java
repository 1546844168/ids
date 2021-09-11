package com.jf.distribute.ids.client.hystrix;

import com.jf.common.utils.meta.enums.GlobalErrorCodeEnum;
import com.jf.common.utils.result.BaseResult;
import com.jf.distribute.ids.client.IdsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public BaseResult<Long> getId() {
        return BaseResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(),
                GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
    }

    @Override
    public BaseResult<List<Long>> batchGetId(Integer count) {
        return BaseResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(),
                GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());

    }
}