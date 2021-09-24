package com.message.abstractfactory;

import com.User;
import com.message.LazyMessage;
import com.message.Message;

public class LazyMessageFactory implements MessageFactory {
    public Message createMessage(String hello, String goodbye, User user) {
        return new LazyMessage(hello, goodbye, user);
    }
}
