/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 * @author MARCELO LAZO && NICOLAS HIDALDO
 */
public class Archivo extends Contenedor{
    private String extension;
    
    public Archivo(String Nombre){
        super(Nombre);
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

}
