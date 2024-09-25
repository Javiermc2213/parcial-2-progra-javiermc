package com.banco.javier.BancoJavier.service;

import com.banco.javier.BancoJavier.dto.CambioDTO;
import org.springframework.stereotype.Service;

@Service
public class CambioService {

    public CambioDTO obtenerCambio() {
        return new CambioDTO("24/09/2024", "02", 7.8, 7.6);
    }
}
