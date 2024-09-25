package com.banco.javier.BancoJavier.service;

import com.banco.javier.BancoJavier.dto.CambioDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CambioServiceTest {

    @Test
    void testObtenerCambio() {
        // Instancia del servicio a probar
        CambioService cambioService = new CambioService();

        // Llamada al método que estamos probando
        CambioDTO cambio = cambioService.obtenerCambio();

        // Verificaciones (Assertions)
        assertNotNull(cambio); // Verifica que el objeto no es nulo
        assertEquals("24/09/2024", cambio.getFecha()); // Verifica que la fecha es correcta
        assertEquals("02", cambio.getMoneda()); // Verifica que la moneda es la esperada
        assertEquals(7.8, cambio.getVenta()); // Verifica que el valor de venta es correcto
        assertEquals(7.6, cambio.getCompra()); // Verifica que el valor de compra es correcto
    }
}
