package com.seabox.module.system.mq.producer.permission;

import com.seabox.framework.mq.core.bus.AbstractBusProducer;
import com.seabox.module.system.mq.message.permission.MenuRefreshMessage;
import org.springframework.stereotype.Component;

/**
 * Menu 菜单相关消息的 Producer
 */
@Component
public class MenuProducer extends AbstractBusProducer {

    /**
     * 发送 {@link MenuRefreshMessage} 消息
     */
    public void sendMenuRefreshMessage() {
        publishEvent(new MenuRefreshMessage(this, getBusId(), selfDestinationService()));
    }

}
