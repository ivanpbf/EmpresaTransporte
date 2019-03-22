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

    public void iniciarReclamo(){
        for (int i = 0; i < cant; i++){
            for(int j = 0; j < cant; j++){
                reclamarPedido[i][j] = 0;
            }
        }
    }
    
    
    
    public int getActualBloqueados() {
        return actualBloqueados;
    }

    public int[][] getAlocarPedido() {
        return alocarPedido;
    }

    public int getCant() {
        return cant;
    }

    public int getContPedidosRealizados() {
        return contPedidosRealizados;
    }

    public int getContPeliminados() {
        return contPeliminados;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String[] getNombre() {
        return nombre;
    }

    public int[] getPedidoDisponible() {
        return pedidoDisponible;
    }

    public int[][] getPedidoRestantes() {
        return pedidoRestantes;
    }

    public int[][] getPedidosBloqueados() {
        return pedidosBloqueados;
    }

    public int[][] getReclamarPedido() {
        return reclamarPedido;
    }

    public int getTotalBloqueados() {
        return totalBloqueados;
    }

    public void setActualBloqueados(int actualBloqueados) {
        this.actualBloqueados = actualBloqueados;
    }

    public void setAlocarPedido(int[][] alocarPedido) {
        this.alocarPedido = alocarPedido;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setContPedidosRealizados(int contPedidosRealizados) {
        this.contPedidosRealizados = contPedidosRealizados;
    }

    public void setContPeliminados(int contPeliminados) {
        this.contPeliminados = contPeliminados;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public void setPedidoDisponible(int[] pedidoDisponible) {
        this.pedidoDisponible = pedidoDisponible;
    }

    public void setPedidoRestantes(int[][] pedidoRestantes) {
        this.pedidoRestantes = pedidoRestantes;
    }

    public void setPedidosBloqueados(int[][] pedidosBloqueados) {
        this.pedidosBloqueados = pedidosBloqueados;
    }

    public void setReclamarPedido(int[][] reclamarPedido) {
        this.reclamarPedido = reclamarPedido;
    }

    public void setTotalBloqueados(int totalBloqueados) {
        this.totalBloqueados = totalBloqueados;
    }
    
    
    
}
