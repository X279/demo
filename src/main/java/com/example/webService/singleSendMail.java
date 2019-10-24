package com.example.webService;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.io.UnsupportedEncodingException;

public class singleSendMail {

    private IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou","LTAI4FnFAWu8z3VGdGT8AvTn","VzH6nHOM1wr3jW9fOj5D19hj3Mjioo");
    private IAcsClient client = new DefaultAcsClient(profile);
    private final String[] address;
    private final String topic;
    private final String information;


   public singleSendMail(String address,String topic,String information) throws UnsupportedEncodingException {
       String add = java.net.URLDecoder.decode(address, "utf-8");
       this.address = add.split(";");
       this.topic = java.net.URLDecoder.decode(topic, "utf-8");
       this.information = java.net.URLDecoder.decode(information, "utf-8");
   }

   public String[] getAddress(){
       return address;
   }

    public String sendMail(String url){
        SingleSendMailRequest request = new SingleSendMailRequest();
        try{
            request.setAccountName("zhouning@cugyn.xyz");
            request.setReplyToAddress(true);
            request.setFromAlias("lkx");
            request.setAddressType(1);
            request.setToAddress(url);
            request.setSubject(topic);
            request.setHtmlBody(information);
            request.setClickTrace("0");
            System.out.println("发送...");
            SingleSendMailResponse response = client.getAcsResponse(request);
            return "Y";
        }catch (ServerException e1){
            System.out.println("Error1:" + e1.getErrCode());
            e1.printStackTrace();
            return "N";
        }catch (ClientException e2){
            System.out.println("Error2:" + e2.getErrCode());
            e2.printStackTrace();
            return "N";
        }
    }

    public String sendEmailBatch(String[] url){
       int size = url.length;
       for(int i=0;i<size;i++){
           System.out.println(url[i]);
           return sendMail(url[i]);
       }
       return "N";
    }
}
