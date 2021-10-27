package com.chenhao.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-8-25 14:28
 */
public class EmailUtils {
    private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);

    public static void sendEmail(String sendTo,String subject,String content) {
        logger.info("发送邮件考试");
        Properties props = new Properties();
        //指定邮件的发送服务器地址
        props.put("mail.smtp.host", "smtp.qq.com");
        //指定邮件的发送服务器地址
        props.put("mail.smtp.port", "587");
        //服务器是否要验证用户的身份信息
        props.put("mail.smtp.auth", "true");
        //得到Session
        Session session = Session.getInstance(props);
        //代表启用debug模式，可以在控制台输出smtp协议应答的过程
        session.setDebug(true);

        //创建一个MimeMessage格式的邮件
        MimeMessage message = new MimeMessage(session);

        //设置发送者
        Address fromAddress = null;
        try {
            //邮件地址;
            fromAddress = new InternetAddress("1183829953@qq.com");
            //设置发送的邮件地址
            message.setFrom(fromAddress);
            //设置接收者
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(sendTo));
            //设置邮件的主题
            message.setSubject(subject);
            //设置邮件的内容
            message.setText(content);
            //保存邮件
            message.saveChanges();
            //得到发送邮件的服务器(这里用的是smtp服务器)
            Transport transport = session.getTransport("smtp");

            //发送者的账号连接到smtp服务器上  @163.com可以不写
            transport.connect("smtp.qq.com", "1183829953@qq.com", "fdlhawvcbqirbahd");
            //发送信息
            transport.sendMessage(message, message.getAllRecipients());
            //关闭服务器通道
            transport.close();
        } catch (Exception e) {
            logger.error("发送邮件发生异常",e);
        }
    }

}
