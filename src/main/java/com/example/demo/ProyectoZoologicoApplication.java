package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Animal;
import com.example.demo.service.IAlmacenService;
import com.example.demo.service.IAnimalService;

@SpringBootApplication
public class ProyectoZoologicoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoZoologicoApplication.class, args);
	}

	@Autowired
	IAnimalService animalService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Corregido");
		
//		var a = animalService.buscarPorId(1);
//		System.out.println(a.getNombreComun());
//		
		var b = animalService.buscarPorHabitat("p");
		System.out.println(b.get(0).getNombreCientifico());
		
		for (Animal animal : b) {
			System.out.println(animal.getNombreCientifico());
		}
	}

}
