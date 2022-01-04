package br.dev.api.controller;


import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myservice.Implements;
import com.example.myservice.ImplementsResponse;
import com.example.myservice.IwsConsultaSQL;
import com.example.myservice.Type;


@RestController
@RequestMapping("/soapclient")
public class SoapClientController {
	@Autowired
	IwsConsultaSQL consultaWS;
	
	@GetMapping("/imp")
	public String run() {
		Implements parameters = new Implements();
		Type val = new Type();
		
		Class<Type> type = Type.class;
		QName qname = new QName("testing");
		JAXBElement<Type> value = new JAXBElement<Type>(qname, type, val);
		parameters.setType(value);
		ImplementsResponse implementa = consultaWS.implementa(parameters );
	
		return implementa.toString();
	}		
	@GetMapping
	public String listar() {
		
		String codSentenca = "abc";
		Integer codColigada = 123;
		String codSistema = "ax12";
		String parameters = "bc34";
		String context = "wy90";
		
		String retorno = consultaWS.realizarConsultaSQL(codSentenca, codColigada, codSistema, parameters, context);
		
		return retorno;
	}
	
}
