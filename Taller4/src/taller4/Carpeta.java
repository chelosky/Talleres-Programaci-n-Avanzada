/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 *
 * @author carlos
 */
public class Carpeta extends Contenedor{
    private Carpeta padre;
    private ListaContenedores LC;
    
    public Carpeta(String Nombre){
        super(Nombre);
        LC = new ListaContenedores();
    }

    public Carpeta getPadre() {
        return padre;
    }

    public ListaContenedores getLC() {
        return LC;
    }

    public void setPadre(Carpeta padre) {
        this.padre = padre;
    }
    
}
