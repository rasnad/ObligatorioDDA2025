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

    public Servicio(Cliente cliente) {
        this.cliente = cliente;
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
