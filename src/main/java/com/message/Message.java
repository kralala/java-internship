package com.message;

import com.User;

public interface Message {

    String getText();

    User getUser();

    void setHello(String hello);

    void setGoodbye(String goodbye);
}
