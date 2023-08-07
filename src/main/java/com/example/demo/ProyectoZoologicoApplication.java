package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Almacen;
import com.example.demo.modelo.Producto;
import com.example.demo.service.IAlmacenService;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class ProyectoZoologicoApplication implements CommandLineRunner {

	@Autowired
	private IAlmacenService almacenService;
	@Autowired
	private IProductoService iProductoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoZoologicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola");
		
//		Almacen a1 = new Almacen();
//		a1.setNombre("Almacen 1");
//		a1.setCapacidad(33);
//		almacenService.agregar(a1);
//		System.out.println("asd");
//		
//		Producto p1 = new Producto();
//		p1.setNombre("Leche");
//		p1.setAlmacen(a1);
//		iProductoService.agregar(p1);
		


		
	
	}

}
