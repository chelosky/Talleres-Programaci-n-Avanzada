package taller1;
import java.io.*;
import ucn.*;
/**
 *
 * @author Marcelo Lazo - Nicolas Hidalgo
 */
public class Taller1 {

    public static void Menu(){
        /*
        La función "MENU" imprimira una pequeña descripcion de la opciones disponibles.
        */
        StdOut.println("----------------------");
        StdOut.println("Opciones Disponibles :");
        StdOut.println("----------------------");
        StdOut.println("RF1: Opción venta por mes.");
        StdOut.println("RF2: Opción dia mayor recaudación.");
        StdOut.println("RF3: Opción promedio.");
        StdOut.println("RF4: Opción total ventas.");
        StdOut.println("RF5: Opción Salir.");
        StdOut.println("Ingrese la opcion que desee: ");
        StdOut.println("(Ingrese solo el numero de la opcion deseada)");
        StdOut.println("(Ejemplo: RF1 ---> Ingrese solo : 1)");
    }
    
    public static int ContarVentas() throws IOException{
        /*
        Funcion ContarVentas se encarga de contar la filas del archivo de texto "Ventas"
        */
        int contar=0;//Variable de acumulacion
        ArchivoEntrada uno = new ArchivoEntrada("ventas.txt");//Cargar Archivo de entrada ventas.txt
        while(!uno.isEndFile()){//Mientras archivo no es fin de linea
            Registro linea=uno.getRegistro();//Obtener fila del archivo
            contar++;//Aumentar acumulador
        }
        uno.close();//Cierre de achivo
        return contar;//Devolvemos el valor de la acumulacion
    }
    
    public static int ContarProductos() throws IOException{
        /*
        Funcion ContarVentas se encarga de contar la filas del archivo de texto "Ventas"
        */
        int contar=0;//Definir variable acumulacion
        ArchivoEntrada uno = new ArchivoEntrada("productos.txt");//Cargar Archivo de entrada productos.txt
        while(!uno.isEndFile()){//Mientras archivo noes fin de linea
            Registro linea=uno.getRegistro();//Obtener fila del archivo
            contar++;//Aumentar acumulador
        }
        uno.close();//Cierre de  archivo
        return contar;//Devolvemos el valor de la acumulacion
    }
    
    public static void TransVentas(int filas,int matriz [][]) throws IOException{
       /*
        Funcion TransVentas, se encargara de transferir archivo de entrada ventas.txt
        a matriz de 4 columnas y x cantidad de filas.
        */ 
        ArchivoEntrada ventitas = new ArchivoEntrada("ventas.txt");//Cargar Archivo de entrada ventas.txt
        for(int i=0;i<filas;i++){
            Registro linea = ventitas.getRegistro();//Obtener fila del archivo
            //Cada get se separa por coma
            matriz[i][0]=linea.getInt();//Obtener de primer Int
            matriz[i][1]=linea.getInt();//Obtener de segundo Int
            matriz[i][2]=linea.getInt();//Obtener de tercero Int
            matriz[i][3]=linea.getInt();//Obtener de cuarto Int
        }
        ventitas.close();//Cerramos el archivo de entrada
    }
     
    public static void TransProductos(int filas,int matriz1 [][],String matriz2[][]) throws IOException{
        /*
        Funcion TransProductos, se encargara de transferir archivo de entrada ventas.txt
        a matriz de 4 columnas y h cantidad de filas. 
        */
        ArchivoEntrada productitos = new ArchivoEntrada("productos.txt");//Cargar Archivo de entrada productos.txt
        for(int i=0;i<filas;i++){
            Registro linea = productitos.getRegistro();//Obtener fila del archivo
            //Cada get se separa por coma
            matriz1[i][0]=linea.getInt();//Obtener de primer Int
            matriz2[i][0]=linea.getString();//Obtener de primer String
            matriz1[i][1]=linea.getInt();//Obtener de segunda Int
            matriz2[i][1]=linea.getString();//Obtener de segunda String
        }
        productitos.close();//Cerramos el archivo de entrada
    }

