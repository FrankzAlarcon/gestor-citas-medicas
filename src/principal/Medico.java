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
    
    public void registrar() {
        this.medicoPersistencia.registrarMedico(this);
    }

    @Override
    public String toString() {
        return cedula + "," + nombre + "," + edad + "," + correoElectronico + "," + contrasenia;
    }
    
    
    
    
}
