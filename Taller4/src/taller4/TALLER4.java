/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;
import java.util.Scanner;
import ucn.*;
/**
 * @author MARCELO LAZO && NICOLAS HIDALDO
 */
public class TALLER4 {

    /**
     *
     * COMANDO: cd .. Cambia de directorio (carpeta) hacía la carpeta padre.
     * 
     * @param actual Directorio actual de la aplicacion.
     * @return Devuelve el directorio de la carpeta padre del directorio actual.
     */
    public static Carpeta VolverAPadre(Carpeta actual){
        if(actual.getPadre()==null){
            actual = actual;
            StdOut.println(">>>No se pude acceder a la carpeta padre de la raiz. dah~~");
        }else{
            actual = actual.getPadre();
            StdOut.println(">>>Cambio de directorio a '"+ actual.getNombre() +"'");
        }
        return actual;
    }
    
    /**
     *
     * COMANDO: cd nomContenedor Cambia de directorio a la carpeta contenida en la carpeta 
     * actual (de nombre ‘nomContenedor’).Si es una secuencia de enlaces (enlaces a otros enlaces),
     * donde el último enlace tiene referencia a una carpeta, entonces también cambiará directorio a
     * dicha carpeta.
     * 
     * @param actual Directorio actual de la aplicacion.
     * @param nombre Nombre del contenedor con el cual se cambiara el directorio.
     * @return Devuelve el directorio de la variable asiganada del directorio actual.
     */
    public static Carpeta CambioDeDir(Carpeta actual,String nombre){
        if(actual.getLC().Buscar(nombre)!=null){
            Contenedor temporal = actual.getLC().Buscar(nombre);
            if(temporal instanceof Carpeta){
                Carpeta carpetatemporal = (Carpeta)temporal;
                actual = carpetatemporal;
                StdOut.println(">>>Cambio de directorio a 'nombre'");
            }
            if(temporal instanceof Archivo){
                StdOut.println("Nombre del contenedor es un archivo, devuelta a carpeta raiz.");
                actual = TALLER4.VolverRoot(actual);
            }
            if(temporal instanceof Enlace){
                temporal = ((Enlace)temporal).getRefCon();
                while(temporal instanceof Enlace){
                    temporal = ((Enlace)temporal).getRefCon();
                }
                if(temporal instanceof Carpeta){
                    Carpeta carpetatemporal = (Carpeta)temporal;
                    actual = carpetatemporal;
                    StdOut.println(">>>Cambio de directorio a '"+ actual.getNombre() +"'");
                }else{
                    StdOut.println("Nombre del contenedor no es un directorio, devuelta a carpeta raiz.");
                    actual = TALLER4.VolverRoot(actual);
                }
                
            }
            return actual;
        }else{
            actual = actual;
            StdOut.println("No existe una contenedor con el nombre de "+nombre+".");
            return actual;
        }
    }
    
    /**
     *
     * COMANDO: cd / Cambia de directorio a la carpeta “root”, independiente de cuál es la carpeta actual.
     * 
     * @param actual Directorio actual de la aplicacion.
     * @return Devuelve directorio raiz.
     */
    public static Carpeta VolverRoot(Carpeta actual){
        while(actual.getPadre()!=null){
            actual = actual.getPadre();            
        }
        StdOut.println(">>>Cambio de directorio a '"+ actual.getNombre() +"'");
        return actual;
    }
    
    /**
     * COMANDO: ls Muestra un listado detallado de los contenedores que posee la carpeta actual.
     * Esto es: código, nombre y tipo.Tipo: Si es carpeta DIR, si es archivo FILE y si es enlace LINK.
     * En el caso del nombre de un enlace, debe aparecer también en paréntesis y concatenado con el nombre,
     * el código de a qué contenedor hace referencia, y NULL si no enlaza con ninguno.
     * @param actual Directorio actual de la aplicacion.
     */
    public static void DesplegarContenedores(Carpeta actual){
        NodoContenedor current = actual.getLC().getFirst();
        StdOut.println("Código      Nombre      Tipo");
        StdOut.println("------      ------      ----");
        while(current!=null){
            Contenedor nuevo = current.getContenedor();
            String tipo = "";
            String nombre = "";
            int codigo = 0;
            if(nuevo instanceof Carpeta){
                tipo = "DIR";
                nombre = nuevo.getNombre();
                codigo = nuevo.getCodigo();
            }
            if(nuevo instanceof Archivo){
                tipo = "FILE";
                nombre = nuevo.getNombre() +"."+ ((Archivo) nuevo).getExtension();
                codigo = nuevo.getCodigo();
            }
            if(nuevo instanceof Enlace){
                if(((Enlace) nuevo).getRefCon()==null){
                    nombre = nuevo.getNombre();
                    tipo = "LINK";
                }else{
                    nombre = nuevo.getNombre()+"("+ ((Enlace) nuevo).getRefCon().getCodigo() +")";
                    tipo = "LINK        (Enlazado con "+((Enlace)nuevo).getRefCon().getNombre()+")";
                
                }
                codigo = nuevo.getCodigo();
            }
            StdOut.println(codigo+"          "+nombre+"        "+tipo);
            current = current.getNext();
        }
    }
    //rm nombrecontenedor