    public static void CreacionCatalogo1(String Matrix[][],String Vectorx[],int precio[]){
        /*
        Funcion CreacionCatalogo1 se encargara de crear un vector que guarda todas las categorias de los productos
        */
        Vectorx[0]="Telefonia";//Matrix[0][1];
        Vectorx[1]="Electrohogar";//Matrix[4][1];
        Vectorx[2]="Computacion";//Matrix[10][1];
        Vectorx[3]="TV Audio";//Matrix[14][1];
        Vectorx[4]="Entretenimiento";//Matrix[16][1];
        Vectorx[5]="Muebles";//Matrix[20][1];
        Vectorx[6]="Dormitorio";//Matrix[22][1];
        Vectorx[7]="Ripley Home";//Matrix[25][1];
        Vectorx[8]="Deporte";//Matrix[26][1];
        Vectorx[9]="Infatil";//Matrix[29][1];
        Vectorx[10]="Belleza";//Matrix[31][1];
        Vectorx[11]="Zapatos y Bolsos";//Matrix[36][1];
        Vectorx[12]="Moda";//Matrix[38][1];
        
        for(int i=0;i<13;i++){
            precio[i]=0;
        }
    }
    
    public static void CreacionCatalogo2(String Matrix[][],String Vectorx[]){
        /*
        Funcion CreacionCatalogo2se encargara de crear un vector que guarda todas las categorias de los productos + un espacio de ventas total
        */
        Vectorx[0]="Telefonia";//Matrix[0][1];
        Vectorx[1]="Electrohogar";//Matrix[4][1];
        Vectorx[2]="Computacion";//Matrix[10][1];
        Vectorx[3]="TV Audio";//Matrix[14][1];
        Vectorx[4]="Entretenimiento";//Matrix[16][1];
        Vectorx[5]="Muebles";//Matrix[20][1];
        Vectorx[6]="Dormitorio";//Matrix[22][1];
        Vectorx[7]="Ripley Home";//Matrix[25][1];
        Vectorx[8]="Deporte";//Matrix[26][1];
        Vectorx[9]="Infatil";//Matrix[29][1];
        Vectorx[10]="Belleza";//Matrix[31][1];
        Vectorx[11]="Zapatos y Bolsos";//Matrix[36][1];
        Vectorx[12]="Moda";//Matrix[38][1];
        Vectorx[13]="Total";
    }
    
    public static void Creaciondias(int D[][]){
        /*
        Esta Funcion se encarga de crear matriz de [dias|dinerodedia]
        */
        for(int i=0;i<31;i++){
            D[i][0]=i+1;
            D[i][1]=0;
        }
    }
    
    // FIN SECCION 1
    
    // INCIO SECCION 2
    //SECCION DONDE SE ENCUENTRAN LAS OPCIONES DE LA APLICACIONES DE RF1 A RF4
    public static void Opcion1(int mes,int FilasP,int FilasV,int ventas[][],int Iproduc[][], String Sproduc[][],String cata[],int Precio[]){
        /*
        Opcion 1 representa la opcion RF1  de la aplicacion
        Esta opción le permite introducir un mes al usuario y visualizar para cada categoría, el nombre de la categoría y el dinero recaudado, en el mes ingresado.
        */
        int auxiliar;//Variable auxiliar que guardara el precio de venta
        boolean exito;//Variable Boleano que permitira imprimir matriz de ventas por mes
        if(mes>=1 && mes<=12){//si el mes esta entre 1 y 12 entonces se ingresa al if
            exito=true;//si se ingresa exito igual true
            for(int i=0;i<FilasV;i++){//Pasamos por fila de la matriz ventas
                if(ventas[i][3]==mes){//Si matriz mes es igual al mes ingresado por el usuario
                    for(int j=0;j<FilasP;j++){//Pasamos por fila de la matriz productos
                        if(ventas[i][0]==Iproduc[j][0]){//si codigo de vetnas es igual codigo de productos
                            for(int x=0;x<13;x++){//Pasamos por fila de la matriz catalogo
                                if(cata[x].equals(Sproduc[j][1])){//Si categoria es iguala a cateoria de producot
                                    auxiliar=0;//Axuliar igual 0 para que siempre se "resete" en teoria
                                    auxiliar=ventas[i][1]*Iproduc[j][1];//Multiplicamos cantidad de ventas por precio unitario de productos
                                    Precio[x]=Precio[x]+auxiliar;//se guarda ese valor auxiliar en la matriz de precio
                                }
                            }
                        }
                    }
                }
            }
        }else{
            StdOut.println("Mes ingresado esta fuera de rango");//Si mes esta fuera de rango imprimimos un aviso
            exito=false;//ADEMAS EXITO SE VUELVE FALSE porque no ingreso al if
        }
        if(exito==true){//Si exito es True significa que se ingreso el mes si estaba en rango y por ello se puede imprimir la matriz precio
            StdOut.println("Categoria" + " ---> " + "Precio");
            StdOut.println("---------" + " ---- " + "------");
            for(int i=0;i<13;i++){
                StdOut.println(cata[i] + " ---> " + Precio[i]);
            }
        }
    }
    
