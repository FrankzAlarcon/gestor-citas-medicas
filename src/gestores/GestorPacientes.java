/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import principal.Paciente;
import persistencia.PacientePersistencia;

/**
 *
 * @author Frankz
 */
public class GestorPacientes {

    private Paciente paciente;

    public GestorPacientes() {
        this.paciente = new Paciente();
    }

    public Paciente obtenerPaciente(String cedula) {
        PacientePersistencia pacienteP = new PacientePersistencia();
        Paciente p = pacienteP.obtenerPaciente(cedula);
        if (p == null) {
            return null;
        }
        return p;
    }

    public String eliminarPaciente(String cedula) {
        PacientePersistencia pacienteP = new PacientePersistencia();
        Paciente p = pacienteP.obtenerPaciente(cedula);
        if (p == null) {
            return "El usuario con cédula " + cedula + " no existe.";
        }
        p.eliminar();
        return "Eliminado exitosamente.";
    }

}
