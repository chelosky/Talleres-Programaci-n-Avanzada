/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5_1;

/**
 * @author Marcelo Lazo CHAVEZ
 *         Nicolas Hidalgo CASTILLO
 * El apellido de la mamá es el más importante.
 */

public class Nodo {
    private int dato;
    private Nodo izq,der;
    
    public Nodo(int dato){
        this.dato = dato;
        this.izq = null;
        this.der =  null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    
}
