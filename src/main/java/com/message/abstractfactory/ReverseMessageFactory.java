package com.message.abstractfactory;

import com.User;
import com.message.ReverseMessage;
import com.message.Message;

public class ReverseMessageFactory implements MessageFactory {
    public Message createMessage(String hello, String goodbye, User user) {
        return new ReverseMessage(hello, goodbye, user);
    }
}
