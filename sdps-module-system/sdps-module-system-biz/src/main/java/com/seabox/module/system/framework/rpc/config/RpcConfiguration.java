package com.seabox.module.system.framework.rpc.config;

import com.seabox.module.infra.api.file.FileApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = FileApi.class)
public class RpcConfiguration {
}
