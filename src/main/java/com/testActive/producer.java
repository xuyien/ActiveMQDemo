package com.testActive;

import javax.jms.Destination;

public interface producer {
	public  void sendMsg(Destination dest,final String msg);
}
