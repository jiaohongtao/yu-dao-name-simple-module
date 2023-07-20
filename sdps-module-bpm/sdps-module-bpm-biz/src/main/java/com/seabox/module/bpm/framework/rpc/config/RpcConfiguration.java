package com.seabox.module.bpm.framework.rpc.config;

import com.seabox.module.system.api.dept.DeptApi;
import com.seabox.module.system.api.dept.PostApi;
import com.seabox.module.system.api.dict.DictDataApi;
import com.seabox.module.system.api.permission.RoleApi;
import com.seabox.module.system.api.sms.SmsSendApi;
import com.seabox.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {RoleApi.class, DeptApi.class, PostApi.class, AdminUserApi.class, SmsSendApi.class, DictDataApi.class})
public class RpcConfiguration {
}
