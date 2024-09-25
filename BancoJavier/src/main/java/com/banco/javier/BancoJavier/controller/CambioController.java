package com.banco.javier.BancoJavier.controller;

import com.banco.javier.BancoJavier.dto.CambioDTO;
import com.banco.javier.BancoJavier.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api")
public class CambioController {

    @Autowired
    private CambioService cambioService;

    @GetMapping(value = "/cambio", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public CambioDTO obtenerCambio() {
        return cambioService.obtenerCambio();
    }
}
