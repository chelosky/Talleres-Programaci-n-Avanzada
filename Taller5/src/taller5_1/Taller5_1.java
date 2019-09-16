/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5_1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import ucn.*;

/**
 *Conjunto de operacion basicas que debe realizar la aplicacion del taller 5 entrega 1
 * @author Marcelo Lazo CHAVEZ
 *         Nicolas Hidalgo CASTILLO
 * El apellido de la mamá es el más importante.
 */
public class Taller5_1 {

    /**
     * AppTaller5Entrega1:  Procedimiento que se encarga de leer y almacenar en arrays la información
     *                      del archivo de texto "abb.txt", obteniendo datos en pareja
     *                      (linea 1 y linea2, linea3 y linea4,etc).
     *                      Una vez almacenados los datos del arrays, se crea el arbol binario, siguiendo las
     *                      indicaciones del pdf del taller 5, las cuales eran:
     *                      "Una de las formas de representar un árbol binario es mediante un arreglo,
     *                      donde se cumple que para todo nodo actual ubicado en la posición “i” del arreglo
     *                      tendrá a su hijo izquierdo en la posición 2*i + 1 del arreglo y a su hijo derecho
     *                      en la posición 2*i + 2 del arreglo. Asumiendo que el índice de partida del arreglo
     *                      es 0 y que la posición de los hijos no cae fuera del arreglo."
     *                      Una vez creado el arbol, se comprueba utilizando el metodo recursivo "ComprobarSiEsABB"
     *                      de la clase ArbolBinario, si es un arbol binario de busqueda, se utilizar otro metodo
     *                      recursivo dentro de la clase arbol, denominado "MaxMin", que se encargara de retornar
     *                      el valor mayor y valor minimo del arbol.
     *                      
     *                      
     * @throws IOException
     */
    public static void AppTaller5Entrega1() throws IOException{
        Scanner SC = new Scanner(new File("abb.txt"));
        int tipo = 0; //Si es la linea de cantidad de elementos o linea con los elementos a almacenar.
        int largo=0;
        int[] vector = null;
        while(SC.hasNextLine()){
            if(tipo==0){
                String linea = SC.nextLine();
                largo = Integer.parseInt(linea);
                vector = new int[largo];
                tipo=1;
            }else{
                String linea=SC.nextLine();
                String[] numero = linea.split(",");
                for(int i=0;i<largo;i++){
                    int temp = Integer.parseInt(numero[i]);
                    vector[i]=temp;
                }
                //Para cada árbol del archivo abb.txt se debe indicar si es un árbol binario de búsqueda (RF2), y en el caso de ser así, indicar el valor mínimo y máximo del abb (RF3).
                ArbolBinario AB = new ArbolBinario();//inicializamos el arbol
                AB.InsertarNodo(0,vector);//insertamos la raiz del arbol del vector
                String TextoAImprimir = "";
                for(int i=0;i<largo;i++){
                    TextoAImprimir = TextoAImprimir + vector[i] + " ";
                }
                StdOut.println(TextoAImprimir);
                StdOut.println("    Es Abb: "+ AB.ComprobarSiEsABB(0,vector));
                if(AB.ComprobarSiEsABB(0,vector)){
                    int[] valores = AB.MaxMin();
                    StdOut.println("    Mínimo : "+ valores[1]);
                    StdOut.println("    Máximo : "+ valores[0]);
                }
                //AB.recorridoPreorden();
                StdOut.println(" ");
                tipo=0;
            }
        }
        SC.close();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try{
            Taller5_1.AppTaller5Entrega1();
        }catch(Exception e){
            StdOut.println("Error Función Principal.");
        }
    }
}
