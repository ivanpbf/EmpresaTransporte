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
public class EmpresaTransporte {

    Banquero algoritmo = new Banquero();
    public static void main(String[] args) {
        //OJO
        //me equivoque y puse ruta como camion
        //usar camion para estos metodos y banquero pero ruta en la interfaz
        //OJO
        //aunque creo que no hay problema?
    }
    
    public int getContPedidosRealizados(){
        return algoritmo.getContPedidosRealizados();
    }
    public int getContPeliminados(){
        return algoritmo.getContPeliminados();
    }
    
    public int getActualBloqueados(){
        return algoritmo.getActualBloqueados();
    }
    
    public int getTotalBloqueados(){
        return algoritmo.getTotalBloqueados();
    }
    
    public String getMensaje(){
        return algoritmo.getMensaje();
    }
    
    public void llenarNombre(int i, String pedido){
        algoritmo.llenarNombres(i, pedido);
    }
    
    public void agregarReclamo(int i, int j, int max){
        algoritmo.agregarReclamo(i, j, max);
    }
    
    public void imprimirReclamo(){
        algoritmo.imprimirReclamo();
    }
    
    public void llenarDisponible(int i, int c){
        algoritmo.llenarDisponible(i, c);
    }
    
    public void AnadirAsignado(int i, int j, int c, int Pedidos, int Camiones){
        algoritmo.AnadirAsignado(i, j, c, Pedidos, Camiones);
    }
    
    public int getCant(){
        return algoritmo.getCant();
    }
    
    public void setCant(int cant){
        algoritmo.setCant(cant);
    }
    
    public int buscarDisponibles(int i){
        return algoritmo.buscarDisponible(i);
    }
    
    public int buscarReclamo(int i, int j){
        return algoritmo.buscarReclamo(i, j);
    }

}
