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
    private Medico medico;
    private GestorCitasMedicas gestorCitas;
        
    
    public void listarTodasLasCitas(){
        this.gestorCitas = new GestorCitasMedicas();
        this.gestorCitas.obtenerTodasLasCitas();
    }
    
    private ArrayList<String> recogerDatosMedico(){
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
        System.out.println("INGRESE SU CONTRASEÑA:");
        med.add(in.nextLine());
        
        return med;
    }

    public void registrarMedico() {
        ArrayList<String> med = recogerDatosMedico();

        //dando valor a la instancia medico
        this.medico = new Medico(med.get(0), med.get(1),
                Integer.parseInt(med.get(2)), 
                med.get(3), med.get(4));
        
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
    
    public String modificarMedico(){
        Scanner in = new Scanner(System.in);
        System.out.println("INGRESE LA CEDULA DEL MEDICO A MODIFICAR");
        String ci = in.nextLine();
        Medico medico =this.obtenerMedico(ci);
        if (medico == null) {
            return "El medico con cédula " + ci + " no existe.";
        }
        medico.modificar();
        return "La modificacion ha sido exitosa";
    }
}
