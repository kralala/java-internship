package com;

import com.message.abstractfactory.LazyMessageFactory;
import com.message.abstractfactory.MessageFactory;
import com.message.Message;
import com.message.abstractfactory.ReverseMessageFactory;
import com.message.wrapper.MessageWrapper;

import static com.message.language.Language.*;

public class Main {
    public static void main(String[] args) {

        User A = new User(1L, "Albert", RUSSIAN);
        User B = new User(2L, "Ben", ENGLISH);
        User C = new User(3L, "Charles", GERMAN);
        User D = new User(4L, "Dan", FRENCH);
        User E = new User(5L, "Eivor", SWEDISH);
        User F = new User(6L, "Frankie", JAPANESE);

        MessageFactory factory = getRandomBool() ? new LazyMessageFactory() : new ReverseMessageFactory();
        Message msg = factory.createMessage("hello","goodbye",B);
        MessageWrapper wrapped = new MessageWrapper(msg);
        send(wrapped);

    }

    private static void send(Message message){
        System.out.println(message.getText());
    }

    private static boolean getRandomBool(){
        return Math.random() > 0.5;
    }
}