package com.jl.controller;

import com.jl.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

@RestController
public class SendServlet {
	

    @RequestMapping("sendMail")
	protected void sendMail(HttpServletRequest request, HttpServletResponse response, User info) throws ServletException, IOException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 邮箱服务器主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");//是否使用ssl安全连接
        properties.put("mail.debug", "true");//是否在控制台显示相关信息

        //获取会话对象
        Session session = Session.getInstance(properties);
        //获取邮件对象
        Message message = new MimeMessage(session);

        try {
        	System.out.println(info);
            // 设置发件人邮箱地址
            message.setFrom(new InternetAddress("1792594824@qq.com"));
            // 设置收件人邮箱地址
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(info.getEmail()));

            //有多个收件人时，写成数组形式
            //InternetAddress[] receiverArr={new InternetAddress("xxx@qq.com"),new InternetAddress("xxx@qq.com"),new InternetAddress("xxx@qq.com")};
            //message.setRecipients(Message.RecipientType.TO, receiverArr);

            String code=100000+new Random().nextInt(899999)+"";
            System.out.println(code);
            // 设置邮件标题
            message.setSubject("【阅读网】认证");
            // 设置邮件内容
            message.setText("【阅读网】<br>您的短信验证码为:<a>"+code+"</a>，验证码在60s内有效。");

            //获取邮差对象
            Transport transport = session.getTransport();
            //连接自己的邮箱账户，第二个参数是授权码
            transport.connect("1792594824@qq.com", "ssdedgyivmrvciae");
            //发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        	PrintWriter out = response.getWriter();
        	request.getSession().setAttribute("code",code);
    		out.print(code);

        } catch (MessagingException e) {
        	PrintWriter out = response.getWriter();
    		out.print("error");
            e.printStackTrace();
        }

    }

}
