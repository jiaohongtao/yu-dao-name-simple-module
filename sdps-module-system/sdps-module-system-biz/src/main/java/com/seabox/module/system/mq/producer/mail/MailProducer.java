package com.seabox.module.system.mq.producer.mail;

import com.seabox.framework.mq.core.bus.AbstractBusProducer;
import com.seabox.module.system.mq.message.mail.MailAccountRefreshMessage;
import com.seabox.module.system.mq.message.mail.MailSendMessage;
import com.seabox.module.system.mq.message.mail.MailTemplateRefreshMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Mail 邮件相关消息的 Producer
 *
 * @author wangjingyi
 * @since 2021/4/19 13:33
 */
@Slf4j
@Component
public class MailProducer extends AbstractBusProducer {

    @Resource
    private StreamBridge streamBridge;

    /**
     * 发送 {@link MailTemplateRefreshMessage} 消息
     */
    public void sendMailTemplateRefreshMessage() {
        publishEvent(new MailTemplateRefreshMessage(this, getBusId(), selfDestinationService()));
    }

    /**
     * 发送 {@link MailAccountRefreshMessage} 消息
     */
    public void sendMailAccountRefreshMessage() {
        publishEvent(new MailAccountRefreshMessage(this, getBusId(), selfDestinationService()));
    }

    /**
     * 发送 {@link MailSendMessage} 消息
     *
     * @param sendLogId 发送日志编码
     * @param mail 接收邮件地址
     * @param accountId 邮件账号编号
     * @param nickname 邮件发件人
     * @param title 邮件标题
     * @param content 邮件内容
     */
    public void sendMailSendMessage(Long sendLogId, String mail, Long accountId,
                                    String nickname, String title, String content) {
        MailSendMessage message = new MailSendMessage()
                .setLogId(sendLogId).setMail(mail).setAccountId(accountId)
                .setNickname(nickname).setTitle(title).setContent(content);
        streamBridge.send("mailSend-out-0", message);
    }

}
