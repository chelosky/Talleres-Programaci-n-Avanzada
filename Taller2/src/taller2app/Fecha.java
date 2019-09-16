/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class Fecha {
    private int dia;
    private int mes;
    private int año;
    private int hora;
    private int minutos;
    private int segundos;
    
    public Fecha(int a,int b,int c,int d,int e,int f){
        dia=a;
        mes=b;
        año=c;
        hora=d;
        minutos=e;
        segundos=f;
    }
    public void setDia(int a){
        dia = a;
    }
    public void setMes(int b){
        mes=b;
    }
    public void setAño(int c){
        año = c;
    }
    public void setHora(int d){
        hora =d;
    }
    public void setMinutos(int e){
        minutos =e;
    }
    public void setSegundos(int f){
        segundos =f;
    }
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAño(){
        return año;
    }
    public int getHora(){
        return hora;
    }
    public int getMinutos(){
        return minutos;
    }
    public int getSegundos(){
        return segundos;
    }
}