package com.seabox.module.system.convert.notify;

import com.seabox.framework.common.pojo.PageResult;
import com.seabox.module.system.controller.admin.notify.vo.template.NotifyTemplateCreateReqVO;
import com.seabox.module.system.controller.admin.notify.vo.template.NotifyTemplateRespVO;
import com.seabox.module.system.controller.admin.notify.vo.template.NotifyTemplateUpdateReqVO;
import com.seabox.module.system.dal.dataobject.notify.NotifyTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 站内信模版 Convert
 *
 * @author xrcoder
 */
@Mapper
public interface NotifyTemplateConvert {

    NotifyTemplateConvert INSTANCE = Mappers.getMapper(NotifyTemplateConvert.class);

    NotifyTemplateDO convert(NotifyTemplateCreateReqVO bean);

    NotifyTemplateDO convert(NotifyTemplateUpdateReqVO bean);

    NotifyTemplateRespVO convert(NotifyTemplateDO bean);

    List<NotifyTemplateRespVO> convertList(List<NotifyTemplateDO> list);

    PageResult<NotifyTemplateRespVO> convertPage(PageResult<NotifyTemplateDO> page);

}
