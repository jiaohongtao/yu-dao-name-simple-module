package com.seabox.framework.tenant.config;

import com.seabox.framework.common.enums.WebFilterOrderEnum;
import com.seabox.framework.mybatis.core.util.MyBatisUtils;
import com.seabox.framework.tenant.core.aop.TenantIgnoreAspect;
import com.seabox.framework.tenant.core.db.TenantDatabaseInterceptor;
import com.seabox.framework.tenant.core.job.TenantJobAspect;
import com.seabox.framework.tenant.core.mq.TenantChannelInterceptor;
import com.seabox.framework.tenant.core.mq.TenantFunctionAroundWrapper;
import com.seabox.framework.tenant.core.redis.TenantRedisCacheManager;
import com.seabox.framework.tenant.core.security.TenantSecurityWebFilter;
import com.seabox.framework.tenant.core.service.TenantFrameworkService;
import com.seabox.framework.tenant.core.service.TenantFrameworkServiceImpl;
import com.seabox.framework.tenant.core.web.TenantContextWebFilter;
import com.seabox.framework.web.config.WebProperties;
import com.seabox.framework.web.core.handler.GlobalExceptionHandler;
import com.seabox.module.system.api.tenant.TenantApi;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.function.context.catalog.FunctionAroundWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.config.GlobalChannelInterceptor;

import java.util.Objects;

@AutoConfiguration
@ConditionalOnProperty(prefix = "sdps.tenant", value = "enable", matchIfMissing = true) // 允许使用 sdps.tenant.enable=false 禁用多租户
@ConditionalOnClass(name = {
        "org.springframework.messaging.support.ChannelInterceptor",
        "org.springframework.cloud.function.context.catalog.FunctionAroundWrapper"
})
@EnableConfigurationProperties(TenantProperties.class)
public class SdpsTenantMQAutoConfiguration {

    @Bean
    @GlobalChannelInterceptor // 必须添加在方法上，否则无法生效
    public TenantChannelInterceptor tenantChannelInterceptor() {
        return new TenantChannelInterceptor();
    }

    @Bean
    public FunctionAroundWrapper functionAroundWrapper() {
        return new TenantFunctionAroundWrapper();
    }

}
