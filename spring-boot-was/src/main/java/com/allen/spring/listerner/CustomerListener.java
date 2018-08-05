package com.allen.spring.listerner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class CustomerListener  implements SessionAwareMessageListener<Message>{


    private Logger logger = LoggerFactory.getLogger(getClass());
  

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        logger.info("收到消息CorrelationID:" + message.getJMSCorrelationID());
        logger.info("收到消息MessageID:" + message.getJMSMessageID());
        String msg = ((TextMessage) message).getText();
        logger.info("消息内容是：" + msg);

    }

}
