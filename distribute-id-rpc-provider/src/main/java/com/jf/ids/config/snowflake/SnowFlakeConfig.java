package com.jf.ids.config.snowflake;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-25 4:42
 * @since: 2.22.1
 */
@Configuration
@EnableConfigurationProperties(SnowFlakeProperties.class)
public class SnowFlakeConfig {

}
