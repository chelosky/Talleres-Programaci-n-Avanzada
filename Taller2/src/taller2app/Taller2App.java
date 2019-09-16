package taller2app;
import java.io.IOException;
import ucn.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *Conjunto de operacion basicas que debe realizar la aplicacion del taller 2
 * @author Marcelo Lazo Chavez y Nicolas Hidalgo
 */
public class Taller2App {

    /**
     *
     * Contador de Filas por parametro de String. (ejemplo "Texto.txt")
     * 
     * 
     * @param a Representa la direccion de Archivo de texto que se desea leer.
     * @return devuelve entero que representa la cantidad total de filas del archivo leido
     * @throws IOException
     */
    public static int ContadorDeFilas(String a)throws IOException{
        ArchivoEntrada FileT = new ArchivoEntrada(a);
        int Contador=0;
        while(!FileT.isEndFile()){
            Registro reg = FileT.getRegistro();
            Contador++;
        }
        FileT.close();
        return Contador;
    }
    
    /**
     * OBS: LOS PASOS 1 A 5, se encargaran de realizar el proceso de transferir la informacion de archivos de textos.
     */
    
    /**
     *Paso 1: Se encargara de almacenar todas las tiendas en la lista tiendas
     * @param LT Representa la lista de tiendas totales
     * @param MCFC Representa la Maxima Cantidad Filas Clientes
     * @throws IOException
     */
    public static void Paso1(ListaTiendas LT, int MCFC)throws IOException{
        try (Scanner SC = new Scanner(new File("tiendas.txt"))) {
            while(SC.hasNextLine()){
                String linea = SC.nextLine();
                String[] tok = linea.split(";");
                int cod = Integer.parseInt(tok[0]);
                String Dir = tok[1];
                Tienda T = new Tienda(cod,Dir,MCFC);
                LT.AgregarTienda(T);
                }
            SC.close();
        }catch(Exception e){
            StdOut.println("Error En Archivo de Tiendas.txt");
        }
    }
    
    /**
     *Paso 2: Se encargar Agregar cada cliente en lista de clientes y asocia tienda-cliente.
     * @param LT Representa la lista de tiendas totales.
     * @param LC Representa la lista de clientes totales.
     * @param MCOC1 Representa la Maxima Cantidad de ordenes de compra
     * @throws IOException
     */
    public static void Paso2(ListaTiendas LT,ListaClientes LC, int MCOC1)throws IOException{
        try(Scanner SC = new Scanner(new File("clientes.txt"))){
            while(SC.hasNextLine()){
                String linea = SC.nextLine();
                String[] VEC = linea.split(";");
                String rut = VEC[0];
                String name = VEC[1];
                String apellido = VEC[2];
                String sexo = VEC[3];
                int telefono = Integer.parseInt(VEC[4]);
                String email = VEC[5];
                int Cod = Integer.parseInt(VEC[6]);
                Clientes C = new Clientes(rut,name,apellido,sexo,telefono,email,MCOC1);
                LC.AgregarCliente(C);
                for(int i=0;i<LT.getCantidadTiendas();i++){
                    if(Cod==LT.getTiendaEspecifica(i).getcodTienda()){
                        C.setTienda(LT.getTiendaEspecifica(i));
                        LT.getTiendaEspecifica(i).getLC().AgregarCliente(C);
                    }
                }
            }
            SC.close();
        }catch(FileNotFoundException | NumberFormatException e){
            StdOut.println("Error archivo clientes.txt");
        }
    }
    
    /**
     *Paso3: Se encarga de almacenar los productos en la lista de productos totales
     * @param LP Representa la lista de productos totales
     * @param MCFP Representa la Maxima Cantidad de Filas Productos
     */
    public static void Paso3(ListaProductos LP,int MCFP){
        try(Scanner SC = new Scanner(new File("productos.txt"))){
            while(SC.hasNextLine()){
                String linea = SC.nextLine();
                String[] UCN = linea.split(";");
                String CodP = UCN[0];
                String nombreP = UCN[1];
                int precioP = Integer.parseInt(UCN[2]);
                String platafP = UCN[3];
                Producto P = new Producto(CodP,nombreP,precioP,platafP);
                LP.AgregarProducto(P);
            }
            SC.close();
        }catch(Exception e){
            StdOut.println("Error archivo productos.txt");
        }
    }    
    
