package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/principal")
public class VistaWebPricipalController {
	
//	INICIO PAGINA PRINCIPAL
//	http://localhost:8080/zoologico/principal/vistaPrincipal

	@GetMapping("/vistaPrincipal")
	public String vistaPrincipal() {
		
		return "Principal";
	}
	
}
