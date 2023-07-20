package com.seabox.framework.operatelog.config;

import com.seabox.framework.operatelog.core.aop.OperateLogAspect;
import com.seabox.framework.operatelog.core.service.OperateLogFrameworkService;
import com.seabox.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.seabox.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class SdpsOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
