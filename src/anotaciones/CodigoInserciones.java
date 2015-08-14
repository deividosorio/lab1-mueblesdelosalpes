/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CodigoInserciones.java,v 1.1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Taller 1 - anotaciones
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package anotaciones;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * Clase encargada de contener el código de las inserciones
 * El nombre de cada método debe corresponder con el de la clase que representa
 */
public class CodigoInserciones
{

    /**
     * Método invocado en la insercion de código hecha a los métodos anotados con @Init
     * @param instance Instancia desde que se invoca este método
     * @param claseRepresentada Clase a la que representa el proxý que hizo la invocación del método
     * @param annotacion Informacion de la anotación hecha sobre el método que invoca a este
     * @param method Método que fua anotado con @Init
     */
    public static void Init(Object instance, Class claseRepresentada, Annotation annotacion, Method method) throws Exception {
        Init c = (Init) annotacion;
        for (Field f : claseRepresentada.getDeclaredFields()) {
            try {
                f.setAccessible(true);
                if (!f.isAnnotationPresent(NoInit.class)) {
                    if (f.getType().equals(Integer.TYPE)) {
                        f.set(instance, c.Integer());
                    } else if (f.getType().equals(Double.TYPE)) {
                        f.set(instance, c.Double());
                    } else if (f.getType().equals(Character.TYPE)) {
                        f.set(instance, c.Char());
                    } else if (f.getType().equals(String.class)) {
                        f.set(instance, c.String());
                    } else if (f.getType().equals(Boolean.TYPE)) {
                        f.set(instance, c.Boolean());
                    } else if (f.getType().equals(Float.TYPE)) {
                        f.set(instance, c.Float());
                    } else if (f.getType().equals(Long.TYPE)) {
                        f.set(instance, c.Long());
                    }
                }
            } 
            catch (Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
    }

    
    /**
     * Método invocado en la insercion de código hecha a los métodos anotados con @PostConstructor
     * @param instance Instancia desde que se invoca este método
     * @param claseRepresentada Clase a la que representa el proxý que hizo la invocación del método
     * @param annotacion Informacion de la anotación hecha sobre el método que invoca a este
     * @param method Método que fue anotado con @PostConstructor
     */
    public static void PostConstructor(Object instance, Class claseRepresentada, Annotation annotacion, Method method) throws Exception {
        
    }
    
    
       /**
     * Método invocado en la insercion de código hecha a los métodos anotados con @PostConstructor
     * @param instance Instancia desde que se invoca este método
     * @param claseRepresentada Clase a la que representa el proxý que hizo la invocación del método
     * @param annotacion Informacion de la anotación hecha sobre el método que invoca a este
     * @param method Método que fue anotado con @PostConstructor
     */
    public static void Log(Object instance, Class claseRepresentada, Annotation annotacion, Method method) throws Exception {
        File f = new File("./log.txt");
        Date fecha = new Date ();
        
        try {
            if (method.isAnnotationPresent(Log.class)) {
                //Si no Existe el fichero lo crea
                if (!f.exists()) {
                    f.createNewFile();
                }

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
                bw.write("--------");
                bw.newLine();
                bw.write("LOG");
                bw.newLine();
                bw.write("Fecha y hora:       " + fecha.toString());
                bw.newLine();
                bw.write("Nombre de la clase: " + claseRepresentada.getName());
                bw.newLine();
                bw.write("Metodo invocado:    " + method.getName());
                bw.newLine();
                bw.newLine();
                bw.flush();
                bw.close();

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    

}
