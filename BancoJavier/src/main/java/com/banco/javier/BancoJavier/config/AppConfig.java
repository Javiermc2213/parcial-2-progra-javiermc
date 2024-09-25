package com.banco.javier.BancoJavier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import com.sun.xml.messaging.saaj.soap.MessageFactoryImpl;  // <--- Cambia a la clase de la implementación SAAJ

@Configuration
public class AppConfig {

    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(new MessageFactoryImpl());
        messageFactory.afterPropertiesSet();
        return new WebServiceTemplate(messageFactory);
    }
}
