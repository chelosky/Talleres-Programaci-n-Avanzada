/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class ListaProductos {
    private Producto[] LP;
    private int cant;
    private int max;
    
    public ListaProductos(int N){
        LP = new Producto[N];
        cant=0;
        max=N;
    }
    public void AgregarProducto(Producto D){
        LP[cant]=D;
        cant++;
    }
    public int getCantidadProductos(){
        return cant;
    }
    public int getMax(){
        return max;
    }
    public Producto getProductoEspecifico(int i){
        return LP[i];
    }
    public Producto getBuscarProducto(String cod){
        int i;
        for(i=0;i<cant;i++){
            if(LP[i].getCodProducto().equals(cod)){
                break;
            }
        }
        if(i==cant){
            return null;
        }else{
            return LP[i];
        }
    }
}
