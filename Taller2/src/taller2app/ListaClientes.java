/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2app;

/**
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class ListaClientes {
    private Clientes[] LC;
    private int cant;
    private int max;
    
    public ListaClientes(int N){
        LC = new Clientes[N];
        max = N;
        cant =0;
    }
    public void AgregarCliente(Clientes D){
        LC[cant]=D;
        cant++;
    }
    public int getCantidadClientes(){
        return cant;
    }
    public int getMax(){
        return max;
    }
    public Clientes getClienteEspecifico(int i){
        return LC[i];
    }
    public Clientes getBuscarCliente(String rut){
        int i;
        for(i=0;i<cant;i++){
            if(LC[i].getApellido().equals(rut)){
                break;
            }
        }
        if(i==cant){
            return null;
        }else{
            return LC[i];
        }
    }
}
