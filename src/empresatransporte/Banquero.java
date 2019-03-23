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
    int[][] asignadoPedido = new int[cant][cant];
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
    
    public void llenarNombres(int i, String pedido){
        nombre[i] = pedido;
    }
    
    public void agregarReclamo(int i, int j, int max){
        reclamarPedido[i][j] = max;
    }
    
    public void imprimirReclamo(){
        for(int i = 0; i < cant; i++){
            for(int j = 0; j < cant; j++){
                System.out.println(reclamarPedido[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println(" ");
    }
    
    public void llenarDisponible(int i, int c){ //c es la cantidad
        pedidoDisponible[i] = c;
    }
    
    //para solicitacion de recurso
    public void solicitar(int i, int j, int c){ //c es la cantidad
        int contigualdad = 0;
        this.setMensaje("Se realizo la solicitud correctamente");
        asignadoPedido[i][j] = asignadoPedido[i][j]+c;
        pedidoDisponible[j] = pedidoDisponible[j]-c;
        
        //si llega a sus requerimientos maximos, se finaliza
        for(int k =0; k < cant; k++){
            if(reclamarPedido[i][k] == asignadoPedido[i][k]){
                contigualdad++;
            }
        }
        if(contigualdad==cant){
            for(int k = 0; k < cant; k++){
                pedidoDisponible[k] = pedidoDisponible[k] + asignadoPedido[i][k];
            }
            for(int k = 0; k < cant; k++){
                reclamarPedido[i][k] = 0;
                asignadoPedido[i][k] = 0;
            }
            contPeliminados++;
            this.setMensaje("El pedido "+nombre[i]+" finalizo");
            System.out.println("Se elimino el pedido");
        }
        contPedidosRealizados++;
        
        Reclamacion();
        Asignacion();
        Disponible();
        RA();  
    }
    
    public void AnadirAsignado(int i, int j, int c, int Pedidos, int Camiones){
        int contsim = 0;
        int cont0 = 0;
        int contceros = 0;
        int verif;
        int contigualdadS = 0;
        boolean posible =  true;
        
        //estructuras aux
        int[][] recPS = new int[cant][cant];
        int[][] asiPS = new int[cant][cant];
        int[] dispPS = new int[cant];
        int[][] restPS = new int[cant][cant];
        for(int k = 0; k < cant;k++){
            for(int l = 0; l < cant;l++){
                pedidoRestantes[k][l] = reclamarPedido[k][l] - asignadoPedido[k][l];
            }
        }
        
        //asignar valores para la simulacion
        for(int k = 0; k < cant;k++){
            for(int l = 0; l < cant;l++){
               recPS[k][l] = reclamarPedido[k][l];
               asiPS[k][l] = asignadoPedido[k][l];
               dispPS[k] = pedidoDisponible[k];
            }
        }
        
        //restantes simulacion
        for(int k = 0; k < cant;k++){
            for(int l = 0; l < cant;l++){
                restPS[k][l] = recPS[k][l] - asiPS[k][l];
            }
        }
        
        //aqui verificamos que el pedido no este eliminado y lo que solicita lo requiera
        verificacionEstado();
    }
    
    public void verificacionEstado(){
        int estadoEliminado = 0;
        int estadoRequiere = 0;
        
        
    }
    
    public void Reclamacion(){
        System.out.println("Reclamacion");
        for(int i = 0; i< cant; i++){
            for(int j = 0; j < cant; j++){
                System.out.println(reclamarPedido[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println(" ");
    }
    
    public void Asignacion(){
        System.out.println("Asignacion");
        for(int i = 0; i< cant; i++){
            for(int j = 0; j < cant; j++){
                System.out.println(asignadoPedido[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println(" ");
    }
           
    public void Disponible(){
        System.out.println("Disponible");
        for(int i = 0; i < cant; i++){
            System.out.println(pedidoDisponible[i]+" ");
        }
    }
    
    public void RA(){
        System.out.println("Reclamacion - Asignacion");
        for(int i = 0; i< cant; i++){
            for(int j = 0; j < cant; j++){
                pedidoRestantes[i][j] = reclamarPedido[i][j] - asignadoPedido[i][j];
                System.out.println(pedidoRestantes[i][j]+" ");
            }
            System.out.print(" ");
        }
        System.out.println("\n");
    }
    
    //gets y sets
    public int getActualBloqueados() {
        return actualBloqueados;
    }

    public int[][] getAsignadoPedido() {
        return asignadoPedido;
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

    public void setAsignadoPedido(int[][] asignarPedido) {
        this.asignadoPedido = asignarPedido;
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
