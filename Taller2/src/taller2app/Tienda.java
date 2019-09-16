/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class Tienda {
    private int codTienda;
    private String direccion;
    private ListaClientes LC;
    
    public Tienda(int a, String b,int c){
        codTienda = a;
        direccion = b;
        LC = new ListaClientes(c);
    }
    
    public void setcodTienda(int a){
        this.codTienda=a;
    }
    public void setdireccion(String b){
        this.direccion=b;
    }
    public int getcodTienda(){
        return this.codTienda;
    }
    public String getdireccion(){
        return this.direccion;
    }
    public ListaClientes getLC(){
        return this.LC;
    }
}
