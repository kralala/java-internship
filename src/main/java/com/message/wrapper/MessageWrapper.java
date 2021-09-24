package com.message.wrapper;

import com.message.Message;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageWrapper extends Wrapper {

    public MessageWrapper(Message msg) {
        super(msg);
    }

    public String getTranslatedText() {

        ResourceBundle bundle;
        bundle = ResourceBundle
                .getBundle("languages",
                        msg.getUser().getLanguage().getLocale());

        msg.setHello(bundle.getString("hello"));
        msg.setGoodbye((bundle.getString("goodbye")));

        return msg.getText();
    }

    @Override
    public String getText() {
        return getTranslatedText();
    }

    @Override
    public void setHello(String hello) {
        msg.setHello(hello);
    }

    @Override
    public void setGoodbye(String goodbye) {
        msg.setGoodbye(goodbye);
    }

}