    public static void Opcion2(int mes,int FilasP,int FilasV,int ventas[][],int Iproduc[][],int dias[][]){
        /*
        Opcion2 representa la opcion RF2 de la aplicacion
        Esta opción le permite introducir un mes al usuario y visualizar en qué día se ha obtenido la mayor recaudación en dicho mes.
        */
        int auxiliar;//Variable auxiliar que guardara el precio de venta
        boolean exito;//Variable Boleano que permitira imprimir matriz de ventas por mes
        if(mes>=1 && mes<=12){//si el mes esta entre 1 y 12 entonces se ingresa al if
            exito=true;//si se ingresa exito igual true
            for(int i=0;i<FilasV;i++){//Pasamos por fila de la matriz ventas
                if(ventas[i][3]==mes){//Si matriz mes es igual al mes ingresado por el usuario
                    for(int j=0;j<FilasP;j++){//Pasamos por fila de la matriz productos
                        if(ventas[i][0]==Iproduc[j][0]){//si codigo de vetnas es igual codigo de productos
                            for(int x=0;x<31;x++){//Pasamos por fila de la matriz dias
                                if(dias[x][0]==ventas[i][2]){//Si dia de matriz dias es igual a dia de matriz ventas
                                    auxiliar=0;//Axuliar igual 0 para que siempre se "resete" en teoria
                                    auxiliar=ventas[i][1]*Iproduc[j][1];//Multiplicamos cantidad de ventas por precio unitario de productos
                                    dias[x][1]=dias[x][1]+auxiliar;//se guarda ese valor auxiliar en la matriz de dias
                                }
                            }
                        }
                    }
                }
            }
        }else{
            StdOut.println("El mes ingresado esta fuera de rango.");//Si el mes ingresado del usuario estaba fuera de rango imprimi esto
            exito=false;//Si estaba fuera de rango exito es false
        }
        if(exito==true){//Si exito es true
            int mayor=-99999;//Definimos variable mayor con numero muy chico
            for(int q=0;q<31;q++){
                if(dias[q][1]>mayor){//Si precio de un dia es mayor a la variable mayor, se reemplaza la variable mayor
                    mayor=dias[q][1];
                }
            }
            StdOut.println("--Mayor Recaudacion Del Mes "+ mes + "--");
            StdOut.println("--Dia--"+" "+"--Total--");
            for(int q=0;q<31;q++){//Imprimimos la matriz
                if(dias[q][1]==mayor){
                    StdOut.println("--"+dias[q][0]+"--"+" "+"--"+dias[q][1]+"--");
                }
            }
        }
    }
    
