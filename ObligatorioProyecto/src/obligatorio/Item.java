/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Item {
    ArrayList<Ingrediente> igredientes;
    UnidadProcesadora unidadProcesadora;
    Categoria categoria;
    Pedido pedido; // El pedido, puede, o no estar atado a un Producto ? Es decir 0 a 1
}
