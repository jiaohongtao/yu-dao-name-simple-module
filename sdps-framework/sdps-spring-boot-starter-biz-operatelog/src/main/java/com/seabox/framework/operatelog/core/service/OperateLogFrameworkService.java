package com.seabox.framework.operatelog.core.service;

/**
 * 操作日志 Framework Service 接口
 *
 * @author 芋道源码
 */
public interface OperateLogFrameworkService {

    /**
     * 异步记录操作日志
     *
     * @param operateLog 操作日志请求
     */
    void createOperateLog(OperateLog operateLog);

}
