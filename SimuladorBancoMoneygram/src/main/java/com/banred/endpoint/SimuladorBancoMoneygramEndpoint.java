package com.banred.endpoint;

import javax.xml.XMLConstants;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.tempuri.CommitPayment;
import org.tempuri.CommitPaymentResponse;
import org.tempuri.ObjectFactory;
import org.tempuri.SendPayment;
import org.tempuri.SendPaymentResponse;

import com.banred.config.IConstants;
import com.banred.service.CommitPaymentResultService;
import com.banred.service.SendPaymentResultService;

/**
 * The Class MunicipioGyeCepEndpoint.
 */

@Endpoint
public class SimuladorBancoMoneygramEndpoint implements IConstants {
	
	/** The Constant NAMESPACE. */
	public static final String NAMESPACE = "http://tempuri.org/";

	
	/** The consultar datos result service. */
	@Autowired
	SendPaymentResultService sendPaymentResultService;
	@Autowired
	CommitPaymentResultService commitPaymentResultService;

	private static final Logger logger = LoggerFactory.getLogger(SimuladorBancoMoneygramEndpoint.class);

	/**
	 * Prints the SOAP response.
	 *
	 * @param soapResponse the soap response
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
	}

	/**
	 * Creates the SOAP request.
	 *
	 * @param comercio the comercio
	 * @param tipo_trx the tipo trx
	 * @return the SOAP message
	 * @throws Exception the exception
	 */
	private static SOAPMessage createSOAPRequest(String comercio, String tipo_trx) throws Exception {

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		// envelope.addNamespaceDeclaration("sam", "http://samples.axis2.techdive.in");
		envelope.addNamespaceDeclaration("web", "http://webservice/");
		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("comercio", "web");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("codSimulador");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("tipoTransacion");
		soapBodyElem1.addTextNode(comercio);
		soapBodyElem2.addTextNode(tipo_trx);
		soapMessage.saveChanges();
		soapMessage.writeTo(System.out);
		System.out.println();
		return soapMessage;
	}



	/**
	 * Consultar datos.
	 *
	 * @param request the request
	 * @return the consultar datos response
	 */
	@PayloadRoot(namespace = NAMESPACE, localPart = REQUEST_LOCAL_PART_REQUEST_SEND_PAYMENT)
	@ResponsePayload
	public SendPaymentResponse SendPayment(@RequestPayload SendPayment request) {
		ObjectFactory obj = new ObjectFactory();
		SendPaymentResponse response = obj.createSendPaymentResponse();
		logger.info("getMethod: " + request.getAmount().toString() + "\n");
		try {
			response.setSendPaymentResult(sendPaymentResultService.createSendPaymentResultObject());
			return response;
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
			return null;
		}
		
	}


	@PayloadRoot(namespace = NAMESPACE, localPart = REQUEST_LOCAL_PART_REQUEST_COMMIT_PAYMENT)
	@ResponsePayload
	public CommitPaymentResponse CommitPayment(@RequestPayload CommitPayment request) {
		ObjectFactory obj = new ObjectFactory();
		CommitPaymentResponse response = obj.createCommitPaymentResponse();
		logger.info("getMethod: " + request.getAmount().toString() + "\n");
		try {
			response.setCommitPaymentResult(commitPaymentResultService.createCommitPaymentResultObject());
			return response;
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
			return null;
		}

	}
//	
}