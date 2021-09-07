package com.chenhao.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.Properties;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-8-25 14:28
 */
public class EmailManager {






    /**
     * 发送邮件 (完整版) (纯JavaMail)
     *
     * @param toAddress		: 收件人邮箱[]
     * @param ccAddress		: 抄送人邮箱[]
     * @param mailSubject	: 邮件主题
     * @param mailBody		: 邮件正文
     * @param mailBodyIsHtml: 邮件正文格式,true:HTML格式;false:文本格式
     * //@param inLineFile	: 内嵌文件
     * @param attachments	: 附件
     */
    public static boolean sendMail (String host, String port, String username, String password, String sendFrom, String sendNick, String[] toAddress, String[] ccAddress , String mailSubject, String mailBody,
                                    boolean mailBodyIsHtml, File[] attachments){
        try {
            // 创建邮件发送类 JavaMailSender (用于发送多元化邮件，包括附件，图片，html 等    )
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(host); 			// 设置邮件服务主机
            mailSender.setUsername(username); 	// 发送者邮箱的用户名
            mailSender.setPassword(password); 	// 发送者邮箱的密码

            //配置文件，用于实例化java.mail.session
            Properties pro = new Properties();
            pro.put("mail.smtp.auth", "true");		// 登录SMTP服务器,需要获得授权 (网易163邮箱新近注册的邮箱均不能授权,测试 sohu 的邮箱可以获得授权)
            pro.put("mail.smtp.socketFactory.port", port);
            pro.put("mail.smtp.socketFactory.fallback", "false");
            System.setProperty("mail.mime.splitlongparameters", "false");
            mailSender.setJavaMailProperties(pro);

            //创建多元化邮件 (创建 mimeMessage 帮助类，用于封装信息至 mimeMessage)
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, ArrayUtils.isNotEmpty(attachments), "UTF-8");

            helper.setFrom(sendFrom, sendNick);
            //收件人
            helper.setTo(toAddress);

            //抄送人
            helper.setCc(ccAddress);

            //标题
            helper.setSubject(mailSubject);
            //内容
            helper.setText(mailBody, mailBodyIsHtml);

            // 添加内嵌文件，第1个参数为cid标识这个文件,第2个参数为资源
            //helper.addInline(MimeUtility.encodeText(inLineFile.getName()), inLineFile);

            // 添加附件
            if (ArrayUtils.isNotEmpty(attachments)) {
                for (File file : attachments) {
                    StringBuilder sb = new StringBuilder();
                    String fileName = file.getName();

                    if(fileName.indexOf("-")>=0&&fileName.lastIndexOf("-")!=fileName.indexOf("-")) {
                    	sb.append(fileName.substring(0, fileName.indexOf("-", fileName.indexOf("-") + 1)));
                    	sb.append(fileName.substring(fileName.indexOf(".")));
                    }else {
                    	sb.append(fileName);
                    }

                    helper.addAttachment(MimeUtility.encodeText(sb + ""), file);
                }
            }

            mailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        EmailManager.sendMail("smtp.qq.com","587","1183829953@qq.com","fdlhawvcbqirbahd",
                "1183829953@qq.com","chenhao",new String[]{"625872582@qq.com"},new String[]{"chenhao3@tebon.com.cn"},"","老陈给女朋友的测试",false,new File[]{new File("/Users/chenhao/project/serverCode/ServerCode/document/hu.txt") });
        System.out.println("success");
    }
}
