package com.seabox.module.system.api.errorcode;

import com.seabox.framework.common.pojo.CommonResult;
import com.seabox.module.system.api.errorcode.dto.ErrorCodeAutoGenerateReqDTO;
import com.seabox.module.system.api.errorcode.dto.ErrorCodeRespDTO;
import com.seabox.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@FeignClient(name = ApiConstants.NAME) // TODO 芋艿：fallbackFactory =
@Tag(name =  "RPC 服务 - 错误码")
public interface ErrorCodeApi {

    String PREFIX = ApiConstants.PREFIX + "/error-code";

    @PostMapping(PREFIX + "/auto-generate")
    @Operation(summary = "自动创建错误码")
    CommonResult<Boolean> autoGenerateErrorCodeList(@Valid @RequestBody List<ErrorCodeAutoGenerateReqDTO> autoGenerateDTOs);

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "增量获得错误码数组", description = "如果 minUpdateTime 为空时，则获取所有错误码")
    @Parameters({
            @Parameter(name = "applicationName", description = "应用名", example = "system-server", required = true),
            @Parameter(name = "minUpdateTime", description = "最小更新时间")
    })
    CommonResult<List<ErrorCodeRespDTO>> getErrorCodeList(@RequestParam(value = "applicationName") String applicationName,
                                                          @RequestParam(value = "minUpdateTime", required = false) LocalDateTime minUpdateTime);

}