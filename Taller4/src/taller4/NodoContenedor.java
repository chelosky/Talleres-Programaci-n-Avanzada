/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 * @author MARCELO LAZO && NICOLAS HIDALDO
 */
public class NodoContenedor {
    private Contenedor contenedor;
    NodoContenedor next,prev;
    
    public NodoContenedor(Contenedor contenedor){
        this.contenedor = contenedor;
        next=null;
        prev=null;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    public void setNext(NodoContenedor next) {
        this.next = next;
    }

    public void setPrev(NodoContenedor prev) {
        this.prev = prev;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }

    public NodoContenedor getNext() {
        return next;
    }

    public NodoContenedor getPrev() {
        return prev;
    }
    
}
