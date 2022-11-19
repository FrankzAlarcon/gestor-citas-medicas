/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import persistencia.CitasPersistencia;
import principal.Cita;

/**
 *
 * @author Frankz
 */
public class GestorCitasMedicas {
    Scanner in = new Scanner(System.in);
    private GestorMedicos gMedicos = new GestorMedicos();
    private GestorPacientes gPacientes = new GestorPacientes();
    private Cita cita;
    
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
    
     public void registrarCita() {
        ArrayList<Object> med = new ArrayList<Object>();
        System.out.println("INGRESE FECHA DE CONSULTA [aa/mm/dd/hh:min]:");
        med.add(in.nextLine());
        System.out.println("INGRESE ESPECIALIDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE DESCRIPCION:");
        med.add(in.nextLine());
        System.out.println("INGRESE CI DEL MEDICO:"); //con el ci se encuentra y se obtiene el objeto medico desde el csv
        med.add(in.nextLine());
        System.out.println("INGRESE CI DEL PACIENTE:");
        med.add(in.nextLine());
        
        //dando valor a la instancia Cita
        this.cita = new Cita(LocalDateTime.of((Integer.parseInt(((String)med.get(0)).substring(0, 3))),
                (Integer.parseInt(((String)med.get(0)).substring(5, 6))),(Integer.parseInt(((String)med.get(0)).substring(8, 9))),
        (Integer.parseInt(((String)med.get(0)).substring(11, 12))),(Integer.parseInt(((String)med.get(0)).substring(14, 15)))),
                (String) med.get(1),(String) med.get(2),gMedicos.obtenerMedico((String)med.get(3)),
                gPacientes.obtenerPaciente((String)med.get(4))); //Aqui hacer validacion de si existe el medico o paciente
        
        //llamado del metodo registrar
        this.cita.registrar();
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
