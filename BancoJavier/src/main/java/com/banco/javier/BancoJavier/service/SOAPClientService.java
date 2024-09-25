package com.banco.javier.BancoJavier.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SOAPClientService {

    private final WebServiceTemplate webServiceTemplate;

    @Value("${soap.endpoint}")
    private String soapEndpoint;

    public SOAPClientService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public String getExchangeRate(String date, int currency) {
        String soapRequest = buildSOAPRequest(date, currency);
        // Usa SoapActionCallback para agregar el SOAPAction correcto
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.banguat.gob.gt/variables/ws/TipoCambioFechaInicialMoneda");

        return webServiceTemplate.marshalSendAndReceive(soapEndpoint, soapRequest, soapActionCallback).toString();
    }

    private String buildSOAPRequest(String date, int currency) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soap:Body>" +
                "<TipoCambioFechaInicialMoneda xmlns=\"http://www.banguat.gob.gt/variables/ws/\">" +
                "<fechainit>" + date + "</fechainit>" +
                "<moneda>" + currency + "</moneda>" +
                "</TipoCambioFechaInicialMoneda>" +
                "</soap:Body>" +
                "</soap:Envelope>";
    }
}
