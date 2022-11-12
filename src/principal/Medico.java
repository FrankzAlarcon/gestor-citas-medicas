/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gestores.GestorCitasMedicas;
import persistencia.MedicosPersistencia;

/**
 *
 * @author Frankz
 */
public class Medico {
    private String cedula;
    private String nombre;
    //private String nombreUsuario;
    private int edad;
    private String correoElectronico;
    private String contrasenia;
    
    private MedicosPersistencia medicoPersistencia;
    private GestorCitasMedicas gestorCitas;

    public Medico(String cedula, String nombre, int edad, String correoElectronico, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;        
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.medicoPersistencia = new MedicosPersistencia();
    }
    /*public Medico(String cedula, String nombre, String nombreUsuario, int edad, String correoElectronico, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.medicoPersistencia = new MedicosPersistencia();
    }*/
    
    public void registrar() {
        this.medicoPersistencia.registrarMedico(this);
    }
    public void eliminar() {
        this.medicoPersistencia.eliminarMedico(this);
    }

    public void accederGestorCitasMedicas(){
        this.gestorCitas = new GestorCitasMedicas();
    }

    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    @Override
    public String toString() {
        return cedula + "," + nombre + "," + edad + "," + correoElectronico + "," + contrasenia;
    }
    
    
    
    
}
