package com.seabox.framework.idempotent.config;

import com.seabox.framework.idempotent.core.aop.IdempotentAspect;
import com.seabox.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.seabox.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.seabox.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.seabox.framework.idempotent.core.redis.IdempotentRedisDAO;
import com.seabox.framework.redis.config.SdpsRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration
@AutoConfigureAfter(SdpsRedisAutoConfiguration.class)
public class SdpsIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
