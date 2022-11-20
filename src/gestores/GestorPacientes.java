/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.ArrayList;
import java.util.Scanner;
import principal.Paciente;
import persistencia.PacientesPersistencia;

/**
 *
 * @author Frankz
 */
public class GestorPacientes {   
    private Paciente paciente;

    private ArrayList<String> recogerDatosPaciente() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> med = new ArrayList<String>();
        System.out.println("INGRESE CI:");
        med.add(in.nextLine());
        System.out.println("INGRESE NOMBRE COMPLETO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU EDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CORREO ELECTRONICO:");
        med.add(in.nextLine());
        return med;
    }

    public void registrarPaciente() {
        //Obtencion de datos
        ArrayList<String> med = recogerDatosPaciente();

        //dando valor a la instancia medico
        this.paciente = new Paciente(med.get(0), med.get(1),
                Integer.parseInt(med.get(2)), med.get(3));
        //llamado del metodo registrar
        this.paciente.registrar();
    }

    public Paciente obtenerPaciente(String cedula) {
        PacientesPersistencia pacienteP = new PacientesPersistencia();
        Paciente p = pacienteP.obtenerPaciente(cedula);
        if (p == null) {
            return null;
        }
        return p;
    }
    
    public String modificarMedico(){
        Scanner in = new Scanner(System.in);
        System.out.println("INGRESE LA CEDULA DEL MEDICO A MODIFICAR");
        String ci = in.nextLine();
        Paciente paciente = this.obtenerPaciente(ci);
        if (paciente == null) {
            return "El medico con cédula " + ci + " no existe.";
        }
        paciente.modificar();
        return "La modificacion ha sido exitosa";
    }

    public String eliminarPaciente(String cedula) {
        PacientesPersistencia pacienteP = new PacientesPersistencia();
        Paciente p = pacienteP.obtenerPaciente(cedula);
        if (p == null) {
            return "El usuario con cédula " + cedula + " no existe.";
        }
        p.eliminar();
        return "Eliminado exitosamente.";
    }

}