    /**
     *Paso 4 : Se encargar de asociar Cliente-OrdenCompra y almacenar cada orden de compra en la lista de orden compra total
     * @param LC Representa la lista de clientes totales
     * @param LOC Representa la lista de Ordenes de compra totales
     * @param MCOC2 Representa al Maximo Cantidad filas Orden de compra 2 (En esta caso se refiere a total de lista productos)
     */
    public static void Paso4(ListaClientes LC, ListaOrdenCompra LOC, int MCOC2){
        try(Scanner SC = new Scanner(new File("orden_compra.txt"))){
            while(SC.hasNextLine()){
                String linea = SC.nextLine();
                String[] Vacio1 = linea.split(";");
                int CodOrd = Integer.parseInt(Vacio1[0]);
                String rut = Vacio1[1];
                String[] FechaG = Vacio1[2].split(" ");
                String[] Fecha1 = FechaG[0].split("/");
                int dia = Integer.parseInt(Fecha1[0]);
                int mes = Integer.parseInt(Fecha1[1]);
                int año = Integer.parseInt(Fecha1[2]);
                String[] Fecha2 = FechaG[1].split(":");
                int hora = Integer.parseInt(Fecha2[0]);
                int min = Integer.parseInt(Fecha2[1]);
                int seg = Integer.parseInt(Fecha2[2]);
                OrdenCompra OC = new OrdenCompra(CodOrd,dia,mes,año,hora,min,seg,MCOC2);
                LOC.AgregarOrden(OC);
                for(int i=0;i<LC.getCantidadClientes();i++){
                    if(rut.equals(LC.getClienteEspecifico(i).getRut())){
                        OC.setCliente(LC.getClienteEspecifico(i));
                        LC.getClienteEspecifico(i).getLO().AgregarOrden(OC);
                    }
                }
                
            }
            SC.close();
        }catch(Exception e){
            StdOut.println("Error archivo orden_compra.txt");
        }
    }
    
    /**
     * Paso 5: Este paso se encargara de almacenar y asociar Ordecompra-OrdencompraProductos
     * @param LOC Representa a la Lista de orden de compra total
     * @param LP Representa a la lista de productos
     * @throws IOException
     */
    public static void Paso5(ListaOrdenCompra LOC, ListaProductos LP)throws IOException{
        try(Scanner SC = new Scanner(new File("orden_compra_productos.txt"))){
            while(SC.hasNextLine()){
                String linea = SC.nextLine();
                String[] tuk = linea.split(";");
                int codO = Integer.parseInt(tuk[0]);
                String codP = tuk[1];
                int cantP = Integer.parseInt(tuk[2]);
                for(int i=0;i<LOC.getCantidadOrden();i++){
                    if(codO==LOC.getOrdenEspecifica(i).getNumOrden()){
                        for(int j=0;j<LP.getCantidadProductos();j++){
                            if(codP.equals(LP.getProductoEspecifico(j).getCodProducto())){
                                LP.getProductoEspecifico(j).setCantidad(cantP);
                                LP.getProductoEspecifico(j).setPFinal(LP.getProductoEspecifico(j).getCantidad(),LP.getProductoEspecifico(j).getPrecio());
                                Producto P = LP.getProductoEspecifico(j);
                                LOC.getOrdenEspecifica(i).getLP().AgregarProducto(P);
                            }
                        }
                    }
                }
            }
            SC.close();
        }catch(Exception e){
            StdOut.println("Error archivo orden_compra_productos.txt");
        }
    }
    
