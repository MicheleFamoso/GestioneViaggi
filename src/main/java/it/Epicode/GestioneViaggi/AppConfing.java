package it.Epicode.GestioneViaggi;


import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@PropertySource("application.properties")
public class AppConfing {

    @Bean
    public Cloudinary getCloudinary(@Value("${cloudinary.cloud_name}") String cloudName,
                                    @Value("${cloudinary.api_key}")String apiKey,
                                    @Value("${cloudinary.api_secret}")String secretKey){
        Map<String,String> confingCloudinary = new HashMap<>();
        confingCloudinary.put("cloud_name",cloudName);
        confingCloudinary.put("api_key",apiKey);
        confingCloudinary.put("api_secret",secretKey);


        return new Cloudinary(confingCloudinary);




    }

    @Bean
    public JavaMailSenderImpl getJavaMailSender(@Value("${gmail.mail.transport.protocol}" ) String protocol,
                                                @Value("${gmail.mail.smtp.auth}" ) String auth,
                                                @Value("${gmail.mail.smtp.starttls.enable}" ) String starttls,
                                                @Value("${gmail.mail.debug}" ) String debug,
                                                @Value("${gmail.mail.from}" ) String from,
                                                @Value("${gmail.mail.from.password}" ) String password,
                                                @Value("${gmail.smtp.ssl.enable}" ) String ssl,
                                                @Value("${gmail.smtp.host}" ) String host,
                                                @Value("${gmail.smtp.port}" ) String port){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));

        mailSender.setUsername(from);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", protocol);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", starttls);
        props.put("mail.debug", debug);
        props.put("smtp.ssl.enable",ssl);

        return mailSender;
    }

}