    public static void Opcion3(int FilasP,int FilasV,int ventas[][],int Iproduc[][], String Sproduc[][],String Cata[]) throws IOException{
        //El primer vector guarda la cantidad de dinero recaudado, el segundo la cantidad elementos vendidos
        int dinerox[]=new int[13];
        //Definimos archivodesalida
        ArchivoSalida salir=null;
        
        //dejamos a los 2 vectores con elementos 0 en sus espacios
        for(int i=0;i<13;i++){
            dinerox[i]=0;
        }
        for(int i=0;i<FilasV;i++){//pase por filas de ventanas
            for(int j=0;j<FilasP;j++){
                if(ventas[i][0]==Iproduc[j][0]){
                    int money = ventas[i][1]*Iproduc[j][1];//Variable igual a cantidad de producto vendido con precio unitario
                    for(int x=0;x<13;x++){
                        if(Cata[x].equals(Sproduc[j][1])){
                            dinerox[x]=dinerox[x]+money;//Dinero es igual dinemo mas money
                        }
                    }
                }
            }
        }
        salir = new ArchivoSalida("promedio.txt");//Creamos archivosalida promedio.txt
        for(int b=0;b<13;b++){
            Registro registrar = new Registro(2);//Creamos archivo de linea
            float promedio = (float)dinerox[b]/12;//Definimos variable de promedio
            registrar.agregarCampo(Cata[b]);//agregamos campo
            registrar.agregarCampo(promedio);//agregamos campo
            salir.writeRegistro(registrar);//Cerramos registro
        }
        StdOut.println("El archivo txt, ya a sido creado.");//Imprimios mensajes de creacion de txt
        salir.close();//Cerramos Archivos 
    }
    
    public static void Opcion4(int FilasP,int FilasV,int ventas[][],int Iproduc[][], String Sproduc[][],String Cata[]) throws IOException{
        //Vector que guardara el total de dinero recaudado
        int[] TotalD = new int[14];
        ArchivoSalida salir = null;
        //Dejamos todos los espacios de este vector con ceros
        for(int i=0;i<14;i++){
            TotalD[i]=0;
        }
        
        for(int i=0;i<FilasV;i++){
            for(int j=0;j<FilasP;j++){
                if(ventas[i][0]==Iproduc[j][0]){
                    int cantidad = ventas[i][1]*Iproduc[j][1];
                    for(int x=0;x<13;x++){
                        if(Cata[x].equals(Sproduc[j][1])){
                            TotalD[x]=TotalD[x]+cantidad;
                            TotalD[13]=TotalD[13]+cantidad;
                        }
                    }
                }
            }
        }
        salir = new ArchivoSalida("total_ventas.txt");//Definimos archivo de salida
        for(int a=0;a<14;a++){
            Registro Reg = new Registro(2);//Iniciamos registro
            Reg.agregarCampo(Cata[a]);//Agregamos el campo
            Reg.agregarCampo(TotalD[a]);//Agregamos el campo
            salir.writeRegistro(Reg);//Salimos de linea
        }
        StdOut.println("El archivo txt, ya a sido creado.");//Imprimimos informacion del archivo txt
        salir.close();//Cerrar achivo de salida
    }
    
