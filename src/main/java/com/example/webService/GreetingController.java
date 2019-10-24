package com.example.webService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    //发送邮件
    @RequestMapping("/send")
    public String sending(@RequestParam String address,
                         @RequestParam(value = "topic",defaultValue = "你好") String topic,
                         @RequestParam(value = "information",defaultValue = "你好，来自刘可欣")String information) throws UnsupportedEncodingException {
        Send s = new Send(counter.incrementAndGet(),
                address,topic,information);
        return s.sendMail();
    }

    //验证邮箱
    @RequestMapping("/varify")
    public String varifying(@RequestParam String address){
        varifyMailAddress v = new varifyMailAddress(address);
        String result = v.varify();
        return result;
    }
}
