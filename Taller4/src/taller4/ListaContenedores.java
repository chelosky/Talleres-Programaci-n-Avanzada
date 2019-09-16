    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 * @author MARCELO LAZO && NICOLAS HIDALDO
 */
public class ListaContenedores {
    private NodoContenedor First,Last;
    
    public ListaContenedores(){
        First=null;
        Last=null;
    }
    public void insertarUltimo(Contenedor contenedor){
        NodoContenedor Nuevo = new NodoContenedor(contenedor);
        if(First==null){
            First = Nuevo;
            Last = Nuevo;
        }else{
            Last.setNext(Nuevo);
            Nuevo.setPrev(Last);
            Last = Nuevo;
        }
    }
    

    public boolean delete(String nombre){
        NodoContenedor current = First;
        while(current != null && !current.getContenedor().getNombre().equals(nombre)){
            current = current.getNext();
        }
        if (current != null) { //La encontró
            if(current==First) {
                First = current.getNext();
            }else{
                current.getPrev().setNext(current.getNext());
            }
            if(current==Last){
                Last = current.getPrev();
            }else{
                current.getNext().setPrev(current.getPrev());
            }
            return true;
        }else{
            return false;
        }
    }
    
    public Contenedor Buscar(String nombre){
        NodoContenedor NC = First;
        while(NC!=null && !NC.getContenedor().getNombre().equals(nombre)){
            NC = NC.getNext();
        }
        if(NC==null){
            return null;
        }else{
            return NC.getContenedor();
        }
    }

    public NodoContenedor getFirst() {
        return First;
    }

    public NodoContenedor getLast() {
        return Last;
    }
    
    
}
