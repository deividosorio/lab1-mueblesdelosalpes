/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Vendedor.java,v 1.1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Taller 1 - anotaciones
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

import anotaciones.Init;
import anotaciones.NoInit;
import anotaciones.PostConstructor;

/**
 * Entidad que representa a un vendedor de MLA
 */
@Init(String="-- Vacio --")
public class Vendedor
{

    /**
     * Id del vendedor. Tiene que ser único.
     */
    private int id;

    /**
     * Nombres del vendedor.
     */
    private String nombres;

    /**
     * Apellidos del vendedor
     */
    private String apellidos;

    /**
     * Sexo del vendedor
     */
    private String sexo;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    
    @PostConstructor
    public void validar(){
        if(this.getNombres().equalsIgnoreCase("-- Vacio --")){
            System.out.println("Los nombres no pueden ser vacio");
        }
        if(this.getApellidos().equalsIgnoreCase("-- Vacio --")){
            System.out.println("Los apellidos no pueden ser vacio");
        }
        if(this.getSexo().equalsIgnoreCase("-- Vacio --")){
            System.out.println("El sexo no puede ser vacio");
        }
    }
}