    public static void main(String[] args) throws IOException{
        
        int Opcion = 0;//Opcion final de la aplicacion
        String Opcion2;//Opcion inicial de la aplicacion
        //vector que guarda a los catalogos con su dinero
        String Catalogo1[]=new String[13];
        int dinero1[]=new int[13];
        //vector que guarda los catalogos, y aÃ±ade un espacio que guara el total de ventas
        String Catalogo2[]=new String[14];
        //Matriz de dias (son 31 dias por mes)y dinero recaudado de ese dia
        int dias[][]=new int [31][2];
        Creaciondias(dias);
        //ESTAS 3 matrices son de los archivos Ventas y Productos
        int ventitas [][];
        String Sproduc [][];
        int Iproduc [][];

        //Contar filas de los archivos
        int FilasV=ContarVentas();
        int FilasP=ContarProductos();
        //CREAR Matrices correspondientes
        //Matrices de Ventas
        ventitas = new int[FilasV][4];
        //Matrices de Productos
        Sproduc=new String[FilasP][2];
        Iproduc=new int[FilasP][2];
        //Transferir Datos de Archivos a matrices
        //Transferir Ventas
        TransVentas(FilasV,ventitas);
        //Transferir Productos
        TransProductos(FilasP,Iproduc,Sproduc);
        //Creamos vector catalogo1(para RF1 y RF3) y catalogo2(para RF4)
        CreacionCatalogo1(Sproduc,Catalogo1,dinero1);
        CreacionCatalogo2(Sproduc,Catalogo2);
        
        //COMIENZO DE LA APLICACION INTERFAZ CON EL USUARIO
        
        Menu();//cargamos la funcion Menu
        Opcion2=StdIn.readString();//Realizamos input de opcion inicial en string
        try//Inciamos try
        {
            Opcion= Integer.valueOf(Opcion2);//Si opcion inicial de string puede pasar a un entero que opcion final tome este valor
        }
        catch(NumberFormatException e){//error formato ingresado
            StdOut.println("Porfavor ingrese NUMEROS ENTEROS!.");//Informa del error
        }
        
        while(Opcion!=5){//Si opcion es igual a 5 representa a RF5
            if(Opcion>=1 && Opcion<=4){//Si esta en el rango de 1 a 4 se ingresa corre la apliacion
                if(Opcion==1){//RF1
                    int mes = 0;//Variable mes final int
                    String mes1;//Variable mes incial string
                    StdOut.println("Ingrese el MES deseado: ");
                    StdOut.println("(Solo ingrese el numero del MES)");
                    StdOut.println("(Tome que Enero=1,Febrero=2 y asi hasta llegar a Diciembre=12)");
                    mes1=StdIn.readString();//Input de mes inicial
                    try
                    {
                        mes= Integer.valueOf(mes1);//Si mes inicial se puede transformar en entero que lo haga
                    }
                    catch(NumberFormatException e){//Error de formato
                        StdOut.println("Porfavor ingrese NUMEROS ENTEROS!.");//Informar de error
                    }
                    Opcion1(mes,FilasP,FilasV,ventitas,Iproduc,Sproduc,Catalogo1,dinero1); //iniciar funcion Opcion1
                    //Volvemos a resetar los vectores catalogo y dinero, porque si no se aculuma.                   
                    CreacionCatalogo1(Sproduc,Catalogo1,dinero1);
                }        
                if(Opcion==2){
                    int mes = 0;//Variable mes final int
                    String mes1;//Variable mes incial string
                    StdOut.println("Ingrese el MES deseado: ");
                    StdOut.println("(Solo ingrese el numero del MES)");
                    StdOut.println("(Tome que Enero=1,Febrero=2 y asi hasta llegar a Diciembre=12)");
                    mes1=StdIn.readString();//Input de mes inicial
                    try
                    {
                        mes= Integer.valueOf(mes1);//Si mes inicial se puede transformar en entero que lo haga
                    }
                    catch(NumberFormatException e){//Error de formato
                        StdOut.println("Porfavor ingrese NUMEROS ENTEROS!.");//Informar de error
                    }
                    Opcion2(mes,FilasP,FilasV,ventitas,Iproduc,dias);//Llamamos funcion Opcion2
                    //Volvemos a resetear la matriz de dias
                    Creaciondias(dias);
                }
                if(Opcion==3){
                    Opcion3(FilasP,FilasV,ventitas,Iproduc,Sproduc,Catalogo1);//Llamamos funcion Opcion3
                }
                if(Opcion==4){
                    Opcion4(FilasP,FilasV,ventitas,Iproduc,Sproduc,Catalogo2);//Llamamos funcion Opcion4
                }
            }else{
                //Esto ocurre si opcion esta fuera de rango
                StdOut.println("HA INGRESADO UNA OPCION, QUE ESTA FUERA DE RANGO!");
                StdOut.println("VUELVA A INGRESAR LA OPCION DESEADA!");
            }
            Menu();//cargamos la funcion Menu
            Opcion2=StdIn.readString();//Realizamos input de opcion inicial en string
            try//Inciamos try
            {
                Opcion= Integer.valueOf(Opcion2);//Si opcion inicial de string puede pasar a un entero que opcion final tome este valor
            }
            catch(NumberFormatException e){//error formato ingresado
                StdOut.println("Porfavor ingrese NUMEROS ENTEROS!.");//Informa del error
            }     
        
        
        }
        StdOut.println("-Programa Cerrado-");//Si opcion es 5 informamos que se cerror el programa.
        StdOut.println("Tenga un Buen Dia");// despedida con educacion :) 

    }
}