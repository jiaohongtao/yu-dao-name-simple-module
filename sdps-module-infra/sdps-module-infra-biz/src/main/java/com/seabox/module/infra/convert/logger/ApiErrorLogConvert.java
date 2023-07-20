package com.seabox.module.infra.convert.logger;

import com.seabox.framework.apilog.core.service.ApiErrorLog;
import com.seabox.framework.common.pojo.PageResult;
import com.seabox.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import com.seabox.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import com.seabox.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import com.seabox.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
