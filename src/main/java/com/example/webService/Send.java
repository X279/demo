package com.example.webService;

import java.io.UnsupportedEncodingException;

public class Send {
    private final long id;
    private final String address;
    private final String topic;
    private final String information;
    private singleSendMail sendMailRequest;

    public Send(long id, String address, String topic, String information) throws UnsupportedEncodingException {
        this.id = id;
        this.address = address;
        this.topic = topic;
        this.information = information;
    }

    public String sendMail() throws UnsupportedEncodingException {
        sendMailRequest = new singleSendMail(address, topic, information);
        String[] addressList = sendMailRequest.getAddress();
        return sendMailRequest.sendEmailBatch(addressList);
    }

    public long getID(){
        return id;
    }

    public String getAddress(){
        return address;
    }

    public String getTopic(){
        return topic;
    }

    public String getInformation(){
        return information;
    }
}
