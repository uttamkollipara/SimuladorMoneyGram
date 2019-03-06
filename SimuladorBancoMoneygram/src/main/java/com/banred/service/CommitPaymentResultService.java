package com.banred.service;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;
import org.tempuri.CommitPaymentResult;
import org.tempuri.ObjectFactory;

@Service
public class CommitPaymentResultService {
	
	public CommitPaymentResult createCommitPaymentResultObject() {
		CommitPaymentResult commitPaymentDatosResult = new CommitPaymentResult();
		
		try {
			ObjectFactory factory = new ObjectFactory();
			JAXBElement<String> jaxbElement  = factory.createSendPaymentResultSwitchAuditNumber("3014281E1551364245821908592637NN");
			//commitPaymentDatosResult(jaxbElement);
			//consultarDatosResult.setWNumeroTerminal(jaxbElement);
			return commitPaymentDatosResult;}		
			catch(Exception ex) {
				return null;
			}				
	}

}