    /**
     *RF1 = Hace referencia a la primera operacion del taller2.
     * Dado un mes (Número entre 1 - 12) que se ingresa por pantalla, se debe mostrar por consola: 
     * El código de la tienda, la ubicación de la tienda y el ingreso obtenido en dicho mes.
     * La información de la tienda que debe mostrarse, es para aquella que ha obtenido el mayor ingreso
     * en el mes ingresado.
     * Restricciones:
     *              pre:
     *                  Mes ingresado debe estar entre 1 a 12.
     * @param N Representa el mes ingresado por consola al usuario
     * @param LC Representa a la lista de clientes totales
     * @param LOC Representa a la lista de orden de compra totales
     * @param LT Representa a la lista de tiendas totales
     * @param LP Representa a la lista de productos totales
     */
    public static void RF1(int N,ListaClientes LC,ListaOrdenCompra LOC,ListaTiendas LT, ListaProductos LP){
        int mayor=-999999;
        int total = 0;
        String Direccion = " ";
        int codT = 0;
        boolean exito;
        if(N>=1 && N<=12){
            exito=true;
            for(int i=0;i<LT.getCantidadTiendas();i++){
                for(int w=0;w<LT.getTiendaEspecifica(i).getLC().getCantidadClientes();w++){
                    for(int s=0;s<LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getCantidadOrden();s++){
                        if(LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(s).getFechaOrden().getMes()==N){
                            for(int r=0;r<LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(s).getLP().getCantidadProductos();r++){
                                total=total + LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(s).getLP().getProductoEspecifico(r).getPFinal();
                            }
                        }
                    }
                }
                if(total>mayor){
                    mayor = total;
                    Direccion = LT.getTiendaEspecifica(i).getdireccion();
                    codT = LT.getTiendaEspecifica(i).getcodTienda();
                }
                total=0;
            }
        }else{
            StdOut.println("El mes ingresado esta fuera de rango.");
            exito=false;
        }
        if(exito==true){
            StdOut.println("--------------------------------------------");
            StdOut.println("Codigo de tienda: "+codT);
            StdOut.println("Direccion de tienda: "+ Direccion);
            StdOut.println("Total ingreso en mes "+N+" es de: $"+ mayor);
            StdOut.println("--------------------------------------------");
        }
    }
    
