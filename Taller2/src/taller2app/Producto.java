/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class Producto {
    private String CodProducto;
    private String nombre;
    private String Plataforma;
    private int precio;
    private int cantidad;
    private int precioF;
    
    public Producto(String a,String b,int c,String d){
        CodProducto = a;
        nombre = b;
        precio = c;
        Plataforma = d;
    }
    public void setCodProducto(String a){
        CodProducto = a;
    }
    public void setNombre(String b){
        nombre =b;
    }
    public void setCantidad(int a){
        cantidad=a;
    }
    public void setPrecio(int c){
        precio =c;
    }
    public void setPlataforma(String d){
        Plataforma =d;
    }
    public String getCodProducto(){
        return CodProducto;
    }
    public String getNombre(){
        return nombre;
    }
    public int getPrecio(){
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setPFinal(int a,int b){
        cantidad=a;
        precioF=a*b;
    }
    public int getPFinal(){
        return precioF;
    }
    public String getPlataforma(){
        return Plataforma;
    }
}
