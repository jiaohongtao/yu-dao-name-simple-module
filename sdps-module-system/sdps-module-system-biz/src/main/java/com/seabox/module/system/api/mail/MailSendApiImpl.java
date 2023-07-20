package com.seabox.module.system.api.mail;

import com.seabox.framework.common.pojo.CommonResult;
import com.seabox.module.system.api.mail.dto.MailSendSingleToUserReqDTO;
import com.seabox.module.system.api.sms.SmsSendApi;
import com.seabox.module.system.api.sms.dto.send.SmsSendSingleToUserReqDTO;
import com.seabox.module.system.service.mail.MailSendService;
import com.seabox.module.system.service.sms.SmsSendService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.seabox.framework.common.pojo.CommonResult.success;
import static com.seabox.module.system.enums.ApiConstants.VERSION;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class MailSendApiImpl implements MailSendApi {

    @Resource
    private MailSendService mailSendService;

    @Override
    public CommonResult<Long> sendSingleMailToAdmin(MailSendSingleToUserReqDTO reqDTO) {
        return success(mailSendService.sendSingleMailToAdmin(reqDTO.getMail(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams()));
    }

    @Override
    public CommonResult<Long> sendSingleMailToMember(MailSendSingleToUserReqDTO reqDTO) {
        return success(mailSendService.sendSingleMailToMember(reqDTO.getMail(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams()));
    }

}
