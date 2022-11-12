/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.ArrayList;
import java.util.Scanner;
import persistencia.MedicosPersistencia;
import principal.Medico;

/**
 *
 * @author Frankz
 */
public class GestorMedicos {

    Scanner in = new Scanner(System.in);
    private Medico medico;

    public void registrarMedico() {
        ArrayList<Object> med = new ArrayList<Object>();
        System.out.println("INGRESE CI:");
        med.add(in.nextLine());
        System.out.println("INGRESE NOMBRE COMPLETO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU EDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CORREO ELECTRONICO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CONTRASEÑA:");
        med.add(in.nextLine());

        //dando valor a la instancia medico
        this.medico = new Medico((String) med.get(0), (String) med.get(1),
                Integer.parseInt((String)med.get(2)), (String) med.get(3), (String) med.get(4));
        //llamado del metodo registrar
        this.medico.registrar();
    }

    public Medico obtenerMedico(String cedula) {
        MedicosPersistencia medicoP = new MedicosPersistencia();
        Medico medico = medicoP.obtenerMedico(cedula);
        if (medico == null) {
            return null;
        }
        return medico;
    }

    public String eliminarMedico(String cedula) {
        MedicosPersistencia medicoP = new MedicosPersistencia();
        Medico medico = medicoP.obtenerMedico(cedula);
        if (medico == null) {
            return "El medico con cédula " + cedula + " no existe.";
        }
        medico.eliminar();
        return "Eliminado exitosamente.";
    }
}