    /**
     * RF2 = Hace referencia a la segunda operacion del taller2.
     * Dado un código de tienda ingresado por pantalla, se debe mostrar la información de todas las órdenes
     * de compra generadas por mujeres de dicha tienda, siempre y cuando la clienta haya generado
     * al menos 3 órdenes de compra. Lo que se debe mostrar de la orden de compra es el número de la orden,
     * el rut, nombre y apellido del cliente, además una lista enumerada de los productos asociados
     * a la orden de compra, indicando el código de producto, nombre y cantidad. Se debe indicar si la tienda
     * no cumple con la condición ya mencionada.
     * Restricciones:
     *              pre:
     *                  El codigo ingresado por el usuario pertenesca a lo menos a alguna tienda.
     * @param N Representa al codigo de la tienda ingresado por pantalla por el usuario 
     * @param LC Representa a la lista de clientes totales
     * @param LOC Representa a la lista de orden de compra totales
     * @param LT Representa a la lista de tiendas totales
     * @param LP Representa a la lista de productos totales
     */
    public static void RF2(int N,ListaClientes LC,ListaOrdenCompra LOC,ListaTiendas LT, ListaProductos LP){
        if(N>=1 && N<=21){
            int exito1=0,exito2=0;
            for(int i=0;i<3/*LT.getCantidadTiendas()*/;i++){
                if(LT.getTiendaEspecifica(i).getcodTienda()==N){
                    for(int w=0;w<LT.getTiendaEspecifica(i).getLC().getCantidadClientes();w++){
                        if(LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getSexo().equals("Femenino")){
                            exito1=exito1 + 1;
                            if(LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getCantidadOrden()>=3){
                                exito2=exito2 + 1;
                                StdOut.println("Rut Cliente: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getRut());
                                StdOut.println("Nombre Cliente: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getNombre());
                                StdOut.println("Apellido Cliente: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getApellido());
                                for(int e=0;e<LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getCantidadOrden();e++){
                                    StdOut.println("Codigo de Orden: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(e).getNumOrden());
                                    StdOut.println("---------LISTA PRODUCTOS----------");
                                    for(int t=0;t<LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(e).getLP().getCantidadProductos();t++){
                                        int p=t+1;
                                        StdOut.println( p + " Codigo Producto: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(e).getLP().getProductoEspecifico(t).getCodProducto());
                                        StdOut.println("-- Nombre Producto: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(e).getLP().getProductoEspecifico(t).getNombre());
                                        StdOut.println("-- Cantidad Vendida: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(w).getLO().getOrdenEspecifica(e).getLP().getProductoEspecifico(t).getCantidad());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(exito1==0){
                StdOut.println("No hay clientes femeninos, en la tienda.");
            }else{
                if(exito2==0){
                    StdOut.println("Hay clientes femeninos, pero ninguno cumple el requisito de 3 ordenes de compra.");
                }
            }
        }else{
            StdOut.println("El codigo ingresado no pertenece a ninguna tienda.");
        }
    }
    
    /**
     * RF3 = Hace referencia a la tercera operacion del taller2.
     * Para cada tienda, se debe mostrar su código, ubicación y una lista enumerada de todos
     * los clientes que han generado alguna orden de compra después de las 18:30 hrs. De los
     * clientes se debe mostrar el RUT, nombre, apellido, teléfono y mail.
     * @param LC Representa a la lista de clientes totales
     * @param LOC Representa a la lista de orden de compra totales
     * @param LT Representa a la lista de tiendas totales
     * @param LP Representa a la lista de productos totales
     */
    public static void RF3(ListaClientes LC,ListaOrdenCompra LOC,ListaTiendas LT, ListaProductos LP){
        for(int i=0;i<LT.getCantidadTiendas();i++){
            StdOut.println("Codigo Tienda: "+ LT.getTiendaEspecifica(i).getcodTienda());
            StdOut.println("Direccion Tienda: "+ LT.getTiendaEspecifica(i).getdireccion());
            int Cumple=0;
            for(int j=0;j<LT.getTiendaEspecifica(i).getLC().getCantidadClientes();j++){
                for(int k=0;k<LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getLO().getCantidadOrden();k++){
                    if(LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getLO().getOrdenEspecifica(k).getFechaOrden().getHora()>18 && LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getLO().getOrdenEspecifica(k).getFechaOrden().getMinutos()>30){
                        Cumple++;
                        StdOut.println("-----DATOS CLIENTE-----");
                        StdOut.println("Rut Cliente: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getRut());
                        StdOut.println("Nombre Cliente: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getNombre());
                        StdOut.println("Apellido Cliente: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getApellido());
                        StdOut.println("Telefono Cliente: "+ LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getTelefono());
                        StdOut.println("Email Cliente: "+LT.getTiendaEspecifica(i).getLC().getClienteEspecifico(j).getEmail());
                    }
                }
            }
            if(Cumple==0){
                    StdOut.println("TIENDA NO CUMPLE CONDICION.");
                }
        }
    }
    
    public static void main(String[] args) throws IOException {
        int MCFT = ContadorDeFilas("tiendas.txt");       
        int MCFC = ContadorDeFilas("clientes.txt");
        int MCOC1 = ContadorDeFilas("orden_compra.txt");
        int MCOC2 = ContadorDeFilas("orden_compra_productos.txt");
        int MCFP = ContadorDeFilas("productos.txt");
        ListaTiendas LT = new ListaTiendas(MCFT);
        ListaClientes LC = new ListaClientes(MCFC);
        ListaOrdenCompra LOC = new ListaOrdenCompra(MCOC1);
        ListaProductos LOCP = new ListaProductos(MCOC2);
        try{
            Paso1(LT,MCFC);
            Paso2(LT,LC,MCOC1);
            Paso3(LOCP,MCFP);
            Paso4(LC,LOC,MCOC2);
            Paso5(LOC,LOCP);
            StdOut.println("---------------------RF1--------------------");
            StdOut.println("--------------INGRESE EL MES----------------");
            StdOut.println("------------(Ingrese del 1 al 12)-----------");
            int MES = StdIn.readInt();
            RF1(MES, LC, LOC, LT, LOCP);
            StdOut.println("---------------------RF2--------------------");
            StdOut.println("------------INGRESE COD DE TIENDA-----------");
            StdOut.println("-------------(Ingrese del 1 al 21)----------");
            int COD = StdIn.readInt();
            RF2(COD, LC, LOC, LT, LOCP);
            StdOut.println("--------------------------------------------");
            StdOut.println("---------------------RF3--------------------");
            StdOut.println("--------------------------------------------");
            RF3(LC, LOC, LT, LOCP);
        }catch(Exception e){
            StdOut.println("ERROR en la funcion principal.(Recuerde!, Solo ingresar Numeros Enteros)");
    }
}
}    

