/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.ArrayList;
import persistencia.CitasPersistencia;
import principal.Cita;

/**
 *
 * @author Frankz
 */
public class GestorCitasMedicas {
    
    public ArrayList<Cita> obtenerTodasLasCitas() {
        CitasPersistencia citaP = new CitasPersistencia();
        return citaP.obtenerTodasLasCitas();
    }

    public Cita obtenerCita(String idCita) {
        CitasPersistencia citaP = new CitasPersistencia();
        Cita cita = citaP.obtenerCita(idCita);
        if (cita == null) {
            return null;
        }
        return cita;
    }

    public String eliminarCita(String idCita) {
        CitasPersistencia citaP = new CitasPersistencia();
        Cita cita = citaP.obtenerCita(idCita);
        if (cita == null) {
            return "El medico con cédula " + idCita + " no existe.";
        }
        System.out.println(cita.toString());
        cita.cancelar();
        return "Eliminado exitosamente.";
    }
}
