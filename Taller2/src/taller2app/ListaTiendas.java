/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class ListaTiendas {
    private Tienda[] LT;
    private int cant;
    private int max;
    
    public ListaTiendas(int N){
        LT = new Tienda[N];
        max=N;
        cant=0;
    }
    public void AgregarTienda(Tienda D){
        LT[cant]=D;
        cant++;
    }
    public int getCantidadTiendas(){
        return cant;
    }
    public int getMax(){
        return max;
    }
    public Tienda getTiendaEspecifica(int i){
        return LT[i];
    }
    public Tienda getBuscarTienda(int codigo){
        int i;
        for(i=0;i<cant;i++){
            if(LT[i].getcodTienda()==codigo){
                break;
            }
        }
        if(i==cant){
            return null;
        }else{
            return LT[i];
        }
    }
}
