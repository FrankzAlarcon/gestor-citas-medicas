/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gestores.GestorMedicos;
import persistencia.PacientePersistencia;
import gestores.GestorPacientes;

/**
 *
 * @author Frankz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ---  PROBADO PACIENTES - OBTENER POR CEDULA Y REGISTRAR EN TXT  ---
        // Registra un paciente
        //Paciente p = new Paciente("2209876543", "Frankz Alarcon", 20, "frankz@correo.com");
        //Paciente p = new Paciente("1234567891", "Lenin Alarcon", 20, "lenin@correo.com");
        //p.registrar();
        
        /*GestorPacientes gestorPacientes = new GestorPacientes();
        Paciente p = gestorPacientes.obtenerPaciente("1234567891");
        if (p == null) {
            System.out.println("No existe ese paciente");
            return;
        }
        System.out.println(p.toString());*/
                
        // ---  PROBADO MEDICOS - OBTENER POR CEDULA Y REGISTRAR EN TXT  ---
        // Registra un medico
        //Medico medico = new Medico("123456789", "Glender Miranda", 40, "glender@correo.com", "123456");
        //Medico medico = new Medico("0987654321", "Wellinton Peralta", 25, "wellinton@correo.com", "123456");
        
        //medico.registrar();
        
        /*GestorMedicos gestorPacientes = new GestorMedicos();
        Medico medico = gestorPacientes.obtenerPaciente("0987654321");
        if (medico == null) {
            System.out.println("No existe ese medico");
            return;
        }
        System.out.println(medico.toString());*/
        
        
    }
    
}
