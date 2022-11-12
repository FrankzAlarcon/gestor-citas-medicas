/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gestores.GestorCitasMedicas;
import gestores.GestorMedicos;
import persistencia.PacientePersistencia;
import gestores.GestorPacientes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Frankz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ---  PROBADO PACIENTES - OBTENER POR CEDULA, REGISTRAR EN TXT Y ELIMINAR POR CEDULA ---
        // Registra un paciente
        //Paciente p = new Paciente("2209876543", "Frankz Alarcon", 20, "frankz@correo.com");
        //Paciente p = new Paciente("1234567891", "Lenin Alarcon", 20, "lenin@correo.com");
        //Paciente p = new Paciente("56371839432", "Julio", 20, "julio@correo.com");
        //p.registrar();
        
        //GestorPacientes gestorPacientes = new GestorPacientes();
        /*Paciente p = gestorPacientes.obtenerPaciente("1234567891");
        if (p == null) {
            System.out.println("No existe ese paciente");
            return;
        }
        System.out.println(p.toString());*/
        //gestorPacientes.eliminarPaciente("56371839432");
        
        
        
        
                
        // ---  PROBADO MEDICOS - OBTENER POR CEDULA Y REGISTRAR EN TXT  ---
        // Registra un medico
        //Medico medico = new Medico("1234567890", "Glender Miranda", 40, "glender@correo.com", "123456");
        //Medico medico = new Medico("3627463724", "Frankz Alarcon", 20, "frankz@correo.com", "123456");
        //Medico medico = new Medico("0987654321", "Wellinton Peralta", 25, "wellinton@correo.com", "123456");
        
        //medico.registrar();
        
        //GestorMedicos gestorMedicos = new GestorMedicos();
        /*Medico medico = gestorPacientes.obtenerPaciente("0987654321");
        if (medico == null) {
            System.out.println("No existe ese medico");
            return;
        }
        System.out.println(medico.toString());*/
        
        //String message = gestorMedicos.eliminarMedico("3627463724");
        //System.out.println(message);
        
        
        // -- PROBADO CITAS - OBTENER CITA POR ID, REGISTRAR EN TXT Y ELIMINAR CITA ---
        
        //GestorPacientes gestorPacientes = new GestorPacientes();
        //GestorMedicos gestorMedicos = new GestorMedicos();
        
        // Los datos del constructor son -> fecha de cita, especialidad, descripcion, medico, paciente
        // -> de medico y paciente se guardara la cedula en el txt para luego poder buscarlos por cedula
        // -> La fecha (año, mes, dia, hora, minuto)        
        //Cita cita = new Cita(LocalDateTime.of(2022, 12,20, 10,0), "Diabetologia", "Examen de diabetes", gestorMedicos.obtenerMedico("1234567890"), gestorPacientes.obtenerPaciente("2209876543"));
        //Cita cita = new Cita(LocalDateTime.of(2022, 12,20, 10,0), "Gastroenterologia", "Chequeo de Gastritis", gestorMedicos.obtenerMedico("1234567890"), gestorPacientes.obtenerPaciente("1234567891"));
        //Cita cita = new Cita(LocalDateTime.of(2022, 12,20, 10,0), "Traumatologia", "Chequeo lesion", gestorMedicos.obtenerMedico("0987654321"), gestorPacientes.obtenerPaciente("56371839432"));
        
        //cita.registrar();
        
        //GestorCitasMedicas gestorCitas = new GestorCitasMedicas();
        //Cita cita = gestorCitas.obtenerCita("2613618");
        //System.out.println(cita.toString());
        //String message = gestorCitas.eliminarCita("1953138");
        //System.out.println(message);        
        
        //ArrayList<Cita> citas = gestorCitas.obtenerTodasLasCitas();
        //for (Cita c: citas) {
        //    System.out.println(c.toString());
        //}        
        
        
        //Probando metodo de registro de medicos
        //GestorMedicos gMedicos = new GestorMedicos();
        //gMedicos.registrarMedico();
        //Probando meotod de registro de pacientes
        //GestorPacientes gPacientes = new GestorPacientes();
        //gPacientes.registrarPaciente();
        GestorCitasMedicas gCitas = new GestorCitasMedicas();
        gCitas.registrarCita();
        
    }
    
}
