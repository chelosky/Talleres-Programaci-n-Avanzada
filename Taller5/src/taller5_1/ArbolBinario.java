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

public class ArbolBinario {
    private Nodo raiz;
    
    public ArbolBinario(){
        this.raiz = null;
    }
    
    public void InsertarNodo(int inicio,int[] vector){
        if(raiz==null){
            raiz = Comenzar(inicio,vector);
        }
    }
    
    private Nodo Comenzar(int i,int[] vector){
        Nodo Nuevo = new Nodo(vector[i]);
        Nuevo.setIzq(InsertIzq(2*i+1,vector));
        Nuevo.setDer(InsertDer(2*i+2,vector));
        return Nuevo;
    }
    
    private Nodo InsertIzq(int x,int[] vector){
        if(x >= vector.length){
            return null;
        }else{
            Nodo temp = new Nodo(vector[x]);
            temp.setIzq(InsertIzq(2*x+1,vector));
            temp.setDer(InsertDer(2*x+2,vector));
            return temp;
        }
    }
    
    private Nodo InsertDer(int j,int[] vector){
        if(j >= vector.length){
            return null;
        }else{
            Nodo temp = new Nodo(vector[j]);
            temp.setIzq(InsertIzq(2*j +1,vector));
            temp.setDer(InsertDer(2*j +2,vector));
            return temp;
        }
    }
    
    public void recorridoPreorden(){
        ayudantePreorden(raiz);
    }
    
    private void ayudantePreorden(Nodo n){
        if(n==null){
            return;
        }
        System.out.print(n.getDato() + " ");
        ayudantePreorden(n.getIzq());
        ayudantePreorden(n.getDer());
    }
    
    /**
     *
     * RF2: Implementar una función recursiva que valide si un árbol dado es abb o no.
     * 
     * @param i Posicion inicial.
     * @param vector Array con los elementos del arbol.
     * @return Retorna false, si no es abb y true si lo es.
     */
    public boolean ComprobarSiEsABB(int i,int[] vector){
        if(vector.length==1){
            // 1 elemento
            return true;
        }else{
            if(vector.length==2){
                //2 elementos
                return RecComprobar(2*i+1,vector);
            }else{
                //3 o +
                return RecComprobar(2*i+1,vector) && RecComprobar(2*i+2,vector);
            }
        }
    }

    private boolean RecComprobar(int i,int[] vector){
        if(2*i+1<vector.length || 2*i+2<vector.length){
            if(2*i+1<vector.length && 2*i+2<vector.length){
                return RecComprobar(2*i+1,vector) && RecComprobar(2*i+2,vector);
            }else{
                if(2*i+1<vector.length){
                    return RecComprobar(2*i+1,vector);
                }else{
                    return RecComprobar(2*i+2,vector);
                }
            }
        }
        //izq
        int w=i;
        while(w!=0){
            if(w%2==0){
                w=(w-2)/2;
                if(vector[i]<vector[w]){
                    return false;
                }
            }else{
                //der
                w=(w-1)/2;
                if(vector[i]>vector[w]){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *
     * RF3 : Implementar una función recursiva que devuelva el valor mínimo y máximo del abb. El mínimo y máximo deben ser retornados de la misma función.
     * 
     * @return devuelve un vector de 2 elementos, donde el primer elemento es el mayor y el segundo es el minimo.
     */
    public int[] MaxMin(){
        Nodo Current=raiz;
        int mayor=Max(Current);
        int minimo=Min(Current);
        int [] v = new int[2];
        v[0]=mayor;
        v[1]=minimo;
        return v;
    }
    
    private int Max(Nodo candidato){
        if(candidato.getDer()==null){
            return candidato.getDato();
        }else{
            return Max(candidato.getDer());
        }
    }
    
    private int Min(Nodo candidato){
        if(candidato.getIzq()==null){
            return candidato.getDato();
        }else{
            return Min(candidato.getIzq());
        }
    }
}
