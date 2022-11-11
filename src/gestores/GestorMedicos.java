/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import persistencia.MedicosPersistencia;
import principal.Medico;

/**
 *
 * @author Frankz
 */
public class GestorMedicos {
    private Medico medico;
   
    
    public Medico obtenerPaciente(String cedula) {
        MedicosPersistencia medicoP = new MedicosPersistencia();
        Medico medico = medicoP.obtenerMedico(cedula);
        if (medico == null) {
            return null;            
        }
        return medico;
    }
}
