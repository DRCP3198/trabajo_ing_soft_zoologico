package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Este controlador maneja la vista principal de la aplicación.
 */

@Controller
@RequestMapping("/principal")
public class VistaWebPricipalController {
	
	/**
	 * Muestra la página principal.
	 *
	 * @return La vista "Principal".
	 */
	@GetMapping("/vistaPrincipal")
	public String vistaPrincipal() {
		return "Principal";
	}
}

