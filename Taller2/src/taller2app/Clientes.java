/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class Clientes {
    private String rut;
    private String nombre;
    private String apellido;
    private String sexo;
    private int telefono;
    private String email;
    private Tienda Tienda;
    private ListaOrdenCompra LO;
    
    public Clientes(String a,String b,String c,String d,int e,String f,int g){
        rut = a;
        nombre = b;
        apellido = c;
        sexo = d;
        telefono = e;
        email = f;
        Tienda = null;
        LO = new ListaOrdenCompra(g);
    }
    public void setRut(String a){
        this.rut = a;
    }
    public void setNombre(String b){
        this.nombre = b;
    }
    public void setApellido(String c){
        this.apellido = c;
    }
    public void setSexo(String d){
        this.sexo = d;
    }
    public void setTelefono(int e){
        this.telefono = e;
    }
    public void setEmail(String f){
        this.email = f;
    }
    public void setTienda(Tienda T){
        this.Tienda = T;
    }
    public String getRut(){
        return rut;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getSexo(){
        return sexo;
    }
    public int getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }
    public Tienda getTienda(){
        return Tienda;
    }
    public ListaOrdenCompra getLO(){
        return LO;
    }
}
