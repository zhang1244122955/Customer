package com.zz624.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zz624.biz.RoleBiz;
import com.zz624.biz.UserBiz;
import com.zz624.entry.Data;
import com.zz624.entry.Friend;
import com.zz624.entry.Init;
import com.zz624.entry.Mine;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.util.ConsumerService;
import com.zz624.util.ProducerService;




@Controller
public class MessageController {
    private Logger logger = Logger.getLogger(MessageController.class);
    
//    //创建队列
//    private Destination destination = new ActiveMQQueue("liuzhonghui");
//
//    //队列消息生产者
//    @Resource(name = "producerService")
//    private ProducerService producer;
//
//
//    //队列消息消费者
//    @Resource(name = "consumerService")
//    private ConsumerService consumer;
    
    @Autowired
	private UserBiz userBiz;
	@Autowired
	private RoleBiz roleBiz;


//    @RequestMapping(value = "/SendMessage", method = RequestMethod.POST)
//    @ResponseBody
//    public void send(HttpServletRequest request, HttpServletResponse response,@RequestBody String msg) {
//    	
//        logger.info(Thread.currentThread().getName()+"------------send to jms Start");
//        producer.sendMessage(destination,msg);
//        logger.info(Thread.currentThread().getName()+"------------send to jms End");
//    }
//
//
//    @RequestMapping(value= "/ReceiveMessage",method = RequestMethod.GET)
//    @ResponseBody
//    public Object receive(){
//        logger.info(Thread.currentThread().getName()+"------------receive from jms Start");
//        TextMessage tm = consumer.receive(destination);
//        logger.info(Thread.currentThread().getName()+"------------receive from jms End");
//        ObjectMapper mapper = new ObjectMapper();
//        
//        try {
//			return mapper.writeValueAsString(tm.getText());
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		} catch (JMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return null;
//    }
    
    @RequestMapping(value = "/init", method = RequestMethod.POST)
    @ResponseBody
    public Init init(Integer userid) {
    	
    	Init init = new Init();
    	//前台需要
    	init.setCode(0);
    	init.setMsg("");
    	
    	Data data = new Data();
    	
    	//根据id先查自己
    	User user = new User();
    	user.setUserid(userid);
    	user = userBiz.findOwn(user);
    	
    	Mine mine = new Mine();
    	mine.setUsername(user.getName());
    	mine.setId(""+user.getUserid());
    	//暂时把自己在线
    	mine.setStatus("online");
    	mine.setSign("Ailin！！！");
    	mine.setAvatar("/Customer/resources/images/Ailin.png");
    	
    	data.setMine(mine);
    	
    	List<Friend> friends = new ArrayList<Friend>();
    	for(Role role : roleBiz.findRoles()){
    		Friend friend = new Friend();
    		friend.setGroupname(role.getRolename());
    		friend.setId(role.getRoleid());

    		user.setRole(role);
    		user.setUserid(userid);
    		
    		List<Mine> mines = new ArrayList<Mine>();
    		for(User user2 : userBiz.findUsersByRoleID(user)){
    			mine = new Mine();
    			mine.setUsername(user2.getName());
    	    	mine.setId(""+user2.getUserid());
    	    	//暂时把自己在线
    	    	mine.setStatus("online");
    	    	mine.setSign("Ailin！！！");
    	    	mine.setAvatar("/Customer/resources/images/Ailin.png");
    	    	mines.add(mine);
    		}
    		friend.setList(mines);
    		friends.add(friend);
    	}
    	data.setFriend(friends);
    	init.setData(data);
    	
    	return init;
    }


}