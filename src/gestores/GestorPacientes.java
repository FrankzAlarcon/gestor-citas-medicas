/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.ArrayList;
import java.util.Scanner;
import principal.Paciente;
import persistencia.PacientePersistencia;

/**
 *
 * @author Frankz
 */
public class GestorPacientes {

    Scanner in = new Scanner(System.in);
    private Paciente paciente;

    public void registrarPaciente() {
        //Obtencion de datos
        ArrayList<Object> med = new ArrayList<Object>();
        System.out.println("INGRESE CI:");
        med.add(in.nextLine());
        System.out.println("INGRESE NOMBRE COMPLETO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU EDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CORREO ELECTRONICO:");
        med.add(in.nextLine());

        //dando valor a la instancia medico
        this.paciente = new Paciente((String) med.get(0), (String) med.get(1),
                Integer.parseInt((String)med.get(2)), (String) med.get(3));
        //llamado del metodo registrar
        this.paciente.registrar();
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
