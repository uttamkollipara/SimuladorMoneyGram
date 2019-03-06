package com.banred.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;


/**
 * The Class WebServiceConfig.
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
   
   

   /**
    * Message dispatcher servlet.
    *
    * @param applicationContext the application context
    * @return the servlet registration bean
    */
   @Bean
   public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
      ApplicationContext applicationContext) {
      MessageDispatcherServlet servlet = new MessageDispatcherServlet();
      servlet.setApplicationContext(applicationContext);
      servlet.setTransformWsdlLocations(true);
      return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/PrediosBT/*");
   }

   /**
    * Default wsdl 11 definition.
    *
    * @return the wsdl 11 definition
    */
   @Bean(name = "SimuladorBancoMoneygram")
   public Wsdl11Definition defaultWsdl11Definition() {
      SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();             
      wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/SimuladorBancoMoneygram.wsdl"));
      return wsdl11Definition;
   }
   
   
   
}
