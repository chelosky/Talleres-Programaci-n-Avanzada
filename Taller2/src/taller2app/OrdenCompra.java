/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;
/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class OrdenCompra {
    private int numOrden;
    private Clientes Cliente;
    private Fecha Fecha;
    private ListaProductos LP;
    
    public OrdenCompra(int a,int dia,int mes, int año, int hora, int min ,int seg , int o){
        numOrden = a;
        Cliente = null;
        Fecha = new Fecha(dia,mes,año,hora,min,seg);
        LP = new ListaProductos(o);
    }
    public void setNumOrden(int a){
        numOrden = a;
    }
    public void setCliente(Clientes b){
        Cliente = b;
    }
    public void setFecha(Fecha c){
        Fecha = c;
    }
    public int getNumOrden(){
        return numOrden;
    }
    public Clientes getClientes(){
        return Cliente;
    }
    public Fecha getFechaOrden(){
        return Fecha;
    }
    public ListaProductos getLP(){
        return LP;
    }
    public int TOTAL(){
        return 1;
    }
}
