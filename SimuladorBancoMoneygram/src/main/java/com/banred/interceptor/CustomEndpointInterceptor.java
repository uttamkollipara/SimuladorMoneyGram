package com.banred.interceptor;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class CustomEndpointInterceptor.
 */
@Component
public class CustomEndpointInterceptor extends EndpointInterceptorAdapter {

	/** The Constant SOAP_ENV_NAMESPACE. */
	private static final String SOAP_ENV_NAMESPACE = "http://schemas.xmlsoap.org/soap/envelope/";
	
	/** The Constant PREFERRED_PREFIX. */
	private static final String PREFERRED_PREFIX = "soap";
	
	private static final Logger logger = LoggerFactory.getLogger(CustomEndpointInterceptor.class);

	/* (non-Javadoc)
	 * @see org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter#handleResponse(org.springframework.ws.context.MessageContext, java.lang.Object)
	 */
	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
		SaajSoapMessage soapResponse = (SaajSoapMessage) messageContext.getResponse();
		alterSoapEnvelope(soapResponse);
		return super.handleResponse(messageContext, endpoint);
	}

	/* (non-Javadoc)
	 * @see org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter#handleFault(org.springframework.ws.context.MessageContext, java.lang.Object)
	 */
	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
		SaajSoapMessage soapResponse = (SaajSoapMessage) messageContext.getResponse();
		alterSoapEnvelope(soapResponse);
		return super.handleFault(messageContext, endpoint);
	}

	/**
	 * Alter soap envelope.
	 *
	 * @param soapResponse the soap response
	 */
	private void alterSoapEnvelope(SaajSoapMessage soapResponse) {
		try {
			SOAPMessage soapMessage = soapResponse.getSaajMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPHeader header = soapMessage.getSOAPHeader();//***
			SOAPBody body = soapMessage.getSOAPBody();
			SOAPFault fault = body.getFault();
			envelope.removeNamespaceDeclaration(envelope.getPrefix());
			envelope.addNamespaceDeclaration(PREFERRED_PREFIX, SOAP_ENV_NAMESPACE);
			envelope.setPrefix(PREFERRED_PREFIX);
		//	header.setPrefix(PREFERRED_PREFIX);//***
		//	header.detachNode(); //***
			body.setPrefix(PREFERRED_PREFIX);
			if (fault != null) {
				fault.setPrefix(PREFERRED_PREFIX);
			}
		} catch (SOAPException e) {
			e.printStackTrace();
			logger.debug("context", e);
		}
	}
}
