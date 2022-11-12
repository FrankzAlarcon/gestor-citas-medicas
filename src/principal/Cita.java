/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Frankz
 */
public class Cita {
   
    private Date fecha;
    private Time hora;
    private String especialidad;
    private String descripcion;
    
    private CitaPersistencia citaPersistencia;
    private Medico medico;
    private Paciente paciente;

    public Cita(Date fecha, Time hora, String especialidad, String descripcion, Medico medico, Paciente paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.citaPersistencia = new CitaPersistencia();
        this.medico = medico;
        this.paciente = paciente;
    }

    public void registrar() {
        this.citaPersistencia.registrarCita(this);
    }
    
    public void cancelar() {
        this.citaPersistencia.cancelarCita(this);
    }
    
    public String toString() {
        return "fecha=" + fecha + ", hora=" + hora + ", especialidad=" + especialidad + ", descripcion=" + descripcion + ", medico=" + medico + ", paciente=" + paciente;
    }
    
    
    
    
}
