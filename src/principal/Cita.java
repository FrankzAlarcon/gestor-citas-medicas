/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.time.LocalDateTime;
import java.util.Date;
import persistencia.CitasPersistencia;

/**
 *
 * @author Frankz
 */
public class Cita {
   
    private String id;
    private LocalDateTime fecha;    
    private String especialidad;
    private String descripcion;
    
    private CitasPersistencia citaPersistencia;
    private Medico medico;
    private Paciente paciente;
    
    public Cita(String id, LocalDateTime fecha, String especialidad, String descripcion, Medico medico, Paciente paciente) {
        this.id = id;
        this.fecha = fecha;        
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.citaPersistencia = new CitasPersistencia();
        this.medico = medico;
        this.paciente = paciente;
    }

    public Cita(LocalDateTime fecha, String especialidad, String descripcion, Medico medico, Paciente paciente) {
        this.id = Math.round(Math.random() * 10000000) + "";
        this.fecha = fecha;        
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.citaPersistencia = new CitasPersistencia();
        this.medico = medico;
        this.paciente = paciente;
    }    

    public void registrar() {
        this.citaPersistencia.registrarCita(this);
    }
    
    public void cancelar() {
        this.citaPersistencia.eliminarCita(this);
    }

    @Override
    public String toString() {
        return id + "," + fecha.toString() + "," + especialidad + "," + descripcion  + "," + medico.getCedula() + "," + paciente.getCedula();
    }
    
    
    public String getId() {
        return this.id;
    }
    
}
