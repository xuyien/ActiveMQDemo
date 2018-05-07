package com.testActive;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
@Service(value="producerImpl")
public class producerImpl implements producer {
	@Resource(name="menuTemplate")
    private JmsTemplate tmp;

	public void sendMsg(Destination dest,final String msg) {
		MessageCreator msgCreator=new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				return session.createTextMessage(msg);
			}
		};
		tmp.send(dest,msgCreator);
	}

}
