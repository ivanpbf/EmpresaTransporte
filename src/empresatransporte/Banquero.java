/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresatransporte;

/**
 *
 * @author Ivan
 */
public class Banquero {
    int cant = 200; //cantidad "ilimitada" de rutas
    String nombre[] = new String[cant]; //matriz que guarda los nombres de pedidos
    int[][] reclamarPedido = new int[cant][cant];
    int[][] alocarPedido = new int[cant][cant];
    int[] pedidoDisponible = new int[cant];
    int[][] pedidoRestantes = new int [cant][cant];
    int[][] pedidosBloqueados = new int [cant][cant+1];
    String mensaje;
    int contPeliminados;
    int contPedidosRealizados;
    int totalBloqueados;
    int actualBloqueados;
    
}
