package br.dev.api.controller;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myservice.IwsConsultaSQL;
import com.example.myservice.RealizarConsultaSQLResponse;

@RestController
@RequestMapping("/soapclient")
public class SoapClientController {
	@Autowired
	IwsConsultaSQL consultaWS;

	@PostMapping(value = "/consulta", produces = MediaType.TEXT_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE)
	public Envelope consulta(@RequestBody String input) {
		RealizarConsultaSQLResponse response = new RealizarConsultaSQLResponse();
		JAXBElement<String> value = new JAXBElement<String>(
				new QName("http://www.totvs.com/", "RealizarConsultaSQLResult"), String.class, "Yoman!");
		response.setRealizarConsultaSQLResult(value);
		return new Envelope().setBody(new Body().setResponse(response));
	}

	@GetMapping
	public String listar() {
		String codSentenca = "abc";
		Integer codColigada = 123;
		String codSistema = "ax12";
		String parameters = "bc34";
		String context = "wy90";
		return consultaWS.realizarConsultaSQL(codSentenca, codColigada, codSistema, parameters, context);
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "body" })
	@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
	public class Envelope {
		@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/", type = Body.class)
		protected Body body;

		public Envelope setBody(Body body) {
			this.body = body;
			return this;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "response" })
	@XmlRootElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
	public class Body {
		@XmlElement(name = "RealizarConsultaSQLResponse", namespace = "http://www.totvs.com/", type = RealizarConsultaSQLResponse.class)
		protected RealizarConsultaSQLResponse response;

		public Body setResponse(RealizarConsultaSQLResponse response) {
			this.response = response;
			return this;
		}
	}
}
