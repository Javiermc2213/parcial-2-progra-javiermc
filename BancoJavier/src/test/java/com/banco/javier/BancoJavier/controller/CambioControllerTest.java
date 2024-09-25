package com.banco.javier.BancoJavier.controller;

import com.banco.javier.BancoJavier.dto.CambioDTO;
import com.banco.javier.BancoJavier.service.CambioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CambioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testObtenerCambioJSON() throws Exception {
        // Ejecutamos la solicitud y validamos la respuesta en JSON
        mockMvc.perform(get("/api/cambio")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fecha").value("24/09/2024"))
                .andExpect(jsonPath("$.moneda").value("02"))
                .andExpect(jsonPath("$.venta").value(7.8))
                .andExpect(jsonPath("$.compra").value(7.6));

        // Imprimir la respuesta en JSON en la consola
        String jsonResponse = mockMvc.perform(get("/api/cambio")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Response in JSON: " + jsonResponse);
    }

    @Test
    public void testObtenerCambioXML() throws Exception {
        // Ejecutamos la solicitud y validamos la respuesta en XML
        mockMvc.perform(get("/api/cambio")
                .accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(xpath("/CambioDTO/fecha").string("24/09/2024"))
                .andExpect(xpath("/CambioDTO/moneda").string("02"))
                .andExpect(xpath("/CambioDTO/venta").string("7.8"))
                .andExpect(xpath("/CambioDTO/compra").string("7.6"));

        // Imprimir la respuesta en XML en la consola
        String xmlResponse = mockMvc.perform(get("/api/cambio")
                .accept(MediaType.APPLICATION_XML))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Response in XML: " + xmlResponse);
    }
}
