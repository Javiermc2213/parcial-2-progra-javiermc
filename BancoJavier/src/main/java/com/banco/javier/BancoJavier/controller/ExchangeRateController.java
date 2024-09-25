package com.banco.javier.BancoJavier.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {

    private static final Logger logger = LogManager.getLogger(ExchangeRateController.class);

  
    @GetMapping("/exchange-rate")
    public String obtenerCambio() {
        logger.info("Se ha accedido al endpoint /exchange-rate");
        logger.error("Esto es solo un ejemplo de error");
        return "Prueba de logging en el endpoint de exchange-rate";
    }
}
