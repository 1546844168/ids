package com.jf.distribute.ids.client.hystrix;

import com.jf.common.utils.meta.enums.GlobalErrorCodeEnum;
import com.jf.common.utils.result.BaseResult;
import com.jf.distribute.ids.client.IdsClient;
import feign.hystrix.FallbackFactory;
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
public class IdsClientFallback implements FallbackFactory<IdsClient> {

    @Override
    public IdsClient create(Throwable throwable) {

        log.error("调用分布式Id服务失败, 错误原因：", throwable);

        return new IdsClient() {

            @Override
            public BaseResult<Long> getId() {

                return BaseResult.fail(GlobalErrorCodeEnum.ERROR.getCode(),
                        "获取一个id失败");
            }

            @Override
            public BaseResult<List<Long>> batchGetId(Integer count) {
                return BaseResult.fail(GlobalErrorCodeEnum.ERROR.getCode(),
                        "批量获取id失败");

            }
        };
    }
}