package com.seabox.framework.pay.core.client.impl.alipay;

import com.seabox.framework.common.exception.ErrorCode;
import com.seabox.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.seabox.framework.pay.core.client.AbstractPayCodeMapping;

import java.util.Objects;

/**
 * 支付宝的 PayCodeMapping 实现类
 *
 * @author 芋道源码
 */
public class AlipayPayCodeMapping extends AbstractPayCodeMapping {

    @Override
    protected ErrorCode apply0(String apiCode, String apiMsg) {
        if (Objects.equals(apiCode, "10000")) {
            return GlobalErrorCodeConstants.SUCCESS;
        }
        // alipay wap  api code 返回为null, 暂时定为-9999
        if (Objects.equals(apiCode, "-9999")) {
            return GlobalErrorCodeConstants.SUCCESS;
        }
        return null;
    }

}
