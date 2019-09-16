/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 * @author MARCELO LAZO && NICOLAS HIDALDO
 */
public class Enlace extends Contenedor{
    private Contenedor refCon;
    
    public Enlace(String Nombre){
        super(Nombre);
    }

    public Contenedor getRefCon() {
        return refCon;
    }

    public void setRefCon(Contenedor refCon) {
        this.refCon = refCon;
    }
    
}
