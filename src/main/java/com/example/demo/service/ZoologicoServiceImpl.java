package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Zoologico;
import com.example.demo.repository.IZoologicoRepo;

/**
 * Implementación del servicio para la gestión de zoológicos.
 */
@Service
public class ZoologicoServiceImpl implements IZoologicoService {

    @Autowired
    private IZoologicoRepo iZoologicoRepo;

    /**
     * Agrega un zoológico a la base de datos.
     *
     * @param zoologico El zoológico a agregar.
     */
    @Override
    public void agregar(Zoologico zoologico) {
        this.iZoologicoRepo.insertar(zoologico);
    }
}

