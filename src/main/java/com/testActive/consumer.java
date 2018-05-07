package com.testActive;

import javax.jms.Destination;
import javax.jms.TextMessage;

public interface consumer {
       TextMessage getMessage(Destination dest);
}
