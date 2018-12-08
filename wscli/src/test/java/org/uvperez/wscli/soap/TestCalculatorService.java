package org.uvperez.wscli.soap;

import java.net.URI;

public class TestCalculatorService {

	private static final String WSDL = "http://www.dneonline.com/calculator.asmx?WSDL";
	
	public static void main(String[] args) throws Exception {
		URI uriEndpoint = new URI(WSDL.substring(0, WSDL.length() - 5));
		SoapClient client = new SimpleSoapClient(uriEndpoint);
		String payload;
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<soap:Body>");
		sb.append("<Add xmlns=\"http://tempuri.org/\">");
		sb.append("<intA>").append(1).append("</intA>");
		sb.append("<intB>").append(4).append("</intB>");
		sb.append("</Add>");
		sb.append("</soap:Body>");
		sb.append("</soap:Envelope>");
		payload = sb.toString();
		System.out.println(payload);
		String response = client.request("http://tempuri.org/Add", payload);
		System.out.println(response);
	}

}
