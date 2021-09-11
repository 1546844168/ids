package com.jf.ids.controller;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.exception.ServiceException;
import com.jf.common.utils.result.BaseResult;
import com.jf.ids.service.IdsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-25 4:17
 * @since: 2.22.1
 */
@Api(value = "分布式id服务controller", tags = {"分布式id"})
@RestController
@Slf4j
public class IdsController {

    @Autowired
    private IdsService idsService;

    @ApiOperation("获取一个id")
    @GetMapping("/id")
    @MethodLogger
    public BaseResult<Long> getId() {
        long id = idsService.getId();
        int num = 6;
        if (num == 6) {
            throw new ServiceException("完蛋了");
        }
        return BaseResult.success(id);
    }

    @ApiOperation("获取count个id")
    @GetMapping("/id/{count}")
    @MethodLogger
    public BaseResult<List<Long>> batchGetId(@PathVariable Integer count) {

        List<Long> idList = idsService.batchGetId(count);
        return BaseResult.success(idList);
    }
}
