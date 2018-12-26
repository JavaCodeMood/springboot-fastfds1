package com.lhf.springbootfastfds1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @ClassName: FdfsConfiguration
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/24 20:11
 */
@Configuration
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
public class FdfsConfiguration {

}