package com.tensquare.notice.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareBatchMessageListener;

import java.util.List;

/**
 * @version v1.0
 * @ClassName SysNoticeListener
 * @Description TODO
 * @Author Q
 */
public class SysNoticeListener implements ChannelAwareBatchMessageListener {
    @Override
    public void onMessageBatch(List<Message> list, Channel channel) {

    }
}
