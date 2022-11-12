/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import persistencia.PacientePersistencia;

/**
 *
 * @author Frankz
 */
public class Paciente {
    private String cedula;
    private String nombre;
    private int edad;
    private int numHistoriaClinica;
    private String correoElectronico;
    private PacientePersistencia pacientePersistencia;
    
    public Paciente() {
        this.pacientePersistencia = new PacientePersistencia();
    }

    public Paciente(String cedula, String nombre, int edad, int numHistoriaClinica, String correoElectronico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.numHistoriaClinica = numHistoriaClinica;
        this.correoElectronico = correoElectronico;
        this.pacientePersistencia = new PacientePersistencia();
    }
        
    
    public void registrar() {
        this.pacientePersistencia.registrarPaciente(this);
    }
    
    public void eliminar() {
        this.pacientePersistencia.eliminarPaciente(this);
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

    public int getNumHistoriaClinica() {
        return numHistoriaClinica;
    }

    public void setNumHistoriaClinica(int numHistoriaClinica) {
        this.numHistoriaClinica = numHistoriaClinica;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    
    @Override
    public String toString() {
        return cedula + "," + nombre + "," + edad + "," + correoElectronico;
    }
    
    
    
    
    
    
}
