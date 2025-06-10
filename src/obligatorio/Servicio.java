/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio;

import java.util.ArrayList;

public class Servicio {
    float montoTotal;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    Cliente cliente;
    Dispositivo dispositivo;

    public Servicio(Cliente cliente, Dispositivo servicio) {
        this.cliente = cliente;
        this.dispositivo = servicio;
    }

    public float calcularSubtotal(){
        float subtotal = 0;
        //calcular descuento de cada pedido
        for (Pedido pedido : pedidos){
            subtotal += cliente.calcularBeneficioItem( pedido.getItem() );
        }
        //calcular descuentos sobre el total del servicio
        return cliente.calcularBeneficioServicio(subtotal);
    }

}
