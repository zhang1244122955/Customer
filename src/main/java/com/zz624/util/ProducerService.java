package com.zz624.util;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	ApplicationContext act = new ClassPathXmlApplicationContext("activemq.xml");
    private JmsTemplate jmsTemplate = act.getBean("jmsTemplate",JmsTemplate.class);


    public void sendMessage(String userid,String msg){

    	Destination destination = new ActiveMQQueue(userid);
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("notice!**!"+msg);
            }
        });
    }


//    public void sendMessage(String msg){
//        String destination = jmsTemplate.getDefaultDestinationName();
//        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
//        jmsTemplate.send(new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage(msg);
//            }
//        });
//    }
}