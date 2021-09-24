package com.message;

import com.User;

public class ReverseMessage implements Message {

    private String hello;
    private String goodbye;
    private final User user;

    public ReverseMessage(String hello, String goodbye, User user) {
        this.hello = hello;
        this.goodbye = goodbye;
        this.user = user;
    }

    @Override
    public String getText() {
        return String.format(
                "\n%s, %s. %s!",
                goodbye,
                user.getName(),
                hello
        );
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void setGoodbye(String goodbye) {
        this.goodbye = goodbye;
    }
}
