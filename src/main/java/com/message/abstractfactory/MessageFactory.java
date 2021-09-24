package com.message.abstractfactory;

import com.User;
import com.message.Message;

public interface MessageFactory {
    Message createMessage(String hello, String goodbye, User user);
}
