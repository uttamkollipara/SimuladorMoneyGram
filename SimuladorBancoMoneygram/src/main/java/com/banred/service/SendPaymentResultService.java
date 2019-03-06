package com.banred.service;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;
import org.tempuri.ObjectFactory;
import org.tempuri.SendPaymentResult;

@Service
public class SendPaymentResultService {
   
   public SendPaymentResult createSendPaymentResultObject() {
      SendPaymentResult sendPaymentDatosResult = new SendPaymentResult();
      
      try {
         ObjectFactory factory = new ObjectFactory();
         JAXBElement<String> jaxbElement  = factory.createSendPaymentResultSwitchAuditNumber("3014281E1551364245821908592637NN");
         sendPaymentDatosResult.setSwitchAuditNumber(jaxbElement);
         //consultarDatosResult.setWNumeroTerminal(jaxbElement);
         return sendPaymentDatosResult;}       
         catch(Exception ex) {
            return null;
         }           
   }

}