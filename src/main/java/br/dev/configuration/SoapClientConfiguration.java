package br.dev.configuration;

import java.net.URL;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.myservice.IwsConsultaSQL;
import com.example.myservice.WsConsultaSQL;

@Configuration
public class SoapClientConfiguration {
	static Logger log = LoggerFactory.getLogger(SoapClientConfiguration.class);
	@Bean
	public IwsConsultaSQL getWS() {
		enableSoapLog();
		URL url = null;
		
		try {
			url = new URL("classpath:wsdl/ServiceTotvs.wsdl");
		} catch (Exception e) { e.printStackTrace();}
		
		IwsConsultaSQL service = new WsConsultaSQL(url).getRMIwsConsultaSQL();
		
		Map<String,Object> reqContext = ((BindingProvider) service).getRequestContext();
		reqContext.put(BindingProvider.USERNAME_PROPERTY, "user");
		reqContext.put(BindingProvider.PASSWORD_PROPERTY, "passw");
		reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/clientes");
		
		return service;
	}

	private void enableSoapLog() {
		log.info("Enabling HTTP console output for SOAP debug.");
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
	}
}


