package com.message.wrapper;

import com.User;
import com.message.Message;

abstract class Wrapper implements Message {

    protected final Message msg;

    public Wrapper(Message msg) {
        this.msg = msg;
    }

    @Override
    public String getText() {return msg.getText();}

    @Override
    public User getUser(){
        return msg.getUser();
    }

}
