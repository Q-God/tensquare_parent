package com.tensquare.notice.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @version v1.0
 * @ClassName UserNoticeListener
 * @Description TODO
 * @Author Q
 */
public class UserNoticeListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

    }
}
