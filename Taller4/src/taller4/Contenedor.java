/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 * @author MARCELO LAZO && NICOLAS HIDALDO
 */
public abstract class Contenedor {
    protected int codigo;
    protected String nombre;
    protected static int CodigoUniversal=0;
    
    protected Contenedor(String nombre){
        this.nombre = nombre;
        CodigoUniversal++;
        this.codigo = CodigoUniversal;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public static int getCodigoUniversal() {
        return CodigoUniversal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
