package com.jf.ids.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-25 4:00
 * @since: 2.22.1
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "snow.flake")
public class SnowFlakeProperties {

	/**
	 * 数据中心标识ID, 默认为1
	 */
	private int datacenterId = 1;

	/**
	 * 机器进程标识ID，默认为1
	 */
	private int machineId = 1;
}
