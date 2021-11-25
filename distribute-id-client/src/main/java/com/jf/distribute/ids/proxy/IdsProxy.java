package com.jf.distribute.ids.proxy;

import com.alibaba.fastjson.JSON;
import com.jf.common.utils.exception.BizException;
import com.jf.common.utils.result.BaseResult;
import com.jf.distribute.ids.client.IdsClient;
import com.jf.distribute.ids.request.HelloRequest;
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
        System.out.println(new HelloRequest());
        BaseResult<Long> result = idsClient.getId();

        if (!result.getSuccess()) {
            log.error("调用ids服务获取一个id失败, result = [{}]", JSON.toJSON(result));
            throw new BizException(result.getCode(), result.getMsg());
        }
        return result.getData();
    }

    /**
     * 获取count个id
     */
    public List<Long> batchGetId(Integer count) {

        BaseResult<List<Long>> result = idsClient.batchGetId(count);

        if (!result.getSuccess()) {
            log.error("调用ids服务获取count个id失败, result = [{}]", JSON.toJSON(result));
            throw new BizException(result.getCode(), result.getMsg());
        }
        return result.getData();
    }
}
