package com.aikoprocesso.api.controller.status;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/") //URL PADRAO
public class StatusApiApplication {

	@GetMapping  //VAI RETORNAR A DATA E HORA ATUAL + IP DA MAQUINA
	public String status() throws UnknownHostException {
		return "Api_aiko_processo rodando " + Instant.now() + " Servidor [" + InetAddress.getLocalHost() + "]";
	}
}
