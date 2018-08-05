package com.allen.spring.controller;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.bean.ActionEventDomain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    @Qualifier("jms/omsReplyQueue")
    private Destination destination;
    
    @Autowired
    private JmsTemplate jmsTemplate ;
    
    @PostMapping(path = "/hello")
    public String loginPage(@RequestBody final ActionEventDomain domain) {
        jmsTemplate.send(destination, new MessageCreator() {
            
            @Override
            public Message createMessage(Session session) throws JMSException {
                logger.info("开始创造消息");
                String value = null;
                try {
                    value = objectMapper.writeValueAsString(domain);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                TextMessage msg = session.createTextMessage(value);
                msg.setJMSCorrelationID("111111111111111111111");
                msg.setJMSMessageID("2222222222222222222");
                return msg;
            }
        });
        logger.info("消息发送成功");
        return "hello boot!";
    }
}
