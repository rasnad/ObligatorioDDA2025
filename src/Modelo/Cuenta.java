package Modelo;

import java.util.ArrayList;

public class Cuenta {
    
    ArrayList<Item> itemsDescontados = new ArrayList<>();
    float servicioSinDescuentos = 0; //Tiene el subtotal SIN descuentos sobre el servicio. Ejemplo: 2000
    float servicioConDescuento = 0; //Tiene el subtotal con descuentos sobre el servicio. Ejemplo: Si el subtotal es 2000 y restan los 500 pesos de DeLaCasa, esto valdría 1500

    public ArrayList<Item> getItemsDescontados() {
        return itemsDescontados;
    }

    public void setItemsDescontados(ArrayList itemsDescontados) {
        this.itemsDescontados = itemsDescontados;
    }

    public float getServicioSinDescuentos() {
        return servicioSinDescuentos;
    }

    public void setServicioSinDescuento(float servicioSinDescuentos) {
        this.servicioSinDescuentos = servicioSinDescuentos;
    }

    public float getServicioConDescuento() {
        return servicioConDescuento;
    }

    public void setServicioConDescuento(float servicioConDescuento) {
        this.servicioConDescuento = servicioConDescuento;
    }
    
}
