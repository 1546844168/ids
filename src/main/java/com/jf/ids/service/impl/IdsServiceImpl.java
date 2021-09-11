package com.jf.ids.service.impl;

import com.jf.ids.config.snowflake.SnowFlakeProperties;
import com.jf.ids.core.SnowFlake;
import com.jf.ids.service.IdsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的处理器，目前支持三种请求： getTime: 获取服务器当前时间； clientInfo: 获取请求客户端的User-Agent信息 其它：
 * 返回404状态，并且提示404信息
 *
 * @author Yd
 */
@Service
@Slf4j
public class IdsServiceImpl implements IdsService {

    @Autowired
    private SnowFlakeProperties snowFlakeProperties;

    private SnowFlake snowFlake;

    @PostConstruct
    public void init() {
        final SnowFlake snowFlake = new SnowFlake(
                snowFlakeProperties.getDatacenterId(),
                snowFlakeProperties.getMachineId());

        this.snowFlake = snowFlake;
    }

    @Override
    public long getId() {

        return snowFlake.nextId();

    }

    @Override
    public List<Long> batchGetId(int count) {

        List<Long> idList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            idList.add(snowFlake.nextId());
        }

        return idList;
    }

}