    /**
     *
     * COMANDO: rm nomContenedor Elimina el contenedor que está incluido en la lista de contenedores 
     * de la carpeta actual, con nombre ‘nomContenedor’. Al borrar uno, debe considerar que los enlaces
     * ya no estarán enlazados con el contenedor (si es que hay alguno). Ahora estarán enlazados a NULL
     * 
     * @param actual Directorio actual de la aplicacion.
     * @param nombre Nombre del contenedor el cual sera borrado del directorio.
     */
    public static void eliminarcontenedor(Carpeta actual, String nombre){
        
        boolean exito = actual.getLC().delete(nombre);
        if(exito){
            StdOut.println(">>>Resultado Exitoso, el contenedor '"+nombre+"' ha sido eliminado.");
            NodoContenedor current = actual.getLC().getFirst();
            while(current!=null){
                if(current.getContenedor() instanceof Enlace){
                    if(((Enlace)current.getContenedor()).getRefCon().getNombre().equals(nombre)){
                        ((Enlace)current.getContenedor()).setRefCon(null);
                    }
                }
                current=current.getNext();
            }
        }else{
            StdOut.println(">>>Resultado Fallido, el contenedor '"+nombre+"' no existe.");
        }
    }
    
    /**
     *
     * Funcion que se utiliza meramente, para comprobar si ya existe un contenedor con un nombre predeterminado
     * 
     * @param actual Directorio actual de la aplicacion.
     * @param nombre Nombre del contenedor del cual se quiere comprobar si existe.
     * @return true si existe y false si no existe.
     */
    public static boolean ExisteContenedor(Carpeta actual,String nombre){
        NodoContenedor current = actual.getLC().getFirst();
        while(current!=null && !current.getContenedor().getNombre().equals(nombre)){
            current = current.getNext();
        }
        if(current==null){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     *
     * COMANDO: ln nomEnlace nomContenedor Crea un enlace de nombre ‘nomEnlace’, y lo enlaza con el contenedor 
     * (contenido en la carpeta actual) de nombre ‘nomContenedor’. Si no hay ningún contenedor con ese nombre,
     * el enlace se crea, pero no enlazará a nadie (NULL).
     * 
     * @param actual Directorio actual de la aplicacion.
     * @param nombre Nombre del enlace
     * @param enlazar Nombre del contenedor que esta enlazado con el enlace
     */
    public static void CrearEnlace(Carpeta actual,String nombre,String enlazar){
        if(!TALLER4.ExisteContenedor(actual, nombre)){
            String date = enlazar;
            Contenedor current = actual.getLC().Buscar(date);
            Enlace nuevo = new Enlace(nombre);
            nuevo.setRefCon(current);
            actual.getLC().insertarUltimo((Contenedor)nuevo); 
            StdOut.println(">>>Enlace creado.");
        }else{
            StdOut.println(">>>YA EXISTE ALGUN CONTENEDOR CON ESE NOMBRE.");
        }
        
    }
    
    /**
     *
     * COMANDO touch nomArchivo.extension Crea un archivo dentro de la carpeta actual de nombre ‘nomArchivo’
     * y de extensión ‘extension’.
     * 
     * @param actual Directorio actual de la aplicacion.
     * @param nombre Nombre del archivo
     * @param extend Nombre de la extension del archivo.
     */
    public static void CrearArchivo(Carpeta actual,String nombre,String extend){
        if(!TALLER4.ExisteContenedor(actual, nombre)){
            Archivo nuevo = new Archivo(nombre);
            nuevo.setExtension(extend);
            actual.getLC().insertarUltimo((Contenedor)nuevo);
            StdOut.println(">>>Archivo Creado.");
        }else{
            StdOut.println(">>>YA EXISTE ALGUN CONTENEDOR CON ESE NOMBRE.");
        }
    }
    
    /**
     *
     * COMANDO: mkdir nomCarpeta Crea una carpeta llamada ‘nomCarpeta’, dentro del directorio actual.
     * 
     * @param actual Directorio actual de la aplicacion.
     * @param nombre Nombre de la carpeta
     */
    public static void CrearCarpeta(Carpeta actual,String nombre){
        if(!TALLER4.ExisteContenedor(actual, nombre)){
            Carpeta nuevo = new Carpeta(nombre);
            nuevo.setPadre(actual);
            actual.getLC().insertarUltimo((Contenedor)nuevo);
            StdOut.println("Carpeta '"+nombre+"' creada.");
        }else{
            StdOut.println(">>>YA EXISTE ALGUN CONTENEDOR CON ESE NOMBRE.");
        }
    }
    
    /**
     *
     * COMANDO: mv nomCon nuevoNomCon Cambia el nombre del contenedor de nombre ‘nomCon’ al nombre ‘nuevoNomCom’
     * 
     * @param actual Directorio actual de la aplicacion.
     * @param nombre Nombre del contenedor al cual se le quiere cambiar el nombre.
     * @param nuevo Nombre que se le pondra al contenedor.
     */
    public static void CambiaNombreContenedor(Carpeta actual,String nombre,String nuevo){
        if(actual.getLC().Buscar(nombre)!=null){
            actual.getLC().Buscar(nombre).setNombre(nuevo);
            StdOut.println("El contenedor a cambiado de nombre a "+ actual.getLC().Buscar(nombre).getNombre());
        }else{
            StdOut.println("No existe un contenedor con ese nombre.");
        }
    }
    
    /**
     *
     * COMANDO : help Muestra una lista de todos los comandos disponibles y una descripción para cada uno de ellos.
     * 
     */
    public static void help(){
        StdOut.println("cd nomCarpeta                           Cambia directorio a carpeta de nombre 'nomCarpeta'");
        StdOut.println("cd ..                                   Cambia directorio a carpeta 'padre'");
        StdOut.println("cd /                                    Cambia directorio a carpeta 'root");
        StdOut.println("ls                                      Muestra lista de contenedores de la carpeta actual");
        StdOut.println("rm nomContenedor                        Elimina el contenedor de nombre 'nomContenedor' de la carpeta actual");
        StdOut.println("ln nomEnlace nomContenedo               Crea un enlace de nombre 'nomEnlace' hacia el contenedor de nombre 'nomContenedor'");
        StdOut.println("mkdir nomCarpeta                        Crea un directorio de nombre 'nomCarpeta'");
        StdOut.println("touch nomArchivo.extension              Crea un archivo de nombre 'nomArchivo' y extension 'extension'");
        StdOut.println("help                                    Muestra la lista de comandos y su descripción");
        StdOut.println("exit                                    Finalizacion la consola");
    }
    
    /**
     *
     * Funcion que se encargar de concatenar la direccion actual con las de sus padres, hasta la raiz.
     * 
     * @param actual Directorio actual de la aplicacion.
     * @return Devuelve la ruta actual de la direccion como un string
     */
    public static String ruta(Carpeta actual){
        String nombre = "";
        while(actual!=null){
            nombre = actual.getNombre()+"/"+ nombre;
            actual = actual.getPadre();
        }
        return nombre;
    }
    
//    public static
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carpeta root = new Carpeta("root");
        root.setPadre(null);
        Carpeta actual = root;
        StdOut.println("Consola");
        StdOut.println("-------");
        StdOut.println("> Para más ayuda, escriba: help");
        StdOut.print("> "+actual.getNombre()+"/: ");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();
        while(!opcion.equals("exit")){
            String[] verificar = opcion.split(" ");
            if(verificar[0].equals("cd")){
                if(verificar[1].equals("..")){
                    actual =TALLER4.VolverAPadre(actual);
                }else{
                    if(verificar[1].equals("/")){
                        actual = TALLER4.VolverRoot(actual);
                    }else{
                        actual = TALLER4.CambioDeDir(actual, verificar[1]);
                    }
                }
            }
            if(verificar[0].equals("ls")){
                TALLER4.DesplegarContenedores(actual);
            }
            if(verificar[0].equals("rm")){
                TALLER4.eliminarcontenedor(actual, verificar[1]);
            }
            if(verificar[0].equals("ln")){
                TALLER4.CrearEnlace(actual, verificar[1], verificar[2]);
            }
            if(verificar[0].equals("touch")){
                String[] separa = verificar[1].split("\\.");
                TALLER4.CrearArchivo(actual, separa[0], separa[1]);
            }
            if(verificar[0].equals("mkdir")){
                TALLER4.CrearCarpeta(actual, verificar[1]);
            }
            if(verificar[0].equals("mv")){
                TALLER4.CambiaNombreContenedor(actual, verificar[1], verificar[2]);
            }
            if(opcion.equals("help")){
                TALLER4.help();
            }
            if(!opcion.equals("help") && !verificar[0].equals("mv") && !verificar[0].equals("mkdir") && !verificar[0].equals("touch")
                    && !verificar[0].equals("ln") && !verificar[0].equals("rm") && !verificar[0].equals("ls")
                    && !verificar[0].equals("cd")){
                StdOut.println(">>>COMANDO INGRESADO NO VALIDO. Escriba help, para ayuda.");
            }
            StdOut.print("> "+TALLER4.ruta(actual)+": ");
            //StdOut.print("> "+actual.getNombre()+"/: ");
            opcion = sc.nextLine();
        }
        StdOut.println("> Fin aplicación.");
        StdOut.println("> Ten un buen dia.");
        //StdOut.println("> Adios trunks del futuro, jamas te olvidaremos :c.");
        
    }
    
}
