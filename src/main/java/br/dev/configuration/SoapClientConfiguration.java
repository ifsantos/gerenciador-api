package br.dev.configuration;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.myservice.IwsConsultaSQL;
import com.example.myservice.WsConsultaSQL;

import javax.xml.ws.BindingProvider;

@Configuration
public class SoapClientConfiguration {
	
	@Bean
	public IwsConsultaSQL getWS() {
		enableSoapLog();
		
		IwsConsultaSQL service = new WsConsultaSQL().getRMIwsConsultaSQL();
		
		Map<String,Object> reqContext = ((BindingProvider) service).getRequestContext();
		reqContext.put(BindingProvider.USERNAME_PROPERTY, "user");
		reqContext.put(BindingProvider.PASSWORD_PROPERTY, "passw");
		reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/clientes");
		
		return service;
	}

	private void enableSoapLog() {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
	}
}


