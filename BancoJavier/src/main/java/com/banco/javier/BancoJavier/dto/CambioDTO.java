package com.banco.javier.BancoJavier.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CambioDTO")
public class CambioDTO {
    private String fecha;
    private String moneda;
    private double venta;
    private double compra;

    // Constructor vacío necesario para JAXB
    public CambioDTO() {}

    public CambioDTO(String fecha, String moneda, double venta, double compra) {
        this.fecha = fecha;
        this.moneda = moneda;
        this.venta = venta;
        this.compra = compra;
    }

    @XmlElement
    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    @XmlElement
    public String getMoneda() { return moneda; }

    public void setMoneda(String moneda) { this.moneda = moneda; }

    @XmlElement
    public double getVenta() { return venta; }

    public void setVenta(double venta) { this.venta = venta; }

    @XmlElement
    public double getCompra() { return compra; }

    public void setCompra(double compra) { this.compra = compra; }
}
