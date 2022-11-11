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
    private String correoElectronico;
    private PacientePersistencia pacientePersistencia;
    
    public Paciente() {
        this.pacientePersistencia = new PacientePersistencia();
    }

    public Paciente(String cedula, String nombre, int edad, String correoElectronico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.pacientePersistencia = new PacientePersistencia();
    }
        
    
    public void registrar() {
        this.pacientePersistencia.registrarPaciente(this);
    }

    @Override
    public String toString() {
        return cedula + "," + nombre + "," + edad + "," + correoElectronico;
    }
    
    
    
    
    
    
}
