/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class ListaOrdenCompra {
    private OrdenCompra[] LO;
    private int cant;
    private int max;
    
    public ListaOrdenCompra(int N){
        LO = new OrdenCompra[N];
        max=N;
        cant=0;
    }
    public void AgregarOrden(OrdenCompra D){
        LO[cant]=D;
        cant++;
    }
    public int getCantidadOrden(){
        return cant;
    }
    public int getMax(){
        return max;
    }
    public OrdenCompra getOrdenEspecifica(int i){
        return LO[i];
    }
    public OrdenCompra getBuscarOrden(int num){
        int i;
        for(i=0;i<cant;i++){
            if(LO[i].getNumOrden()==num){
                break;
            }
        }
        if(i==cant){
            return null;
        }else{
            return LO[i];
        }
    }
}
